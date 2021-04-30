package test.interview.javaapi.account;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    private final AccountRepository repository;

    @Autowired
    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public List<Account> getAccounts(){
        return repository.findAll();
    }

    public void addAccount(Account account) {
        Optional<Account> acc = repository.findById(account.getId());
        if(acc.isPresent()){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Account already exists");
        }
        repository.save(account);
    }

    public Optional<Account> getAccountById(Long id) {
        Optional<Account> existingAcc = repository.findById(id);
        if(!existingAcc.isPresent()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such account");
        }

        return existingAcc;
    }

    public void deleteById(Long id) {
        boolean exists = repository.existsById(id);
        if(!exists)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such account");
        repository.deleteById(id);
    }

    public void updateAccount(Account account, Long id) {
        Account existingAcc = getAccountById(id).get();
        existingAcc.setAddress(account.getAddress());
        existingAcc.setCountry(account.getCountry());
        existingAcc.setDepartment(account.getDepartment());
        existingAcc.setEmail(account.getEmail());
        existingAcc.setName(account.getName());
        existingAcc.setPhone(account.getPhone());
        repository.save(existingAcc);
    }
}
