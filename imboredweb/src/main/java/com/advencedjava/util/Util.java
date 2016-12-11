package com.advencedjava.util;

public class Util {
	private final static String URL_OPENAGENDA_API = "https://api.openagenda.com/v1/agendas/7454155/events?";
	private final static String KEY_OPENAGENDA = "s89Zf831m52LgHMNCUTWfVdNHte8VUtG";
	
	public static String buildOpenAgendaURL(double lat, double lng) {
		return URL_OPENAGENDA_API + "lat=" + lat + "&lng=" + lng + "&radius=1000&key=" + KEY_OPENAGENDA;
	}
}
