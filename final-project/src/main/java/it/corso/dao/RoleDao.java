package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.Role;

public interface RoleDao extends JpaRepository<Role, Integer>{

}
