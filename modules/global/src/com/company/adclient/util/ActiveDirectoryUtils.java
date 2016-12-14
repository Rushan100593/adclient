/*
 * TODO Copyright
 */

package com.company.adclient.util;

import org.apache.commons.lang.StringUtils;

import javax.naming.Name;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author rushan
 * @since 14.12.2016
 */
public class ActiveDirectoryUtils {
    public static final long ACCOUNT_NEVER_EXPIRES_VALUE = 9223372036854775807L;
    private static final Date FILE_TIME_START_DATE;

    static {
        Calendar ldapStart = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        ldapStart.clear();
        ldapStart.set(1601, 0, 1);
        FILE_TIME_START_DATE = ldapStart.getTime();
    }

    public static boolean checkAccountNeverExpires(String timestamp) {
        return StringUtils.isBlank(timestamp) ||
                timestamp.equals(String.valueOf(ACCOUNT_NEVER_EXPIRES_VALUE)) ||
                timestamp.equals("0");
    }

    public static Date convertFileTimeToDate(String timestamp) {
        if(checkAccountNeverExpires(timestamp)) {
            return null;
        }
        long timestamp100Nanos = Long.parseLong(timestamp);
        long timestampMillis = timestamp100Nanos / 10000;
        return new Date(timestampMillis + FILE_TIME_START_DATE.getTime());
    }

    public static String convertDateToFileTime(Date date) {
        long timestamp100Nanos;
        if (date == null) {
            timestamp100Nanos = ACCOUNT_NEVER_EXPIRES_VALUE;
        } else {
            long timestampMillis = date.getTime() - FILE_TIME_START_DATE.getTime();
            timestamp100Nanos = timestampMillis * 10000;
        }
        return String.valueOf(timestamp100Nanos);
    }

    public static boolean isRelativePath(Name name, Name base) {
        return name.size() < base.size() || !name.getPrefix(base.size()).equals(base);
    }

    public static Name getRelativePath(Name name, Name base) {
        if(!isRelativePath(name, base)) {
            name = name.getSuffix(base.size());
        }
        return name;
    }
}
