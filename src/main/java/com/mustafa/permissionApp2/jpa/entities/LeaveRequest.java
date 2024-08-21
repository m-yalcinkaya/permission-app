package com.mustafa.permissionApp2.jpa.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table(name = "leave_request")
@AllArgsConstructor
@NoArgsConstructor
public class LeaveRequest {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "user_id")
    @Getter private int userId;

    @Column(name = "start_date")
    @Getter @Setter private Date startDate;

    @Column(name = "end_date")
    @Getter @Setter private Date endDate;

    @Column(name = "status")
    @Getter @Setter private String status;

    @Column(name = "description")
    @Getter @Setter private String description;

}
