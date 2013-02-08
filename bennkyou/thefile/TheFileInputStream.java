package bennkyou.thefile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import shoukaiseki.characterdetector.CharacterEncoding;
import shoukaiseki.constantlib.CharacterEncodingName;
/**
 * 自动按照相应编码读入文件
 * @author Administrator
 *
 */
public class TheFileInputStream {
	public static void main(String ages[]) throws IOException{
		String fileName="W:/NewFile.java";
		FileInputStream in = new FileInputStream(fileName);
		System.out.println("文件字数为="+in.available());
		
		byte[] bytes = new byte[in.available()];
		while((in.read(bytes)) != -1);
			String code=CharacterEncoding.getLocalteFileEncode(fileName);
		System.out.println("文件编码格式为"+code); 
		
		//常量类:各编码名称
		CharacterEncodingName ce=new CharacterEncodingName();
		String sa= new String(bytes,ce.UTF_8);//按照指定编码格式进行转换为系统编码
		System.out.println(sa);
		
		
		
		String s= readFile(fileName);//使用readFile方法读入
		System.out.println(s);
		
		in.close();
		
		
	}
	public static String readFile(String fileName){
		String content="";
		try {
			FileInputStream in = new FileInputStream(fileName);
			System.out.println("文件字数为="+in.available());
			
			byte[] bytes = new byte[in.available()];
			while((in.read(bytes)) != -1);
			String code=CharacterEncoding.getLocalteFileEncode(fileName);
			System.out.println("文件编码格式为"+code); 
			
			content= new String(bytes,code);//按照文件编码格式进行转换为系统编码
			System.out.println("文件内容为\n"+content); 
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return content;
	}
	public static String readFile(String fileName,String codeName){
		String content="";
		try {
			FileInputStream in = new FileInputStream(fileName);
			System.out.println("文件字数为="+in.available());
			
			byte[] bytes = new byte[in.available()];
			while((in.read(bytes)) != -1);
			
			
			content= new String(bytes,codeName);//按照文件编码格式进行转换为系统编码
			System.out.println("文件内容为\n"+content); 
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return content;
	}
}
