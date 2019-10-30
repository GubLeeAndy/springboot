package com.example.springboot.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Title:
 * @Description TODO(时间处理)
 * @param
 * @author zhangning
 * @Date 2019/9/26 14:11
 */
public class DateUtil {
    public static SimpleDateFormat hourFormatter = new SimpleDateFormat("HH:mm");
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormat_YMR = new SimpleDateFormat("yyyyMMdd");
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat minuteTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    public static final String MONTH = "MONTH";
    public static final String WEEK = "WEEK";
    public static final String DAY = "DAY";
    public static final String HOUR = "HOUR";
    public static final String MINUTE = "MINUTE";
    public static final String SECOND = "SECOND";
    public static final String[] WEEK_DAYS = {"周日", "周一", "周二", "周三", "周四", "周五", "周六"};

    public synchronized static String YMDHM() throws ParseException {
        return dateTimeFormat.format(new Date());
    }

    public synchronized static String YMD() {
        return dateFormat_YMR.format(new Date());
    }

    public synchronized static String createTime() {
        return dateTimeFormat.format(new Date());
    }

    public synchronized static Date now() {
        return new Date();
    }


    /**
     * @param
     * @throws ParseException
     * @Title: dateTimeFormat
     * @Description: TODO(格式化时间)
     * @author gyu
     * @date 2017年5月31日上午11:48:41
     */
    public synchronized static Date dateTimeFormat(String dateTime) throws ParseException {
        return dateTimeFormat.parse(dateTime);
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description 获取当日 0点0分0秒时间
     * @Date 15:52 2019/5/13
     * @Param []
     **/
    public static Date getTimeDayStart() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description // 获取凌晨1点的时间
     * @Date 17:03 2019/7/9
     * @Param []
     **/
    public static Date getTimeOneAM() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, 1);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description // 获取前 past 个整点时间
     * @Date 17:20 2019/7/9
     * @Param []
     **/
    public static Date getTimeAlarm(Integer past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - past);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description 获取本周一 0点0分0秒时间
     * @Date 15:52 2019/5/13
     * @Param []
     **/
    public static Date getTimeWeekStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
        return cal.getTime();
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description 获取从 data 时间往前 past 天数的起始时间
     * @Date 19:12 2019/5/14
     * @Param [date, past]
     **/
    public static Date getNearPastDaysStart(Date date, int past) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description 获取本月 1号0点0分0秒时间
     * @Date 15:52 2019/5/13
     * @Param []
     **/
    public static Date getTimeMonthStart() {
        Calendar cal = Calendar.getInstance();
        cal.set(cal.get(Calendar.YEAR), cal.get(Calendar.MONDAY), cal.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * @return java.util.List<java.util.Date>
     * @Author WuRui
     * @Description 获取 按月/日/时/分 切分的时间片段
     * @Date 15:52 2019/5/13
     * @Param [dateType, dBegin]
     **/
    public static List<Date> getTimesSegmentation(String dateType, Date dBegin, Date dEnd) {
        List<Date> listDate = new ArrayList<>();
        Calendar calBegin = Calendar.getInstance();
        calBegin.get(Calendar.DAY_OF_YEAR);
        calBegin.setTime(dBegin);
        Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(dEnd);
        listDate.add(dBegin);
        while (calEnd.after(calBegin)) {
            switch (dateType) {
                case MONTH:
                    calBegin.add(Calendar.MONTH, 1);
                    break;
                case DAY:
                    calBegin.add(Calendar.DAY_OF_YEAR, 1);
                    break;
                case HOUR:
                    calBegin.add(Calendar.HOUR, 1);
                    break;
                case MINUTE:
                    calBegin.add(Calendar.MINUTE, 1);
                    break;
            }
            if (calEnd.after(calBegin)) {
                listDate.add(calBegin.getTime());
            } else {
                listDate.add(calEnd.getTime());
            }
        }
        return listDate;
    }

    /**
     * @return
     * @Description:(获得昨日当前时间)
     * @returnType:Date
     * @author: JackQin
     * @date: 2019年5月15日下午2:04:56
     */
    public static Date getYesterdayTimeDayEnd() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return cal.getTime();
    }

    /**
     * @return
     * @Description:(获得昨日零点时间)
     * @returnType:Date
     * @author: JackQin
     * @date: 2019年5月15日下午2:04:56
     */
    public static Date getYesterdayTimeDayStrart() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();
    }

    /**
     * @return java.lang.Long
     * @Author WuRui
     * @Description // 获取今天剩余时间
     * @Date 18:00 2019/7/9
     * @Param []
     **/
    public static Long getRestOfDay() {
        final Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 23);
        cal.set(Calendar.MINUTE, 59);
        cal.set(Calendar.SECOND, 59);
        final Long seconds = (cal.getTimeInMillis() - System.currentTimeMillis()) / 1000;
        return seconds;
    }

    /**
     * @return java.util.Date
     * @Author WuRui
     * @Description // 转换字符串为时间，无法转换时返回当前时间
     * @Date 16:32 2019/7/25
     * @Param [time]
     **/
    public static Date StringToDate(String time) {

        try {
            return dateTimeFormat.parse(time);
        } catch (Exception e) {
            try {
                return dateFormat.parse(time);
            } catch (Exception e1) {
                try {
                    return minuteTimeFormat.parse(time);
                } catch (Exception e2) {
                    return null;
                }
            }
        }

    }
}
