package kr.co.koitt.board1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import kr.co.koitt.tip.FileUtilService;

@Controller
public class BoardController {

	@Autowired
	BoardService service;

	private static final Logger logger
		= LoggerFactory.getLogger(BoardController.class);

/*
 * log level - 로그 남김 수준
 * debug - 디버그 모드에서 로그 남김
 * error - 에러 표시 로그 남김
 * info - 정보 표시 로그 남김
 * trace - 에러 추적
 * warn - 경고 표시 로그 남김
 */
	@RequestMapping(value="/board1/list"
							,method=RequestMethod.GET)
	public String list(Model model) {
		//logger.debug("test debug");
		//logger.error("test error");
		//logger.trace("test trace");
		//logger.warn("test warn");
		logger.info("list - test info");
		List<BoardVO> list = null;
		list = service.boardList();
		model.addAttribute("boardList", list);
		return "board1/list";
	}//list

	@RequestMapping(value="/board1/list2"
			,method=RequestMethod.GET)
	public String list2(Model model, String page) {
		logger.info("list2");
		//page count start =============
		int listEndNo = 10;
		int listStartNo = 10 - 9;
		int intPage = 1;
		if(page == null || page.equals("")) {
			page = "1";
		} else {
			intPage = Integer.parseInt(page);
			listEndNo = intPage * 10;
			listStartNo = listEndNo - 9;
		}
		int totalCount = 0;
		int startPage = 1;
		int endPage = 1;
		int totPage = 1;
		totalCount = service.listTotalCount();
		if(totalCount > 0) {
			totPage = totalCount / 10;
			if((totalCount % 10) > 0) {
				totPage++;
			}
		}
		if(page.length() > 1) {
			String tmp
				= page.substring(0, page.length()-1);
			tmp = tmp + "1";
			startPage = Integer.parseInt(tmp);
			if(page.endsWith("0")) {
				startPage = startPage - 10;
			}
		}
		if((startPage + 9) < totPage) {
			endPage = startPage + 9;
		} else {
			endPage = totPage;
		}
		model.addAttribute("startPage", startPage);
		model.addAttribute("endPage", endPage);
		model.addAttribute("totPage", totPage);
		//page count end =============
		HashMap<String, String> map
			= new HashMap<String, String>();
		map.put("listStartNo", ""+listStartNo);
		map.put("listEndNo", ""+listEndNo);

		List<BoardVO> list = null;
		list = service.boardList2(map);
		model.addAttribute("boardList", list);
		return "board1/list";
	}//list2

	@RequestMapping(value="/board1/formi"
							,method=RequestMethod.GET)
	public String formInsert() {
		logger.info("formInsert");
		return "board1/form_insert";
	}//formInsert

	@RequestMapping(value="/board1/formi2"
							,method=RequestMethod.GET)
	public String formInsert2() {
		logger.info("formInsert2");
		return "board1/form_insert2";
	}//formInsert2

	@RequestMapping(value="/board1/formi3"
							,method=RequestMethod.GET)
	public String formInsert3() {
		logger.info("formInsert3");
		return "board1/form_insert3";
	}//formInsert3

	@RequestMapping(value="/board1/formi4"
							,method=RequestMethod.GET)
	public String formInsert4() {
		logger.info("formInsert4");
		return "board1/form_insert4";
	}//formInsert4

	@RequestMapping(value="/board1/formi5"
							,method=RequestMethod.GET)
	public String formInsert5() {
		logger.info("formInsert5");
		return "board1/form_insert5";
	}//formInsert5

	@RequestMapping(value="/board1/insert"
							,method=RequestMethod.POST)
	public void boardInsert(BoardVO vo, PrintWriter out) {
		logger.info("boardInsert");
		int count = 0;
		count = service.boardInsert(vo);
		logger.info("controller - count : "+count);
		out.print(count);
		out.flush();
		out.close();
	}//boardInsert

