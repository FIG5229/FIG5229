package com.hl.analyze.utils;

import com.hl.analyze.utils.enums.DateFmtEnum;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Starry
 * @date 9:46 2018/4/13 Modified By:
 */
public class DateUtils {

    /**
     * 日期格式化
     */
    private final static String gs = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转换字符串
     */
    public static String parseDate(Date date, String gs) {
        SimpleDateFormat sdf = new SimpleDateFormat(gs);
        return sdf.format(date);

    }

    public static String parseDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(gs);
        return sdf.format(date);
    }

    /**
     * 字符串转为日期
     */
    public static Date StringToDate(String time, String gs) {
        SimpleDateFormat sDateFormat = new SimpleDateFormat(gs);
        Date d = null;
        try {
            d = sDateFormat.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;

    }

    public static String getSpecifiedDayBefore(String specifiedDay) {

        Calendar c = Calendar.getInstance();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
        } catch (ParseException e) {
            e.printStackTrace();

        }

        c.setTime(date);
        int day = c.get(Calendar.DATE);

        c.set(Calendar.DATE, day - 1);

        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());

        return dayBefore;

    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static String getDate() {
        Date date = new Date();
        String d = parseDate(date, "yyyy-MM-dd HH:mm:ss");
        return d;
    }

    public static Integer getDifference(Date beginTime, Date endTime) {
        return (int) ((endTime.getTime() - beginTime.getTime()) / (1000 * 3600 * 24));
    }

    /**
     * 获取输入时间与当前时间的差
     *
     * @param time  比较时间
     * @param level 深入层，x年x月x天x时x秒之前，level用来确定精确层数，比如level=2 则x年x月 若年为0 则x月x天
     * @return x年x月x天x时x秒之前，层数受level约束
     */
    public static String getDateDiffForNow(LocalDateTime time, int level) {
        return getDateDiffStr(time, LocalDateTime.now(), level);
    }

    /**
     * 获取输入时间之间时间差
     *
     * @param before 之前时间
     * @param after  之后时间
     * @param level  深入层，x年x月x天x时x秒之前，level用来确定精确层数，比如level=2 则x年x月 若年为0 则x月x天
     * @return x年x月x天x时x秒，层数受level约束
     */
    public static String getDateDiffStr(LocalDateTime before, LocalDateTime after, int level) {
        int currLevel = 0;
        long lastData = 0;
        List<ChronoUnit> chL = Arrays.asList(ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.DAYS, ChronoUnit.HOURS,
                ChronoUnit.MINUTES, ChronoUnit.SECONDS);
        // 记录中文的时间描述
        String[] desCn = {"年", "月", "天", "小时", "分", "秒"};
        // 记录相邻的两个时间刻度之间的转换值，为方便计算，第一位为空缺0
        int[] diff = {0, 12, 30, 24, 60, 60};

        StringBuilder timeSb = new StringBuilder();

        for (int i = 0; i < chL.size(); i++) {
            long cal = chL.get(i).between(before, after);
            if (cal != 0) {
                timeSb.append(cal - lastData * diff[i]).append(desCn[i]);
                currLevel++;
                lastData = cal;

                if (currLevel == level) {
                    break;
                }
            }
        }

        return timeSb.toString();
    }

    /**
     * 返回当前时间字符串，格式：yyyy-MM-dd HH:mm:ss
     *
     * @return
     */
    public static String getNowStr() {
        return getNowStr(com.hl.analyze.utils.enums.DateFmtEnum.FMT_SECODE_HYPHEN);
    }

    /**
     * 根据格式化格式返回当前时间
     *
     * @param fmt 格式化
     * @return
     */
    public static String getNowStr(com.hl.analyze.utils.enums.DateFmtEnum fmt) {
        return getNowStr(fmt.getValue());
    }

    /**
     * 根据格式化格式返回当前时间
     *
     * @param fmt 格式化
     * @return
     */
    public static String getNowStr(String fmt) {
        return LocalDateTimeFmt(LocalDateTime.now(), fmt);
    }

    /**
     * 将时间格式化为字符串，默认格式化为yyyy-MM-dd HH:mm:ss
     *
     * @param time 时间
     * @return
     */
    public static String LocalDatetimeFmt(LocalDateTime time) {
        return LocalDateTimeFmt(time, com.hl.analyze.utils.enums.DateFmtEnum.FMT_SECODE_HYPHEN);
    }

    /**
     * 将时间格式化为字符串
     *
     * @param time 时间
     * @param fmt  格式化
     * @return
     */
    public static String LocalDateTimeFmt(LocalDateTime time, DateFmtEnum fmt) {
        return LocalDateTimeFmt(time, fmt.getValue());
    }

    /**
     * 将时间格式化为字符串
     *
     * @param time 时间
     * @param fmt  格式化
     * @return
     */
    public static String LocalDateTimeFmt(LocalDateTime time, String fmt) {
        return time.format(DateTimeFormatter.ofPattern(fmt));
    }

    // 计算日期时间差（小时）
    public static long getDateHour(Date startDate, Date endDate) {
        long nd = 1000 * 60 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少天
//        long day = diff / nd /24;
        // 计算差多少小时
        long hour = diff / nd;
        return hour;
    }

    // 计算日期时间差（分钟）
    public static long getDateMinute(Date startDate, Date endDate) {
        long nd = 1000 * 60;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - startDate.getTime();
        // 计算差多少分钟
        long minute = diff / nd;
        return minute;
    }

    // 计算当前时间到次日0点秒数
    public static long getTomorrowZeroSeconds() {
        long current = System.currentTimeMillis();// 当前时间毫秒数
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        long tomorrowzero = calendar.getTimeInMillis();
        long tomorrowzeroSeconds = (tomorrowzero - current) / 1000;
        return tomorrowzeroSeconds;
    }

}