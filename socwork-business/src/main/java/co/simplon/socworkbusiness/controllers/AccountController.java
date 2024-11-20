package co.simplon.socworkbusiness.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.socworkbusiness.dtos.AccountAuthentificate;
import co.simplon.socworkbusiness.dtos.AccountCreate;
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

    @PostMapping("/authentificate")
    @ResponseStatus(HttpStatus.CREATED)
    Object login(@RequestBody AccountAuthentificate inputs) {
	return service.authentificate(inputs);
    }
}
