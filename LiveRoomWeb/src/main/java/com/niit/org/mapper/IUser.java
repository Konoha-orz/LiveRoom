package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.User;

/*
 *Edit by @Teemo
 *
 *2017-10-25
 *
 *User的Mapper
 * 
 */

public interface IUser {
   public List<User> getAll();
   public int getNumberOfUsers();
   public void registerUser(User user);
   public List<User> getUser(String username);
   public void updateUser(User user);
   public List<User> getUserById(int id);
}
