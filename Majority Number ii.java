public class Solution {
    /**
     * @param nums: A list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(ArrayList<Integer> nums) {
        // write your code
        int n1 = 0, n2 = 0;
        int count1 = 0, count2 = 0;
        for(int i=0; i<nums.size(); i++) {
            int tmp = nums.get(i);
            if(count1!=0 && n1==tmp)
                count1++;
            else if(count2!=0 && n2==tmp)
                count2++;
            else if(count1==0) {
                count1 = 1;
                n1 = tmp;
            }
            else if(count2==0) {
                count2 = 1;
                n2 = tmp;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for(int i=0; i<nums.size(); i++) {
            if(nums.get(i)==n1)
                count1++;
            else if(nums.get(i)==n2)
                count2++;
        }
        return count1>count2?n1:n2;
    }
}

与Majority Number 1相似。但我们要保存2个number.

1. 遇到第一个不同的值，先记录number 2.

2. 新值与n1,n2都不同，则cnt1,cnt2都减少

3. 当n1,n2任意一个为0时，从新值中挑出一个记录下来。

4. 最后再对2个候选值进行查验，得出最终的解。

主页君其实也想不太明白这个题目为什么这样解。

还是举个例子吧

        7 1 7 7  61 61 61 10 10 10 61

n1      7 7 7 7  7  7   7  7  7 10 10

cnt1    1 1 2 3  2  2   2  1  0  1  1

n2      0 1 1 1  1  61  61 61 61 61 61

cnt2    0 1 1 1  0  1   2  1  0  0  1

证明：

1. 我们对cnt1,cnt2减数时，相当于丢弃了3个数字（当前数字，n1, n2）。也就是说，每一次丢弃数字，我们是丢弃3个不同的数字。

而Majority number超过了1/3所以它最后一定会留下来。

设定总数为N, majority number次数为m。丢弃的次数是x。则majority 被扔的次数是x

而m > N/3, N - 3x > 0. 

3m > N,  N > 3x 所以 3m > 3x, m > x 也就是说 m一定没有被扔完

最坏的情况，Majority number每次都被扔掉了，但它一定会在n1,n2中。

2. 为什么最后要再检查2个数字呢？因为数字的编排可以让majority 数被过度消耗，使其计数反而小于n2，或者等于n2.前面举的例子即是。

另一个例子：

1 1 1 1 2 3 2 3 4 4 4 这个 1就会被消耗过多，最后余下的反而比4少。


http://www.cnblogs.com/yuzhangcmu/p/4175779.html