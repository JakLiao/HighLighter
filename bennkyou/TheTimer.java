package bennkyou;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

public class TheTimer {
	public static  int a=0;
	public static void main(String[] args) {
		Timer timer = new Timer();
		System.out.println(new GregorianCalendar(2011, 8, 19, 23, 59, 59).getTime());
		timer.schedule(new TimerTask() {

			@Override
			public void run() {//实例中的的方法
				method1();//定时器到后执行的方法,一般在定时器到后的内容具体在外面写
			}
		}, 1000, 6000);
		/*schedule(TimerTask task, long delay)
		 * 大意是在延时delay毫秒后执行task
		 * schedule(TimerTask task, long delay, long period)
		 * 在延时delay毫秒后重复的执行task，周期是period毫秒
		 */
	}

	public static void method1() {
		System.out.println("a="+(++a));
	}

}
