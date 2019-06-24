package kr.co.koitt.login1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

	@Autowired
	LoginDAO loginDAO;

	public int login(MemberVO vo) {
		int count = 0;
		count = loginDAO.idCheck(vo);
		if(count < 1) {
			return -1;//id 없음
		}
		count = loginDAO.login(vo);
		if(count < 1) {
			return -2;//pass 없음
		}
		return count;
	}//login

	public MemberVO login2(MemberVO vo) {
		vo = loginDAO.login2(vo);
		return vo;
	}//login2

}//class
