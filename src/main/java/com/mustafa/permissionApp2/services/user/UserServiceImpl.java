package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.jpa.repositories.IUserDal;
import com.mustafa.permissionApp2.jpa.entities.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserServiceImpl implements IUserService {

    private IUserDal userDal;

    @Override
    @Transactional
    public void addUser(User user) {
        userDal.addUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDal.deleteUser(id);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDal.getAllUsers();
    }

    @Override
    @Transactional
    public User getUser(int id) {
        return userDal.getUser(id);
    }
}
