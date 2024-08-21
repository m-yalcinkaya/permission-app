package com.mustafa.permissionApp2.services.leaverequest;

import com.mustafa.permissionApp2.jpa.repositories.ILeaveRequestDao;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestServiceImpl implements ILeaveRequestService{

    private ILeaveRequestDao leaveRequest;

    @Override
    @Transactional
    public void cancelRequest(int id) {
        leaveRequest.cancelRequest(id);
    }

    @Override
    @Transactional
    public void addRequest(LeaveRequest request) {
        leaveRequest.addRequest(request);
    }

    @Override
    @Transactional
    public List<LeaveRequest> getAllRequests() {
        return leaveRequest.getAllRequests();
    }

    @Override
    @Transactional
    public LeaveRequest getRequest(int id) {
        return leaveRequest.getRequest(id);
    }
}
