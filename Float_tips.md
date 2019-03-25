1.```Float```类是单精度浮点类型，```Double```是双精度浮点类型，区别就在于十进制中的小数点后几位，float为6，7位，Double是15位左右。

2.```float```在计算机中的表示是按照 符号+指数+位数表示的，和一般的表示不同，但是在二进制和十进制之间转换时符合一致的，也就是
101.11 二进制小数--->1*2^2+1*2^0+1*2^-1+1*2^-2=5.75(十进制小数)
这中间就衍生出问题：
  二进制小数只能用2的-1，-2，-3，-4等次数的和表示，那么一定存在十进制的小数后位数不能准确表示，也就是说浮点类型表示十进制小数不准确，是近似表示
  所以，银行不能用浮点数表示金额，毕竟银行的数目是要一分一毫都不能差的。