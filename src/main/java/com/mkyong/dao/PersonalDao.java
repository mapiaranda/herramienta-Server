package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;

public interface PersonalDao {
	
	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();

	public void addUser(User user);

	public void addUserRole(UserRole userRole);

	public void deletePersonal(Integer id);

	public void deleteUser(String username);

	public List<Personal> getPersonal(Integer id);

	public void updatePersonal(Personal personal);

	public List<Personal> getPersonalByUsername(String username);

}