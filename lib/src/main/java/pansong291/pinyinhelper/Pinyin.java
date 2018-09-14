package pansong291.pinyinhelper;

/**
 * Created by pansong291 on 2018/9/12.
 */
public final class Pinyin
{

 public static final int UP_CASE = -1;
 public static final int FIRST_UP_CASE = 0;
 public static final int LOW_CASE = 1;
 
 private Pinyin(){}

 /**
  * 将输入字符串转为拼音，以字符为单位插入分隔符
  *
  * 例: "hello:中国！"  在separator为","时，输出： "h,e,l,l,o,:,ZHONG,GUO,!"
  *
  * @param str  输入字符串
  * @param separator 分隔符
  * @return 中文转为拼音的字符串
  */
 public static String toPinyin(String str, String separator, int caseType)
 {
  if (str == null || str.length() == 0)
  {
   return str;
  }

  StringBuffer resultPinyinStrBuf = new StringBuffer();
  for (int i = 0; i < str.length(); i++)
  {
   resultPinyinStrBuf.append(Pinyin.toPinyin(str.charAt(i),caseType)[0]);
   if (i != str.length() - 1)
   {
    resultPinyinStrBuf.append(separator);
   }
  }
  return resultPinyinStrBuf.toString();
 }

 /**
  * 将输入字符转为拼音
  *
  * @param c 输入字符
  * @param caseType 定义拼音大小写
  * @return return pinyin if c is chinese in uppercase, String.valueOf(c) otherwise.
  */
 public static String[] toPinyin(char c, int caseType)
 {
  String result[] = null;

  int charIndex = isChinese(c);
  if(charIndex == 0)
  {
   result = new String[]{PinyinData.PINYIN_12295};
  }else if(charIndex > 0)
  {
   String duoyin[] = getDuoyin(c);
   result = new String[duoyin.length + 1];
   result[0] = PinyinData.PINYIN_TABLE[charIndex];
   for(int i = 0;i < duoyin.length;i++)
   {
    result[i + 1] = duoyin[i];
   }
  }else
  {
   result = new String[]{String.valueOf(c).toUpperCase()};
  }
  
  for(int i = 0;i < result.length;i++)
  {
   switch(caseType)
   {
    case UP_CASE:
     result[i] = result[i].toUpperCase();
     break;
    case LOW_CASE:
     result[i] = result[i].toLowerCase();
     break;
    case FIRST_UP_CASE:
     break;
   }
  }
  return result;
 }

 /**
  * 判断输入字符是否为汉字
  *
  * @param c 输入字符
  * @return 是汉字返回非负数，反之返回负数
  */
 public static int isChinese(char c)
 {
  if(PinyinData.CHAR_12295 == c)
   return 0;
  else if(c < PinyinData.MIN_VALUE || c > PinyinData.MAX_VALUE)
   return -1;
  else
   return getPinyinCode(c);
 }

 /**
  * 删除小写字母
  *
  * @param firstUpCase 首字母大写的拼音
  * @return 拼音首字母
  */
 public static String deleteLowerCase(String firstUpCase)
 {
  StringBuilder sb = new StringBuilder();
  char c;
  for(int i=0;i<firstUpCase.length();i++)
  {
   c=firstUpCase.charAt(i);
   if(c<'a'||c>'z')sb.append(c);
  }
  return sb.toString();
 }
 
 private static int getPinyinCode(char c)
 {
  int offset = c - PinyinData.MIN_VALUE;
  if (0 <= offset && offset < PinyinData.PINYIN_CODE_1_OFFSET)
  {
   return decodeIndex(PinyinCode1.PINYIN_CODE_PADDING, PinyinCode1.PINYIN_CODE, offset);
  }
  else if (PinyinData.PINYIN_CODE_1_OFFSET <= offset
           && offset < PinyinData.PINYIN_CODE_2_OFFSET)
  {
   return decodeIndex(PinyinCode2.PINYIN_CODE_PADDING, PinyinCode2.PINYIN_CODE,
                      offset - PinyinData.PINYIN_CODE_1_OFFSET);
  }
  else
  {
   return decodeIndex(PinyinCode3.PINYIN_CODE_PADDING, PinyinCode3.PINYIN_CODE,
                      offset - PinyinData.PINYIN_CODE_2_OFFSET);
  }
 }

 private static String[] getDuoyin(char c)
 {
  String duoyin[] = null;
  short duoyinCode[] = null;
  int offset = c - PinyinData.MIN_VALUE;
  for(int i = 0;i < DuoyinCode.INDEX_WORD.length;i++)
  {
   if(DuoyinCode.INDEX_WORD[i] == offset)
   {
    duoyinCode = decodeDuoyinIndex(i);
    duoyin = new String[duoyinCode.length];
    for(int j = 0;j < duoyinCode.length;j++)
    {
     duoyin[j] = PinyinData.PINYIN_TABLE[duoyinCode[j]];
    }
    break;
   }
  }
  return duoyin;
 }

 private static short decodeIndex(byte[] paddings, byte[] indexes, int offset)
 {
  int index1 = offset / 8;
  int index2 = offset % 8;
  //低8位
  short realIndex = (short) (indexes[offset] & 0xff);
  //高1位，非0即1
  if ((paddings[index1] & PinyinData.BIT_MASKS[index2]) != 0)
  {
   realIndex = (short) (realIndex | PinyinData.PADDING_MASK);
  }  
  return realIndex;
 }

 private static short[] decodeDuoyinIndex(int offset)
 {
  int ins,iny,len;
  int ind=decodeIndex2(offset);
  if(offset != DuoyinCode.INDEX_DUOYIN_CODE3.length - 1)
   len = decodeIndex2(offset + 1) - ind;
  else
   len = DuoyinCode.DUOYIN_CODE.length - ind;
  short realIndex[]=new short[len];

  for(int j=0;j < len;j++)
  {
   ins = (ind + j) / 8;
   iny = (ind + j) % 8;
   //低8位
   realIndex[j] = (short)(DuoyinCode.DUOYIN_CODE[ind + j] & 0xff);
   //高1位，非0即1
   if((DuoyinCode.DUOYIN_CODE_PADDING[ins] & PinyinData.BIT_MASKS[7 - iny]) != 0)
    realIndex[j] = (short)(realIndex[j] | PinyinData.PADDING_MASK);
  }
  return realIndex;
 }

 private static short decodeIndex2(int offset)
 {
  int ins1=offset / 8,ins2=offset / 4;
  int iny1=offset % 8,iny2=offset % 4;
  //低8位
  short realIndex=(short)(DuoyinCode.INDEX_DUOYIN_CODE3[offset] & 0xff);
  //中2位，有00，01，10，11共4种情况
  short m2Bit=(short)(DuoyinCode.index_duoyin_code2(ins2) & PinyinData.TWO_BIT_MASKS[iny2]);
  m2Bit = (short)(m2Bit << 2 * iny2 + 2);
  realIndex = (short)(realIndex | m2Bit);
  //高1位，非0即1
  if((DuoyinCode.index_duoyin_code1(ins1) & PinyinData.BIT_MASKS[7 - iny1]) != 0)
  {
   realIndex = (short)(realIndex | 0x400);
  }
  return realIndex;
 }
 
}