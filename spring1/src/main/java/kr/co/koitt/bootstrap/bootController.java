package kr.co.koitt.bootstrap;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class bootController {
	
	private static final Logger logger = LoggerFactory.getLogger(bootController.class);
	
	@RequestMapping(value="/boot",method=RequestMethod.GET)
	public void boot1(Model model) {
		model.addAttribute("data1", "kang dong won");
	}//test1

}//class
