package com.example.spsec.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.spsec.entities.Role;

@Mapper
public interface RoleDao {
	public List<String> getRoleNames(Long account_id);
	
	public int insert(Role role);
}
