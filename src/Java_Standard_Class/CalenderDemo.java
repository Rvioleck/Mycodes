package Java_Standard_Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderDemo {
    public static void main(String[] args) throws ParseException {
        // 获得日历对象
//		Calendar c1 = Calendar.getInstance();
//		// 设置周一为一周的第一天
//		c1.setFirstDayOfWeek(Calendar.MONDAY);
//		// 输出日历
//		System.out.println(c1.getTime().toString());
//		// 显示当前对象的日期和各个分量
//		// 创建日历对象，时间为2020年11月8日晚上8时8分8秒
//
//		Calendar c2 = new GregorianCalendar(2020, 11, 8, 20, 8, 8);
//		// 计算今天距离2010年11月8日的天数
//		int days = c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR);
//		System.out.println("距离2020年12月8日还有："+days+"天");
//
//		// 设置日期和时间分量
//		c1.set(2030, 11, 30);
//		c1.set(Calendar.HOUR, 10);
//		c1.set(Calendar.MINUTE, 29);
//		c1.set(Calendar.SECOND, 22);
//		System.out.println("更新后时间：");
//		System.out.println(c1.getTime().toString());
//		// 调整时间和日期
//		c1.add(Calendar.DATE, 10);  // 日期增加10天
//		c1.add(Calendar.HOUR_OF_DAY, 10); // 小时增加10小时
//		System.out.println("调整后时间为：" + c1.getTime().toString());
        SimpleDateFormat myFmt = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        SimpleDateFormat myFmt1 = new SimpleDateFormat("yy/MM/dd HH:mm");
        SimpleDateFormat myFmt2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat myFmt3 = new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒E");
        SimpleDateFormat myFmt4 = new SimpleDateFormat("一年中的第D天 一年中的第w个星期 在一天中k时z时区");
        Date now = new Date();
        System.out.println(now.toString());
        // 格式化输出
        String ds1 = myFmt.format(now);
        System.out.println(ds1);
        System.out.println(myFmt1.format(now));
        System.out.println(myFmt2.format(now));
        System.out.println(myFmt3.format(now));
        System.out.println(myFmt4.format(now));
        // 解析字符串为日期对象
        String ds2 = new String(ds1);
        Date d = myFmt.parse(ds2);
        // 创建日历，日期计算
        Calendar c = Calendar.getInstance();
        c.setTime(d);
        c.add(Calendar.YEAR, 20);
        System.out.println(c.getTime());
    }
}
