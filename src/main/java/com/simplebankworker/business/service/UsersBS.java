package com.simplebankworker.business.service;

import com.simplebankworker.exceptions.UserAlreadyExistsException;
import com.simplebankworker.exceptions.UserNotFoundException;
import com.simplebankworker.repository.UsersRepository;
import com.simplebankworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UsersBS {

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
