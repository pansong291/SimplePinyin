package pansong291.pinyinhelper;

/**
 * Created by pansong291 on 2018/9/12.
 */
public final class DuoyinCode {

 private DuoyinCode() {}

 static short[] INDEX_WORD = new short[]{
  1,7,13,20,44,54,60,66,72,80,87,88,92,121,126,128,134,153,159,161,
  178,192,199,207,212,225,247,282,284,288,293,295,302,303,314,316,317,320,323,339,
  345,346,347,353,372,380,389,407,417,421,423,447,458,478,479,481,489,502,508,510,
  518,536,542,584,597,626,628,634,635,640,691,706,741,750,769,825,831,845,847,857,
  865,870,874,877,886,889,903,912,914,943,970,1013,1016,1017,1023,1042,1064,1080,1081,1098,
  1110,1121,1125,1144,1151,1194,1202,1217,1234,1254,1274,1305,1306,1320,1337,1338,1344,1362,1365,1367,
  1368,1371,1372,1377,1388,1399,1410,1416,1429,1440,1446,1450,1456,1474,1475,1477,1509,1512,1516,1526,
  1537,1539,1544,1555,1569,1574,1580,1581,1585,1597,1599,1606,1610,1616,1620,1623,1624,1634,1649,1650,
  1653,1664,1673,1674,1675,1676,1686,1701,1711,1713,1715,1724,1725,1733,1736,1749,1751,1761,1766,1770,
  1788,1796,1812,1836,1857,1884,1908,1920,1931,1935,1940,1966,1968,1971,1988,1996,2002,2005,2015,2023,
  2024,2031,2046,2063,2072,2074,2076,2089,2092,2098,2104,2111,2124,2131,2150,2161,2180,2183,2195,2211,
  2236,2242,2269,2276,2282,2312,2319,2325,2332,2345,2352,2356,2363,2375,2383,2427,2444,2488,2507,2514,
  2516,2529,2532,2560,2566,2570,2571,2574,2581,2593,2596,2600,2644,2654,2660,2710,2734,2737,2762,2769,
  2782,2803,2831,2855,2863,2866,2873,2880,2887,2897,2904,2931,2995,3045,3100,3104,3113,3137,3172,3177,
  3230,3277,3304,3355,3419,3441,3448,3461,3483,3510,3519,3520,3579,3581,3588,3590,3591,3593,3595,3618,
  3619,3624,3642,3646,3647,3653,3663,3678,3692,3695,3705,3794,3801,3812,3839,3862,3876,3892,3916,3921,
  3968,4000,4034,4078,4087,4133,4145,4160,4173,4194,4204,4223,4227,4245,4262,4268,4275,4289,4296,4305,
  4320,4323,4356,4361,4407,4409,4410,4414,4424,4426,4471,4490,4503,4510,4517,4533,4540,4562,4586,4600,
  4622,4636,4637,4651,4655,4673,4680,4694,4714,4715,4726,4746,4765,4778,4833,4882,4938,4957,5118,5126,
  5132,5135,5152,5159,5167,5170,5185,5198,5202,5205,5211,5235,5272,5278,5305,5307,5314,5318,5331,5335,
  5338,5353,5356,5366,5373,5374,5386,5392,5405,5407,5410,5426,5429,5438,5441,5451,5503,5526,5552,5553,
  5556,5560,5562,5584,5599,5604,5618,5637,5650,5686,5713,5720,5729,5737,5755,5790,5791,5795,5806,5817,
  5822,5831,5848,5877,5893,5906,5916,5922,5930,5982,5990,5995,5999,6000,6008,6017,6025,6026,6044,6050,
  6058,6076,6081,6112,6194,6209,6215,6239,6255,6315,6324,6364,6365,6387,6397,6398,6403,6407,6424,6429,
  6430,6431,6447,6452,6473,6483,6515,6519,6523,6557,6558,6584,6585,6593,6601,6607,6620,6622,6629,6635,
  6651,6661,6670,6678,6680,6685,6687,6689,6690,6712,6721,6740,6759,6818,6841,6867,6897,6898,6905,6921,
  6926,6929,6969,6976,6978,7003,7023,7031,7037,7078,7111,7131,7135,7149,7170,7173,7191,7201,7224,7237,
  7239,7240,7257,7270,7277,7312,7324,7338,7347,7351,7355,7363,7387,7391,7450,7480,7481,7513,7574,7584,
  7607,7610,7611,7612,7695,7699,7709,7774,7780,7809,7816,7820,7826,7827,7841,7882,7884,7906,7907,7927,
  7930,7959,7983,7992,7997,7998,8005,8013,8018,8026,8035,8076,8097,8114,8120,8134,8178,8186,8209,8230,
  8295,8299,8302,8303,8323,8362,8369,8378,8398,8401,8413,8440,8454,8458,8495,8503,8506,8538,8550,8560,
  8578,8580,8608,8622,8633,8664,8666,8674,8699,8721,8725,8743,8837,8852,8878,8885,8921,8927,8948,8972,
  8973,8984,8993,9007,9046,9119,9128,9214,9241,9245,9258,9279,9311,9357,9362,9396,9441,9442,9480,9522,
  9607,9626,9631,9634,9705,9714,9718,9738,9762,9782,9791,9793,9960,9961,10010,10042,10044,10076,10086,10090,
  10123,10136,10143,10168,10179,10248,10261,10277,10279,10316,10328,10348,10366,10372,10382,10390,10454,10459,10463,10494,
  10497,10560,10586,10597,10663,10687,10697,10716,10731,10735,10738,10739,10761,10764,10783,10793,10796,10821,10826,10828,
  10892,10921,10949,11026,11046,11079,11106,11117,11124,11141,11178,11184,11213,11224,11236,11248,11287,11288,11310,11313,
  11325,11340,11370,11396,11416,11432,11469,11471,11474,11475,11476,11477,11489,11490,11566,11616,11636,11703,11776,11890,
  11915,11928,11938,11941,11955,11969,11970,11987,11996,11997,12027,12036,12037,12039,12078,12110,12124,12126,12129,12131,
  12134,12168,12188,12206,12216,12253,12278,12323,12330,12334,12353,12358,12359,12363,12395,12400,12403,12415,12443,12450,
  12452,12453,12454,12470,12505,12508,12510,12520,12528,12540,12543,12553,12559,12585,12586,12594,12596,12632,12647,12663,
  12678,12709,12743,12749,12767,12800,12817,12825,12882,12939,12978,13014,13042,13043,13064,13065,13082,13103,13124,13130,
  13131,13132,13135,13150,13153,13184,13250,13256,13265,13272,13286,13293,13296,13356,13365,13370,13400,13407,13426,13438,
  13458,13464,13477,13483,13501,13502,13518,13520,13525,13539,13541,13543,13561,13572,13576,13596,13612,13649,13654,13664,
  13668,13669,13672,13710,13720,13726,13733,13736,13737,13748,13760,13769,13825,13830,13845,13868,13881,13885,13897,13911,
  13914,13943,13985,14027,14045,14066,14076,14079,14088,14099,14100,14106,14133,14145,14147,14152,14153,14212,14227,14236,
  14239,14266,14281,14285,14287,14291,14309,14327,14337,14347,14359,14362,14443,14453,14457,14462,14476,14484,14485,14517,
  14534,14535,14564,14584,14587,14590,14625,14639,14667,14670,14692,14694,14711,14712,14724,14755,14763,14784,14788,14831,
  14869,14879,14912,14924,14931,14960,14961,14969,15002,15019,15031,15080,15091,15100,15116,15130,15146,15158,15186,15235,
  15243,15248,15256,15258,15274,15290,15297,15305,15314,15324,15331,15335,15397,15409,15448,15490,15530,15532,15533,15536,
  15551,15621,15630,15631,15636,15642,15702,15704,15744,15814,15832,15860,15862,15867,15873,15875,15900,15918,15927,15935,
  15937,15944,15946,15995,16009,16031,16044,16065,16067,16072,16074,16092,16122,16160,16178,16190,16218,16260,16291,16296,
  16307,16309,16350,16361,16395,16430,16458,16482,16483,16498,16555,16586,16587,16610,16629,16632,16713,16717,16742,16743,
  16748,16799,16856,16857,16875,16898,16921,16973,16983,17001,17018,17028,17059,17066,17095,17149,17238,17250,17254,17258,
  17269,17278,17279,17303,17329,17357,17360,17389,17398,17408,17471,17479,17480,17498,17499,17528,17535,17553,17562,17612,
  17670,17682,17711,17786,17836,17859,17939,17940,17946,17978,17985,17987,18032,18047,18085,18095,18111,18117,18122,18139,
  18147,18148,18155,18160,18198,18199,18256,18273,18278,18295,18296,18303,18340,18362,18364,18381,18386,18398,18402,18439,
  18447,18456,18458,18461,18464,18493,18495,18498,18502,18509,18525,18550,18552,18583,18617,18620,18621,18624,18635,18685,
  18713,18736,18738,18755,18771,18778,18790,18793,18817,18836,18840,18853,18873,18941,18963,18970,18972,18977,19000,19051,
  19071,19080,19081,19084,19108,19167,19168,19203,19251,19257,19297,19299,19303,19322,19368,19374,19377,19396,19437,19470,
  19476,19496,19523,19551,19566,19584,19616,19619,19632,19633,19679,19700,19720,19762,19780,19834,19885,19926,19987,19989,
  20108,20113,20141,20255,20320,20338,20387,20393,20404,20411,20417,20421,20442,20511,20548,20568,20615,20617,20623,20629,
  20662,20668,20669,20688,20709,20733,20734,20755,20797,20810,20813,20816,20838,20872,20892,20895};
 
