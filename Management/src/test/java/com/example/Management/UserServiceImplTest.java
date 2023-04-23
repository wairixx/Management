package com.example.Management;

import com.example.Management.entities.User;
import com.example.Management.repositories.UserRepo;
import com.example.Management.servicesImpl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    private final Long ID = 1l;
    private final String EMAIL = "sasha@gmail.com";
    private final String USERNAME = "wairixx";
    private final String PASSWORD = "123";
    private final String ROLE = "USER";
    private final Boolean ACTIVATED = true;
    private final String ACT_CODE = null;
    User user;

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    private void init(){
        user = new User(ID, EMAIL, USERNAME, PASSWORD, ROLE, ACTIVATED, ACT_CODE);
    }

    @Test
    public void findByUsernameTest(){
        when(userRepo.findByUsername(USERNAME)).thenReturn(user);
        User user1 = userService.findByUsername(USERNAME);
        assertEquals(user.getUsername(), user1.getUsername());
    }
    @Test
    public void findByEmailTest(){
        when(userRepo.findByEmail(EMAIL)).thenReturn(user);
        User user1 = userService.findByEmail(EMAIL);
        assertEquals(user.getEmail(), user1.getEmail());
    }
    @Test
    public void isLoggedTest(){
        when(userRepo.findByUsername(USERNAME)).thenReturn(user);
        Boolean test = userService.isLogged(user);
        assertEquals(true, test);
    }
    @Test
    public void isLoggedTest2(){
        User user1 = new User(ID, EMAIL, "Vova", PASSWORD, ROLE, ACTIVATED, null);
        when(userRepo.findByUsername(USERNAME)).thenReturn(user1);
        Boolean test = userService.isLogged(user);
        assertEquals(false, test);
    }
    @Test
    public void isLoggedTest3(){
        User user1 = new User(ID, EMAIL, USERNAME, "1", ROLE, ACTIVATED, null);
        when(userRepo.findByUsername(user1.getUsername())).thenReturn(user1);
        Boolean test = userService.isLogged(user);
        assertEquals(false, test);
    }
    @Test
    public void isLoggedTest4(){
        when(userRepo.findByUsername(user.getUsername())).thenReturn(null);
        Boolean test = userService.isLogged(user);
        assertEquals(false, test);
    }
}
