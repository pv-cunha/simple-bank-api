package com.transactiontransferworker.business.service;

import com.transactiontransferworker.exceptions.UserAlreadyExistsException;
import com.transactiontransferworker.repository.UserRepository;
import com.transactiontransferworker.repository.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserBSTest {

    @InjectMocks
    private UserBS userBS;
    @Mock
    private UserRepository userRepository;

    @Test
    public void shouldBeAbleToUpdateAnUser() {
        User user = new User();

        when(userRepository.save(any())).thenReturn(user);

        User userUpdated = userBS.update(user);

        assertNotNull(userUpdated);
    }

    @Test
    public void shouldBeAbleToCreateAnUser() {
        User user = new User();
        Optional<User> optionalUser = Optional.empty();

        when(userRepository.findUserByDocument(any())).thenReturn(optionalUser);
        when(userRepository.save(any())).thenReturn(user);

        User userCreated = userBS.create(user);

        assertNotNull(userCreated);
    }

    @Test
    public void shouldBeAbleToGetAnUserByDocument() {
        User user = new User();
        Optional<User> optionalUser = Optional.of(user);

        when(userRepository.findUserByDocument(any())).thenReturn(optionalUser);

        User userByDocument = userBS.getByDocument("document");

        assertNotNull(userByDocument);
    }

    @Test
    public void shouldBeAbleToGetAnUserById() {
        User user = new User();
        Optional<User> optionalUser = Optional.of(user);

        when(userRepository.findUserById(any())).thenReturn(optionalUser);

        User userById = userBS.getById(UUID.randomUUID());

        assertNotNull(userById);
    }

    @Test
    public void shouldNotBeAbleToCreateAnUserWhenTheUserAlreadyExists() {
        User user = new User();
        Optional<User> optionalUser = Optional.of(user);

        when(userRepository.findUserByDocument(any())).thenReturn(optionalUser);

        assertThrows(UserAlreadyExistsException.class, () -> userBS.create(user));
    }

}