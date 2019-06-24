package kr.co.koitt.member1;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.co.koitt.login1.MemberVO;

@Controller
public class MemberController {

	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);

	@RequestMapping(value="/member1/mypage"
							,method=RequestMethod.GET)
	public String myPage(HttpSession session) {
		logger.info("myPage");
		//session check start =================
		MemberVO sessionVO
			= (MemberVO) session.getAttribute("usrVO");
		if(sessionVO == null
			|| sessionVO.getId() == null
			|| sessionVO.getId().trim().equals("")) {
			return "member1/not_allowed";
		}
		//session check end =================
		return "member1/my_page";
	}//myPage

}//class
