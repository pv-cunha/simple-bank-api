package com.transactiontransferworker.business.service;

import com.transactiontransferworker.repository.GroupRepository;
import com.transactiontransferworker.repository.enuns.UserType;
import com.transactiontransferworker.repository.models.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserPermissionBS {

    @Autowired
    private GroupRepository groupRepository;

    public List<Group> getGroupByUserType(UserType userType) {
        Optional<Group> groups = groupRepository.getGroupByName(userType.getUserType());

        return groups.stream()
                .collect(Collectors.toList());
    }
}
