package pt.ua.tqs.backend.Repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.TestPropertySource;
import pt.ua.tqs.backend.Model.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@TestPropertySource(locations = "classpath:pt/ua/tqs/backend/repositorytest.properties")
public class UserRepositoryTest {
    @Autowired
    private TestEntityManager testEntityManager;

    @Autowired
    private UserRepository userRepository;

    @Test
    void whenGetUserByExistingEmailAndPassword_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "983748939", "user");
        testEntityManager.persistAndFlush(user);

        User fromDb = userRepository.findByEmailAndPassword(user.getEmail(), user.getPassword());

        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getEmail()).isEqualTo(user.getEmail());
        assertThat(fromDb.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void whenGetUserByExistingEmailAndWrongPassword_thenNullShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "983748939", "user");
        testEntityManager.persistAndFlush(user);

        User fromDb = userRepository.findByEmailAndPassword(user.getEmail(), "WrongPassword");

        assertThat(fromDb).isNull();
    }

    @Test
    void whenGetUserByUsername_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "983748939", "user");
        testEntityManager.persistAndFlush(user);

        User fromDb = userRepository.findByUsername(user.getUsername());

        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getUsername()).isEqualTo(user.getUsername());
    }

    @Test
    void whenGetUserByEmail_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "983748939", "user");
        testEntityManager.persistAndFlush(user);

        User fromDb = userRepository.findByEmail(user.getEmail());

        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getEmail()).isEqualTo(user.getEmail());
    }

    @Test
    void whenGetUserByPassword_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "983748939", "user");
        testEntityManager.persistAndFlush(user);

        User fromDb = userRepository.findByPassword(user.getPassword());

        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    void whenGetUserByPhone_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "983748939", "user");
        testEntityManager.persistAndFlush(user);

        User fromDb = userRepository.findByPhone(user.getPhone());

        assertThat(fromDb).isNotNull();
        assertThat(fromDb.getPhone()).isEqualTo(user.getPhone());
    }
}
