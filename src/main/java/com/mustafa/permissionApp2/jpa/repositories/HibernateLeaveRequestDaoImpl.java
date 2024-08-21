package com.mustafa.permissionApp2.jpa.repositories;

import com.mustafa.permissionApp2.jpa.entities.LeaveRequest;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class HibernateLeaveRequestDaoImpl implements ILeaveRequestDao {

    public EntityManager entityManager;

    @Override
    @Transactional
    public void cancelRequest(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(LeaveRequest.class, id));
    }

    @Override
    @Transactional
    public void addRequest(LeaveRequest request) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(request);
    }

    @Override
    @Transactional
    public List<LeaveRequest> getAllRequests() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from LeaveRequest", LeaveRequest.class).getResultList();
    }

    @Override
    @Transactional
    public LeaveRequest getRequest(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(LeaveRequest.class, id);
    }
}
