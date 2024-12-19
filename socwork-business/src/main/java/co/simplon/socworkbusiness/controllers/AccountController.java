package co.simplon.socworkbusiness.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.socworkbusiness.dtos.AccountAuthenticate;
import co.simplon.socworkbusiness.dtos.AccountCreate;
import co.simplon.socworkbusiness.dtos.AuthInfo;
import co.simplon.socworkbusiness.entities.Account;
import co.simplon.socworkbusiness.services.AccountService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/accounts")
public class AccountController {
    public final AccountService service;

    public AccountController(AccountService service) {
	this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void create(@RequestBody @Valid AccountCreate inputs) {
	service.create(inputs);
    }

    @PostMapping("/authenticate")
    @ResponseStatus(HttpStatus.CREATED)
    AuthInfo authentificate(@RequestBody AccountAuthenticate inputs) {
	return service.authenticate(inputs);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    String getAccount() {
	return service.getAccount();
    }

    @GetMapping("with-role-admin")
    @ResponseStatus(HttpStatus.OK)
    Object withRole() {
	return "with role admin";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    Account findById(@PathVariable Long id) {
	return service.findById(id);
    }
}
