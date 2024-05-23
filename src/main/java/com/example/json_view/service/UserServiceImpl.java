package com.example.json_view.service;

import com.example.json_view.model.User;
import com.example.json_view.model.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        if (getUser(id)!= null){
            User oldUser = getUser(id);
            oldUser.setName(user.getName());
            oldUser.setEmail(user.getEmail());
            return userRepository.save(oldUser);
        }
        else {
            return null;
        }
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