	@RequestMapping(value="/board1/insert3"
							,method=RequestMethod.POST)
	public void boardInsert3(BoardVO vo, PrintWriter out
				, MultipartRequest multipartRequest)
			throws IOException {
		logger.info("boardInsert3");
		//////////////////////////////////////////
		Iterator<String> iter
			= multipartRequest.getFileNames();
		MultipartFile file = null;
		String ofnm = "", sfnm = "";
		InputStream in = null;
		OutputStream out2 = null;
		while(iter.hasNext()) {
			file = multipartRequest.getFile(
										iter.next());
			ofnm = file.getOriginalFilename();
			if(!ofnm.trim().equals("")) {
				sfnm = FileUtilService.makeSaveFileName(ofnm);
				in = file.getInputStream();
				out2 = new FileOutputStream(
						"C:\\filetest\\"+sfnm);
				FileCopyUtils.copy(in, out2);
			}//if
		}//while
		//////////////////////////////////////////
		int count = 0;
		count = service.boardInsert(vo);
		out.print(count);
		out.flush();
		out.close();
	}//boardInsert3

	@RequestMapping(value="/board1/insert4"
							,method=RequestMethod.POST)
	@Transactional
	public void boardInsert4(BoardVO vo
									, PrintWriter out) {
		logger.info("boardInsert4");
		int count = 0;
		count = service.boardInsert(vo);
		//CK image start============================
		int imgYn = 0;
		imgYn = vo.getCnts().indexOf("src=\"");
		if(imgYn > 0) {//image in cnts
			try {
				FileUtilService.mvCKImgTmpToNew(
						vo.getCnts(), vo.getNo());
			} catch (IOException e) {
				out.print(0);
				out.flush();
				out.close();
				e.printStackTrace();
				return;
			}//try
		}//if
		//CK image end============================
		vo.setCnts(vo.getCnts().replaceAll("/tmp/"
								, "/"+vo.getNo()+"/")
		);
		count = service.boardUpdate(vo);
		out.print(count);
		out.flush();
		out.close();
	}//boardInsert4

	@RequestMapping(value="/board1/insert5"
							,method=RequestMethod.POST)
	@Transactional
	public void boardInsert5(BoardVO vo
									, PrintWriter out) {
		logger.info("boardInsert5");
		int count = 0;
		count = service.boardInsert(vo);
		//file upload start=========================
		String filePath = "";
		try {
			filePath
			= FileUtilService.saveMultipartFile(
						vo.getChumbu(), vo.getNo());
		} catch (IOException e1) {
			e1.printStackTrace();
			out.print(0);
			out.flush();
			out.close();
			return;
		}
		//file upload end=========================
		if(!filePath.equals("")) {
			FileVO fileVO = new FileVO();
			fileVO.setBoard1_no(vo.getNo());
			fileVO.setFile_path(filePath);
			count = service.boardFileInsert(fileVO);
		}
		//CK image start============================
		int imgYn = 0;
		imgYn = vo.getCnts().indexOf("src=\"");
		if(imgYn > 0) {//image in cnts
			try {
				FileUtilService.mvCKImgTmpToNew(
						vo.getCnts(), vo.getNo());
			} catch (IOException e) {
				out.print(0);
				out.flush();
				out.close();
				e.printStackTrace();
				return;
			}//try
		}//if
		//CK image end============================
		vo.setCnts(vo.getCnts().replaceAll("/tmp/"
								, "/"+vo.getNo()+"/")
		);
		int idx = vo.getCnts().indexOf(",");
		vo.setCnts(vo.getCnts().substring(idx+1));
		count = service.boardUpdate(vo);
		out.print(count);
		out.flush();
		out.close();
	}//boardInsert5

	@RequestMapping(value="/board1/detail"
							,method=RequestMethod.GET)
	public String boardDatail(BoardVO vo, Model model) {
		logger.info("boardDatail");
		vo = service.boardDetail(vo);
		model.addAttribute("detailVO", vo);
		return "board1/detail";
	}//boardDatail

