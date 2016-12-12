package com.advencedjava.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Util {
	private final static String URL_FULL = "https://api.openagenda.com/v1/events?key=s89Zf831m52LgHMNCUTWfVdNHte8VUtG";
	private final static String URL_AGENDA = "https://api.openagenda.com/v1/agendas/24882772/events?limit=20&key=s89Zf831m52LgHMNCUTWfVdNHte8VUtG";
	private final static Boolean FULL_ACCESS = true; 
	
	public static String buildOpenAgendaURL(double lat, double lng, Date date) {
		if (FULL_ACCESS){
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			String url = URL_FULL + "&lat=" + lat + "&lng=" + lng + "&radius=2000" + "&when=" + format.format(date) + "-" + format.format(addDays(date, 5));
			System.out.println(url);
			return url;
		}
		else {
			return URL_AGENDA;
		}
	}
	
    public static Date addDays(Date date, int days)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }
}
