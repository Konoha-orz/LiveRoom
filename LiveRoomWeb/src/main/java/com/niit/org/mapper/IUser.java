package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.User;

/*
 *Edit by Teemo
 *
 *2017-10-24
 *
 *User的Mapper
 * 
 */

public interface IUser {
   public List<User> getAll();
   public void registerUser(User user);
   public List<User> getUser(String username);
}
