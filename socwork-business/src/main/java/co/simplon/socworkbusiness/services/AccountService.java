package co.simplon.socworkbusiness.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.simplon.socworkbusiness.dtos.AccountAuthentificate;
import co.simplon.socworkbusiness.dtos.AccountCreate;
import co.simplon.socworkbusiness.entities.Account;
import co.simplon.socworkbusiness.repositories.AccountRepository;

@Service
@Transactional(readOnly = true)
public class AccountService {

    private final AccountRepository repos;
    private final PasswordEncoder passwordEncoder;

    public AccountService(AccountRepository repos, PasswordEncoder passwordEncoder) {
	this.repos = repos;
	this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void create(AccountCreate inputs) {
	Account entity = new Account();
	entity.setUsername(inputs.username().toLowerCase());
	entity.setPassword(passwordEncoder.encode(inputs.password()));
	repos.save(entity);
    }

    @Transactional
    public Object authentificate(AccountAuthentificate inputs) {
	String username = inputs.username();
	Account account = repos.findAllByUsernameIgnoreCase(username)
		.orElseThrow(() -> new BadCredentialsException(username));

	if (account != null) {
	    return "account found " + username;
	}
	return "account not found " + username;
    }
}
