package kr.co.koitt.tip;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FillSelectService {

	@Autowired
	FillSelectDAO fillSelectDAO;

	public List<FillSelectVO> selectLarge() {
		List<FillSelectVO> listLarge = null;
		listLarge = fillSelectDAO.selectLarge();
		return listLarge;
	}//selectLarge

	public List<FillSelectVO> selectMediem(FillSelectVO vo) {
		List<FillSelectVO> listMediem = null;
		listMediem = fillSelectDAO.selectMediem(vo);
		return listMediem;
	}//selectMediem

	public List<FillSelectVO> selectSmall(FillSelectVO vo) {
		List<FillSelectVO> listSmall = null;
		listSmall = fillSelectDAO.selectSmall(vo);
		return listSmall;
	}//selectSmall

}//class
