package com.mkyong.service;

import java.util.List;

import javax.mail.Session;

import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;

public interface PersonalService {

	public void addPersonal(Personal personal);

	public List<Personal> getAllPersonal();

	public void addUser(User user);

	public void addUserRole(UserRole userRole);

	public void deletePersonal(Integer id);

	public void deleteUser(String username);

	public List<Personal> getPersonal(Integer id);

	public void updatePersonal(Personal personal);

	public void sendEmail(Session session, String toEmail, String subject, String body);

	public void sesionEmail(String emailDestino, String contraseña);

	public List<Personal> getPersonalByUsername(String username);

}