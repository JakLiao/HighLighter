package bennkyou;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TheDate {

	public static void main(String[] args) throws IOException {

		SimpleDateFormat bartDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Calendar cal =Calendar.getInstance();
		java.util.Date date = new java.util.Date();
		cal.setTime(date);//设置时间为当前时间
		long  timeOne=cal.getTimeInMillis();
		System.out.println("现在时间为:"+bartDateFormat.format(date));


		cal.set(2011,0,1,21,12,11);//设置今年的1月1日
		System.out.println("时间1为"+bartDateFormat.format(cal.getTime()));
        timeOne=cal.getTimeInMillis();
        cal.setTime(date);//将日历翻到1945年八月十五日,7表示八月
  
        long  timeTwo=cal.getTimeInMillis();
        long  daysapart = (timeTwo-timeOne)/(1000*60*60*24)+1;//二者时间相隔天数,第几天要加1
        long  hoursapart =(timeTwo-timeOne)%(1000*60*60*24)/(1000*60*60);//二者时间相隔天数,第几天要加1
        long  minutesapart =(timeTwo-timeOne)%(1000*60*60)/(1000*60);//二者时间相隔天数,第几天要加1
        long  secondsapart =(timeTwo-timeOne)%(1000*60)/(1000);//二者时间相隔天数,第几天要加1
        System.out.println("时间差为 "+daysapart+"天"+hoursapart+"时"+minutesapart+"分"+secondsapart+"秒");
	}
}
