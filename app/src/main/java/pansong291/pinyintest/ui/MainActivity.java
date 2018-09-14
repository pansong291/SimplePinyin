package pansong291.pinyintest.ui;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import pansong291.pinyinhelper.Pinyin;
import pansong291.pinyinhelper.PinyinData;
import pansong291.pinyintest.R;
import pansong291.pinyinhelper.DuoyinCode;

public class MainActivity extends Zactivity 
{
 String inPath="/storage/emulated/0/Download/unicode2Duoyin.txt";
 
 EditText edt;
 Button btn,btn2,btn3,btn4,btn5,btn6;
 
 BufferedReader br;
 
 @Override
 protected void onCreate(Bundle savedInstanceState)
 {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  
  edt=(EditText)findViewById(R.id.edt);
  btn=(Button)findViewById(R.id.btn);
  btn2=(Button)findViewById(R.id.btn2);
  btn3=(Button)findViewById(R.id.btn3);
  btn4=(Button)findViewById(R.id.btn4);
  btn5=(Button)findViewById(R.id.btn5);
  btn6=(Button)findViewById(R.id.btn6);
  
  requestPower();
 }
 
 public void onClick(View v)
 {
  btn.setClickable(false);
  try
  {
   br = new BufferedReader(new FileReader(new File(inPath)));
   String temp;
   int count_pinyin=0;
   byte highBitCache=0;
   String tps[];
   List<Short>indexInPinyinTable=new ArrayList<Short>();
   List<Integer>indexInDuoyinTable=new ArrayList<Integer>();
   List<Byte>duoyinCode=new ArrayList<Byte>();
   List<Byte>duoyinCodePadding=new ArrayList<Byte>();
   int index_duoyin=0;
   while((temp = br.readLine()) != null)
   {
    // 了,4E86,le,liao,
    tps=temp.split(",");
    
    //if(!tps[2].equals(Pinyin.toPinyin(temp.charAt(0),Pinyin.LOW_CASE)))edt.append(temp);
    //if(true)continue;
    
    indexInPinyinTable.add((short)(Integer.parseInt(tps[1],16)-19968));
    indexInDuoyinTable.add(index_duoyin);
    index_duoyin+=tps.length-3;
    for(int i=3;i<tps.length;i++,count_pinyin++)
    {
     if(!tps[i].isEmpty())
     {
      for(int x=0;x<PinyinData.PINYIN_TABLE.length;x++)
      {
       //dei,eng,hng,lo,lue,n,qui,r,tei, not find
       if(tps[i].compareToIgnoreCase(PinyinData.PINYIN_TABLE[x])==0)
       {
        duoyinCode.add((byte)(x&0xff));
        highBitCache=(byte)(highBitCache|((x&0x100)>>>(count_pinyin%8+1)));
        if((1+count_pinyin)%8==0)
        {
         duoyinCodePadding.add(highBitCache);
         highBitCache=0;
        }
        break;

       }else if(x==PinyinData.PINYIN_TABLE.length-1)
       {
        edt.append(tps[i]+",");
       }
      }
     }
    }

   }
   //如果拼音总数不是8的倍数，说明还有最后的高1位的缓存
   if(count_pinyin%8!=0)
    duoyinCodePadding.add(highBitCache);
   edt.append(" not find.----end");
//   edt.append("\n\nindex_in_pinyinTable=");
//   edt.append(getStringValueOfList(indexInPinyinTable));
//   edt.append("\n\nindex_in_duoyinTable=");
//   edt.append(getStringValueOfList(indexInDuoyinTable));
//   edt.append("\n\nduoyinCode=");
//   edt.append(getStringValueOfList(duoyinCode));
//   edt.append("\n\nduoyinCodePadding=");
//   edt.append(getStringValueOfList(duoyinCodePadding));
   
  }catch(FileNotFoundException e)
  {
   e.printStackTrace();
  }catch(IOException e)
  {
   e.printStackTrace();
  }
  if(br != null)
   try
   {
    br.close();
   }catch(IOException e)
   {
    e.printStackTrace();
   }
   
 }
 
 public void onClick2(View v)
 {
  btn2.setClickable(false);
  int ind,len;
  short relInd;
  char word;
  for(int i=0;i<DuoyinCode.INDEX_DUOYIN_CODE.length;i++)
  {
   ind=DuoyinCode.INDEX_DUOYIN_CODE[i];
   if(i!=DuoyinCode.INDEX_DUOYIN_CODE.length-1)
    len=DuoyinCode.INDEX_DUOYIN_CODE[i+1]-ind;
   else len=DuoyinCode.DUOYIN_CODE.length-ind;
      
   word=(char)(DuoyinCode.INDEX_WORD[i]+19968);
   edt.append(String.valueOf(word)+","
    +Integer.toHexString(word).toUpperCase()+",");
   edt.append(Pinyin.toPinyin(word,Pinyin.LOW_CASE)+",");
   for(int j=0;j<len;j++)
   {
    //relInd=Pinyin.decodeIndex(DuoyinCode.DUOYIN_CODE_PADDING,DuoyinCode.DUOYIN_CODE,ind+j);
    
    int in1=(ind+j)/8,in2=(ind+j)%8;
    relInd=(short)(DuoyinCode.DUOYIN_CODE[ind+j]&0xff);
    if((DuoyinCode.DUOYIN_CODE_PADDING[in1]&PinyinData.BIT_MASKS[7-in2])!=0)
     relInd=(short)(relInd|0x100);
    
    try{
    edt.append(PinyinData.PINYIN_TABLE[relInd].toLowerCase()+",");
    }catch(Exception e)
    {
     edt.append(e.getMessage()+",");
    }
   }
   edt.append("\n");
  }
  
 }
 
