package com.luglobal.contest.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by ZHAOZENGJIE004 on 2017/5/22.
 */
public class DateCompareUtils {
    public static boolean isBetweenRange(Date source, Date upper, Date lower) {
        boolean result = false;

        if (upper == null && lower == null){
            result = true;
        }else if (upper == null){
            result = source.compareTo(lower) >= 0;
        }else if (lower == null){
            result = source.compareTo(upper) <= 0;
        }else {
            if (lower.compareTo(upper)>0){
                result = false;
            }
            return source.compareTo(upper) <= 0 && source.compareTo(lower) >= 0;
        }
        return result;
    }

    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.HOUR_OF_DAY,10);
        Date upper = instance.getTime();

        Calendar instance1 = Calendar.getInstance();
        instance1.add(Calendar.HOUR_OF_DAY,-10);
        Date lower = instance1.getTime();

        Date date = new Date();
        boolean betweenRange = DateCompareUtils.isBetweenRange(upper,null , date);
        System.err.println(new Date());
        System.err.println(upper);
        System.err.println(lower);
        System.err.println("是否处于时间区间内："+betweenRange);
    }

}
