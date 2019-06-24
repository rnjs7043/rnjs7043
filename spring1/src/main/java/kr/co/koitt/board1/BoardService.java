package kr.co.koitt.board1;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {

	@Autowired
	BoardDAO dao;

	public int boardInsert(BoardVO vo) {
		int count = 0;
		count = dao.boardInsert(vo);
		return count;
	}//boardInsert

	public List<BoardVO> boardList() {
		List<BoardVO> list = null;
		list = dao.boardList();
		return list;
	}//boardList

	public List<BoardVO> boardList2(
						HashMap<String, String> map) {
		List<BoardVO> list = null;
		list = dao.boardList2(map);
		return list;
	}//boardList2

	public BoardVO boardDetail(BoardVO vo) {
		vo = dao.boardDetail(vo);
		if(vo != null && vo.getFile_path() != null
				&& !vo.getFile_path().equals("")) {
			vo.setFile_name(
				vo.getFile_path().substring(
					vo.getFile_path().lastIndexOf("\\")+1
				)
			);
		}//if
		return vo;
	}//boardDetail

	public int boardDelete(BoardVO vo) {
		int count = 0;
		count = dao.boardDelete(vo);
		return count;
	}//boardInsert

	public int boardUpdate(BoardVO vo) {
		int count = 0;
		count = dao.passCheck(vo);
		if(count < 1) {
			count = -1;
			return count;
		}
		count = dao.boardUpdate(vo);
		return count;
	}//boardUpdate

	public int listTotalCount() {
		int totalCount = 0;
		totalCount = dao.listTotalCount();
		return totalCount;
	}//listTotalCount

	public int updateCnts(BoardVO vo) {
		int count = 0;
		count = dao.boardUpdate(vo);
		return count;
	}//updateCnts

	public int boardFileInsert(FileVO fileVO) {
		int count = 0;
		count = dao.boardFileInsert(fileVO);
		return count;
	}//boardFileInsert

	public FileVO boardFileDetail(FileVO fileVO) {
		fileVO = dao.boardFileDetail(fileVO);
		if(fileVO != null
				&& fileVO.getFile_path() != null
				&& !fileVO.getFile_path().equals("")) {
			fileVO.setFile_name(
				fileVO.getFile_path().substring(
					fileVO.getFile_path().lastIndexOf("\\")+1
				)
			);
		}//if
		return fileVO;
	}//boardFileDetail

}//class
