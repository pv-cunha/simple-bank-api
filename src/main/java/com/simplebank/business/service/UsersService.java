package com.simplebank.business.service;

import com.simplebank.exceptions.UserAlreadyExistsException;
import com.simplebank.exceptions.UserNotFoundException;
import com.simplebank.repository.UsersRepository;
import com.simplebank.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersService {

    @Autowired
    private UsersRepository usersRepository;
    @Transactional
    public User createNewUser(User user) {
        Optional<User> userByDocument = usersRepository.findUserByDocument(user.getDocument());

        if (userByDocument.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        return usersRepository.save(user);
    }

    public User getUserByDocument(String document) {
        Optional<User> userByDocument = usersRepository.findUserByDocument(document);

        return userByDocument.orElseThrow(UserNotFoundException::new);
    }

}
