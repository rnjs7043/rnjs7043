package kr.co.koitt;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DynamicSQLController {

	@Autowired
	SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(DynamicSQLController.class);

	@RequestMapping(value="/searchtest",method=RequestMethod.GET)
	public String searchTest() {
		logger.info("searchTest");
		return "search_test";
	}//searchTest

	@RequestMapping(value="/test/search",method=RequestMethod.GET)
	public String search(Model model, SearchVO searchVO) {
		logger.info("search");
		List<EmpVO> list = null;
		list = sqlSession.selectList(
			"DynamicSQLMapper.testSearch1", searchVO);
		model.addAttribute("searchVO", searchVO);
		model.addAttribute("list", list);
		return "search_test";
	}//search

}//class
