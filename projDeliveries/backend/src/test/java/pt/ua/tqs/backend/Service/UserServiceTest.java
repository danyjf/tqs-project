package pt.ua.tqs.backend.Service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.ua.tqs.backend.Model.User;
import pt.ua.tqs.backend.Repository.UserRepository;

import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void whenGetUserByExistingEmailAndPassword_thenUserShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "934758849", "user");

        Mockito.when(userRepository.findByEmailAndPassword("daniel@gmail.com", "danielpass")).thenReturn(user);

        User fromDb = userService.getUserByEmailAndPassword("daniel@gmail.com", "danielpass");

        assertThat(fromDb.getEmail()).isEqualTo("daniel@gmail.com");
        assertThat(fromDb.getPassword()).isEqualTo("danielpass");

        verify(userRepository, times(1)).findByEmailAndPassword(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void whenGetUserByWrongEmailAndPassword_thenNullShouldBeReturned() {
        Mockito.when(userRepository.findByEmailAndPassword("daniel", "")).thenReturn(null);

        User fromDb = userService.getUserByEmailAndPassword("daniel", "");

        assertThat(fromDb).isNull();

        verify(userRepository, times(1)).findByEmailAndPassword(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void whenCreateUserWithValidInput_thenSuccessMessageShouldBeReturned() {
        User user = new User("daniel", "daniel@gmail.com", "danielpass", "934758849", "user");

        Mockito.when(userRepository.findByUsername("daniel")).thenReturn(null);
        Mockito.when(userRepository.findByEmail("daniel@gmail.com")).thenReturn(null);
        Mockito.when(userRepository.findByPassword("danielpass")).thenReturn(null);
        Mockito.when(userRepository.findByPhone("934758849")).thenReturn(null);

        Map<String, String> response = userService.createUser(user);

        assertThat(response.get("status")).isEqualTo("success");

        verify(userRepository, times(1)).save(Mockito.any());
        verify(userRepository, times(1)).findByUsername(Mockito.anyString());
        verify(userRepository, times(1)).findByEmail(Mockito.anyString());
        verify(userRepository, times(1)).findByPassword(Mockito.anyString());
        verify(userRepository, times(1)).findByPhone(Mockito.anyString());
    }

    @Test
    void whenCreateUserWithRegisteredUsername_thenUsedUsernameShouldBeReturned() {
        User userInDb = new User("daniel", "daniel@gmail.com", "danielpass", "934758849", "user");
        User user = new User("daniel", "dan@gmail.com", "pass", "999998849", "user");

        Mockito.when(userRepository.findByUsername("daniel")).thenReturn(userInDb);

        Map<String, String> response = userService.createUser(user);

        assertThat(response.get("status")).isEqualTo("fail");
        assertThat(response.get("message")).isEqualTo("Username already in use");

        verify(userRepository, times(0)).save(Mockito.any());
        verify(userRepository, times(1)).findByUsername(Mockito.anyString());
        verify(userRepository, times(0)).findByEmail(Mockito.anyString());
        verify(userRepository, times(0)).findByPassword(Mockito.anyString());
        verify(userRepository, times(0)).findByPhone(Mockito.anyString());
    }

    @Test
    void whenCreateUserWithRegisteredEmail_thenUsedEmailShouldBeReturned() {
        User userInDb = new User("daniel", "daniel@gmail.com", "danielpass", "934758849", "user");
        User user = new User("joao", "daniel@gmail.com", "pass", "999998849", "user");

        Mockito.when(userRepository.findByUsername("joao")).thenReturn(null);
        Mockito.when(userRepository.findByEmail("daniel@gmail.com")).thenReturn(userInDb);

        Map<String, String> response = userService.createUser(user);

        assertThat(response.get("status")).isEqualTo("fail");
        assertThat(response.get("message")).isEqualTo("Email already in use");

        verify(userRepository, times(0)).save(Mockito.any());
        verify(userRepository, times(1)).findByUsername(Mockito.anyString());
        verify(userRepository, times(1)).findByEmail(Mockito.anyString());
        verify(userRepository, times(0)).findByPassword(Mockito.anyString());
        verify(userRepository, times(0)).findByPhone(Mockito.anyString());
    }

    @Test
    void whenCreateUserWithRegisteredPassword_thenUsedPasswordShouldBeReturned() {
        User userInDb = new User("daniel", "daniel@gmail.com", "danielpass", "934758849", "user");
        User user = new User("joao", "joao@gmail.com", "danielpass", "999998849", "user");

        Mockito.when(userRepository.findByUsername("joao")).thenReturn(null);
        Mockito.when(userRepository.findByEmail("joao@gmail.com")).thenReturn(null);
        Mockito.when(userRepository.findByPassword("danielpass")).thenReturn(userInDb);

        Map<String, String> response = userService.createUser(user);

        assertThat(response.get("status")).isEqualTo("fail");
        assertThat(response.get("message")).isEqualTo("Password already in use");

        verify(userRepository, times(0)).save(Mockito.any());
        verify(userRepository, times(1)).findByUsername(Mockito.anyString());
        verify(userRepository, times(1)).findByEmail(Mockito.anyString());
        verify(userRepository, times(1)).findByPassword(Mockito.anyString());
        verify(userRepository, times(0)).findByPhone(Mockito.anyString());
    }

    @Test
    void whenCreateUserWithRegisteredPhone_thenUsedPhoneShouldBeReturned() {
        User userInDb = new User("daniel", "daniel@gmail.com", "danielpass", "934758849", "user");
        User user = new User("joao", "joao@gmail.com", "joaopass", "934758849", "user");

        Mockito.when(userRepository.findByUsername("joao")).thenReturn(null);
        Mockito.when(userRepository.findByEmail("joao@gmail.com")).thenReturn(null);
        Mockito.when(userRepository.findByPassword("joaopass")).thenReturn(null);
        Mockito.when(userRepository.findByPhone("934758849")).thenReturn(userInDb);

        Map<String, String> response = userService.createUser(user);

        assertThat(response.get("status")).isEqualTo("fail");
        assertThat(response.get("message")).isEqualTo("Phone already in use");

        verify(userRepository, times(0)).save(Mockito.any());
        verify(userRepository, times(1)).findByUsername(Mockito.anyString());
        verify(userRepository, times(1)).findByEmail(Mockito.anyString());
        verify(userRepository, times(1)).findByPassword(Mockito.anyString());
        verify(userRepository, times(1)).findByPhone(Mockito.anyString());
    }
}
