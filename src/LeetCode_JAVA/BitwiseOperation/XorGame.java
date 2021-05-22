package LeetCode_JAVA.BitwiseOperation;

/**
 * https://leetcode-cn.com/problems/chalkboard-xor-game/
 * 黑板上写着一个非负整数数组 nums[i] 。Alice 和 Bob 轮流从黑板上擦掉一个数字，Alice 先手。
 * 如果擦除一个数字后，剩余的所有数字按位异或运算得出的结果等于 0 的话，当前玩家游戏失败。
 * (另外，如果只剩一个数字，按位异或运算得到它本身；如果无数字剩余，按位异或运算结果为 0。）
 * 换种说法就是，轮到某个玩家时，如果当前黑板上所有数字按位异或运算结果等于 0，这个玩家获胜。
 * 假设两个玩家每步都使用最优解，当且仅当 Alice 获胜时返回 true。
 */
public class XorGame {

    public static void main(String[] args) {
        System.out.println(new XorGame().xorGame(new int[]{1, 2, 1}));
    }

    /**
     * @param nums 用于异或的原数组 且记xor = num[0] ^ nums[1] ^...^ nums[n - 1]
     * @return 先手胜利true，后手胜利false
     * 原问题可以转化为：只要此轮擦除结束后数组异或结果不为0即此轮不输，反之则输
     * 策略：如果先手xor == 0，先手直接取胜
     * 如果数组为大小为偶数，先手取胜，反之后手取胜
     * 分析：① xor == 0: 先手直接取胜
     * ② xor != 0 时，若nums数组为偶数数组
     * xor = nums[0]^nums[1]^...^nums[n - 1] (n为偶数，即偶数个异或)
     * 若去掉元素nums[i]后的异或值记为 Si = xor ^ nums[i], i = 0, 1,.., n - 1
     * 反证法：假设对于所有的 Si==0，则必有S0^S1^...^Sn-1 = 0 (n个0异或为0)
     * 但是S0^S1^...Sn-1 = (xor ^ nums[0]) ^ (xor ^ nums[1]) ^...^(xor ^ nums[n - 1])
     *          = (xor ^ xor ^...^ xor) [n个xor] ^ (nums[0] ^ nums[1]^ ... ^nums[n - 1])
     *          = xor ^ xor ^...^ xor [n+1(奇数)个xor]
     *          = xor != 0 与原假设矛盾
     * 可得：存在Si != 0 此时先手选择擦除nums[i]即可保证此轮不输，后续先手数组仍为偶数数组，必胜
     * ③ xor != 0 时，若nums数组为奇数数组
     * 同理可得 S0^S1^...Sn-1 = xor ^ xor ^...^ xor [注：n+1(偶数)个xor] = 0
     * 原假设成立，则对于所有 Si，有Si == 0，此时先手擦除任何nums[i]均会输，必输
     * 综上：对于先手而言，初始xor为0,或初始数组为偶数数组时必胜；初始xor不为0时且初始数组为奇数数组时必输
     */
    public boolean xorGame(int[] nums) {
        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }
        if (xor == 0){
            return true;
        }
        return (nums.length & 1) == 0;
    }

}
