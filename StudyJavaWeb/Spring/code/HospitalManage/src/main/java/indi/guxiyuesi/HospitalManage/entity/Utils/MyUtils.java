package indi.guxiyuesi.HospitalManage.entity.Utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @author 叶意
 * @ClassName MyUtils
 * @Description TODO
 * @createTime 2021年12月20日  05:35:00
 */
public class MyUtils {
    public static String GetWeekday() {
        String weekday = "";
        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);
        int temp = calendar.get(Calendar.DAY_OF_WEEK)-1;
        switch (temp) {
            case 1:
                weekday = "Monday";
                break;
            case 2:
                weekday = "Tuesday";
                break;
            case 3:
                weekday = "Wednesday";
                break;
            case 4:
                weekday = "Thursday";
                break;
            case 5:
                weekday = "Friday";
                break;
            case 6:
                weekday = "Saturday";
                break;
            case 0:
                weekday = "Sunday";
        }
        return weekday;
    }
}
