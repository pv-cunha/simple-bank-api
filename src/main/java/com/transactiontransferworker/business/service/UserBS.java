package com.transactiontransferworker.business.service;

import com.transactiontransferworker.exceptions.UserAlreadyExistsException;
import com.transactiontransferworker.exceptions.UserNotFoundException;
import com.transactiontransferworker.repository.UserRepository;
import com.transactiontransferworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserBS {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User update(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User create(User user) {
        Optional<User> userByDocument = userRepository.findUserByDocument(user.getDocument());

        if (userByDocument.isPresent()) {
            throw new UserAlreadyExistsException();
        }

        return userRepository.save(user);
    }

    public User getByDocument(String document) {
        Optional<User> userByDocument = userRepository.findUserByDocument(document);

        return userByDocument.orElseThrow(UserNotFoundException::new);
    }

    public User getById(UUID id) {
        Optional<User> userById = userRepository.findUserById(id);

        return userById.orElseThrow(UserNotFoundException::new);
    }

    public User getByEmail(String email) {
        Optional<User> userByDocument = userRepository.findUserByEmail(email);

        return userByDocument.orElseThrow(UserNotFoundException::new);
    }

}
