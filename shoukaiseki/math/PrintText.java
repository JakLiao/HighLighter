package shoukaiseki.math;

import bennkyou.gui.jtextpane.JTextPaneOperating;

public class PrintText {
	/**
	 * 输出模式,true为GUI模式,false为控制台模式
	 */
	public Boolean mode=true;
	public JTextPaneOperating textPane=null;
	/**
	 * @mode 输出模式,true为控制台模式,false为GUI模式
	 */
	public PrintText(Boolean mode) {
		this.mode=mode;
	}
	/**
	 * 
	 * @param textPane  JTextPaneOperating
	 * @param mode  输出模式,true为控制台模式,false为GUI模式
	 */
	public PrintText(JTextPaneOperating textPane,Boolean mode) {
		this.textPane=textPane;
		this.mode=mode;
	}
	public JTextPaneOperating getTextPane(){
		return this.textPane;
	}
	public void setTextPane(JTextPaneOperating textPane){
		this.textPane=textPane;
	}
	/**
	 * 在content开始加入一行内容age0,如果age0内容为空时则直接取消在String concat前的LineBreaks
	 * @param age0
	 * 			加入的行内容
	 * @return content
	 */
	public void addHeadLine(String age0){
		if(mode){
			textPane.addHeadLine(age0);
		}else{
			System.out.println(age0);
		}
	}
	/**
	 * 在content末尾加入一行内容age0,如果age0内容为空时则直接取消在String concat前的LineBreaks
	 * @param age0
	 * 			加入的行内容
	 * @return content
	 */
	public void addLastLine(String age0){
		if(mode){
			textPane.addLastLine(age0);
		}else{
			System.out.println(age0);
		}
	}
	public void delHeadLine(){
		if(mode){
			textPane.delHeadLine();
		}
	}
	/**
	 * 删除最末尾一行
	 * @return
	 */
	public void delLastLine(){
		if(mode){
			textPane.delLastLine();
		}
	}
	/**
	 * 在开始加入空行
	 * @return content
	 */
	public void addHeadLineBreaks(){
		if(mode){
			textPane.addHeadLineBreaks();
		}
	}
	/**
	 * 在末尾加入空行
	 * @return content
	 */
	public void addLastLineBreaks(){
		if(mode){
			textPane.addLastLineBreaks();
		}else{
			System.out.println();
		}
	}
}
tY()));
		return d;
	}

}