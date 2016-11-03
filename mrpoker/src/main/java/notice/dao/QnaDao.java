package notice.dao;

import java.util.List;
import java.util.Map;

import notice.vo.Qna;

public interface QnaDao {
	List<Qna> selectList(Map<String,Object> paramMap) throws Exception;
	Qna SelectOne(int no) throws Exception;
	int insert(Qna qna) throws Exception;
	int update(Qna qna) throws Exception;
	int delete(int no) throws Exception;
}
