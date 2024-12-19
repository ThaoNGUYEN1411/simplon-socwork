package co.simplon.socworkbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_roles")
public class Role extends AbstractEntity {

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "role_default")
    private Boolean roleDefault;

    public Role() {
	// ORM
    }

    public Role(String roleName, Boolean roleDefault) {
	this.roleName = roleName;
	this.roleDefault = roleDefault;
    }

    public String getRoleName() {
	return roleName;
    }

    public void setRoleName(String roleName) {
	this.roleName = roleName;
    }

    public Boolean getRoleDefault() {
	return roleDefault;
    }

    public void setIsDefault(Boolean roleDefault) {
	this.roleDefault = roleDefault;
    }

}
