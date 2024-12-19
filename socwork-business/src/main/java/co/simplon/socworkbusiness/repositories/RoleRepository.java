package co.simplon.socworkbusiness.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.socworkbusiness.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String role);

    Set<Role> findByRoleDefaultTrue();

}
