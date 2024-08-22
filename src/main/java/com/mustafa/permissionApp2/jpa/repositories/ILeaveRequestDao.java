package com.mustafa.permissionApp2.jpa.repositories;


import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ILeaveRequestDao extends JpaRepository<LeaveRequest, Integer> {

}