 static byte index_duoyin_code1(int i)
 {
  if(i<115)
  {
   return 0;
  }else if(i==115)
  {
   return 1;
  }else
  {
   return -1;
  }
 }
  
  static byte index_duoyin_code2(int i)
  {
   if(i==55)
   {
    return 5;
   }else if(i==114)
   {
    return 86;
   }else if(i==175)
   {
    return -81;
   }else if(i==231)
   {
    return -4;
   }else if(i<55)
   {
    return 0;
   }else if(i<114)
   {
    return 85;
   }else if(i<175)
   {
    return -86;
   }else if(i<231)
   {
    return -1;
   }else if(i<291)
   {
    return 0;
   }else
   {
    return 85;
   }
  }
  
  static byte[] INDEX_DUOYIN_CODE3 = new byte[]{
  0,1,2,3,4,5,6,7,8,10,11,12,13,14,15,16,18,19,20,21,
  22,23,25,26,27,28,29,30,31,32,33,34,35,36,38,39,40,43,44,45,
  46,47,48,49,50,51,52,53,54,55,57,59,60,62,63,64,65,66,67,68,
  69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,
  89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,
  109,110,111,112,113,115,116,117,118,119,120,122,123,124,125,126,127,-128,-127,-125,
  -124,-123,-122,-121,-120,-119,-118,-116,-115,-114,-113,-112,-111,-110,-108,-105,-103,-102,-101,-100,
  -99,-98,-97,-96,-95,-94,-93,-92,-91,-90,-89,-88,-87,-86,-85,-84,-83,-82,-80,-78,
  -77,-75,-74,-73,-72,-70,-67,-66,-65,-62,-61,-58,-57,-56,-55,-54,-53,-52,-51,-49,
  -46,-45,-44,-42,-41,-40,-39,-38,-37,-36,-35,-34,-32,-31,-30,-29,-28,-27,-26,-25,
  -24,-23,-22,-21,-20,-19,-18,-17,-16,-14,-13,-12,-10,-9,-8,-7,-6,-5,-4,-3,
  -2,-1,0,1,2,3,4,5,7,8,9,10,11,12,13,15,16,17,18,19,
  20,21,22,24,25,26,27,28,29,30,32,33,34,35,36,37,38,39,40,41,
  42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,58,60,61,62,63,
  64,65,66,67,69,70,71,72,73,74,76,77,78,79,80,82,83,84,85,86,
  87,88,89,90,91,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,
  108,109,110,111,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,-128,
  -127,-126,-125,-124,-123,-122,-121,-120,-119,-118,-117,-116,-115,-114,-113,-112,-111,-110,-108,-107,
  -106,-105,-104,-103,-102,-101,-99,-98,-97,-96,-95,-94,-93,-92,-91,-90,-89,-88,-87,-86,
  -85,-84,-83,-82,-81,-80,-79,-78,-77,-76,-75,-74,-73,-72,-71,-70,-69,-68,-67,-66,
  -64,-63,-62,-61,-60,-59,-58,-57,-56,-55,-54,-53,-51,-50,-48,-47,-46,-45,-44,-43,
  -42,-41,-40,-38,-36,-35,-34,-33,-32,-31,-30,-29,-28,-27,-26,-25,-24,-23,-22,-21,
  -20,-19,-18,-17,-16,-15,-14,-13,-12,-10,-9,-8,-7,-6,-5,-4,-3,-2,-1,0,
  1,2,3,4,5,6,7,8,9,10,11,12,13,14,16,17,18,19,20,21,
  22,23,24,25,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,
  43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,
  63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,
  83,84,85,86,87,88,89,91,92,93,94,95,96,97,98,99,100,101,102,103,
  104,105,106,107,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,
  125,126,127,-128,-127,-126,-125,-124,-123,-122,-121,-120,-119,-118,-117,-116,-115,-114,-113,-112,
  -111,-110,-107,-106,-105,-104,-103,-102,-101,-100,-99,-98,-97,-95,-94,-93,-92,-91,-90,-89,
  -88,-87,-86,-84,-83,-82,-81,-80,-79,-78,-77,-76,-75,-74,-73,-72,-71,-70,-69,-68,
  -67,-66,-65,-64,-63,-62,-61,-60,-59,-58,-57,-56,-54,-53,-52,-51,-50,-49,-47,-46,
  -45,-43,-42,-41,-40,-39,-38,-37,-36,-35,-34,-33,-32,-31,-30,-29,-28,-27,-26,-25,
  -24,-22,-21,-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,-4,
  -3,-2,0,1,2,3,4,5,7,8,9,10,11,12,13,14,15,16,17,18,
  19,20,21,22,23,24,25,26,27,28,29,30,31,32,34,35,36,37,38,39,
  40,41,42,43,44,45,46,48,50,51,56,57,62,67,68,69,70,71,72,73,
  74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,
  94,95,96,97,98,99,100,101,102,103,104,105,107,109,110,111,112,114,115,116,
  117,118,119,120,121,122,123,124,125,126,127,-128,-127,-126,-125,-123,-121,-119,-118,-117,
  -116,-115,-114,-113,-112,-111,-110,-109,-108,-107,-106,-105,-104,-103,-102,-101,-100,-98,-97,-96,
  -95,-94,-93,-92,-91,-90,-89,-88,-87,-86,-85,-84,-83,-82,-80,-79,-78,-77,-76,-75,
  -74,-73,-72,-71,-70,-69,-68,-67,-66,-65,-64,-63,-62,-61,-60,-59,-58,-57,-56,-55,
  -54,-53,-52,-51,-50,-49,-48,-47,-46,-45,-44,-43,-42,-41,-40,-39,-38,-37,-35,-33,
  -29,-28,-27,-26,-24,-23,-22,-21,-20,-19,-18,-17,-16,-15,-14,-13,-12,-11,-10,-8,
  -7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,
  13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,
  33,34,35,36,38,39,40,41,42,43,44,45,47,48,49,50,51,52,53,54,
  55,56,57,58,59,60,61,62,63,65,66,67,68,69,70,71,72,74,76,77,
  78,79,80,81,82,83,84,85,86,87,88,89,91,93,94,95,96,97,98,99,
  100,101,102,103,104,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,
  121,122,123,124,125,127,-128,-127,-126,-125,-124,-123,-122,-120,-119,-118,-117,-116,-115,-114,
  -112,-111,-110,-109,-108,-107,-106,-105,-104,-103,-102,-101,-99,-98,-97,-96,-95,-94,-93,-92,
  -91,-90,-89,-88,-87,-86,-85,-84,-83,-82,-81,-80,-79,-77,-76,-75,-74,-73,-72,-70,
  -69,-68,-67,-66,-65,-64,-63,-62,-60,-59,-58,-57,-56,-55,-54,-53,-52,-51,-50,-48,
  -47,-46,-45,-43,-42,-41,-40,-39,-37,-36,-35,-34,-33,-32,-31,-30,-29,-28,-27,-26,
  -25,-24,-23,-22,-21,-20,-19,-18,-16,-15,-14,-13,-12,-11,-10,-9,-8,-7,-6,-5,
  -4,-3,-2,-1,0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,
  16,17,18,19,20,21,23,24,25,26,27,28,29,30,31,32,33,34,35,36,
  37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,53,54,55,56,57,
  58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,
  78,79,81,82,83,84,85,86,87,88,89,90,91,92,93,95};

