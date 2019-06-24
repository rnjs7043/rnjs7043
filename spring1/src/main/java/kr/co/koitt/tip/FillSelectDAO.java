package kr.co.koitt.tip;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FillSelectDAO {

	@Autowired
	SqlSession sqlSession;

	public List<FillSelectVO> selectLarge() {
		List<FillSelectVO> listLarge = null;
		listLarge = sqlSession.selectList(
						"FillSelectMapper.selectLarge");
		return listLarge;
	}//selectLarge

	public List<FillSelectVO> selectMediem(FillSelectVO vo) {
		List<FillSelectVO> listMediem = null;
		listMediem = sqlSession.selectList(
						"FillSelectMapper.selectMediem", vo);
		return listMediem;
	}//selectMediem

	public List<FillSelectVO> selectSmall(FillSelectVO vo) {
		List<FillSelectVO> listSmall = null;
		listSmall = sqlSession.selectList(
						"FillSelectMapper.selectSmall", vo);
		return listSmall;
	}//selectSmall

}//class
