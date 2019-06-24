package kr.co.koitt;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DITestController {

	private static final Logger logger = LoggerFactory.getLogger(DITestController.class);

	@Autowired
	DITestService dITestService;
	//약한 결합 - 의존성 주입 - spring di.

	@RequestMapping(value="/ditest",method=RequestMethod.GET)
	public String diTest(Model model) {
		logger.info("diTest");
		//DITestServiceImpl service = new DITestServiceImpl();
		//객체 직접 생성 - 강한 결합 - not spring di.
		//DITestService service2 = new DITestServiceImpl();
		//객체 직접 생성 - 조금 약한 결합 - not spring di.
		String returnData1 = "";
		returnData1 = dITestService.data1();

		model.addAttribute("data1", returnData1);
		return "test1";
	}//test1

}//class
