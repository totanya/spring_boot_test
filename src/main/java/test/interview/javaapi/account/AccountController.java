package test.interview.javaapi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/accounts")
public class AccountController {

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    private final AccountService service;

    @GetMapping
    public List<Account> getAccounts() {
        return service.getAccounts();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable Long id) {
        Optional<Account> account = service.getAccountById(id);
        return new ResponseEntity<>(account.get(), HttpStatus.OK);
    }

    @PostMapping
    public void createAccount(@RequestBody Account account) {
        service.addAccount(account);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(@RequestBody Account account, @PathVariable Long id) {
        service.updateAccount(account, id);
        return new ResponseEntity(account, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAccount(@PathVariable Long id) {
        service.deleteById(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
