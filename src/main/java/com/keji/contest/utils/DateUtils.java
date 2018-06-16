package com.luglobal.contest.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by ZHAOZENGJIE004 on 2017/12/22.
 */
public class DateUtils {

    private static String dateTime = "yyyyMMddHHmmss";
    private static String dateFormat = "yyyyMMdd";

    public static String getDateTime(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(dateTime);
        return format.format(date);
    }
    public static String getDate(){
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat(dateFormat);
        return format.format(date);
    }

}
