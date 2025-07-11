package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.dto.CreateUserRequest;
import com.mustafa.permissionApp2.jpa.entities.User;
import com.mustafa.permissionApp2.jpa.repositories.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mustafa.permissionApp2.utils.PasswordGenerator.generatePassword;

@Service
@Transactional
public class UserServiceImpl implements IUserService, UserDetailsService {

    private UserRepository userRepository;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Kullanıcıyı veritabanında bulmaya çalış
        UserDetails user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + username));

        // Kullanıcıyı UserDetails olarak döndür
        return user;
    }

    @Override
    public User createUser(CreateUserRequest request) {

        if (request.password() == null || request.password().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }


        User user = User.builder()
                .name(request.name())
                .surname(request.surname())
                .username(request.username())
                .password(bCryptPasswordEncoder.encode(request.password()))
                .authorities(request.authorities())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .isEnabled(true)
                .build();

        return userRepository.save(user);
    }

    // UserServiceImpl sınıfına eklenmesi gereken metot
    public boolean authenticateUser(String email, String password) {
        // Kullanıcıyı email'e göre bul
        Optional<User> userOptional = userRepository.findByUsername(email);

        // Eğer kullanıcı bulunursa
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // Şifreyi doğrulamak için BCryptPasswordEncoder'ın matches yöntemini kullan
            return bCryptPasswordEncoder.matches(password, user.getPassword());
        }

        // Kullanıcı bulunamadıysa false döndür
        return false;
    }


    @Override
    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users;
    }

   /* @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }*/

    @Override
    public User getUser(int id) {
        User user = userRepository.getReferenceById(id);
        return user;
    }
}

