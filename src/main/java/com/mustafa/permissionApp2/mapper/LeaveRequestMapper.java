package com.mustafa.permissionApp2.mapper;

import com.mustafa.permissionApp2.dto.LeaveRequestDto;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;

import java.sql.Date;


public class LeaveRequestMapper {


    public static LeaveRequestDto toLeaveRequestDto(LeaveRequest leaveRequest) {
        return new LeaveRequestDto(
                leaveRequest.getId(),
                leaveRequest.getUserId(),
                leaveRequest.getStartDate(),
                leaveRequest.getEndDate(),
                leaveRequest.getStatus(),
                leaveRequest.getDescription()
        );
    }

    public static LeaveRequest toLeaveRequest(LeaveRequestDto leaveRequestDto) {
        return new LeaveRequest(
                leaveRequestDto.getId(),
                leaveRequestDto.getUserId(),
                (Date) leaveRequestDto.getStartDate(),
                (Date) leaveRequestDto.getEndDate(),
                leaveRequestDto.getStatus(),
                leaveRequestDto.getDescription()
        );
    }

}
