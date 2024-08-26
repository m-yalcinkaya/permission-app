package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.dto.LeaveRequestDto;
import com.mustafa.permissionApp2.dto.UserDto;
import com.mustafa.permissionApp2.services.leaverequest.ILeaveRequestService;

import com.mustafa.permissionApp2.services.user.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping()
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestController {

    private ILeaveRequestService leaveRequestService;
    private IUserService userService;

    @PostMapping("requests/cancel")
    public ResponseEntity<Void> cancelRequest(int id){
        leaveRequestService.cancelRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("requests/add")
    public ResponseEntity<Void> addRequest(LeaveRequestDto leaveRequestDto){
        leaveRequestService.addRequest(leaveRequestDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("requests")
    public ResponseEntity<Void> getAllRequests(){
        leaveRequestService.getAllRequests();
        return ResponseEntity.ok().build();
    }

    @GetMapping("requests/{id}")
    public LeaveRequestDto getRequest(@PathVariable int id){
        return leaveRequestService.getRequest(id);
    }

    @GetMapping("requestLeaves")
    public ModelAndView viewRequestLeaves(){
        List<LeaveRequestDto> leaveRequestDtos =  leaveRequestService.getAllRequests();
        Map<Integer, String> userNames = new HashMap<>();
        Map<Integer, String> userEmails = new HashMap<>();
        Map<Integer, String> userRoles = new HashMap<>();
        Map<Integer, String> statusValues = new HashMap<>();

        for(LeaveRequestDto leaveRequestDto : leaveRequestDtos){
            UserDto user = userService.getUser(leaveRequestDto.getUserId());
            userNames.put(leaveRequestDto.getId(), user.getName() +" "+ user.getSurname());
            userEmails.put(leaveRequestDto.getId(), user.getEmail());
            String status = leaveRequestDto.getStatus() == 1 ? "Pending" : leaveRequestDto.getStatus() == 2 ? "Approved" : "rejected";
            statusValues.put(leaveRequestDto.getId(), status);
            if(user.getRole() == 1)
                userRoles.put(leaveRequestDto.getId(), "Admin");
            else
                userRoles.put(leaveRequestDto.getId(), "User");
        }
       ModelAndView modelAndView = new ModelAndView("request-leave");
        modelAndView.addObject("leaveRequestDtos", leaveRequestDtos);
        modelAndView.addObject("userNames", userNames);
        modelAndView.addObject("userEmails", userEmails);
        modelAndView.addObject("userRoles", userRoles);
        modelAndView.addObject("statusValues", statusValues);

        return modelAndView;
    }


}
