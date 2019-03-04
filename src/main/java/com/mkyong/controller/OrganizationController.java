package com.mkyong.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Organization;
import com.mkyong.model.Personal;
import com.mkyong.service.OrganizationService;

@RestController
@RequestMapping(value = "/organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@RequestMapping(value = "/saveOrganization", method = RequestMethod.POST)
	public void saveOrganization(@RequestParam(value = "id") int id, @RequestParam(value = "cif") int cif,@RequestParam(value = "name_org") String name_org,
			@RequestParam(value = "name_trade") String name_trade, @RequestParam(value = "name_contact") String name_contact,
			@RequestParam(value = "role_contact") String role_contact, @RequestParam(value = "telephone_contact") String telephone_contact) throws ServletException, IOException, Exception {
		Organization organization = new Organization(id, cif,name_org, name_trade, name_contact, role_contact,telephone_contact);
		organizationService.addOrganization(organization);

	}
	
	@RequestMapping(value = "/getAllOrganization", method = RequestMethod.GET, produces = "application/json")
	public List<Organization> getAllOrganization() {
		List<Organization> list = new ArrayList<Organization>();
		list = organizationService.getAllOrganization();
		return list;

	}
	
	@RequestMapping(value = "/deleteOrganization", method = RequestMethod.POST)
	public void deleteOrganization(@RequestParam(value = "id") Integer id) 
			throws ServletException, IOException, Exception {
		organizationService.deleteOrganization(id);

	}
	
	@RequestMapping(value = "/getOrganization", method = RequestMethod.GET, produces = "application/json")
	public List<Organization> getOrganization(@RequestParam(value = "id") Integer id) {
		List<Organization> list = new ArrayList<Organization>();
		list = organizationService.getOrganization(id);
		return list;

	}
	
	@RequestMapping(value = "/updateOrganization", method = RequestMethod.POST)
	public void updateOrganization(@RequestParam(value = "id") int id, @RequestParam(value = "cif") int cif,@RequestParam(value = "name_org") String name_org,
			@RequestParam(value = "name_trade") String name_trade, @RequestParam(value = "name_contact") String name_contact,
			@RequestParam(value = "role_contact") String role_contact, @RequestParam(value = "telephone_contact") String telephone_contact) throws ServletException, IOException, Exception {
		Organization organization = new Organization(id, cif,name_org, name_trade, name_contact, role_contact,telephone_contact);
		organizationService.updateOrganization(organization);

	}

}
