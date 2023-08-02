package com.solvd.qa.carina.demo.mobile.gui.pages.common.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class UtilClock {

    public static String getCurrentTime() {
        Date currentTime = Calendar.getInstance().getTime();

        SimpleDateFormat formatter = new SimpleDateFormat("h:mm a");
        return formatter.format(currentTime).replace(" ", "\u200A");
    }

    public static String getCurrentDate() {
        Date currentDate = Calendar.getInstance().getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE, MMM d");
        return formatter.format(currentDate);
    }
}
