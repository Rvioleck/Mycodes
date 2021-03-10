package Lanqiao.Provincial10th;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class GetText {

    public static List<List<Integer>> getText(String address){
        List<List<Integer>> res = new ArrayList<>();
        try {
            String encoding = "GBK";
            File file = new File(address);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    List<Integer> oneLine = new ArrayList<>();
                    String[] chars = lineTxt.split(" ");
                    for (String ch : chars) {
                        oneLine.add(Integer.valueOf(ch));
                    }
                    res.add(new ArrayList<>(oneLine));
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
//        System.out.println(team);
        return res;
    }

}
