package objackie.dao;

import java.util.List;
import java.util.Map;

import objackie.vo.Gongzi;

public interface GongziDao {
  List<Gongzi> selectList(Map<String,Object> paramMap) throws Exception;
  Gongzi selectOne(int no) throws Exception;
  int insert(Gongzi gongzi) throws Exception;
  int update(Gongzi gongzi) throws Exception;
  int delete(int no) throws Exception;
}








