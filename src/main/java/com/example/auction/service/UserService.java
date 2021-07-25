package com.example.auction.service;

import com.example.auction.domain.User;

import java.util.List;

public interface UserService {


    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(long id);
    /*Page<User> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);*/
}
