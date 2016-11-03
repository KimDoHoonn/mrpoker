package notice.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import notice.vo.Qna;

public interface QnaService {//interface인 이유공부
	List<Qna> getQnaList(int pageNo, int length) throws Exception;
	void insertQna(Qna qna, MultipartFile file1, MultipartFile file2, String uploadDir)throws Exception;
	Qna getQna(int no) throws Exception;
	void updateQna(Qna qna) throws Exception;
	void deleteQna(int no) throws Exception;
}
