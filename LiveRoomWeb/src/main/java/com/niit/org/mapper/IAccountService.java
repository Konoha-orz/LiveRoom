package com.niit.org.mapper;

import java.util.List;

import com.niit.org.bean.Account;

public interface IAccountService {
	public List<Account> getAll();
	public Account getUser(Account account);
}
