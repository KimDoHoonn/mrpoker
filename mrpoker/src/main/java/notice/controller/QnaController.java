package notice.controller;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import notice.service.QnaService;
import notice.vo.Qna;

@Controller
@RequestMapping("/mrpoker/")
public class QnaController {
	@Autowired ServletContext sc;
	@Autowired QnaService qnaService; // Service 기능 공부

	@RequestMapping("firstlist1")
	public String firstlist(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="1") int length,
			Model model) throws Exception { // Model 역활 찾아보기
		List<Qna> list = qnaService.getQnaList(pageNo, length);
		model.addAttribute("list", list);
		return "qna/QnaList";		
	}

	@RequestMapping("list1")
	public String list(
			@RequestParam(defaultValue="1") int pageNo,
			@RequestParam(defaultValue="6") int length,
			Model model) throws Exception {
		List<Qna> list = qnaService.getQnaList(pageNo, length);
		model.addAttribute("list", list);
		return "qna/QnaList";
	}

	@RequestMapping("add1")
	public String add(
			Qna qna,
			MultipartFile file1,
			MultipartFile file2) throws Exception {
		String uploadDir = sc.getRealPath("/upload") + "/";
		try {
			qnaService.insertQna(qna, file1, file2, uploadDir);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:list.do";
	}


	@RequestMapping("detail1")
	public String detail(int no, Model model) throws Exception {
		Qna qna = qnaService.getQna(no);
		model.addAttribute("qna", qna);
		return "qna/QnaDetail";
	}

	@RequestMapping("update1")
	public String update(Qna qna) throws Exception {
		qnaService.updateQna(qna);
		return "redirect:list.do";
	}

	@RequestMapping("delete1")
	public String delete(int no) throws Exception {
		qnaService.deleteQna(no);
		return "redirect:list.do";
	}	
}
