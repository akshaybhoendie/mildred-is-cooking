package com.unasat.utility;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;

public class UtilityMethods {

    public static final String generatedColumns[] = { "id" };

    public static LocalDate convertSqlDateToLocalDate(Date dateToConvert) {
        LocalDate localdate = Date.valueOf(String.valueOf(dateToConvert)).toLocalDate();
        return localdate;
    }

    public static String convertSqlDateToLocalDateToString(Date dateToConvert) {
        LocalDate localdate = Date.valueOf(String.valueOf(dateToConvert)).toLocalDate();
        return localdate.toString();
    }

    public static Date convertLocalDateToSqlDate(LocalDate localDate){
        Date date = Date.valueOf(localDate);
        return date;
    }

    public static boolean intToBoolean(int value){
        if(value == 0){
            return false;
        }
        return true;
    }

    public static boolean isInputNotCorrect(String input) {
        return (input == null || input.trim().isEmpty());
    }

    public static boolean isOptionCorrect(String input) {
        if (input != null) {
            if (input.trim().equalsIgnoreCase("1")) {
                return true;
            } else if (input.trim().equalsIgnoreCase("2")) {
                return true;
            } else if (input.trim().equalsIgnoreCase("3")) {
                return true;
            } else if (input.trim().equalsIgnoreCase("4")) {
                return true;
            } else if (input.trim().equalsIgnoreCase("5")) {
                return true;
            } else if (input.trim().equalsIgnoreCase("6")) {
                return true;
            }
        }
        return false;
    }
}
