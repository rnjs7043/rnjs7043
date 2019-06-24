package kr.co.koitt.tip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

public class FileUtilService {

	/*
	 * name : makeSaveFileName
	 * desc : 파일 이름을 받아, 파일 이름에 시간 정보를 덧붙임.
	 */
	public static String makeSaveFileName(
						String originalFileName) {
		int extIdx = originalFileName.lastIndexOf(".");
		String name = originalFileName.substring(0,extIdx);
		String ext = originalFileName.substring(extIdx);
		Date date = new Date();
		DateFormat dateFormat
			= new SimpleDateFormat("HHmmss");
		String sigan = dateFormat.format(date);
		String saveFileName = name+"_"+sigan+ext;
		return saveFileName;
	}//makeSaveFileName

	public static void mvCKImgTmpToNew(
								String cnts, String no)
			throws IOException {
		String [] sArr = cnts.split("src=\"");
		String tmpPath = "";
		String newPath = "";
		for(String tmp : sArr) {
			if(tmp.indexOf("/upload") == 0){
				//image 주소가 있는 문자열만 대상이 됨
				tmpPath	= tmp.substring(0
							, tmp.indexOf("\""));
				newPath
				= tmpPath.replace("/tmp/"
					, "/"+no+"/");
				File newFolder = new File(
					"C:\\upload\\"+no);
				if(!newFolder.exists()) {
					newFolder.mkdirs();
				}//if
				FileInputStream fis
					= new FileInputStream("C:"+tmpPath);
				FileOutputStream fos
					= new FileOutputStream("C:"+newPath);
				FileCopyUtils.copy(fis, fos);
				fis.close();
				fos.close();
				File delFile = new File("C:"+tmpPath);
				delFile.delete();
			}//if
		}//for
	}//mvImgTmpToNew

	public static void mvCKImgNewToTmp(
								String cnts, String no)
			throws IOException {
		String [] sArr = cnts.split("src=\"");
		String newPath = "";
		String tmpPath = "";
		for(String neo : sArr) {
			if(neo.indexOf("/upload") == 0){
				//image 주소가 있는 문자열만 대상이 됨
				newPath	= neo.substring(0
							, neo.indexOf("\""));
				tmpPath
				= newPath.replace("/"+no+"/","/tmp/");
				File tmpFolder = new File(
					"C:\\upload\\tmp");
				if(!tmpFolder.exists()) {
					tmpFolder.mkdirs();
				}//if
				FileInputStream fis
					= new FileInputStream("C:"+newPath);
				FileOutputStream fos
					= new FileOutputStream("C:"+tmpPath);
				FileCopyUtils.copy(fis, fos);
				fis.close();
				fos.close();
			}//if
		}//for
	}//mvCKImgNewToTmp

	public static void delCKImg(String no) {
		File deleteFolder = new File("C:/upload/"+no);
		if(deleteFolder.exists()) {
			File [] deleteFiles
				= deleteFolder.listFiles();
			for(File tmpFile : deleteFiles) {
				tmpFile.delete();
			}//for
			deleteFolder.delete();
		}//if
	}//delCKImg

	public static String saveMultipartFile(
				MultipartFile file, String no)
			throws IOException {
		String ofnm = "", sfnm = "";
		InputStream in = null;
		OutputStream out = null;
		ofnm = file.getOriginalFilename();
		if(!ofnm.trim().equals("")) {
			sfnm = makeSaveFileName(ofnm);
			File newFolder = new File(
						"C:\\upload\\"+no);
			if(!newFolder.exists()) {
				newFolder.mkdirs();
			}//if
			in = file.getInputStream();
			out = new FileOutputStream(
			"C:\\upload\\"+no+"\\"+sfnm);
			FileCopyUtils.copy(in, out);
			in.close();
			out.close();
		}//if
		if(sfnm.equals("")) {
			return "";
		}
		return "\\upload\\"+no+"\\"+sfnm;
	}//saveMultipartFile

}//class
