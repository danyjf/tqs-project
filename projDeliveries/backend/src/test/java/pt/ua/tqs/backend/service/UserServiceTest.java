package pt.ua.tqs.backend.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pt.ua.tqs.backend.Repository.UserRepository;
import pt.ua.tqs.backend.Service.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    void whenGetUserByExistingEmailAndPassword_thenUserShouldBeReturned() {

    }

    @Test
    void whenGetUserByEmailAndWrongPassword_thenNullShouldBeReturned() {

    }

    @Test
    void whenGetUserByWrongEmailAndPassword_thenNullShouldBeReturned() {

    }

    @Test
    void whenCreateUserWithValidInput_thenSuccessMessageShouldBeReturned() {

    }

    @Test
    void whenCreateUserWithRegisteredUsername_thenUsedUsernameShouldBeReturned() {

    }

    @Test
    void whenCreateUserWithRegisteredEmail_thenUsedEmailShouldBeReturned() {

    }

    @Test
    void whenCreateUserWithRegisteredPassword_thenUsedPasswordShouldBeReturned() {

    }

    @Test
    void whenCreateUserWithRegisteredPhone_thenUsedPhoneShouldBeReturned() {
        
    }
}
