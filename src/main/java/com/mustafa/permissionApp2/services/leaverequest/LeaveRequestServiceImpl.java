package com.mustafa.permissionApp2.services.leaverequest;

import com.mustafa.permissionApp2.jpa.entities.User;
import com.mustafa.permissionApp2.jpa.repositories.LeaveRepository;
import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import com.mustafa.permissionApp2.services.user.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class LeaveRequestServiceImpl implements ILeaveRequestService{


    private IUserService userService;
    private LeaveRepository leaveRequestService;

    @Override
    public void cancelRequest(int id) {
        leaveRequestService.deleteById(id);
    }

    @Override
    public void addRequest(LeaveRequest leaveRequest) {
        leaveRequestService.save(leaveRequest);
    }

    public ModelAndView getModelData(){
        List<LeaveRequest> leaveRequestDtos =  getAllRequests();
        List<User> userDtos = userService.getAllUsers();
        Map<Integer, String> userNames = new HashMap<>();
        Map<Integer, String> userEmails = new HashMap<>();
        Map<Integer, String> userRoles = new HashMap<>();
        Map<Integer, String> statusValues = new HashMap<>();

        for(LeaveRequest leaveRequest : leaveRequestDtos){
            User user = userService.getUser(leaveRequest.getUserId());
            userNames.put(leaveRequest.getId(), user +" "+ user.getSurname());
            userEmails.put(leaveRequest.getId(), user.getUsername());
            String status = leaveRequest.getStatus() == 1 ? "Pending" : leaveRequest.getStatus() == 2 ? "Approved" : leaveRequest.getStatus() == 3 ? "Rejected" : "Canceled";
            statusValues.put(leaveRequest.getId(), status);
            if(user.getAuthorities().equals("ROLE_ADMIN"))
                userRoles.put(leaveRequest.getId(), "Admin");
            else
                userRoles.put(leaveRequest.getId(), "Staff");
        }
        ModelAndView modelAndView = new ModelAndView("request-leave");
        modelAndView.addObject("leaveRequestDtos", leaveRequestDtos);
        modelAndView.addObject("userNames", userNames);
        modelAndView.addObject("userEmails", userEmails);
        modelAndView.addObject("userRoles", userRoles);
        modelAndView.addObject("statusValues", statusValues);
        modelAndView.addObject("userDtos", userDtos);

        return modelAndView;
    }

    @Override
    public List<LeaveRequest> getAllRequests() {
        List<LeaveRequest> leaveRequests = leaveRequestService.findAll();
        List<LeaveRequest> requests = new ArrayList<>();
        requests.addAll(leaveRequests);
        return requests;
    }


    public void updateLeaveStatus(int leaveId, int status) {
        Optional<LeaveRequest> leaveRequestOptional = leaveRequestService.findById(leaveId);

        LeaveRequest leaveRequestImpl = leaveRequestOptional.orElseThrow(() ->
                new IllegalArgumentException("LeaveRequest not found for id: " + leaveId));

        leaveRequestImpl.setStatus(status);
        leaveRequestService.save(leaveRequestImpl);
    }

    @Override
    public LeaveRequest getRequest(int id) {
        return leaveRequestService.getReferenceById(id);
    }
}
