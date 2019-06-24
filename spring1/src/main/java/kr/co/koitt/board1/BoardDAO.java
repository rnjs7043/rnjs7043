package kr.co.koitt.board1;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAO {

	@Autowired
	SqlSession sqlSession;

	public int boardInsert(BoardVO vo) {
		System.out.println("dao - boardInsert");
		int count = 0;
		count = sqlSession.insert(
						"Board1Mapper.boardInsert", vo);
		System.out.println("dao - count : "+count);
		return count;
	}//boardInsert

	public List<BoardVO> boardList() {
		List<BoardVO> list = null;
		list = sqlSession.selectList(
							"Board1Mapper.boardList");
		return list;
	}//boardList

	public List<BoardVO> boardList2(
						HashMap<String, String> map) {
		List<BoardVO> list = null;
		list = sqlSession.selectList(
					"Board1Mapper.boardList2", map);
		return list;
	}//boardList2

	public BoardVO boardDetail(BoardVO vo) {
		vo = sqlSession.selectOne(
				"Board1Mapper.boardDetail", vo);
		return vo;
	}//boardDetail

	public int boardDelete(BoardVO vo) {
		int count = 0;
		count = sqlSession.delete(
						"Board1Mapper.boardDelete", vo);
		return count;
	}//boardDelete

	public int passCheck(BoardVO vo) {
		int count = 0;
		count = sqlSession.selectOne(
						"Board1Mapper.passCheck", vo);
		return count;
	}//passCheck

	public int boardUpdate(BoardVO vo) {
		int count = 0;
		count = sqlSession.update(
						"Board1Mapper.boardUpdate", vo);
		return count;
	}//boardUpdate

	public int listTotalCount() {
		int totalCount = 0;
		totalCount = sqlSession.selectOne(
						"Board1Mapper.listTotalCount");
		return totalCount;
	}//listTotalCount

	public int boardFileInsert(FileVO fileVO) {
		int count = 0;
		count = sqlSession.insert(
				"Board1Mapper.boardFileInsert", fileVO);
		return count;
	}//boardFileInsert

	public FileVO boardFileDetail(FileVO fileVO) {
		fileVO = sqlSession.selectOne(
				"Board1Mapper.boardFileDetail", fileVO);
		return fileVO;
	}//boardFileDetail

}//class
