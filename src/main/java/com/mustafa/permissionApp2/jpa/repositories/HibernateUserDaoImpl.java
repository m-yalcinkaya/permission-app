package com.mustafa.permissionApp2.jpa.repositories;

import com.mustafa.permissionApp2.jpa.entities.User;
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
public class HibernateUserDaoImpl implements IUserDal {

    private EntityManager entityManager;

    @Override
    @Transactional
    public void addUser(User user) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        User user = session.get(User.class, id);
        session.remove(user);
    }


    @Override
    @Transactional
    public List<User> getAllUsers() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from User", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(User.class, id);
    }
}
