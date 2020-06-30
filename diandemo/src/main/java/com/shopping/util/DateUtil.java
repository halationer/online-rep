package com.shopping.util;



import java.text.SimpleDateFormat;
import java.util.Date;

//??util

public class DateUtil {
	private  static final String STANDARD_FORMAT="yyyy-MM-dd HH:mm:ss";
	public static String dataToStr(Date date,String formate )
	{
		
		SimpleDateFormat ft = new SimpleDateFormat(formate);
		return ft.format(date);
		
	}
	public static String dataToStr(Date date)
	{
		SimpleDateFormat ft = new SimpleDateFormat(STANDARD_FORMAT);
		return ft.format(date);
		
	}
	public static Date strToDate(String str)
	{
		SimpleDateFormat formatter = new SimpleDateFormat(STANDARD_FORMAT);
		Date date = null;
		try {
		date = formatter.parse(str);
		} catch (java.text.ParseException e) {
		e.printStackTrace();
		}
		return date;
		}
		
}

