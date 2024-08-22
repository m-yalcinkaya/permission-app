package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.dto.LeaveRequestDto;
import com.mustafa.permissionApp2.services.leaverequest.ILeaveRequestService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestController {

    private ILeaveRequestService leaveRequestService;

    @PostMapping("/cancel")
    public void cancelRequest(int id){
        leaveRequestService.cancelRequest(id);
    }

    @PostMapping("/add")
    public void addRequest(LeaveRequestDto leaveRequestDto){
        leaveRequestService.addRequest(leaveRequestDto);
    }

    @GetMapping()
    public void getAllRequests(){
        leaveRequestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequestDto getRequest(@PathVariable int id){
        return leaveRequestService.getRequest(id);
    }


}
