package notice.vo;

import java.io.Serializable;
import java.sql.Date;
import java.text.SimpleDateFormat;

public class Member implements Serializable {
	private static final long serialVersionUID = 1L;
	
	protected int no;
	protected String id;
	protected String name;
	protected String password;
	protected String email;
	@Override
	public String toString() {
		return "Member [no=" + no + ", id=" + id + ", name=" + name + ", password=" + password + ", email=" + email
				+ "]"; // toString을 사용하는 이유?
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Object getWriter() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

