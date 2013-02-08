package bennkyou;
import java.text.DecimalFormat;
import java.util.Hashtable;

public class TheLong {

	public static void main(String args[]) {
		DecimalFormat df = new DecimalFormat("0000");//输出格式
		String b = "1234567890";
		long c = Long.parseLong(b);//字符型转换为long型
		System.out.println(c);//1234567890
		c = 1;
		System.out.println(df.format(c));//0001		格式化输出,返回为String型
		b = "NO1234567890";
		c = Long.parseLong(b.substring(2, b.length()));
		System.out.println(c);//1234567890
		
	}
}
