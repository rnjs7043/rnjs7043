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
public class CKController {

	private static final Logger logger
		= LoggerFactory.getLogger(CKController.class);

	@RequestMapping(value="/tip/formck"
							,method=RequestMethod.GET)
	public String formCK() {
		logger.info("formCK");
		return "tip/form_ck";
	}//formCK

	@RequestMapping(value="/ckupload"
							,method=RequestMethod.POST)
	public void ckUpload(PrintWriter prnt
				, MultipartRequest multipartRequest)
			throws IOException {
		logger.info("ckUpload");
		Iterator<String> iter
			= multipartRequest.getFileNames();
		String sfnm = "", ofnm = "";
		while(iter.hasNext()) {
			MultipartFile file
				= multipartRequest.getFile(iter.next());
			ofnm = file.getOriginalFilename();
			sfnm = FileUtilService.makeSaveFileName(ofnm);
			InputStream in = file.getInputStream();
			OutputStream out = new FileOutputStream(
							"C:\\upload\\tmp\\"+sfnm);
			FileCopyUtils.copy(in, out);
		}//while
		JSONObject jsonObj = new JSONObject();
		jsonObj.put("uploaded",	1);
		jsonObj.put("fileName",	sfnm);
		jsonObj.put("url",	"/upload/tmp/"+sfnm);
		prnt.print(jsonObj);
		prnt.flush();
		prnt.close();
	}//ckUpload

}//class
