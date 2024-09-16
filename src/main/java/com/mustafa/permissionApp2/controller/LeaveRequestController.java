package com.mustafa.permissionApp2.controller;


import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import com.mustafa.permissionApp2.services.leaverequest.ILeaveRequestService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping()
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestController {

    private ILeaveRequestService leaveRequestService;

    @PostMapping("requests/cancel")
    public ResponseEntity<Void> cancelRequest(int id){
        leaveRequestService.cancelRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PostMapping("/requests/add")
    public RedirectView addRequest(@ModelAttribute LeaveRequest leaveRequest) {
        leaveRequestService.addRequest(leaveRequest);
        return new RedirectView("/requestLeaves");
    }

    @GetMapping("requests")
    public ResponseEntity<Void> getAllRequests(){
        leaveRequestService.getAllRequests();
        return ResponseEntity.ok().build();
    }

    @GetMapping("requests/{id}")
    public LeaveRequest getRequest(@PathVariable int id){
        return leaveRequestService.getRequest(id);
    }

    @PostMapping("/updateLeaveStatus")
    public ModelAndView updateLeaveStatus(@RequestParam("leaveId") int leaveId,
                                    @RequestParam("status") int status) {
        leaveRequestService.updateLeaveStatus(leaveId, status);
        return viewRequestLeaves();
    }

    @GetMapping("requestLeaves")
    public ModelAndView viewRequestLeaves(){
        return leaveRequestService.getModelData();
    }


}
