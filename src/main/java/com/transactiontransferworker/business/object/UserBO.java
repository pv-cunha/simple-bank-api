package com.transactiontransferworker.business.object;

import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.business.service.UserBS;
import com.transactiontransferworker.converters.UsersConverter;
import com.transactiontransferworker.exceptions.UserBalanceException;
import com.transactiontransferworker.exceptions.UserMerchantException;
import com.transactiontransferworker.repository.enuns.UserType;
import com.transactiontransferworker.repository.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class UserBO {

    @Autowired
    private UserBS userBS;

    @Autowired
    private UsersConverter usersConverter;

    public void updateSenderBalance(User user, BigDecimal amount) {

        user.setBalance(user.getBalance().subtract(amount));

        userBS.update(user);
    }

    public void updateReceiverBalance(User user, BigDecimal amount) {

        user.setBalance(user.getBalance().add(amount));

        userBS.update(user);
    }

    public void create(UserDTO userDTO) {
        User user = usersConverter.convertToUserModel(userDTO);

        userBS.create(user);
    }

    public void validateTransaction(User sender, BigDecimal amount) {
        if (sender.getUserType() == UserType.MERCHANT) {
            throw new UserMerchantException();
        }

        if (sender.getBalance().compareTo(amount) < 0) {
            throw new UserBalanceException();
        }
    }
}
