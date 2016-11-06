package notice.dao;

import java.util.List;
import java.util.Map;

import notice.vo.Member;

public interface MemberDao {
	int insert(Member member) throws Exception;
	List<Member> selectList(Map<String,Object> paramMap) throws Exception;
	Member selectOne(int no) throws Exception;
	Member selectOneByPassword(Map<String,Object> paramMap) throws Exception;
	Member selectOneByIdAndPassword(Map<String,Object> paramMap);
	int update(Member member) throws Exception;
	int delete(int no) throws Exception;
}
