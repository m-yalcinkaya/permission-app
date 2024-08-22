package com.mustafa.permissionApp2.services.leaverequest;

import com.mustafa.permissionApp2.mapper.LeaveRequestMapper;
import com.mustafa.permissionApp2.jpa.repositories.ILeaveRequestDao;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import com.mustafa.permissionApp2.dto.LeaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestServiceImpl implements ILeaveRequestService{

    private ILeaveRequestDao leaveRequest;

    @Override
    public void cancelRequest(int id) {
        leaveRequest.deleteById(id);
    }

    @Override
    public void addRequest(LeaveRequestDto requestDto) {
        LeaveRequest request = LeaveRequestMapper.toLeaveRequest(requestDto);
        leaveRequest.save(request);
    }

    @Override
    public List<LeaveRequestDto> getAllRequests() {
        List<LeaveRequest> leaveRequests = leaveRequest.findAll();
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        for (LeaveRequest leaveRequest : leaveRequests) {
            leaveRequestDtos.add(LeaveRequestMapper.toLeaveRequestDto(leaveRequest));
        }
        return leaveRequestDtos;
    }

    @Override
    public LeaveRequestDto getRequest(int id) {
        LeaveRequest leaveRequest1 = leaveRequest.getReferenceById(id);
        return LeaveRequestMapper.toLeaveRequestDto(leaveRequest1);
    }
}
