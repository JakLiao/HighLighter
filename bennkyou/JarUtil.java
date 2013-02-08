package bennkyou;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**获取jar,class路径
 * 
 * @author 李京蔚
 */
public class JarUtil {
	// jar包名
	private String jarName;
	// jar包所在绝对路径
	private String jarPath;

	public JarUtil(Class clazz) {
		String path = clazz.getProtectionDomain().getCodeSource().getLocation().getFile();
		try {
			path = java.net.URLDecoder.decode(path, "UTF-8");
		} catch (java.io.UnsupportedEncodingException ex) {
			Logger.getLogger(JarUtil.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		java.io.File jarFile = new java.io.File(path);
		this.jarName = jarFile.getName();
		java.io.File parent = jarFile.getParentFile();
		if (parent != null) {
			this.jarPath = parent.getAbsolutePath();
		}
	}

	/**
	 * 获取Class类所在Jar包的名称
	 * 
	 * @return Jar包名 (例如：C:\temp\demo.jar 则返回 demo.jar )
	 */
	public String getJarName() {
		try {
			return java.net.URLDecoder.decode(this.jarName, "UTF-8");
		} catch (java.io.UnsupportedEncodingException ex) {
			Logger.getLogger(JarUtil.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return null;
	}

	/**
	 * 取得Class类所在的Jar包路径
	 * 
	 * @return 返回一个路径 (例如：C:\temp\demo.jar 则返回 C:\temp )
	 */
	public String getJarPath() {
		try {
			return java.net.URLDecoder.decode(this.jarPath, "UTF-8");
		} catch (java.io.UnsupportedEncodingException ex) {
			Logger.getLogger(JarUtil.class.getName()).log(Level.SEVERE, null,
					ex);
		}
		return null;
	}

	public static void main(String[] args) throws Exception {
		JarUtil ju = new JarUtil(JarUtil.class);
		JOptionPane.showMessageDialog(null, ju.getJarPath() + "/"
				+ ju.getJarName());
	}
}