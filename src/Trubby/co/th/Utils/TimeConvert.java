package Trubby.co.th.Utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeConvert {

	public static String getDate(Long l){
		long yourmilliseconds = 1119193190;
	    SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");

	    Date resultdate = new Date(yourmilliseconds);
	    System.out.println(sdf.format(resultdate));
	    
	    return sdf.format(resultdate);
	}
}
