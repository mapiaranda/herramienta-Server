package com.mkyong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mkyong.model.Personal;
import com.mkyong.model.User;
import com.mkyong.model.UserRole;
import com.mkyong.service.PersonalService;

@RestController
@RequestMapping(value = "/personal")
public class PersonalController {

	public PersonalController() {
		System.out.println("PersonalController()");
	}

	@Autowired
	private PersonalService personalService;

	@RequestMapping(value = "/")
	public String helloWorld() {
		return "Hello World!";

	}

	@RequestMapping(value = "/savePersonal", method = RequestMethod.POST)
	public void savePersonal(@RequestParam(value = "id") int id, @RequestParam(value = "username") String username,
			@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address, @RequestParam(value = "telephone") String telephone,
			@RequestParam(value = "passNoEncryp") String passNoEncryp) throws ServletException, IOException, Exception {
		Personal personal = new Personal(id, username, name, email, address, telephone);
		personalService.addPersonal(personal);
		personalService.sesionEmail(email, passNoEncryp);

	}

	@RequestMapping(value = "/updatePersonal", method = RequestMethod.POST)
	public void updatePersonal(@RequestParam(value = "id") int id, @RequestParam(value = "username") String username,
			@RequestParam(value = "name") String name, @RequestParam(value = "email") String email,
			@RequestParam(value = "address") String address, @RequestParam(value = "telephone") String telephone)
			throws ServletException, IOException, Exception {
		Personal personal = new Personal(id, username, name, email, address, telephone);
		personalService.updatePersonal(personal);

	}

	@RequestMapping(value = "/getAllPersonal", method = RequestMethod.GET, produces = "application/json")
	public List<Personal> getAllPersonal() {
		List<Personal> list = new ArrayList<Personal>();
		list = personalService.getAllPersonal();
		return list;

	}

	@RequestMapping(value = "/getPersonal", method = RequestMethod.GET, produces = "application/json")
	public List<Personal> getPersonal(@RequestParam(value = "id") Integer id) {
		List<Personal> list = new ArrayList<Personal>();
		list = personalService.getPersonal(id);
		return list;

	}
	
	@RequestMapping(value = "/getPersonalByUsername", method = RequestMethod.GET, produces = "application/json")
	public List<Personal> getPersonalByUsername(@RequestParam(value = "username") String username) {
		List<Personal> list = new ArrayList<Personal>();
		list = personalService.getPersonalByUsername(username);
		return list;

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public void saveUser(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "enabled") Boolean enabled)
			throws ServletException, IOException, Exception {
		User user = new User(username, password, enabled);
		personalService.addUser(user);

	}

	@RequestMapping(value = "/saveUserRole", method = RequestMethod.POST)
	public void saveUserRole(@RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password, @RequestParam(value = "enabled") Boolean enabled,
			@RequestParam(value = "role") String role) throws ServletException, IOException, Exception {
		Set<UserRole> userRole = null;
		UserRole ur = null;
		User user = new User();

		user.setUsername(username);
		user.setPassword(password);
		user.setEnabled(enabled);

		ur = new UserRole(user, role);
		userRole = new HashSet<UserRole>(0);
		userRole.add(ur);
		user.setUserRole(userRole);
		personalService.addUser(user);
		personalService.addUserRole(ur);
		// personalService.enviarEmail(user);

	}

	@RequestMapping(value = "/deletePersonal", method = RequestMethod.POST)
	public void deletePersonal(@RequestParam(value = "id") Integer id) throws ServletException, IOException, Exception {
		personalService.deletePersonal(id);

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public void deleteUser(@RequestParam(value = "username") String username)
			throws ServletException, IOException, Exception {
		personalService.deleteUser(username);

	}

}
