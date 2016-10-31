package objackie.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import objackie.dao.GongziDao;
import objackie.dao.GongziFileDao;
import objackie.service.GongziService;
import objackie.util.FileUploadUtil;
import objackie.vo.Gongzi;
import objackie.vo.GongziFile;

@Service 
public class DefaultGongziService implements GongziService {
  @Autowired GongziDao gongziDao;
  @Autowired GongziFileDao gongziFileDao;
  
  public List<Gongzi> getGongziList(int pageNo, int length) throws Exception {
    HashMap<String,Object> map = new HashMap<>();
    map.put("startIndex", (pageNo - 1) * length);
    map.put("length", length);
    return gongziDao.selectList(map);
  }
  
  public void insertGongzi(Gongzi gongzi, 
      MultipartFile file1,
      MultipartFile file2,
      String uploadDir) throws Exception {
    
    gongziDao.insert(gongzi);
    
    String newFilename = null;
    if (file1 != null && !file1.isEmpty()) {
      newFilename = FileUploadUtil.getNewFilename(file1.getOriginalFilename());
      file1.transferTo(new File(uploadDir + newFilename));
      GongziFile gongziFile = new GongziFile();
      gongziFile.setPhopath(newFilename);
      gongziFile.setNo(gongzi.getNo());
      //gongziFile.setGongziNo(10200); //트랜잭션 테스트 용 
      gongziFileDao.insert(gongziFile);
    }
    
    if (file2 != null && !file2.isEmpty()) {
      newFilename = FileUploadUtil.getNewFilename(file2.getOriginalFilename());
      file2.transferTo(new File(uploadDir + newFilename));
      GongziFile gongziFile = new GongziFile();
      gongziFile.setPhopath(newFilename);
      gongziFile.setNo(gongzi.getNo());
      gongziFileDao.insert(gongziFile);
    }
  }
  
  public Gongzi getGongzi(int no) throws Exception {
    return gongziDao.selectOne(no);
  }
    
    
  public void updateGongzi(Gongzi gongzi) throws Exception {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", gongzi.getNo());
    paramMap.put("email", gongzi.getEmail());
    
    gongziDao.update(gongzi);
  }
  
  public void deleteGongzi(int no) throws Exception {
    gongziDao.delete(no);
  }
}







