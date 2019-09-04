package kr.co.ziziza.admin.dao;

import java.util.List;
import java.util.Map;

import kr.co.ziziza.admin.vo.AdminCommentVO;

public interface AdminCommentDAO {
	
	int selectTotalCnt(Map<String, Object> params);
	
	List<AdminCommentVO> selectList(Map<String, Object> params);

	AdminCommentVO selectInfo(Map<String, Object> params);

	int insertInfo(AdminCommentVO vo);

	int updateInfo(AdminCommentVO vo);

	int deleteInfo(Map<String, Object> params);
	
}//interface end