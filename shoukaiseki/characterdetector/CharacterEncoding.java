package shoukaiseki.characterdetector;

import info.monitorenter.cpdetector.io.ASCIIDetector;
import info.monitorenter.cpdetector.io.CodepageDetectorProxy;
import info.monitorenter.cpdetector.io.JChardetFacade;
import info.monitorenter.cpdetector.io.ParsingDetector;
import info.monitorenter.cpdetector.io.UnicodeDetector;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

public class CharacterEncoding {
	/**
	 * 获得远程URL文件的编码格式
	 */
	public static String getReomoteURLFileEncode(URL url) {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		detector.add(new ParsingDetector(false));
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		java.nio.charset.Charset charset = null;
		try {
			System.out.println(url);
			charset = detector.detectCodepage(url);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (charset != null) {
			return charset.name();
		} else {
			return "utf-8";
		}
	}

	/**
	 * 获得文件流的编码格式
	 */
	public static String getInputStreamEncode(InputStream is) {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		detector.add(new ParsingDetector(false));
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		java.nio.charset.Charset charset = null;
		try {
			charset = detector.detectCodepage(is, 0);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (charset != null) {
			return charset.name();
		} else {
			return "utf-8";
		}
	}

	/**
	 * 获得本地文件的编码格式
	 */
	public static String getLocalteFileEncode(String filePath) {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		//支持Html中设置的编码提取,加入后会出现无法对Html文件获取正确的文件的编码格式
//		detector.add(new ParsingDetector(false));
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		java.nio.charset.Charset charset = null;
		File file = new File(filePath);
		try {
			charset = detector.detectCodepage(file.toURI().toURL());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (charset != null) {
			return charset.name();
		} else {
			return "utf-8";
		}
	}
	public static String getLocalteFileHttpEncode(String filePath) {
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		//支持Html中设置的编码提取,加入后会出现无法对Html文件获取正确的文件的编码格式
		detector.add(new ParsingDetector(false));
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		java.nio.charset.Charset charset = null;
		File file = new File(filePath);
		try {
			charset = detector.detectCodepage(file.toURI().toURL());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (charset != null) {
			return charset.name();
		} else {
			return "utf-8";
		}
	}
	/**
	 * 获得字符串的编码格式
	 */
	public static String getStringEncode(String str) {
		if (str == null) {
			return "utf-8";
		}
		CodepageDetectorProxy detector = CodepageDetectorProxy.getInstance();
		detector.add(new ParsingDetector(false));
		detector.add(JChardetFacade.getInstance());
		detector.add(ASCIIDetector.getInstance());
		detector.add(UnicodeDetector.getInstance());
		java.nio.charset.Charset charset = null;
		InputStream myIn = new ByteArrayInputStream(str.getBytes());
		try {
			charset = detector.detectCodepage(myIn, 3);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		if (charset != null) {
			return charset.name();
		} else {
			return "utf-8";
		}
	}
}
