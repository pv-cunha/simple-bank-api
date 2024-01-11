package com.transactiontransferworker.business.object;

import com.transactiontransferworker.api.dtos.UserCreatedDTO;
import com.transactiontransferworker.api.dtos.UserDTO;
import com.transactiontransferworker.business.service.UserBS;
import com.transactiontransferworker.converters.UsersConverter;
import com.transactiontransferworker.exceptions.UserBalanceException;
import com.transactiontransferworker.exceptions.UserMerchantException;
import com.transactiontransferworker.repository.enuns.UserType;
import com.transactiontransferworker.repository.models.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class UserBOTest {
    @Spy
    @InjectMocks
    private UserBO userBO;

    @Mock
    private UserBS userBS;

    @Mock
    private UsersConverter usersConverter;

    @Test
    public void shouldBeAbleToCreateAUser() {
        User user = new User();
        UserDTO userDTO = new UserDTO();
        UserCreatedDTO userCreatedDTO = new UserCreatedDTO();

        when(usersConverter.convertToUserModel(any())).thenReturn(user);
        when(userBS.create(any())).thenReturn(user);
        when(usersConverter.convertToUserCreatedDTO(any())).thenReturn(userCreatedDTO);

        UserCreatedDTO userCreated = userBO.create(userDTO);

        assertNotNull(userCreated);
    }

    @Test
    public void shouldBeAbleToValidateATransaction() {
        User user = new User();
        user.setUserType(UserType.COMMON);
        user.setBalance(new BigDecimal("10"));

        userBO.validateTransaction(user, new BigDecimal("10"));
        verify(userBO).validateTransaction(user, new BigDecimal("10"));
    }

    @Test
    public void shouldNotBeAbleToValidateATransactionWhenTheUserIsAMerchant() {
        User user = new User();
        user.setUserType(UserType.MERCHANT);
        user.setBalance(new BigDecimal("10"));

        assertThrows(UserMerchantException.class, () -> userBO.validateTransaction(user, new BigDecimal("10")));
    }

    @Test
    public void shouldNotBeAbleToValidateATransactionWhenTheAmountIsHigherThanTheBalance() {
        User user = new User();
        user.setUserType(UserType.COMMON);
        user.setBalance(new BigDecimal("10"));

        assertThrows(UserBalanceException.class, () -> userBO.validateTransaction(user, new BigDecimal("11")));
    }

    @Test
    public void shouldBeAbleToUpdateASenderBalance() {
        User user = new User();
        user.setUserType(UserType.COMMON);
        user.setBalance(new BigDecimal("10"));

        userBO.updateSenderBalance(user, new BigDecimal("10"));
        verify(userBO).updateSenderBalance(user, new BigDecimal("10"));
    }

    @Test
    public void shouldBeAbleToUpdateAReceiverBalance() {
        User user = new User();
        user.setUserType(UserType.COMMON);
        user.setBalance(new BigDecimal("10"));

        userBO.updateReceiverBalance(user, new BigDecimal("10"));
        verify(userBO).updateReceiverBalance(user, new BigDecimal("10"));
    }

}