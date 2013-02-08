package bennkyou.thefile;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import shoukaiseki.constantlib.CharacterEncodingName;

public class TheFileOutputStream {
	//常量类:各编码名称
	public static CharacterEncodingName ce=new CharacterEncodingName();
	public static void main(String ages[]){
		String oldFileName="W:/webhttp/bin/bennkyou/NewFile.java.html"; 
//		oldFileName="W:/webhttp/src/bennkyou/NewFile.java"; 
		String newFileName="W:/NewFile.java.html"; 

		String s= TheFileInputStream.readFile(oldFileName);//使用readFile方法读入
		try {
			FileOutputStream o=new FileOutputStream(newFileName);
			//采用UTF-8编码格式输出
			OutputStreamWriter out =new OutputStreamWriter(o, ce.UTF_8);
			out.write(s);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
}
