package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.jpa.entities.User;
import com.mustafa.permissionApp2.jpa.repositories.IUserDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.mustafa.permissionApp2.utils.PasswordGenerator.generatePassword;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    @Override
    public void addUser(User user) {
        user.setPassword(generatePassword(8));
        userDao.save(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userDao.findAll();
        return users;
    }

    @Override
    public User getUser(int id) {
        User user = userDao.getReferenceById(id);
        return user;
    }
}

