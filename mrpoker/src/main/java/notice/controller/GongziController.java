package notice.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import notice.service.GongziService;
import notice.vo.Gongzi;

@Controller 
@RequestMapping("/gongzi/")
public class GongziController {
  @Autowired ServletContext sc;
  @Autowired GongziService gongziService;
  
  @RequestMapping("firstlist")
  public String firstlist(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="1") int length,
      Model model) throws Exception {
    List<Gongzi> list = gongziService.getGongziList(pageNo, length);
    model.addAttribute("list", list);
    return "gongzi/GongziList";
  }
  
  
  @RequestMapping("list")
  public String list(
      @RequestParam(defaultValue="1") int pageNo,
      @RequestParam(defaultValue="6") int length,
      Model model) throws Exception {
    List<Gongzi> list = gongziService.getGongziList(pageNo, length);
    model.addAttribute("list", list);
    return "gongzi/GongziList";
  }
  
  @RequestMapping("add")
  public String add(
      Gongzi gongzi,
      MultipartFile file1,
      MultipartFile file2) throws Exception {
    String uploadDir = sc.getRealPath("/upload") + "/";
    try {
      gongziService.insertGongzi(gongzi, file1, file2, uploadDir);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "redirect:list.do";
  }
  
  @RequestMapping("detail")
  public String detail(int no, Model model) throws Exception {
    Gongzi gongzi = gongziService.getGongzi(no);
    model.addAttribute("gongzi", gongzi);
    return "gongzi/GongziDetail";
  }
  
  @RequestMapping("update")
  public String update(Gongzi gongzi) throws Exception {
    gongziService.updateGongzi(gongzi);
    return "redirect:list.do";
  }
  
  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    gongziService.deleteGongzi(no);
    return "redirect:list.do";
  }
}







