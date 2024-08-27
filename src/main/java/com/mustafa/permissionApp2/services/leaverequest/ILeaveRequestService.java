package com.mustafa.permissionApp2.services.leaverequest;

import com.mustafa.permissionApp2.dto.LeaveRequestDto;

import java.util.List;

public interface ILeaveRequestService {

    public void cancelRequest(int id);
    public void addRequest(LeaveRequestDto requestDto);
    public List<LeaveRequestDto> getAllRequests();
    public LeaveRequestDto getRequest(int id);
    public void updateLeaveStatus(int id, int status);
}
