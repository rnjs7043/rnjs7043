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
public class FillSelectController {

	@Autowired
	FillSelectService fillSelectService;

	private static final Logger logger
		= LoggerFactory.getLogger(FillSelectController.class);

	@RequestMapping(value="/tip/fill1"
							,method=RequestMethod.GET)
	public String fill1(Model model) {
		logger.info("fill1");
		List<FillSelectVO> listLarge = null;
		listLarge = fillSelectService.selectLarge();
		model.addAttribute("listLarge", listLarge);
		return "tip/fill_select";
	}//fill1

	@RequestMapping(value="/tip/fill2"
							, method= RequestMethod.GET)
	public void fill2(FillSelectVO vo, PrintWriter out) {
		logger.info("fill2");
		List<FillSelectVO> listMediem = null;
		listMediem = fillSelectService.selectMediem(vo);
		JSONArray arr = new JSONArray();
		for(FillSelectVO tmpVO : listMediem) {
			JSONObject obj = new JSONObject();
			obj.put("m_no", tmpVO.getM_no());
			obj.put("m_nm", tmpVO.getM_nm());
			arr.add(obj);
		}//for
		String jsonStr = arr.toString();
		out.print(jsonStr);
		out.flush();
		out.close();
	}//fill2

	@RequestMapping(value="/tip/fill3", method=RequestMethod.GET)
	public void fill3(FillSelectVO vo, PrintWriter out) {
		logger.info("fill3");
		List<FillSelectVO> listSmall = null;
		listSmall = fillSelectService.selectSmall(vo);
		JSONArray arr = new JSONArray();
		for(FillSelectVO tmpVO : listSmall) {
			JSONObject obj = new JSONObject();
			obj.put("s_no", tmpVO.getS_no());
			obj.put("s_nm", tmpVO.getS_nm());
			arr.add(obj);
		}//for
		String jsonStr = arr.toString();
		out.print(jsonStr);
		out.flush();
		out.close();
	}//fill3
}//class

/*
create table class_l(
l_no number(5,0)
, l_nm varchar2(60)
, l_desc varchar2(300)
);
insert into class_l values(1,'아시아','아');
insert into class_l values(2,'오세아니아','오');

create table class_m(
m_no number(5,0)
, l_no number(5,0)
, m_nm varchar2(60)
, m_desc varchar2(300)
);
insert into class_m values(1, 1,'일본','일');
insert into class_m values(2, 1,'대만','대');
insert into class_m values(3, 2,'호주','호');
insert into class_m values(4, 2,'뉴질랜드','뉴');

create table class_s(
s_no number(5,0)
, m_no number(5,0)
, l_no number(5,0)
, s_nm varchar2(60)
, s_desc varchar2(300)
);
insert into class_s values(1, 1, 1,'오사카','오사');
insert into class_s values(2, 1, 1,'오키나와','오키');
insert into class_s values(3, 2, 1,'타이페이','타이페');
insert into class_s values(4, 2, 1,'타이완 남부','타남');
insert into class_s values(5, 3, 2,'멜버른','멜버');
insert into class_s values(6, 3, 2,'골든코스트','골든');
insert into class_s values(7, 4, 2,'뉴질랜드 남부','뉴남');
insert into class_s values(8, 4, 2,'뉴질랜드 북부','북남');
*/