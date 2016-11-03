package notice.controller.json;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import notice.service.QnaService;

@Controller
@RequestMapping("/mrpoker")
public class QnaController {
	@Autowired ServletContext sc;
	@Autowired QnaService qnaService;
	

}
