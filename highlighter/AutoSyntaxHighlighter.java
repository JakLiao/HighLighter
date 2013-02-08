package highlighter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;

import shoukaiseki.characterdetector.CharacterEncoding;
import shoukaiseki.constantlib.CharacterEncodingName;
import shoukaiseki.string.ConCatLineBreaks;

public class AutoSyntaxHighlighter {
	
	public static String sourceCode = "./src";
	public static String htmlCode = "./dst";
	public static String extension = ".java";
	public static String publicHead="";
	public static String publicLast="";
	public static final  String EXTENSION_PATH="./Insert_SyntaxHighlighter/";
	public static File txtfile = new File("./Insert_SyntaxHighlighter/AutoSyntaxHighlighter.ora");
	
	public static void main(String ages[]) throws IOException{
		reFile();//读取文件
		try {
			File[] files = getFiles(sourceCode,extension);
	        for(int i=0;i<files.length;i++){
	            allToHtml(files[i]);
	        }
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	private static void reFile() {
		//读取文件
		try {
			FileReader fr = new FileReader(txtfile);
			BufferedReader br=new BufferedReader(fr);
			br.mark((int)txtfile.length()+1);//标记当前位置
			/*mark.(int readAheadLimit)
			 * 关键是参数readAheadLimit的解释，从字面上看是往前读的限制 ，也就是表示“可以再读多少”。再看详细解释：
			 * 是指当还保留有此mark时（i.e.mark未变化），可以再读入字符数的限制。当所读字符数达到此限制（即等于该限制）
			 * 或超过此限制之后尝试重设该流的话(reset the stream)，就会导致失败，比方说上例中的异常（产生的原因就是
			 * 读入的字符数等于readAheadLimit，都是4）。当限制值大于输入缓存（所谓输入缓存，BufferedReader类
			 * 有两个构造子，其一就有这个参数，无参版本就以默认值替代，大小是8192）时，就会分配一个大小不小于限制值的新缓存
			 * （这里说不小于其实就是等于）.因此要小心使用大数值。
			 */
			int i=0;
			while(br.read()!=-1){
				i++;
			}

			br.reset();//复位到最近的标记位
			String sr=null;
			String a=null;
			String b=null;
			while ((sr=br.readLine()) != null)
	        {
//				sr=new String(sr.getBytes(),"UTF8");
				if(sr.isEmpty()){
					continue;
				}
				a=sr.substring(0, 1);
				if(a.equals("#")){
					continue;
				}
				//取等号位置
				int value = sr.indexOf("=");
				a=sr.substring(0, value).trim();//=号前面取首尾空
				b=sr.substring(value+1,sr.length()).trim();//=号后面取首尾空
				if(a.equals("extension")){
					extension=b;
					continue;
				}if(a.equals("sourceCode")){
					//将\\替换为/,//也替换为/
					sourceCode=b.replace("\\", "/").replace("//", "/");
					if (sourceCode.substring(sourceCode.length()-1, sourceCode.length()).equals("/")) {
						sourceCode=sourceCode.substring(0,sourceCode.length()-1);
					}
					continue;
				}if(a.equals("htmlCode")){
					//将\\替换为/,//也替换为/
					htmlCode=b.replace("\\", "/").replace("//", "/");
					if (htmlCode.substring(htmlCode.length()-1, htmlCode.length()).equals("/")) {
						htmlCode=htmlCode.substring(0,htmlCode.length()-1);
					}
					continue;
				}
	        }
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static File[] getFiles(String dir, String s) {
		// 开始的文件夹
		File file = new File(dir);

		s = s.replace('.', '#');
		s = s.replaceAll("#", "\\\\.");
		s = s.replace('*', '#');
		s = s.replaceAll("#", ".*");
		s = s.replace('?', '#');
		s = s.replaceAll("#", ".?");
		s = "^" + s + "$";

		// System.out.println("实际查找字符串为"+s);
		Pattern p = Pattern.compile(s);
		ArrayList list = new ArrayList();
		list = filePattern(file, p);

		File[] rtn = new File[list.size()];
		list.toArray(rtn);
		return rtn;
	}
	
	private static ArrayList filePattern(File file, Pattern p) {
		if (file == null) {
			return null;
		} else if (file.isFile()) {
			Matcher fMatcher = p.matcher(file.getName());
			if (fMatcher.matches()) {
				ArrayList list = new ArrayList();
				list.add(file);
				return list;
			}
		} else if (file.isDirectory()) {
			File[] files = file.listFiles();
			if (files != null && files.length > 0) {
				ArrayList list = new ArrayList();
				for (int i = 0; i < files.length; i++) {
					ArrayList rlist = filePattern(files[i], p);
					if (rlist != null) {
						list.addAll(rlist);
					}
				}
				return list;
			}
		}
		return null;
	}
	
	public static void allToHtml(File thisfile){
		
		publicHead=readFile(EXTENSION_PATH+"Public_Head.html");
		publicLast=readFile(EXTENSION_PATH+"Public_Last.html");
		
		ConCatLineBreaks writeConten=new ConCatLineBreaks();
        String fileName=thisfile.getPath();
        //将\\替换为/,//也替换为/
        fileName=fileName.replace("\\", "/").replace("//", "/");
        String htmlFileName=fileName.replace(sourceCode, htmlCode)+".html";
        String extensionName=fileName.substring(fileName.lastIndexOf(".")+1,fileName.length());
        File htmlFile=new File(htmlFileName);
        new File(htmlFile.getParent());

		writeConten.addLastLine(publicHead);
		writeConten.addLastLineBreaks();

		String extensionContent=readFile(EXTENSION_PATH+extensionName+".html");
		writeConten.addLastLine(extensionContent);
		writeConten.addLastLineBreaks();

		String s=readFile(fileName);
		writeConten.addLastLine(s);
		writeConten.addLastLineBreaks();

		writeConten.addLastLine(publicLast);
		writeConten.addLastLineBreaks();
		wrFile(new File(htmlFileName), writeConten.getContent());
	}
	public static void wrFile(File file,String age0){
		try {
			//常量类:各编码名称
			CharacterEncodingName ce=new CharacterEncodingName();
			FileOutputStream o=new FileOutputStream(file);
			//采用UTF-8编码格式输出
			OutputStreamWriter out =new OutputStreamWriter(o, ce.UTF_8);
			out.write(age0);
			out.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
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
//			System.out.println("文件内容为\n"+content);
//			printText.addLastLine(content);
			in.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return content;
	}
}
