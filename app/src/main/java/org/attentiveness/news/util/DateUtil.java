package org.attentiveness.news.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class DateUtil {

    public static String getToday() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        SimpleDateFormat simpleDateFormat = getDataFormat();
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String getDate(int before) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, 1 - before);
        SimpleDateFormat simpleDateFormat = getDataFormat();
        return simpleDateFormat.format(calendar.getTime());
    }

    private static SimpleDateFormat getDataFormat() {
        return new SimpleDateFormat("yyyyMMdd", Locale.US);
    }

}
