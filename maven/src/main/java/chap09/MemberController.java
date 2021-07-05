package chap09;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MemberController {
	@Autowired
	MemberService service;
	
	@RequestMapping("/member/index.do")
	public String index(Model model) {
		List<MemberVo> list = service.selectList();
		model.addAttribute("list",list);
		return "member/index"; // jsp 경로
		
	}
	@RequestMapping("/member/form.do")
	public String form(MemberVo vo, @CookieValue(value="cookieEmail", required = false) Cookie cookie) {
		if (cookie != null) {
			vo.setEmail(cookie.getValue());
			vo.setCheckEmail("check");
		}
		return "member/form";
	}
	@RequestMapping("/member/login.do")
	public String login(MemberVo vo,HttpSession sess,HttpServletResponse res, HttpServletRequest req) throws Exception {
		 MemberVo m = service.login(vo);
		 if(m != null) {
			 sess.setAttribute("memberInfo", m);
			 Cookie cookie = new Cookie("cookieEmail", vo.getEmail());
			 cookie.setPath("/");
			 if("check".equals(vo.getCheckEmail())) {
				 cookie.setMaxAge(60*60*24);
			 }else {
				 cookie.setMaxAge(0);
			 }
			 res.addCookie(cookie);
			 return"redirect:index.do";			 
		 }else {
			 res.setContentType("text/html;charset=utf-8");
			 PrintWriter out = res.getWriter();
			 out.println("<script>");
			 out.println("alert('이메일과 비밀번호가 올바르지 않습니다.');");
			 out.println("location.href='form.do';");
			 out.println("</script>");	
			 return null;
		 }
	}
	@RequestMapping("/member/logout.do")
	public String logout(Model model,HttpSession sess,HttpServletResponse res) throws Exception {
		sess.invalidate();
		model.addAttribute("msg", "로그아웃되었습니다.");
		model.addAttribute("url", "index.do");
		return "include/alert";
	}
	@RequestMapping("/member/mypage.do")
	public String mypage(Model model,HttpSession sess) {
		MemberVo vo = (MemberVo) sess.getAttribute("memberInfo");
		
			MemberVo m = service.mypage(vo);
			model.addAttribute("vo", m);
			return "member/update";
					
		}
	
	@RequestMapping("/member/update.do")
	public String update(MemberVo vo,Model model) {
		int r = service.update(vo);
		if(r == 0) {
			model.addAttribute("msg", "수정실패");
			model.addAttribute("url", "mypage.do");
			return "include/alert";
		}else
			model.addAttribute("msg", "수정성공");
			model.addAttribute("url", "index.do");
			return "include/alert";
	}
	@RequestMapping("/member/write.do")
	public String write(MemberVo vo) {
		return "member/write";
	}
	@RequestMapping("/member/insert.do")
	public String insert(MemberVo vo,HttpServletRequest req) throws Exception {
		if(service.insert(vo, req) != 0) {
			req.setAttribute("msg","등록성공");
			req.setAttribute("url","index.do");
		}else {
			req.setAttribute("msg","등록오류");
			req.setAttribute("url","write.do");
		}
		return "include/alert";
	}
}