package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.List;

public class H_CharacterRelativity_Java {

    private int relativity(int k, String str){
        int len = str.length();
        int i = 0, j = 0;
        List<Integer> aliceIndexes = new ArrayList<>(); // 记录Alice串出现的所有的首位置
        List<Integer> bobIndexes = new ArrayList<>();   // 记录Bob串出现的所有首位置
        while (i < len){
            // indexOf方法为字符串匹配算法，从下标i开始在str中找到字符串的下标位置(需要熟练使用)
            int index = str.indexOf("Alice", i); // C/C++中为string库中的find方法
            if (index == -1){ // indexOf算法若无匹配时，返回-1，此时该串不存在原串中
                break;
            }
            aliceIndexes.add(index); // 将当前下标加入集合
            i = index + 1;           // 使下次的搜索位置从下一个字符开始

            // 如果对于字符串AliceAliceBobAlice开始搜索"Alice":
            // 第一次while循环从i = 0开始搜索，得到下标0(第一次出现在0)加入集合，
            // 第二次while循环从i = 1开始搜索，得到下标5(第二次出现在5)加入集合,
            // 第三次while循环从i = 6开始搜索，得到下标13(第三次出现在13)加入集合
        }
        while (j < len){
            // Bob同理
            int index = str.indexOf("Bob", j);
            if (index == -1){
                break;
            }
            bobIndexes.add(index);
            j = index + 1;
        }
        int count = 0;
        // 遍历aliceIndex和bobIndex
        for (int aliceIndex : aliceIndexes) {
            for (int bobIndex : bobIndexes) {
                if (aliceIndex < bobIndex && aliceIndex + 5 + k < bobIndex) break;
                if (bobIndex < aliceIndex && bobIndex + 3 + k >= aliceIndex){
                    // 如果bobIndex < aliceIndex(前提)时, 满足bobIndex + 3 + k >= aliceIndex(判断条件)
                    // 计数器+1
                    count++;
                }
                if (aliceIndex < bobIndex && aliceIndex + 5 + k >= bobIndex){
                    // 如果aliceIndex < bobIndex(前提)时, 满足aliceIndex + 5 + k >= bobIndex(判断条件)
                    // 计数器+1
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int k = 20;
        String str = "This is a story about Alice and Bob. Alice wants to send a private message to Bob.";
        System.out.println(new H_CharacterRelativity_Java().relativity(k, str));
    }

}
