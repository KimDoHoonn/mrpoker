package notice.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import notice.dao.MemberDao;
import notice.dao.MemberFileDao;
import notice.service.MemberService;
import notice.util.FileUploadUtil;
import notice.vo.Member;
import notice.vo.MemberFile;

@Service 
public class DefaultMemberService implements MemberService {
  @Autowired MemberDao memberDao;
  @Autowired MemberFileDao memberFileDao;
  
  public List<Member> getMemberList(int pageNo, int length) throws Exception {
    HashMap<String,Object> map = new HashMap<>();
    map.put("startIndex", (pageNo - 1) * length);
    map.put("length", length);
    return memberDao.selectList(map);
  }
  
  public void insertMember(Member member, 
      MultipartFile file1,
      MultipartFile file2,
      String uploadDir) throws Exception {
    
    memberDao.insert(member);
    
    String newFilename = null;
    if (file1 != null && !file1.isEmpty()) {
      newFilename = FileUploadUtil.getNewFilename(file1.getOriginalFilename());
      file1.transferTo(new File(uploadDir + newFilename));
      MemberFile memberFile = new MemberFile();
      memberFile.setPhopath(newFilename);
      memberFile.setNo(member.getNo());
      //memberFile.setGongziNo(10200); //트랜잭션 테스트 용 
      memberFileDao.insert(memberFile);
    }
    
    if (file2 != null && !file2.isEmpty()) {
      newFilename = FileUploadUtil.getNewFilename(file2.getOriginalFilename());
      file2.transferTo(new File(uploadDir + newFilename));
      MemberFile memberFile = new MemberFile();
      memberFile.setPhopath(newFilename);
      memberFile.setNo(member.getNo());
      memberFileDao.insert(memberFile);
    }
  }
  
  public Member getMember(int no) throws Exception {
    return memberDao.selectOne(no);
  }
    
  public void updateMember(Member member) throws Exception {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", member.getNo());
    paramMap.put("writer", member.getWriter()); // 확인
    
    memberDao.update(member);
  }
  
  public void deleteMember(int no) throws Exception {
    memberDao.delete(no);
  }
}







