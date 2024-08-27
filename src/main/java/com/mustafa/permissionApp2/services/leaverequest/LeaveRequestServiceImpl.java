package com.mustafa.permissionApp2.services.leaverequest;

import com.mustafa.permissionApp2.mapper.LeaveRequestMapper;
import com.mustafa.permissionApp2.jpa.repositories.ILeaveRequestDao;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import com.mustafa.permissionApp2.dto.LeaveRequestDto;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestServiceImpl implements ILeaveRequestService{

    private ILeaveRequestDao leaveRequestService;

    @Override
    public void cancelRequest(int id) {
        leaveRequestService.deleteById(id);
    }

    @Override
    public void addRequest(LeaveRequestDto requestDto) {

        LeaveRequest request = LeaveRequestMapper.toLeaveRequest(requestDto);
        leaveRequestService.save(request);
    }

    @Override
    public List<LeaveRequestDto> getAllRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.findAll();
        List<LeaveRequestDto> leaveRequestDtos = new ArrayList<>();
        for (LeaveRequest leaveRequest : leaveRequests) {
            leaveRequestDtos.add(LeaveRequestMapper.toLeaveRequestDto(leaveRequest));
        }
        return leaveRequestDtos;
    }


    public void updateLeaveStatus(@NonNull int leaveId, @NonNull int status) {
        Optional<LeaveRequest> leaveRequestOptional = leaveRequestService.findById(leaveId);

        LeaveRequest leaveRequestImpl = leaveRequestOptional.orElseThrow(() ->
                new IllegalArgumentException("LeaveRequest not found for id: " + leaveId));

        leaveRequestImpl.setStatus(status);
        leaveRequestService.save(leaveRequestImpl);
    }

    @Override
    public LeaveRequestDto getRequest(int id) {
        LeaveRequest leaveRequest1 = leaveRequestService.getReferenceById(id);
        return LeaveRequestMapper.toLeaveRequestDto(leaveRequest1);
    }
}
