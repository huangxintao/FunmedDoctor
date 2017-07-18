package me.murphy.common.commonutils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by murphy on 16/7/5.
 * 日期时间工具类
 */
public class DateUtils {
    /**
     * 输入日期增加天数
     *
     * @param s 要改变你的日期
     * @param n 要改变的天数
     * @return 改变后的天数
     */
    public static String addDay(String s, int n) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            Calendar cd = Calendar.getInstance();
            cd.setTime(sdf.parse(s));
            cd.add(Calendar.DATE, n);//增加一天
            return sdf.format(cd.getTime());

        } catch (Exception e) {
            return null;
        }

    }

    public static String getToday(long time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String today = format.format(time);
        return today;
    }

    /**
     * des 是否和当天是同一天
     *
     * @param des
     * @return
     */
    public static boolean isInOneDay(final Date des) {
        return isInOneDay(des, new Date());
    }

    /**
     * one和two是否是同一天
     *
     * @param one
     * @param two
     * @return
     */
    @SuppressWarnings("deprecation")
    public static boolean isInOneDay(final Date one, final Date two) {
        Date a = new Date(one.getTime());
        Date b = new Date(two.getTime());
        a.setHours(1);
        a.setMinutes(1);
        a.setSeconds(1);
        b.setHours(1);
        b.setMinutes(1);
        b.setSeconds(1);
        if (a.after(b) || a.before(b)) {
            return false;
        }
        return true;
    }

    /**
     * String时间格式转成Date格式
     *
     * @param time yyyy-MM-dd HH:mm:ss格式
     * @return
     */
    public static Date formatStringToDate(final String time) {
        return formatStringToDate(time, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * String时间格式转成Date格式
     *
     * @param time
     * @param format
     * @return
     */
    public static Date formatStringToDate(final String time, final String format) {
        SimpleDateFormat formate = new SimpleDateFormat(format, Locale.getDefault());
        Date date = null;
        try {
            date = formate.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * String时间格式转成Date格式
     *
     * @param time yyyy-MM-dd
     * @return
     */
    public static String formatStringDateType(final String time) {
        Pattern p = Pattern.compile("-");
        Matcher m = p.matcher(time);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, "/");// 实现非终端添加和替换步骤
        }
        m.appendTail(sb);
        return sb.toString();
    }

    /**
     * 返回当前日期
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getNowDate() {
        return formatTime("yyyy-MM-dd HH:mm:ss", new Date());
    }

    /**
     * 返回当前日期
     *
     * @param format 例如： "yyyy-MM-dd HH:mm:ss"
     * @return 例如：2015-06-01 00:00:00
     */
    public static String getNowDateFormat(final String format) {
        return formatTime(format, new Date());
    }

    /**
     * 格式化时间
     *
     * @param format 例如："yyyy-MM-dd HH:mm:ss"
     * @param time   时间的long形式
     * @return 例如：2015-06-01 00:00:00
     */
    public static String formatTime(final String format, final Long time) {
        return formatTime(format, new Date(time));
    }

    /**
     * 格式化时间
     *
     * @param formater 例如："yyyy-MM-dd HH:mm:ss"
     * @param date     时间Date形式
     * @return 例如：2015-06-01 00:00:00
     */
    public static String formatTime(final String formater, final Date date) {
        return new SimpleDateFormat(formater).format(date);
    }

}
