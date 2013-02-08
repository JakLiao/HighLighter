package shoukaiseki.constantlib;

public class CharacterEncodingName {
	/**
	 * windows下保存为Unicode格式时用
	 * shoukaiseki.characterdetector.CharacterEncoding.getLocalteFileEncode(fileName)
	 * 检测出来的字符编码
	 */
	public final static String WINDOWS_1252 = "WINDOWS-1252";
	/** 7位ASCII字符，也叫作ISO646-US、Unicode字符集的基本拉丁块 */
	public final static String US_ASCII = "US-ASCII";

	/** ISO 拉丁字母表 No.1，也叫作 ISO-LATIN-1 */
	public final static String ISO_8859_1 = "ISO-8859-1";

	/** 8 位 UCS 转换格式 */
	public final static String UTF_8 = "UTF-8";

	/** 16 位 UCS 转换格式，Big Endian（最低地址存放高位字节）字节顺序 */
	public final static String UTF_16BE = "UTF-16BE";

	/** 16 位 UCS 转换格式，Little-endian（最高地址存放低位字节）字节顺序 */
	public final static String UTF_16LE = "UTF-16LE";

	/** 16 位 UCS 转换格式，字节顺序由可选的字节顺序标记来标识 */
	public final static String UTF_16 = "UTF-16";

	/** 中文超大字符集 */
	public final static String GBK = "GBK";
}
