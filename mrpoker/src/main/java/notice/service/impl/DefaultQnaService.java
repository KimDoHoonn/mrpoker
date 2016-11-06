package notice.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import notice.dao.QnaDao;
import notice.dao.QnaFileDao;
import notice.service.QnaService;
import notice.util.FileUploadUtil;
import notice.vo.Qna;
import notice.vo.QnaFile;

@Service
public class DefaultQnaService implements QnaService {
	@Autowired QnaDao qnaDao;
	@Autowired QnaFileDao qnaFileDao;
	
public List<Qna> getQnaList(int pageNo, int length) throws Exception {
	HashMap<String,Object> map = new HashMap<>();
	map.put("startIndex", (pageNo - 1)*length);
	map.put("length", length);
	return qnaDao.selectList(map);
}

public void insertQna(Qna qna,
			MultipartFile file1,
			MultipartFile file2,
			String uploadDir) throws Exception {
	
	qnaDao.insert(qna);
	
	 String newFilename = null;
	    if (file1 != null && !file1.isEmpty()) {
	      newFilename = FileUploadUtil.getNewFilename(file1.getOriginalFilename());
	      file1.transferTo(new File(uploadDir + newFilename));
	      QnaFile qnaFile = new QnaFile();
	      qnaFile.setPhopath(newFilename);
	      qnaFile.setNo(qna.getNo());
	      //gongziFile.setGongziNo(10200); //트랜잭션 테스트 용 
	      qnaFileDao.insert(qnaFile);
	    }
	    
	    if (file2 != null && !file2.isEmpty()) {
	      newFilename = FileUploadUtil.getNewFilename(file2.getOriginalFilename());
	      file2.transferTo(new File(uploadDir + newFilename));
	      QnaFile qnaFile = new QnaFile();
	      qnaFile.setPhopath(newFilename);
	      qnaFile.setNo(qna.getNo());
	      qnaFileDao.insert(qnaFile);
	    }
	  }
public Qna getQna(int no) throws Exception {
    return qnaDao.SelectOne(no);
  }
    
  public void updateQna(Qna qna) throws Exception {
    HashMap<String,Object> paramMap = new HashMap<>();
    paramMap.put("no", qna.getNo());
    paramMap.put("writer", qna.getWriter()); // 확인
    
    qnaDao.update(qna);
  }
  
  public void deleteQna(int no) throws Exception {
    qnaDao.delete(no);
  }
}
