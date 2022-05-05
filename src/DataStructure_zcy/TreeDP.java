package DataStructure_zcy;

import java.util.List;

public class TreeDP {

    static class Employee{
        public int happy;
        public List<Employee> nexts;
    }

    static class Info{
        public int comeHappy;
        public int noComeHappy;
        public Info(int come, int no){
            comeHappy = come;
            noComeHappy = no;
        }

    }

    public int maxHappy(Employee boss){
        Info headInfo = process(boss);
        return Math.max(headInfo.comeHappy, headInfo.noComeHappy);
    }

    public Info process(Employee x){
        if (x.nexts.isEmpty()){
            return new Info(x.happy, 0);
        }
        int come = x.happy;
        int noCome = 0;
        for (Employee next : x.nexts){
            Info nextInfo = process(next);
            come += nextInfo.noComeHappy;
            noCome += Math.max(nextInfo.comeHappy, nextInfo.noComeHappy);
        }
        return new Info(come, noCome);
    }

}
