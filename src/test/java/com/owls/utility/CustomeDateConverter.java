package com.owls.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomeDateConverter {
	
	public  static String convertDate(String str1) throws ParseException
	{
		 SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy");
		    Date date = format1.parse(str1);
		    return format2.format(date);
	}
	

}
