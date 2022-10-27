package cn.edcheung.javaWebBase.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

/**
 * Description PaperControllerTest
 *
 * @author Edward Cheung
 * @date 2020/4/20
 * @since JDK 1.8
 */
// 配置Spring中的测试环境
@RunWith(SpringJUnit4ClassRunner.class)
// 指定测试环境使用的ApplicationContext是WebApplicationContext类型的
// value指定web应用的根
@WebAppConfiguration(value = "src/main/webapp")
// 指定Spring容器层次和配置文件路径
@ContextHierarchy({
        @ContextConfiguration(name = "parent", locations = {"classpath*:/spring/applicationContext.xml"}),
        @ContextConfiguration(name = "child", locations = {"classpath*:/spring/applicationContext_mvc.xml"})
})
// 测试类开启事务,需要指定事务管理器,默认测试完成后,数据库操作自动回滚
@Transactional(transactionManager = "transactionManager")
// 指定数据库操作不回滚,可选
@Rollback(value = false)
public class PaperControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(PaperControllerTest.class);

    // 注入webApplicationContext
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    // 初始化mockMvc,在每个测试方法前执行
    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    public void testIndex() throws Exception {
        /**
         * mockMvc.perform()执行一个请求
         * get("/server/get")构造一个请求
         * andExpect()添加验证规则
         * andDo()添加一个结果处理器
         * andReturn()执行完成后返回结果
         */
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/server/get").param("id", "1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json;charset=UTF-8"))
                .andExpect(MockMvcResultMatchers.content().json("{'foo':'bar'}"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.username").value("Google"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();

        logger.info(result.getResponse().getContentAsString());

        // 增加验证断言
        Assert.assertNotNull(result.getResponse().getContentAsString());
    }
}
