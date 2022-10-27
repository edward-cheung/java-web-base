package cn.edcheung.javaWebBase.service.impl;

import cn.edcheung.javaWebBase.dao.PaperDao;
import cn.edcheung.javaWebBase.pojo.Paper;
import cn.edcheung.javaWebBase.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * PaperServiceImpl TODO
 *
 * @author Edward Cheung
 * 2019/5/14
 */
@Service
public class PaperServiceImpl implements PaperService {
    @Autowired
    private PaperDao paperDao;

    @Override
    public int addPaper(Paper paper) {
        return paperDao.addPaper(paper);
    }

    @Override
    public int deletePaperById(long id) {
        return paperDao.deletePaperById(id);
    }

    @Override
    public int updatePaper(Paper paper) {
        return paperDao.updatePaper(paper);
    }

    @Override
    public Paper queryById(long id) {
        if (id < 0L) {
            throw new IllegalArgumentException();
        } else {
            return paperDao.queryById(id);
        }
    }

    @Override
    public List<Paper> queryAllPaper() {
        return paperDao.queryAllPaper();
    }

}
