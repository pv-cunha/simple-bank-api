package com.simplebank.repository;

import com.simplebank.repository.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<User, String> {

    Optional<User> findUserByDocument(String document);

}
