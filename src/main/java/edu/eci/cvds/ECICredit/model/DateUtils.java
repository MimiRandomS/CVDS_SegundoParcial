package edu.eci.cvds.ECICredit.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static final SimpleDateFormat FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    public static Date convertStringToDate(String dateStr) throws ParseException {
        return FORMATTER.parse(dateStr);
    }
}
