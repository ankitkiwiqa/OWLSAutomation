package com.owls.init;

import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class temp {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		//24 Aug 2016 18:56
		/*Date date1  =  new Date();
		 DateFormat f = new SimpleDateFormat("dd MMM yyyy H:mm");
		System.out.println(f.format(date1));
	
		ArrayList<String> dateStringList = new ArrayList<String>();
		
			dateStringList.add("24 Aug 2016 19:56");

			dateStringList.add("24 Aug 2016 15:56");
			
			dateStringList.add("24 Aug 2016 12:56");
			
			dateStringList.add("24 Aug 2016 24:56");
			
			dateStringList.add("24 Aug 2016 03:56");

	Collections.sort(dateStringList, new Comparator<String>() {
        DateFormat f = new SimpleDateFormat("dd MMM yyyy H:mm");
        @Override
        public int compare(String o1, String o2) {
            try {
                return f.parse(o1).compareTo(f.parse(o2));
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    });
	
	System.out.println(dateStringList);*/
		String candidate = "Candidate Four (c4)";
		System.out.println(candidate.replaceAll("(.*)\\(", "").replaceAll("\\)", ""));//.replaceAll("\\w+ \\w+\\)", "").trim());
		
		/* SimpleDateFormat format1 = new SimpleDateFormat("dd/mm/yyyy");
		    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
		    Date date = format1.parse("09/04/2017");
		    System.out.println(format2.format(date));*/
		    
		    Format formatter = new SimpleDateFormat("dd-MMM-yy");
		  //  String s = formatter.format("09/11/2017");
		 //   System.out.println(s);
		    
		    SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
		    SimpleDateFormat format2 = new SimpleDateFormat("dd-MMM-yy");
		    Date date = format1.parse("05-12-1999");
		    System.out.println(format2.format(date));
	}
}
