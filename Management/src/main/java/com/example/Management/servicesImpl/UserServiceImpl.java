package com.example.Management.servicesImpl;

import com.example.Management.entities.User;
import com.example.Management.repositories.UserRepo;
import com.example.Management.services.MailSender;
import com.example.Management.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private MailSender mailSender;
    @Override
    public User findByUsername(String username) {
        return userRepo.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public Boolean isLogged(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        try {
            if (userFromDB.getUsername().equals(user.getUsername())
                    && userFromDB.getPassword().equals(user.getPassword())) {
                return true;
            }
            return false;
        } catch (NullPointerException e) {
            return false;
        }
    }

    @Override
    public Boolean usernameIsUsed(User user) {
        User userFromDB = userRepo.findByUsername(user.getUsername());
        if (userFromDB != null && (userFromDB.getUsername().equals(user.getUsername()))){
            return true;
        }
        return false;
    }

    @Override
    public Boolean emailIsUsed(User user) {
        User userFromDB = userRepo.findByEmail(user.getEmail());
        if (userFromDB != null && (userFromDB.getEmail().equals(user.getEmail()))){
            return true;
        }
        return false;
    }

    @Override
    public Boolean isNull(User user) {
        if (user.getUsername().contains(" ")
                || user.getEmail().contains(" ")) {
            return true;
        }
        return false;
    }

    @Override
    public void sendMassage(User user) {
        mailSender.sendEmailMessage(user.getEmail(), "Account activation",
                "visit link: http://localhost:8080/activate/" + user.getActivationCode());
    }

    @Override
    public Boolean findByActivationCode(String code) {
        if ( userRepo.findByActivationCode(code) != null){
            return  true;
        }
        return false;
    }


    @Override
    public void activateUser(String code) {
       User user = userRepo.findByActivationCode(code);
       user.setActivated(true);
       user.setActivationCode(null);
       save(user);

    }

}
