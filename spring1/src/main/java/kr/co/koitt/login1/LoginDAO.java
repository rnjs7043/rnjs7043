package kr.co.koitt.login1;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LoginDAO {

	@Autowired
	SqlSession sqlSession;

	public int idCheck(MemberVO vo) {
		int count = 0;
		count = sqlSession.selectOne(
								"MemberMapper.idCheck", vo);
		return count;
	}//idCheck

	public int login(MemberVO vo) {
		int count = 0;
		count = sqlSession.selectOne(
							"MemberMapper.login", vo);
		return count;
	}//login

	public MemberVO login2(MemberVO vo) {
		vo = sqlSession.selectOne(
							"MemberMapper.login2", vo);
		return vo;
	}//login2

}//class
