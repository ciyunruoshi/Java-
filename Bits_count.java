/**
 * 在数组中，出了一个数，其他都出现了三次，找到那个数。
 * 转换为求bits
 * 1 不断叠加，出现三次的bits变为0，也就去掉了混入的三次数
 * 2 妖排除出现三次的数字，那就使用三进制
 * 
 */

public class Solution {
    public int singleNumber(int[] A) {
        int ones= 0; //出现一次的数
        int twos = 0;//出现两次的数
        int three=0;//出现三次的数的叠加
        for(int i=0;i<A.length;i++){
            int t = A[i];
            twos|= ones&t;  //更新出现两次的bits
            ones^=t;        //使用异或可以模拟二进制，出现一次为1，出现二次为0，出
                            //现三次为1，最后这个1需要手动去除
            three=twos&ones;//没加一个数，判断出现三次的bits,然后去掉。
            ones&=~three;
            twos&=~three;
            //这里由三个int来模拟三进制，并保存bits。
            //从总体上看，出现三次的数，会被这种方法消除，剩下的就是所求。
        }
        return ones;
    }
}