package org.meliades;

import org.meliades.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Fred on 20/04/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class UserControllerIntegrationTests {

    @Value("${local.server.port}")
    private int port;

    @Test
    public void runAndTestUser() {

        // TODO
        // http://springinpractice.com/2013/10/02/quick-tip-basic-authentication-with-spring-resttemplate

        //System.out.println("port = " + port);
        //String url = "http://localhost:" + port + "/";
        //String body = new RestTemplate().getForObject(url, String.class);

        //Assert.assertEquals(body, "Hello");
    }
}
