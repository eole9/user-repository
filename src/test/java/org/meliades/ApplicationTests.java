package org.meliades;

import org.meliades.app.Application;
import org.meliades.beans.User;
import org.meliades.repository.UserRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

    private static final Logger log = LoggerFactory.getLogger(ApplicationTests.class);

    @Autowired
    private UserRepository userRepository;

    @Before
    @After
    public void before() {
        userRepository.deleteAll();
    }

    @Test
    public void testFindByUsername() {
        if (log.isDebugEnabled())
            log.debug("testFindByUsername()");

        User hollande = userRepository.save(new User("Hollande", "François", 60));
        User sarkozy = userRepository.save(new User("Sarkozy", "Nicolas", 60));

        Collection<User> users = userRepository.findByNom("Hollande");
        for (User user : users) {
            log.info("->" + user);
        }

        Assert.assertEquals(userRepository.findByPrenom("François").getId(), hollande.getId());

        assertThat(userRepository.findByPrenom("Nicolas").getId(), is(sarkozy.getId()));

        if (log.isDebugEnabled())
            log.debug("testFindByUsername: void");
    }

}
