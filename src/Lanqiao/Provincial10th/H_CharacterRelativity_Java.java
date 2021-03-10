package Lanqiao.Provincial10th;

import java.util.ArrayList;
import java.util.List;

public class H_CharacterRelativity_Java {

    private int relativity(int k, String str){
        int len = str.length();
        int i = 0, j = 0;
        List<Integer> aliceIndexes = new ArrayList<>();
        List<Integer> bobIndexes = new ArrayList<>();
        while (i < len){
            int index = str.indexOf("Alice", i);
            if (index == -1){
                break;
            }
            aliceIndexes.add(index);
            i = index + 1;
        }
        while (j < len){
            int index = str.indexOf("Bob", j);
            if (index == -1){
                break;
            }
            bobIndexes.add(index);
            j = index + 1;
        }
        int count = 0;
        for (int aliceIndex : aliceIndexes) {
            for (int bobIndex : bobIndexes) {
                if (aliceIndex < bobIndex && aliceIndex + 5 + k < bobIndex) break;
                if (bobIndex < aliceIndex && bobIndex + 3 + k >= aliceIndex){
                    count++;
                }
                if (aliceIndex < bobIndex && aliceIndex + 5 + k >= bobIndex){
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
