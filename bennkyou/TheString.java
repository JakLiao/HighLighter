package bennkyou;

import java.io.IOException;

public class TheString {

	public static void main(String[] args) throws IOException {
		String s = " delay =1000 period=6000";
		String s1 = "=";
		int value = s.indexOf(s1);//查找字符
		int lastvalue = s.lastIndexOf(s1);//逆向查找字符
		System.out.println(s+"中的"+s1+"位于第"+value+"个位置,逆向查找时位于第"+lastvalue+"个位置");//取首尾空
		String s2=s.substring(0, value);
		System.out.println(s+"中"+s1+"前的字符为"+s2);
		String s3=s.substring(value+1,s.length());
		System.out.println(s+"中"+s1+"后的字符为"+s3);
		String s4=s2.trim();
		System.out.println(s2+"取首发空后为"+s4);//取首尾空

		/*
		 * 将字符串按指令字符进行分割成字符串组
		 */
		s = "java,h,sql,htm,html";//字符串s
		String[] as = s.split(",");//分割符为,
		for (int i = 0; i < as.length; i++) {
			System.out.println(as[i]);
		}
		//字符串连接
		s="shou ";
		s1="kaiseki";
		s1=s.concat(s1);
		System.out.println("字符串连接concat:"+s1);
		
		/**
		 * 替换字符串
		 */
		s="\\hello\\world//this\\is\\fedora";
		s1=s.replace("\\", "/").replace("//", "/");
		System.out.println("s="+s);
		System.out.println("将\\替换为/后s1="+s1);
	}
}
