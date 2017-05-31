package test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by 张志鹏 on 2017/4/30.
 */
public class DateTest {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = format.format(new Date());
        System.out.println(dateStr);
    }
}
