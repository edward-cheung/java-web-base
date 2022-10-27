package cn.edcheung.javaWebBase.service;

import cn.edcheung.javaWebBase.pojo.Paper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

// 配置Spring中的测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定Spring的配置文件路径
@ContextConfiguration(locations = {"classpath*:/spring/spring-*.xml"})
// 测试类开启事务,需要指定事务管理器,默认测试完成后,数据库操作自动回滚
@Transactional(transactionManager = "transactionManager")
// 指定数据库操作不回滚,可选
@Rollback(value = false)
public class PaperServiceTest {

    private static final Logger logger = LoggerFactory.getLogger(PaperServiceTest.class);

    @Autowired
    private PaperService paperService;

    @Test
    public void addPaper() {
        //检查两个变量或者等式是否平衡
        //void assertEquals()

        //检查条件为真
        //void assertTrue()

        //检查条件为假
        //void assertFalse()

        //检查对象不是空的
        //void assertNotNull()

        //检查对象是空的
        //void assertNull()

        //在没有报告的情况下使测试不通过
        //void fail()
    }

    @Test
    public void deletePaperById() {
    }

    @Test
    public void updatePaper() {
    }

    @Test(expected = Exception.class)
    public void query() {
        Paper paper = paperService.queryById(-1L);
        logger.debug(paper.toString());
    }

    @Test(timeout = 3000L)
    public void queryById() {
        Paper paper = paperService.queryById(0L);
        Assert.assertNull(paper);
    }

    @Test
    public void queryAllPaper() {
        List<Paper> paperList = paperService.queryAllPaper();
        Assert.assertNotNull(paperList);
        paperList.forEach(System.out::println);
    }
}