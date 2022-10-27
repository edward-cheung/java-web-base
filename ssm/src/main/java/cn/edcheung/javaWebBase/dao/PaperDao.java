package cn.edcheung.javaWebBase.dao;

import cn.edcheung.javaWebBase.pojo.Paper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaperDao {

    int addPaper(Paper paper);

    int deletePaperById(@Param("paperId") long id);

    int updatePaper(Paper paper);

    Paper queryById(@Param("paperId") long id);

    List<Paper> queryAllPaper();

}
