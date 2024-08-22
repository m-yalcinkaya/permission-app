package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.dto.LeaveRequestDto;
import com.mustafa.permissionApp2.services.leaverequest.ILeaveRequestService;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requests")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestController {

    private ILeaveRequestService leaveRequestService;

    @PostMapping("/cancel")
    public ResponseEntity<Void> cancelRequest(int id){
        leaveRequestService.cancelRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/add")
    public ResponseEntity<Void> addRequest(LeaveRequestDto leaveRequestDto){
        leaveRequestService.addRequest(leaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<Void> getAllRequests(){
        leaveRequestService.getAllRequests();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public LeaveRequestDto getRequest(@PathVariable int id){
        return leaveRequestService.getRequest(id);
    }


}
