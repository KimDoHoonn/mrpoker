package notice.vo;

import java.io.Serializable;

public class MemberFile implements Serializable{
  private static final long serialVersionUID = 1L;
  
  protected int no;
  protected int phoNo;
  protected String phopath;
  
  
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getPhoNo() {
    return phoNo;
  }
  public void setPhoNo(int phoNo) {
    this.phoNo = phoNo;
  }
  public String getPhopath() {
    return phopath;
  }
  public void setPhopath(String phopath) {
    this.phopath = phopath;
  }  
  
}
