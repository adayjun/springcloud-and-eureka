package com.example.cloudconsumerorder8002;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@SpringBootTest
public class OrderMain8002Test {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;
    private MockHttpSession session;

    // 需要是 @BeforeEach 才生效，junit 5.x中，@Before主键被@BeforeEach所替代
    // > 引用自：https://blog.csdn.net/weixin_45612794/article/details/105450942
    @BeforeEach
    public void setupMockMvc() {
        System.out.println("-- Before > setupMockMvc()");
        //初始化MockMvc对象
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
    }

    @Test
    public void test01() {
        // 创建一个订单
        String url = "/consumer/payment/create?id=1&serial=zhangsan";
        try {
            mvc.perform(MockMvcRequestBuilders.get(url)
                            .session(session))
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print())
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
