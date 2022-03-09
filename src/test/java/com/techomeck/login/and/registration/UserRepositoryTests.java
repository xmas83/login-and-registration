package com.techomeck.login.and.registration;

import com.techomeck.login.and.registration.entity.User;
import com.techomeck.login.and.registration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

    @Autowired
    private UserRepository repo;

    //performs assertion against the DB
    @Autowired
    private TestEntityManager entityManager;


    @Test
    public void testCreateUser() {

        User user = new User();
        user.setEmail("peter432@gmail.com");
        user.setPassword("peter0051/**");
        user.setFirstName("Peter");
        user.setLastName("Huk");
        User userSaved = repo.save(user);

        User existUser = entityManager.find(User.class, userSaved.getId());
        assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
    }
}