  static byte[] DUOYIN_CODE_PADDING = new byte[]{
  -128,120,71,-39,-63,26,69,106,-112,25,111,48,3,58,-128,-68,32,-57,22,-100,
  -108,20,100,-64,-95,58,43,17,-72,109,97,-128,68,-72,68,96,-103,1,22,26,
  -7,-50,-49,49,-54,-62,46,1,10,-57,-70,-77,-52,-16,33,-91,92,-103,17,-112,
  26,108,34,49,-94,107,-52,-112,0,-33,0,-114,65,71,0,-112,71,-52,104,26,
  71,41,6,87,-84,21,74,54,125,0,26,24,118,-41,104,15,52,20,10,36,
  0,85,77,-75,41,101,-44,-128,-59,25,65,2,39,32,66,1,-32,-4,-2,71,
  -121,63,24,7,-8,21,-64,65,-126,18,-11,127,114,64,-69,20,114,-9,125,99,
  112,53,100,8,66,-70,-110,-86,70,21,-23,66,27,-17,73,108,-14,-72,113,21,
  15,4,39,125,18,-121,19,-36,64,44,1,-126,-128};
  
  static byte[] DUOYIN_CODE = new byte[]{
  -124,-53,89,-117,-21,65,58,2,-69,102,113,38,38,-36,-4,93,-114,3,-83,99,
  -6,84,1,39,35,3,90,116,104,-122,-101,-109,-117,60,36,-30,7,6,48,39,
  91,-1,-5,39,65,12,71,67,90,24,80,-126,-112,69,-122,102,-126,120,125,-14,
  -106,-116,41,-6,37,-86,41,-121,11,-84,33,-84,-127,-122,23,120,117,-72,107,-117,
  -72,102,-116,-116,-108,-97,81,127,-108,-108,84,41,-76,-127,48,-52,-53,-53,-10,-120,
  -111,102,76,-105,123,-19,96,30,89,-9,32,10,-117,34,-126,-46,-121,-121,-89,34,
  48,16,39,85,118,99,-24,-24,51,32,32,-50,32,-72,20,-5,101,5,112,3,
  33,49,49,86,-121,3,28,37,28,37,24,28,37,101,60,34,90,95,-127,96,
  86,-15,-15,106,-106,-112,119,102,2,102,-45,58,7,114,-45,-50,102,76,-112,-108,
  1,-107,90,-128,120,124,-128,111,121,91,67,-113,-101,-73,115,111,-113,-112,-101,103,
  119,-113,113,103,114,-25,83,-44,-45,-49,-102,11,-99,-41,86,-128,42,32,-108,124,
  -28,-25,32,32,49,30,30,104,57,-31,-115,-74,116,-99,-109,-126,39,-104,-53,103,
  42,-118,-128,-70,-53,111,29,39,113,-115,-25,115,30,5,-115,5,-48,74,44,-116,
  -116,41,105,124,95,61,34,106,114,-15,-18,63,70,112,-67,-90,21,99,11,14,
  -115,-107,84,13,-80,126,21,-7,64,2,56,27,96,56,126,100,-15,-128,-15,-108,
  -126,57,12,61,91,-66,-127,90,-1,118,17,-40,-51,-28,36,-125,78,-72,-121,3,
  39,102,8,2,96,20,24,89,-127,112,102,-122,94,37,91,-73,39,103,-3,-3,
  111,91,110,110,-20,35,104,54,-40,-127,19,-120,-120,-114,96,70,39,-2,111,2,
  89,77,-111,115,67,-2,85,31,48,113,48,60,-124,61,-116,60,3,3,61,76,
  -66,11,48,86,-121,3,3,-78,-116,-124,59,-124,59,59,-124,84,126,-104,-111,39,
  -124,-126,73,-96,50,-27,120,-80,23,85,6,12,-35,-51,49,6,69,84,-6,-87,
  84,84,-6,-1,62,-127,-116,4,121,38,-3,121,121,-14,115,-23,14,94,-21,35,
  125,-69,37,14,22,57,-33,102,-11,125,103,115,103,35,-78,-50,-119,-126,-126,22,
  30,-32,-126,86,-126,-73,-6,104,20,-23,109,32,32,24,63,39,-117,-122,67,-126,
  -16,44,104,-127,85,-69,32,44,-126,32,-105,-126,83,125,7,-69,52,52,85,52,
  95,-126,60,74,-126,-56,48,48,72,-127,-127,86,70,-117,111,9,-53,90,-128,-102,
  37,107,126,-7,113,10,-118,104,123,123,-101,14,-107,-128,-6,-127,-120,-13,-7,30,
  16,-58,6,-33,-6,49,-117,90,76,15,7,107,124,124,14,124,32,113,85,104,
  -96,12,-123,7,121,113,-117,126,26,18,9,-80,85,-113,38,45,-15,-125,-117,30,
  -103,75,-122,113,112,-125,-111,19,51,113,-111,41,-51,-9,-51,53,-46,36,44,-103,
  106,126,-101,113,19,-40,-111,-117,-122,113,-127,2,-6,85,39,94,100,31,-2,-2,
  6,-123,-61,-49,119,33,37,36,-117,-53,56,-53,-9,14,-9,90,45,-9,87,-122,
  125,86,-23,-125,-101,95,98,78,39,109,104,114,102,121,-125,38,109,39,-126,-123,
  -118,100,33,126,-6,0,-37,92,102,45,95,4,85,-77,57,-128,45,52,-91,126,
  62,62,-59,38,126,59,-42,92,53,80,10,-11,45,-119,6,10,70,-91,106,68,
  -114,64,61,-53,34,96,40,111,61,33,-123,-128,-3,8,-51,-4,63,112,-126,114,
  -53,-15,115,43,48,33,81,86,113,126,63,103,-105,6,126,-63,119,76,35,68,
  68,95,85,-21,41,99,94,102,56,87,-123,86,55,102,100,-127,96,20,63,-126,
  124,96,37,-55,47,92,-113,-128,2,14,99,4,-11,0,105,-126,-126,-22,58,95,
  -1,-105,85,-87,-128,-98,96,-76,39,-20,104,100,-6,-40,125,-122,32,32,-60,39,
  14,-81,36,36,14,-6,39,36,-6,80,36,120,-114,98,100,38,100,38,-127,86,
  -123,104,100,38,38,86,-123,104,100,38,100,38,7,11,49,-6,-105,-114,27,104,
  -98,111,54,-39,48,111,99,37,37,111,-63,37,-127,102,100,96,115,113,-122,-126,
  -91,-10,-127,63,123,1,105,-6,-14,96,17,52,-9,-58,-54,102,110,-127,-127,119,
  -126,-113,-111,72,100,-4,96,102,105,97,-91,-126,63,34,123,-76,-6,-14,52,-58,
  -54,26,119,-113,-126,89,28,-15,16,-3,-18,-9,63,113,73,6,103,-90,108,-21,
  92,91,-68,-53,-115,-126,-7,-115,85,104,100,76,75,-73,-20,14,85,17,85,79,
  94,94,20,-21,75,86,26,69,31,104,79,-15,92,112,63,90,-34,64,34,4,
  11,-34,-11,-126,48,85,124,104,-18,-6,98,92,98,56,37,78,40,-84,-13,-119,
  78,-72,-6,14,-127,-53,15,-95,-91,103,35,-127,-128,-112,-113,12,98,-20,96,115,
  -95,-24,-76,52,-13,78,21,80,118,98,20,-114,-2,10,24,28,20,87,-127,-127,
  -95,25,-87,113,41,77,-10,-36,-87,126,104,-124,110,13,38,65,-108,-117,104,96,
  89,46,104,124,13,124,115,3,110,85,83,39,62,-127,48,-123,-46,18,124,90,
  113,118,-120,53,-127,-123,90,-15,-5,-15,11,33,85,126,-120,73,85,14,0,87,
  -123,32,-123,1,-123,87,-123,-115,-126,-112,90,90,-50,121,4,66,46,113,46,113,
  71,36,66,-121,-63,51,97,104,122,-123,71,-123,-127,46,113,2,81,71,46,66,
  -63,122,111,85,122,-112,-87,3,114,-53,114,125,12,12,102,120,48,-108,114,12,
  102,-108,-1,51,51,-117,20,-73,39,-126,-115,67,-6,-123,-21,54,-116,-117,124,91,
  -118,90,-120,-118,-127,-117,124,91,-118,14,124,-127,-22,-96,-126,-14,80,-96,80,111,
  96,-50,103,124,72,-125,51,-9,-73,89,31,-39,-9,-9,39,85,94,75,-23,65,
  75,75,57,-65,100,-126,110,85,66,66,68,-3,77,51,-127,95,51,75,32,91,
  -100,37,-124,102,113,-105,113,-23,65,100,35,57,37,85,68,66,66,-126,-3,118,
  95,91,59,74,127,127,33,96,81,100,35,57,112,14,35,77,57,112,104,37,
  100,77,11,-15,-79,88,86,102,-79,-98,53,-114,-114,-2,-116,111,-127,24,-77,54,
  -84,-84,-59,-127,75,78,34,-103,-98,3,72,99,112,90,99,32,72,99,90,96,
  32,49,104,49,-126,60,92,117,49,60,-126,92,-10,76,76,90,-127,96,59,16,
  -121,76,57,16,32,31,90,32,88,-4,96,75,20,96,90,-124,85,86,20,90,
  -124,-123,102,-2,18,84,114,121,-40,-13,-79,66,102,121,7,-4,7,7,-87,-64,
  -53,-64,-87,-120,-59,-59,121,-98,125,-127,-127,-107,-107,-114,3,-114,3};
}
