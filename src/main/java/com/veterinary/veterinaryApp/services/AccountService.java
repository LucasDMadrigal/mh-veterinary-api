package com.veterinary.veterinaryApp.services;

import com.veterinary.veterinaryApp.DTOs.AccountDTO;
import com.veterinary.veterinaryApp.models.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAllAccounts();
    List<AccountDTO> getAllAccountsDto();
    Account getAccountById(Long id);
    void saveAccount(Account account);
    Account getAccountByNumber(String accountNumber);

}
