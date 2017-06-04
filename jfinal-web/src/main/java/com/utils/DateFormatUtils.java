package com.utils;

import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;

/**
 * 时间格式化工具类
 * Created by xxx on 2017/4/25.
 */
public class DateFormatUtils  extends org.apache.commons.lang3.time.DateFormatUtils {

    /**
     * 默认的日期格式 .
     */
    public static final String DEFAULT_YYYY_MM_DD_HH_MIN_SS = "yyyy-MM-dd HH:mm:ss";

    /**
     * 存储文件 只要年月日
     */
    public static final String DEFAULT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String ALIYUN_DATE_FORMAT = "yyyy-MM-dd'T'hh:mm:ss'Z'";

    /**
     * "yyyy-MM-dd HH:mm:ss"
     *
     * @param date
     * @return
     */
    public static String format(final Date date) {
        return format(date, DateFormatUtils.DEFAULT_YYYY_MM_DD_HH_MIN_SS);
    }

    public static String formatNYR(final Date date){
        return format(date,DateFormatUtils.DEFAULT_YYYY_MM_DD);
    }

    public static void main(String[] args) throws Exception {
        Date date = DateUtils.parseDate("2014-11-11 20:0:00", DEFAULT_YYYY_MM_DD_HH_MIN_SS);
        System.out.println(format(new Date(),ALIYUN_DATE_FORMAT, TimeZone.getTimeZone("UTC"), Locale.US));
        System.out.println(format(date,ALIYUN_DATE_FORMAT, TimeZone.getTimeZone("UTC"),Locale.US));
        System.out.println(UUID.randomUUID());
    }

}
