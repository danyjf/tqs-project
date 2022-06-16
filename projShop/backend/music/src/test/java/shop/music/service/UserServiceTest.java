package shop.music.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import shop.music.model.User;
import shop.music.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

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
        User user = new User("User", "Name", "email@gmail.com", "password");

        Mockito.when(userRepository.findByEmailAndPassword("email@gmail.com", "password")).thenReturn(user);

        User fromDb = userService.getUserLogin("email@gmail.com", "password");

        assertThat(fromDb.getEmail()).isEqualTo("email@gmail.com");
        assertThat(fromDb.getPassword()).isEqualTo("password");

        verify(userRepository, times(1)).findByEmailAndPassword(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void whenGetUserByWrongEmailAndPassword_thenNullShouldBeReturned() {
        Mockito.when(userRepository.findByEmailAndPassword("User", "")).thenReturn(null);

        User fromDb = userService.getUserLogin("User", "");

        assertThat(fromDb).isNull();

        verify(userRepository, times(1)).findByEmailAndPassword(Mockito.anyString(), Mockito.anyString());
    }

    @Test
    void whenGetUserById_thenUserShouldBeReturned(){
        User user = new User("User", "Name", "email@gmail.com", "password");

        Mockito.when(userRepository.findById(0)).thenReturn(user);

        assertThat(userService.getUserById(0)).isEqualTo(user);

        verify(userRepository, times(1)).findById(Mockito.anyInt());

    }

    @Test
    void whenEmailInUse_thenReturnTrue(){
        User user = new User("User", "Name", "email@gmail.com", "password");

        Mockito.when(userRepository.findByEmail("email@gmail.com")).thenReturn(user);

        boolean response = userService.isEmailInUse("email@gmail.com");

        assertThat(response).isEqualTo(true);

        verify(userRepository, times(1)).findByEmail(Mockito.anyString());

    }

    @Test
    void whenEmailNotInUse_thenReturnTrue(){

        Mockito.when(userRepository.findByEmail("email@gmail.com")).thenReturn(null);

        boolean response = userService.isEmailInUse("email@gmail.com");

        assertThat(response).isEqualTo(false);

        verify(userRepository, times(1)).findByEmail(Mockito.anyString());

    }

    @Test
    void whenGetAllUsers_thenAllUsersShouldBeReturned(){
        User user1 = new User("User", "Name", "emaail@gmail.com", "password");
        User user2 = new User("User", "Name", "email@gmail.com", "password");

        ArrayList<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);

        Mockito.when(userRepository.findAll()).thenReturn(users);

        List<User> response = userService.getUsers();

        assertThat(response).isEqualTo(users);

        verify(userRepository, times(1)).findAll();
    }
}