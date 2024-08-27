package com.mustafa.permissionApp2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequestDto {

    private int id;
    private int userId;
    private Date startDate;
    private Date endDate;
    private int status = 1;
    private String description;


}
