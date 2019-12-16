package vss.spring.trans.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vss.spring.trans.model.User;
import vss.spring.trans.model.UserAccount;
import vss.spring.trans.repositories.UserAccountRepository;

@Service
public class UserAccountService {

    private static final Float OPERATOR_CHANGE_COST = 100.f;

    @Autowired
    private UserAccountRepository accountRepository;

    @Transactional(rollbackFor = {IllegalArgumentException.class, DataAccessException.class})
    public void changeMobileOperator(User user, String newOperatorName) {
        UserAccount account = user.getAccount();
        validateAccount(account);
        validateOperatorName(newOperatorName);
        validateAccountAmount(account.getAmount());

        account.setCompanyName(newOperatorName);
        account.setAmount(account.getAmount() - OPERATOR_CHANGE_COST);
        accountRepository.save(account);
    }

    private void validateAccountAmount(Float amount) {
        if (amount < OPERATOR_CHANGE_COST) {
            throw new IllegalArgumentException("Not enough costs. Amount should be 100 or more");
        }
    }

    private void validateAccount(UserAccount account) {
        if (account == null) {
            throw new IllegalArgumentException("User account should not be empty");
        }
    }

    private void validateOperatorName(String newOperatorName) {
        if (newOperatorName == null) {
            throw new IllegalArgumentException("User account should not be empty");
        }
    }
}