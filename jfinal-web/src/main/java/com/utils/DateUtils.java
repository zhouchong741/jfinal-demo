package com.utils;


/**
 * Created by xxx on 2017/4/25.
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {
    public static String getNow() {
        return DateFormatUtils.format(System.currentTimeMillis(), DateFormatUtils.DEFAULT_YYYY_MM_DD_HH_MIN_SS);
    }

    public static String getNow(String format) {
        return DateFormatUtils.format(System.currentTimeMillis(), format);
    }

    public static String getNYR(String format) {
        return DateFormatUtils.format(System.currentTimeMillis(), format);
    }
}
