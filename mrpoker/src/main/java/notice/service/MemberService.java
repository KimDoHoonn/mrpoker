package notice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import notice.vo.Gongzi;
import notice.vo.Member;

public interface MemberService {
  List<Member> getMemberList(int pageNo, int length) throws Exception;
  void insertMember(Member member, MultipartFile file1, MultipartFile file2, String uploadDir) throws Exception;
  Member getMember(int no) throws Exception;
  void updateMember(Member member) throws Exception;
  void deleteMember(int no) throws Exception;
}







