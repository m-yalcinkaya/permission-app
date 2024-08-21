package com.mustafa.permissionApp2.jpa.repositories;


import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;

import java.util.List;

public interface ILeaveRequestDao {
    public void cancelRequest(int id);
    public void addRequest(LeaveRequest request);
    public List<LeaveRequest> getAllRequests();
    public LeaveRequest getRequest(int id);
}
