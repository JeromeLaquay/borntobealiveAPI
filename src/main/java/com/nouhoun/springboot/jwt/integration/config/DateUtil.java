package com.nouhoun.springboot.jwt.integration.config;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class DateUtil {

    public static Date stringToDate( String dateString) throws ParseException {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.parse(dateString);
    }
}
