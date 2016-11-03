package notice.vo;

import java.io.Serializable;
import java.text.SimpleDateFormat;

public class Qna implements Serializable {
	private static final long serialVersionUID = 1L;
	static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

	protected int no;
	protected String id;
	protected String title;
	protected String contents;
	protected String writer;
	protected String createdDate;
	protected int viewCount;
	private String createdDate2;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public String getCreatedDate2() {
		return createdDate2;
	}
	public void setCreatedDate2(String createdDate2) {
		this.createdDate2 = createdDate2;
	}

	
	



}
