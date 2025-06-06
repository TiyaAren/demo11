package com.example.demo.services.impl;

import com.example.demo.DTO.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public AccountDTO create(AccountDTO accountDTO) {
        return new AccountDTO(accountRepository.save(Account.builder().title(accountDTO.title()).build()).getTitle());
    }


    @Override
    public AccountDTO findById(Long id) {
        return accountRepository.findById(id)
                .map(account -> new AccountDTO(account.getTitle()))
                .orElseThrow(() -> new NoSuchElementException("Account not found"));
    }

    @Override
    public List<AccountDTO> getAll() {
        return accountRepository.findAll().stream()
                .map(account -> new AccountDTO(account.getTitle()))
                .toList();
    }

    @Override
    public AccountDTO update(Long id, AccountDTO accountDTO) {
        Account account = accountRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Hobby not found"));
        account.setTitle(accountDTO.title());
        return new AccountDTO(accountRepository.save(account).getTitle());
    }

    @Override
    public void delete(Long id) {
        accountRepository.deleteById(id);
    }
}
