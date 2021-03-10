package Lanqiao.Provincial10th;

public class C_SeriesValue_Java_C {

    private int getValue(int index){
        if (index <= 3){
            return 1;
        }
        index -= 3;
        int i1 = 1, i2 = 1, i3 = 1;
        while (index-- != 0){
            int sum = (i1 + i2 + i3) % 10000;
            i1 = i2;
            i2 = i3;
            i3 = sum;
        }
        return i3;
    }


    public static void main(String[] args) {
        int index = 20190324;
//        int index = 5;
        System.out.println(new C_SeriesValue_Java_C().getValue(index));
    }

}
