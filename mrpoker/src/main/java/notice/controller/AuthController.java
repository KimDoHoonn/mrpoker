package notice.controller;

import java.util.HashMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import notice.dao.MemberDao;
import notice.vo.Member;

@Controller
@RequestMapping("/Auth/")
@SessionAttributes({"member"})
public class AuthController {
	
	@Autowired MemberDao memberDao; 
	
	@RequestMapping("form")
	public String form(
			@CookieValue(name="id", defaultValue="") String id,
			Model model) throws Exception{
		model.addAttribute("id", id);
		model.addAttribute("checked",((id.equals("")) ? "" : "checked"));
		return "auth/LoginForm";
	}
	
	@RequestMapping("login")
	public String login(
			HttpServletResponse response,
			String id,
			String password,
			String saveId,
			Model model,
			SessionStatus sessionStatus) throws Exception {
		
		Cookie cookie = new Cookie("id", id);
		if (saveId == null) {
			cookie.setMaxAge(0);
		} else {
			cookie.setMaxAge(60 * 60 * 24 * 7);
		}
		response.addCookie(cookie);
		
		HashMap<String,Object> paramMap = new HashMap<>();
		paramMap.put("id", id);
		paramMap.put("password", password);
		Member member = memberDao.selectOneByEmailAndPassword(paramMap);
		
		if (member == null) {
			sessionStatus.setComplete();
			return "auth/LoginFail";
			
		} else {
			model.addAttribute("member", member);
			return "redirect:../board/list,do";
		}
	}
	@RequestMapping("logout")
	public String logout(SessionStatus sessionStatus) throws Exception {
		sessionStatus.setComplete();
		return "redirect:form.do";
	}	
}
