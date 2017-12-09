package utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * 距离现在有多久
 * @param oldtime 对比时间
 * @throws ParseException
 */
public class TransformTime {
	/**
	 * 距离现在有多久
	 * @param oldtime 对比时间
	 * @throws ParseException
	 */
	public static String howLongFromNow(String oldtime){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = df.format(new Date());
		java.util.Date now;
		try {
			now = df.parse(time);
		
			java.util.Date date=df.parse(oldtime);
			long l=now.getTime()-date.getTime();
			long day=l/(24*60*60*1000);
			long hour=(l/(60*60*1000)-day*24);
			long min=((l/(60*1000))-day*24*60-hour*60);
			long s=(l/1000-day*24*60*60-hour*60*60-min*60);
	
			StringBuffer sb = new StringBuffer();
			
			if(hour>0){
				if(day > 0)
					sb.append(day+"天");
				if(hour > 0 )
					sb.append(hour+"小时.前");
				return sb.toString();
			}else{
				if(min > 0 )
					sb.append(min+"分");
				sb.append(s+"秒.前");
				return sb.toString();
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}