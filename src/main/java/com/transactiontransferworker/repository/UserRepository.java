package com.transactiontransferworker.repository;

import com.transactiontransferworker.repository.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByDocument(String document);

    Optional<User> findUserById(UUID id);

}
