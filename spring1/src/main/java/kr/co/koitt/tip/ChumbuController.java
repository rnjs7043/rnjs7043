package kr.co.koitt.tip;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

@Controller
public class ChumbuController {
	
	private static final Logger logger
		= LoggerFactory.getLogger(ChumbuController.class);

	@RequestMapping(value="/tip/file1"
							,method=RequestMethod.GET)
	public String file1() {
		logger.info("file1");
		return "tip/file1";
	}//file1

	@RequestMapping(value="/tip/fileUp1"
							,method=RequestMethod.POST)
	public String fileUp1(
					MultipartRequest multipartRequest)
				throws IOException {
		logger.info("fileUp1");
		MultipartFile file
				= multipartRequest.getFile("chumbu");
		String ofnm = file.getOriginalFilename();
		logger.info(""+ofnm);
		logger.info(""+file.getName());
		logger.info(""+file.getSize());
		InputStream in = file.getInputStream();
		OutputStream out = new FileOutputStream(
				"C:\\filetest\\"+ofnm);
		FileCopyUtils.copy(in, out);
		return "redirect:/tip/file1";
	}//fileUp1

	@RequestMapping(value="/tip/fileUp2"
							,method=RequestMethod.POST)
	public String fileUp2(
					MultipartRequest multipartRequest)
				throws IOException {
		logger.info("fileUp2");
		MultipartFile file
				= multipartRequest.getFile("chumbu");
		String ofnm = file.getOriginalFilename();
		String saveFileName
			= FileUtilService.makeSaveFileName(ofnm);
		InputStream in = file.getInputStream();
		OutputStream out = new FileOutputStream(
				"C:\\filetest\\"+saveFileName);
		FileCopyUtils.copy(in, out);
		return "redirect:/tip/file1";
	}//fileUp2

	@RequestMapping(value="/tip/fileUp3"
							,method=RequestMethod.POST)
	public String fileUp3(
					MultipartRequest multipartRequest)
				throws IOException {
		logger.info("fileUp3");
		Iterator<String> iter
					= multipartRequest.getFileNames();
		MultipartFile file = null;
		InputStream in = null;
		OutputStream out = null;
		String ofnm = "", sfnm = "";
		while(iter.hasNext()) {
			//System.out.println(iter.next());
			file = multipartRequest.getFile(iter.next());
			ofnm = file.getOriginalFilename();
			sfnm = FileUtilService.makeSaveFileName(ofnm);
			in = file.getInputStream();
			out = new FileOutputStream(
					"C:\\filetest\\"+sfnm);
			FileCopyUtils.copy(in, out);
		}//while
		return "redirect:/tip/file1";
	}//fileUp3

}//class
