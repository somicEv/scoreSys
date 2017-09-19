package com.ztkj.scoreSys.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    /**
     * 将时间字符串转换为时间类型
     * @param dateStr 需要转换的时间字符串
     * @return 转换之后的时间类型对象
     */
    public static Date toUtilDate(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return date;
    }

    /**
     * 将时间转换为时间字符串
     * @param date 需要转换的时间
     * @return 转换之后的时间字符串
     */
    public static String toStringDate(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = null;
        dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * 将java.util.Date类型转换为java.sql.Date类型
     * @param utilDate 需要转换的java.util.Date对象
     * @return 转换后的java.sql.Date对象
     */
    public static java.sql.Date utilDateToSqlDate(Date utilDate){
        java.sql.Date sqlDate = null;
        // utilDate.getTime():1970.1.1 00:00:00到utilDate的毫秒数
        sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public static java.sql.Timestamp utilDateToTimestamp(Date utilDate){
        java.sql.Timestamp tt = null;

        tt = new java.sql.Timestamp(utilDate.getTime());

        return tt;
    }

}
