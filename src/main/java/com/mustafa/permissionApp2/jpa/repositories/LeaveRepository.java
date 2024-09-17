package com.mustafa.permissionApp2.jpa.repositories;


import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeaveRepository extends JpaRepository<LeaveRequest, Integer> {

}
