package kr.co.koitt.login1;

import java.io.PrintWriter;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping(value="/login1/form1"
								,method=RequestMethod.GET)
	public String loginForm() {
		logger.info("loginForm");
		return "login1/login_form";
	}//loginForm

	@RequestMapping(value="/login1/login"
								,method=RequestMethod.POST)
	public void login(MemberVO vo, PrintWriter out) {
		logger.info("login");
		int count = 0;
		count = loginService.login(vo);
		out.print(count);
		out.flush();
		out.close();
	}//login

	@RequestMapping(value="/login1/login2"
								,method=RequestMethod.POST)
	public void login2(MemberVO vo
			, HttpSession session, PrintWriter out) {
		logger.info("login2");
		vo = loginService.login2(vo);
		if(vo == null || vo.getId() == null
				||vo.getId().equals("")) {
			out.print(-1);//select 실패
		} else {
			session.setAttribute("usrVO", vo);
			out.print(1);//select 성공
		}
		out.flush();
		out.close();
	}//login2

	@RequestMapping(value="/login1/logout"
							,method=RequestMethod.GET)
	public void logout(MemberVO vo
			, HttpSession session, PrintWriter out) {
		logger.info("logout");
		session.invalidate();
		out.print(1);
		out.flush();
		out.close();
	}//logout

}//class

/*
create table member(
no number(5,0) primary key
,id varchar2(30) not null
,pass varchar2(30) not null
,name varchar2(60) not null
,tel varchar2(13) not null
,email varchar2(60) not null
);

alter table member
add (join_date date not null);

create sequence member_no_seq
start with 1
maxvalue 99999
increment by 1
nocycle;

insert into member values(
member_no_seq.nextval, 'hong', '123'
, 'hong gil dong', '010-1111-3333'
, 'hong@123.123', sysdate
);

commit;
*/