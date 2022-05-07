package DataStructure_zcy.dfs_dp;

public class MinBags {

    public int minBags(int apple){
        // apple能够被8和6组合而成
        if  (apple < 0){
            return -1;
        }
        int bag6 = -1;
        int bag8 = apple / 8;
        int rest = apple - 8 * bag8;
        while (bag8 >= 0 && rest < 24){
            int restUse6 = minBagBase6(rest);
            if (restUse6 != -1){
                bag6 = restUse6;
                break;
            }
            rest = apple - 8 * (--bag8);
        }
        return bag6 == -1 ? -1 : bag6 + bag8;
    }

    public int minBagBase6(int rest){
        return rest % 6 == 0 ? rest / 6 : -1;
    }


}
