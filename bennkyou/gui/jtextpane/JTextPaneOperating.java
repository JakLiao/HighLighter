package bennkyou.gui.jtextpane;

import javax.swing.JTextPane;

import shoukaiseki.string.ConCatLineBreaks;
public class JTextPaneOperating extends JTextPane{ 

	public static ConCatLineBreaks content=new ConCatLineBreaks();//显示到jtextpane的内容
	
	/**
	 * 在content开始加入一行内容age0,如果age0内容为空时则直接取消在String concat前的LineBreaks
	 * @param age0
	 * 			加入的行内容
	 * @return content
	 */
	public void addHeadLine(String age0){
		setText(content. addHeadLine(age0));
	}
	/**
	 * 在content末尾加入一行内容age0,如果age0内容为空时则直接取消在String concat前的LineBreaks
	 * @param age0
	 * 			加入的行内容
	 * @return content
	 */
	public void addLastLine(String age0){
		setText(content.addLastLine(age0));
	}
	/**
	 * 删除最开始一行
	 * @return
	 */
	public void delHeadLine(){
		setText(content.delHeadLine());
	}
	/**
	 * 删除最末尾一行
	 * @return
	 */
	public void delLastLine(){
		setText(content.delLastLine());
	}
	/**
	 * 在开始加入空行
	 * @return content
	 */
	public void addHeadLineBreaks(){
		setText(content.addHeadLineBreaks());
	}
	/**
	 * 在末尾加入空行
	 * @return content
	 */
	public void addLastLineBreaks(){
		setText(content.addLastLineBreaks());
	}
	public String getContent(){
		return content.getContent();
	}
	public void setContent(String age0){
		setText(content.setContent(age0));
		
	}
	public String getLineBreaks(){
		return content.getLineBreaks();
	}
	public void setLineBreaks(String age0){
		setText(content.setLineBreaks(age0));
	}
}
