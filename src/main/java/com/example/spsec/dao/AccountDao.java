package com.example.spsec.dao;

import org.apache.ibatis.annotations.Mapper;

import com.example.spsec.entities.Account;

@Mapper
public interface AccountDao {
	public Account findByUsername(String username);
	
	public int insert(Account account);
}
