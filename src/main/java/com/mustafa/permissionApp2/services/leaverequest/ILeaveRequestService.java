package com.mustafa.permissionApp2.services.leaverequest;

import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface ILeaveRequestService {

    public void cancelRequest(int id);
    public void addRequest(LeaveRequest request);
    public List<LeaveRequest> getAllRequests();
    public LeaveRequest getRequest(int id);
    public void updateLeaveStatus(int id, int status);
    public ModelAndView getModelData();
}
