package objackie.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import objackie.vo.Gongzi;

public interface GongziService {
  List<Gongzi> getGongziList(int pageNo, int length) throws Exception;
  void insertGongzi(Gongzi gongzi, MultipartFile file1, MultipartFile file2, String uploadDir) throws Exception;
  Gongzi getGongzi(int no) throws Exception;
  void updateGongzi(Gongzi gongzi) throws Exception;
  void deleteGongzi(int no) throws Exception;
}