 public void onClick3(View v)
 {
  btn3.setClickable(false);
  
  List<Byte>indexDuoyinCode1=new ArrayList<Byte>();
  List<Byte>indexDuoyinCode2=new ArrayList<Byte>();
  List<Byte>indexDuoyinCode3=new ArrayList<Byte>();
  byte h1Bit=0,h2Bit=0;
  short x;
  
  for(int i=0;i<DuoyinCode.INDEX_DUOYIN_CODE.length;i++)
  {
   x=DuoyinCode.INDEX_DUOYIN_CODE[i];
   indexDuoyinCode3.add((byte)(x&0xff));
   h1Bit=(byte)(h1Bit|((x&0x400)>>>(i%8+3)));
   if((1+i)%8==0)
   {
    indexDuoyinCode1.add(h1Bit);
    h1Bit=0;
   }
   h2Bit=(byte)(h2Bit|((x&0x300)>>>(i%4+1)*2));
   if(i>=222&&i<=232)
   {
    edt.append("\nduoyin["+i+"]="+x+"\n&0x300="+(x&0x300)
               +"\n>>>"+(i%4+1)*2+"="+((x&0x300)>>>(i%4+1)*2)+"\nh2Bit="+h2Bit);
   }
   if((1+i)%4==0)
   {
    indexDuoyinCode2.add(h2Bit);
    h2Bit=0;
   }
  }
  //如果拼音总数不是8的倍数，说明还有最后的高1位的缓存
  if(DuoyinCode.INDEX_DUOYIN_CODE.length%8!=0)indexDuoyinCode1.add(h1Bit);
  if(DuoyinCode.INDEX_DUOYIN_CODE.length%4!=0)indexDuoyinCode2.add(h2Bit);
  
//  edt.append("\n\nindex1=");
//  edt.append(getStringValueOfList(indexDuoyinCode1));
  edt.append("\n\nindex2=");
  edt.append(getStringValueOfList(indexDuoyinCode2));
//  edt.append("\n\nindex3=");
//  edt.append(getStringValueOfList(indexDuoyinCode3));
 }
 
 public void onClick4(View v)
 {
  btn4.setClickable(false);
  int TWO_BIT_MASKS[]={0xc0,0x30,0x0c,0x03};
  int relInd;short m2Bit;
  for(int ind=0;ind<DuoyinCode.INDEX_DUOYIN_CODE3.length;ind++)
  {
   int ins1=ind/8,ins2=ind/4;
   int iny1=ind%8,iny2=ind%4;
   //低8位
   relInd=(short)(DuoyinCode.INDEX_DUOYIN_CODE3[ind]&0xff);
   //中2位
   m2Bit=(short)(DuoyinCode.INDEX_DUOYIN_CODE2[ins2]&TWO_BIT_MASKS[iny2]);
   m2Bit=(short)(m2Bit << 2*iny2+2);
   relInd=(short)(relInd | m2Bit);
   //高1位
   if((DuoyinCode.INDEX_DUOYIN_CODE1[ins1]&PinyinData.BIT_MASKS[7-iny1])!=0)
    relInd=(short)(relInd|0x400);

   if(relInd!=DuoyinCode.INDEX_DUOYIN_CODE[ind])
    edt.append(ind+" is "+relInd+" not match "+DuoyinCode.INDEX_DUOYIN_CODE[ind]+"\n");
  }
  edt.append("----match end.");
 }

 public void onClick5(View v)
 {
  btn5.setClickable(false);
 }
 
 public void onClick6(View v)
 {
  btn6.setClickable(false);
  String dy[];
  for(char i=PinyinData.MIN_VALUE;i<PinyinData.MAX_VALUE;i++)
  {
   dy=Pinyin.getDuoyin(i);
   if(dy==null)
   {
    continue;
   }
   edt.append(String.valueOf(i)+","+Integer.toHexString(i).toUpperCase());
   for(int j=0;j<dy.length;j++)
   {
    edt.append(","+dy[j].toLowerCase());
   }
   edt.append(",\n");
  }
 }
 
 private String getStringValueOfList(List ls)
 {
  StringBuilder strb=new StringBuilder();
  strb.append("{\n");
  int i=0;
  for(Object o:ls)
  {
   i++;
   strb.append(o);
   strb.append(',');
   if(i%20==0)strb.append('\n');
  }
  strb.append('}');
  return strb.toString();
 }
 
 //请求应用内存读写权限
 public void requestPower()
 {
  if(checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
     != PackageManager.PERMISSION_GRANTED)
  {
   if(shouldShowRequestPermissionRationale(
       Manifest.permission.WRITE_EXTERNAL_STORAGE))
   {
   }else
   {
    requestPermissions(
     new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
      Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
   }
  }
 }
 
}
