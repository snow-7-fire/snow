package com.zy.snow;

import com.zy.snow.study.spring.mail.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SnowApplicationTests {

    private MailClient mailClient;

    /*
        邮箱测试
     */
    @Test
    void mailClientTest() {
       mailClient.sendMail("82546668@qq.com","snow","我爱她轰轰烈烈 最疯狂");
    }

    @Autowired
    public void setMailClient(MailClient mailClient) {
        this.mailClient = mailClient;
    }
}
