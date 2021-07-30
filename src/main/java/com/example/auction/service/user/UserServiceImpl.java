package com.example.auction.service.user;

import com.example.auction.domain.User;
import com.example.auction.repository.UserRepository;
import com.example.auction.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);

    }

    @Override
    public User getUserById(String id) {
        return null;
    }
}
