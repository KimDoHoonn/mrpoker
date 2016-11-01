package notice.controller.json;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import notice.dao.ReplyDao;
import notice.vo.JsonResult;
import notice.vo.Reply;

@Controller 
@RequestMapping("/reply/")
public class ReplyController {
  
  @Autowired ReplyDao replyDao;
  
  @RequestMapping(path="list2")
  public Object list(int no) throws Exception {
    
    try {
      
      return JsonResult.success(replyDao.selectList(no));
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="add2")
  public Object add(Reply reply) throws Exception {
    try {
      replyDao.insert(reply);
      return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="detail2")
  public Object detail(int no) throws Exception {
    try {

      return JsonResult.success(replyDao.selectOne(no));
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  @RequestMapping(path="update2")
  public Object update(Reply reply) throws Exception {
    try {
      HashMap<String,Object> paramMap = new HashMap<>();
      paramMap.put("reno", reply.getReno());
      paramMap.put("email", reply.getEmail());
      replyDao.update(reply);
      return JsonResult.success();
      
    } catch (Exception e) {
      return JsonResult.fail(e.getMessage());
    }
  }
  
  
  
  @RequestMapping(path="delete2")
  public Object delete(int no) throws Exception {
    try {
      replyDao.delete(no);
      return JsonResult.success();
      
    } catch (Exception e) {
      e.printStackTrace();
      return JsonResult.fail(e.getMessage());
    }
  }
}



