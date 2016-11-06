package notice.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import notice.service.GongziService;
import notice.service.MemberService;
import notice.vo.Gongzi;
import notice.vo.JsonResult;
import notice.vo.Member;

@Controller 
@RequestMapping("/member/")
public class MemberController {
  
  @Autowired ServletContext sc;
  @Autowired MemberService memberService;
  
   
  @RequestMapping(path="list")
  public Object list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="6") int length) throws Exception {
    
    try {
      List<Member> list = memberService.getMemberList(pageNo, length);
      
      HashMap<String,Object> data = new HashMap<>();
      data.put("list", list);
      data.put("pageNo", pageNo);
      data.put("length", length);
      
      return JsonResult.success(data);
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="add")
  public Object add(Member member,
      MultipartFile file1,
      MultipartFile file2) throws Exception {
    String uploadDir = sc.getRealPath("/upload") + "/";
    try {
      memberService.insertMember(member, file1, file2, uploadDir);
      return JsonResult.success();

    } catch (Exception e) {
    	e.printStackTrace();
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="detail")
  public Object detail(int no) throws Exception {
    try {
      Member member = memberService.getMember(no);
   
      if (member == null) 
        throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
      
      return JsonResult.success(member);
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="update")
  public Object update(Member member) throws Exception {
    try {
      if (memberService.getMember(member.getNo()) == null) {
        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
      }
      memberService.updateMember(member);
      return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  
  @RequestMapping(path="delete")
  public Object delete(int no) throws Exception {
    try {      
      if (memberService.getMember(no) == null) {
        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
      }
      memberService.deleteMember(no);
      return JsonResult.success();
      
    } catch (Exception e) {
      e.printStackTrace();
      return JsonResult.fail(e.getMessage());
    }
  }
}



