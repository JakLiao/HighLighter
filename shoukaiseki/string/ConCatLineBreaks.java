package shoukaiseki.string;
//字符串
public class ConCatLineBreaks {
	
	public String lineBreaks="\r\n";
	public String content=null;
	public ConCatLineBreaks(){
		
	}
	public ConCatLineBreaks(String content){
		this.content=content;
	}
	public ConCatLineBreaks(String lineBreaks,String content){
		this.lineBreaks=lineBreaks;
		this.content=content;
	}
	/**
	 * 在content开始加入一行内容age0,如果age0内容为空时则直接取消在String concat前的LineBreaks
	 * @param age0
	 * 			加入的行内容
	 * @return content
	 */
	public String addHeadLine(String age0){
		if (age0==null) {
			return content;
		}
		if (content==null) {
			content=age0;
			return content;
		}if(content.trim().isEmpty()){
			content=age0;
			return content;
		}
		content=age0+lineBreaks+content;
		return content;
	}
	/**
	 * 在content末尾加入一行内容age0,如果age0内容为空时则直接取消在String concat前的LineBreaks
	 * @param age0
	 * 			加入的行内容
	 * @return content
	 */
	public String addLastLine(String age0){
		if (age0==null) {
			return content;
		}
		if (content==null) {
			content=age0;
			return content;
		}if(content.trim().isEmpty()){
			content=age0;
			return content;
		}
		content=content+lineBreaks+age0;
		return content;
	}
	/**
	 * 删除最开始一行
	 * @return
	 */
	public String delHeadLine(){
		int i=lineBreaks.length();//换行符长度
		content=content.substring(content.indexOf(lineBreaks)+i, content.length());
		return content;
	}
	/**
	 * 删除最末尾一行
	 * @return
	 */
	public String delLastLine(){

		content=content.substring(0,content.lastIndexOf(lineBreaks));
		return content;
	}
	/**
	 * 在开始加入空行
	 * @return content
	 */
	public String addHeadLineBreaks(){
		if(content==null){
			content=lineBreaks;
			return content;
		}
		content=lineBreaks+content;
		return content;
	}
	/**
	 * 在末尾加入空行
	 * @return content
	 */
	public String addLastLineBreaks(){
		if(content==null){
			content=lineBreaks;
			return content;
		}
		content=content+lineBreaks;
		return content;
	}
	public String getContent(){
		return content;
	}
	public String setContent(String age0){
		content=age0;
		return content;
	}
	public String getLineBreaks(){
		return lineBreaks;
	}
	public String setLineBreaks(String age0){
		lineBreaks=age0;
		return lineBreaks;
	}
}
