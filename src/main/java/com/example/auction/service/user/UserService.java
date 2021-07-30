package com.example.auction.service.user;

import com.example.auction.domain.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(String id);
    /*Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);*/
}
