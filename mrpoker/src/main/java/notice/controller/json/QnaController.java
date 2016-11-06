package notice.controller.json;

import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import notice.service.QnaService;
import notice.vo.Gongzi;
import notice.vo.JsonResult;
import notice.vo.Qna;

@Controller
@RequestMapping("/qna/")
public class QnaController {
	@Autowired ServletContext sc;
	@Autowired QnaService qnaService;
	
	@RequestMapping(path="list1")
	  public Object list(
	      @RequestParam(defaultValue="1") int pageNo,
	      @RequestParam(defaultValue="6") int length) throws Exception {
	    
	    try {
	      List<Qna> list = qnaService.getQnaList(pageNo, length);
	      
	      HashMap<String,Object> data = new HashMap<>();
	      data.put("list", list);
	      data.put("pageNo", pageNo);
	      data.put("length", length);
	      
	      return JsonResult.success(data);
	      
	    } catch (Exception e) {
	      return JsonResult.fail(e.getMessage());
	    }
	  }
	  
	  @RequestMapping(path="add1")
	  public Object add(Qna qna,
	      MultipartFile file1,
	      MultipartFile file2) throws Exception {
	    String uploadDir = sc.getRealPath("/upload") + "/";
	    try {
	      qnaService.insertQna(qna, file1, file2, uploadDir);
	      return JsonResult.success();

	    } catch (Exception e) {
	    	e.printStackTrace();
	      return JsonResult.fail(e.getMessage());
	    }
	  }
	  
	  @RequestMapping(path="detail1")
	  public Object detail(int no) throws Exception {
	    try {
	      Qna qna = qnaService.getQna(no);
	      
	      if (qna == null) 
	        throw new Exception("해당 번호의 게시물이 존재하지 않습니다.");
	      
	      return JsonResult.success(qna);
	      
	    } catch (Exception e) {
	      return JsonResult.fail(e.getMessage());
	    }
	  }
	  
	  @RequestMapping(path="update1")
	  public Object update(Qna qna) throws Exception {
	    try {
	      if (qnaService.getQna(qna.getNo()) == null) {
	        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
	      }
	      qnaService.updateQna(qna);
	      return JsonResult.success();
	      
	    } catch (Exception e) {
	      return JsonResult.fail(e.getMessage());
	    }
	  }
	  
	  
	  
	  @RequestMapping(path="delete1")
	  public Object delete(int no) throws Exception {
	    try {      
	      if (qnaService.getQna(no) == null) {
	        throw new Exception("해당 게시물이 없거나 암호가 일치하지 않습니다!");
	      }
	      qnaService.deleteQna(no);
	      return JsonResult.success();
	      
	    } catch (Exception e) {
	      e.printStackTrace();
	      return JsonResult.fail(e.getMessage());
	    }
	  }
	}