	@RequestMapping(value="/board1/delete"
							,method=RequestMethod.GET)
	public void boardDelete(BoardVO vo, PrintWriter out) {
		logger.info("boardDelete");
		//CK image delete start==================
		FileUtilService.delCKImg(vo.getNo());
		//CK image delete end==================
		int count = 0;
		count = service.boardDelete(vo);
		out.print(count);
		out.flush();
		out.close();
	}//boardDelete

	@RequestMapping(value="/board1/formu"
							,method=RequestMethod.GET)
	public String formUpdate(BoardVO vo, Model model) {
		logger.info("formUpdate");
		vo = service.boardDetail(vo);
		//CK image start============================
		int imgYn = 0;
		imgYn = vo.getCnts().indexOf("src=\"");
		if(imgYn > 0) {//image in cnts
			try {
				FileUtilService.mvCKImgNewToTmp(
						vo.getCnts(), vo.getNo());
			} catch (IOException e) {
				e.printStackTrace();
			}//try
		}//if
		//CK image end============================
		vo.setCnts(vo.getCnts().replaceAll("/"+vo.getNo()+"/"
				, "/tmp/")
		);
		model.addAttribute("detailVO", vo);
		return "board1/form_update";
	}//formUpdate

	@RequestMapping(value="/board1/update"
							,method=RequestMethod.POST)
	public void boardUpdate(BoardVO vo, PrintWriter out) {
		logger.info("boardUpdate");
		int idx = vo.getCnts().indexOf(",");
		vo.setCnts(vo.getCnts().substring(idx+1));
		int count = 0;
		count = service.boardUpdate(vo);
		//CK image start============================
		int imgYn = 0;
		imgYn = vo.getCnts().indexOf("src=\"");
		if(imgYn > 0) {//image in cnts
			try {
				FileUtilService.mvCKImgTmpToNew(
						vo.getCnts(), vo.getNo());
			} catch (IOException e) {
				out.print(0);
				out.flush();
				out.close();
				e.printStackTrace();
				return;
			}//try
		}//if
		//CK image end============================
		vo.setCnts(vo.getCnts().replaceAll("/tmp/"
								, "/"+vo.getNo()+"/")
		);
		count = service.updateCnts(vo);
		out.print(count);
		out.flush();
		out.close();
	}//boardUpdate

	@RequestMapping(value="/board1/filedown"
							,method=RequestMethod.GET)
	public void fileDownload(FileVO fileVO
						, HttpServletResponse response)
				throws IOException {
		logger.info("fileDownload");
		fileVO = service.boardFileDetail(fileVO);
		response.setHeader("Content-Disposition"
			, "attachment;filename="
				+ new String(
					fileVO.getFile_name().getBytes()
					,"UTF-8"));//"ISO8859_1"
		FileInputStream in
			= new FileInputStream(
					"C:\\"+fileVO.getFile_path());
		ServletOutputStream out
			= response.getOutputStream();
		byte [] buffer = new byte[1024];
		int size = 0;
		size = in.read(buffer, 0, 1024);
		while(size != -1) {
			out.write(buffer, 0, size);
			size = in.read(buffer, 0, 1024);
		}//while
		out.flush();
		in.close();
		out.close();
	}//fileDownload

}//class

/*
create table board1(
no number(5,0) primary key
, title varchar2(90) not null
, writer varchar2(60) not null
, pass varchar2(13) not null
, cnts varchar2(3000)
, write_date date
);

create sequence board1_no_seq
start with 1
maxvalue 99999
increment by 1
nocycle;

create table board1_file(
no number(5,0) primary key
, board1_no number(5,0)
, file_path varchar2(100)
, upload_date date
);

create sequence board1_file_no_seq
start with 1
maxvalue 99999
increment by 1
nocycle;
*/