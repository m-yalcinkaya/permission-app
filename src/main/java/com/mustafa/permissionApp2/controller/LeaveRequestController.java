package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.services.leaverequest.ILeaveRequestService;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
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
    public void addRequest(LeaveRequest leaveRequest){
        leaveRequestService.addRequest(leaveRequest);
    }

    @GetMapping()
    public void getAllRequests(){
        leaveRequestService.getAllRequests();
    }

    @GetMapping("/{id}")
    public LeaveRequest getRequest(@PathVariable int id){
        return leaveRequestService.getRequest(id);
    }


}
