package com.jarvis.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateTimeUtil {

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/YYYY hh:mm:ss a");
	
	SimpleDateFormat formatterDateFile= new SimpleDateFormat("yyyyMMddHHmmss");
    
	public String msToStrDate(String fileName) {
		try {
			long ms = Long.parseLong(fileName.split("\\.")[0]);
			return dateToString(new Date(ms));
		}catch (Exception e) {
			e.printStackTrace();
			return "fileName";
		}
	}
	
	public String dateToString(Date date) {
		return df.format(date);
	}
	
	public String dateToStringForFile(Date date) {
		return formatterDateFile.format(date);
	}
	
	public Date getDateVariation(Integer variation, Date currentDate) {
	    Calendar c = Calendar.getInstance();
	    c.setTime(currentDate);
	    c.add(Calendar.DAY_OF_YEAR, - (variation));
	    return c.getTime();
	}
}
