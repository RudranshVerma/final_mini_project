package com.cts.project.serviceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cts.project.entity.User;
import com.cts.project.repository.UserRepository;
import com.cts.project.service.UserService;
//@DataJpaTest 
//@RunWith(SpringRunner.class) 

@SpringBootTest
public class UserServiceImplTest {
	@Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    
    AutoCloseable autoCloseable;
    private User user;
    private User oldUser;

    @BeforeEach
    void setup() {
        autoCloseable = MockitoAnnotations.openMocks(this);
        user = User.builder()
                .userId(1L)
                .userRole("user")
                .userName("Ashish")
                .password("Agarwal@12")
                .emailId("agarwal@gmail.com").attendance(1L)
                .build();
        oldUser = User.builder()
                .userId(1L)
                .userRole("admin")
                .userName("Ashish Agarwal")
                .password("Agarwal@123")
                .emailId("agaral@gmail.com").attendance(1L)
                .build();
    }

    @AfterEach
    void tearDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    @DisplayName("Checking create user")
    void checkingWhetherTheUserHasBeenCreatedTest() {
        mock(User.class);
        mock(UserRepository.class);
        when(userRepository.save(user)).thenReturn(user);
        assertThat(userService.createUser(user)).isEqualTo(user);
    }

    @Test
    @DisplayName("Retrieving a particular user")
    void testRetrieveSingleUserById() {
        mock(User.class);
        mock(UserRepository.class);
        when(userRepository.findById(1L)).thenReturn(Optional.ofNullable(user));
        assertThat(userService.getUserById(1L).getUserId()).isEqualTo(user.getUserId());
    }

    @Test
    @DisplayName("Retrieving All Users")
    void testRetrieveAllUsers() {
        mock(User.class);
        mock(UserRepository.class);
        when(userRepository.findAll()).thenReturn(new ArrayList<User>(Collections.singleton(user)));
        assertThat(userService.getAllUsers().get(0).getEmailId()).isEqualTo(user.getEmailId());
    }


    @Test
    @DisplayName("Update User")
    void testUpdateUser() {
        mock(User.class);
        mock(UserRepository.class);
        when(userRepository.save(oldUser)).thenReturn(oldUser);
        when(userRepository.findById(1L)).thenReturn(Optional.of(oldUser));
        Long updatedUser = userService.updateUserById(user.getAttendance(),1L);
        assertEquals(1L, updatedUser);
    }

    @Test
    void testDeleteUserById() {
        mock(User.class);
        mock(UserRepository.class);
        doNothing().when(userRepository).deleteById(1L);
        String result = userService.deleteUserById(1L);
        verify(userRepository).deleteById(1L);
        assertEquals("deleted",result);
    }
}
