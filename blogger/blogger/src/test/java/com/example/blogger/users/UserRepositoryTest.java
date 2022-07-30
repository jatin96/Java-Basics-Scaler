package com.example.blogger.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest(showSql = true)
@ActiveProfiles("test")
public class UserRepositoryTest {
    @Autowired
    private UsersRepository usersRepository;
    @Test
    void can_create_users() {
        usersRepository.save(UserEntity.builder().username("jatinnarula").email("jatin@narula.com").build());
    }
}
