package kr.co.koitt.tip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class AddrController {

	private static final Logger logger
		= LoggerFactory.getLogger(AddrController.class);

	@RequestMapping(value="/tip/formaddr"
							,method=RequestMethod.GET)
	public String formAddr() {
		logger.info("formAddr");
		return "tip/form_addr";
	}//formAddr

	@RequestMapping(value="/tip/date1"
							,method=RequestMethod.GET)
	public String date1() {
		logger.info("date1");
		return "tip/date1";
	}//date1

	@RequestMapping(value="/tip/full1"
							,method=RequestMethod.GET)
	public String full1() {
		logger.info("full1");
		return "tip/full1";
	}//full1

}//class
