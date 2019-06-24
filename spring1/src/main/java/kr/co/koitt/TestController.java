package kr.co.koitt;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {

	@Autowired
	SqlSession sqlSession;

	@RequestMapping(value="/test/mybatis",method=RequestMethod.GET)
	public String testMybatis(Model model) {
		List<TestVO> list = sqlSession.selectList(
						"TestSelectMapper.testSelect");
		model.addAttribute("boardList", list);
		return "test_mybatis";
	}//testMybatis

}//class
