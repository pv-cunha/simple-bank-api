package com.transactiontransferworker.repository;

import com.transactiontransferworker.repository.models.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long> {

    @Query("select group from groups group where group.name = :name")
    Optional<Group> getGroupByName(String name);

}
