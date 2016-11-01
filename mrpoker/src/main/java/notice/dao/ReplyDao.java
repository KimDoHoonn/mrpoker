package notice.dao;

import java.util.List;

import notice.vo.Reply;

public interface ReplyDao {
  List<Reply> selectList(int no) throws Exception;
  Reply selectOne(int no) throws Exception;
  int insert(Reply reply) throws Exception;
  int update(Reply reply) throws Exception;
  int delete(int no) throws Exception;
}








