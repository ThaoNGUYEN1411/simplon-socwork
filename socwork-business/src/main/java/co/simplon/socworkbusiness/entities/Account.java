package co.simplon.socworkbusiness.entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_accounts")
public class Account extends AbstractEntity {

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @ManyToMany
    @JoinTable(name = "t_account_roles", joinColumns = @JoinColumn(name = "account_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public Account() {
	// ORM
    }

//    public Account(String username, String password) {
//	this(username, password, new HashSet<Role>());
//    }

    public Account(String username, String password, Set<Role> roles) {
	this.username = username;
	this.password = password;
	this.roles = new HashSet<Role>(roles);
    }

    public String getUsername() {
	return username;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }

    public Set<Role> getRoles() {
	return Collections.unmodifiableSet(roles);
    }

    @Override
    public String toString() {
	return "{username=" + username + ", password=[PROTECTED]" + ", roles=" + roles + "}";
    }
}
