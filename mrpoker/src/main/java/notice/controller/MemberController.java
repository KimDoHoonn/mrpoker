package notice.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import notice.service.MemberService;
import notice.vo.Gongzi;
import notice.vo.Member;

@Controller 
@RequestMapping("/Member/")
public class MemberController {
  @Autowired ServletContext sc;
  @Autowired MemberService memberService;
  
  @RequestMapping("firstlist")
  public String firstlist(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="1") int length,
      Model model) throws Exception {
    List<Member> list = memberService.getMemberList(pageNo, length);
    model.addAttribute("list", list);
    return "member/MemberList";
  }
  
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="6") int length,
      Model model) throws Exception {
    List<Member> list = memberService.getMemberList(pageNo, length);
    model.addAttribute("list", list);
    return "gongzi/GongziList";
  }
  
  @RequestMapping("add")
  public String add(
      Member member,
      MultipartFile file1,
      MultipartFile file2) throws Exception {
    String uploadDir = sc.getRealPath("/upload") + "/";
    try {
      memberService.insertMember(member, file1, file2, uploadDir);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    Member member = memberService.getMember(no);
    model.addAttribute("member", member);
    return "member/MemberDetail";
  }
  
  @RequestMapping("update")
  public String update(Member member) throws Exception {
    memberService.updateMember(member);
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    memberService.deleteMember(no);
    return "redirect:list.do";
  }
}







