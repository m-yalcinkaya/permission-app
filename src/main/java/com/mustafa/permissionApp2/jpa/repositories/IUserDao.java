package com.mustafa.permissionApp2.jpa.repositories;

import com.mustafa.permissionApp2.jpa.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserDao extends JpaRepository<User, Integer> {

}
