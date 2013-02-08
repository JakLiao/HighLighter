package bennkyou;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class NewFile {
	public static File file = new File("c://temp//test"); 
	public static File TxtFile = new File(".//test001.txt"); //c://temp//test//test001.txt
	public static void main(String[] args) throws IOException{
		
		mkDir();//新建目录 
		file = new File("w:\\hello\\world\\this\\is\\fedora");
		mkDirs();//新建多级目录 
		newFile();//新建文件
		wrFile();//写入文件
		reFile();//读取文件
		System.out.println("文件完全路径为(输出为./格式): "+TxtFile.getPath());
		System.out.println("文件目录路径为(输出为./格式): "+TxtFile.getParent());
		System.out.println("文件完全路径为(不同与./格式): "+TxtFile.getCanonicalPath());
		System.out.println("文件目录路径为(输出格式为'所在目录'+./'格式): "+TxtFile.getAbsolutePath());
		System.out.println("文件名为: "+TxtFile.getName());
	}
	

	public static void mkDir(){
		// 新建文件夹,第一个/为转义符,\\或//都可以
		System.out.println("新建文件夹!");
		if (file.isDirectory()) {
			System.out.println("该文件夹已存在！");
		} else {
			file.mkdir();
			System.out.println("成功创建一个文件夹！");
		}
	}
	public static void mkDirs(){
		// 新建文件夹,第一个/为转义符,\\或//都可以
		System.out.println("新建文件夹!");
		if (file.isDirectory()) {
			System.out.println("该文件夹已存在！");
		} else {
			file.mkdirs();
			System.out.println("成功创建一个文件夹！");
		}
	}
	public static void newFile() throws IOException{
		// 新建文件
		System.out.println("\n\n新建文件!");
		if (!TxtFile.exists()) {
			if (TxtFile.createNewFile()){
				System.out.println("成功创建一个新文件");
			}else{
				System.out.println("创建新文件失败");
			}
		} else {
			System.out.println("该文件已经存在");
		}
	}
	
	public static void wrFile(){
		//写入文件
		System.out.println("\n\n写入文件!");
		try {
			FileWriter fw = new FileWriter(TxtFile);
			/*FileWriter(File file)
			 *写入文件对象(文件号):覆盖原文件
			 *FileWriter(File file, boolean append)
			 *写入文件对象(文件号,是否覆盖原文件)
			 */
			
			String s=wrString();
			System.out.println(s);
			fw.write(s); // 再写内容
			System.out.println("写入成功");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	private static void reFile() {
		//读取文件
		System.out.println("\n\n读取文件!");
		try {
			FileReader fr = new FileReader(TxtFile);
			BufferedReader br=new BufferedReader(fr);
			br.mark((int)TxtFile.length()+1);//标记当前位置  
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

			int line=0;
			br.reset();//复位到最近的标记位  
			String sr=null;
			while ((sr=br.readLine()) != null)
	        {
				System.out.println(sr);
	            /*具体操作*/
	            line++;
	        }
			System.out.println("读取文件成功,字数一共为"+TxtFile.length()+",i="+i+",line="+line);
			br.reset();//复位到最近的标记位  
			char data[] =new char[(int)TxtFile.length()];
			i = br.read(data);
			System.out.println("i = br.read(data)统计的字数为"+i);
			String s=new String(data,0,i);
			System.out.println(s);
			System.out.println("读取文件成功,字数一共为"+i);
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String wrString(){
		String s="";
		for (int i = 1; i <= 100; i++) {
			s=s+i;
			if(i%10==0){
				s=s+"\r\n";
				/*每个加一个换行符Linux下为\n,Windows下为\r\n
				 * \r是回车符，而\n是换行符
				 * Windows默认\n在文档中显示的是一个空格或者小黑框。所以，要先回车，再换行。
				 */
			}else{
				s=s+"\t";
			}
		}
		return s;
	}
}
/*
 *  int i=0;
  strTemp = buf.readline();
  int nMark = 999999;
long size = 0;
  buf.mark(nMark);
  while ((strTemp != null) && (strTemp.trim().length() != 0)){
  i++ ;
  strTemp = buf.readLine();
  size += strTemp.length();
  if(size>nmark){
  buf.reset();
  nMark +=nMark;
  buf.mark(nMark);
  buf.skip(size);
  }
  }
  buf.reset();


只是演示一下我的思路，关于效率，skip函数不会浪费太多时间的。
 */
