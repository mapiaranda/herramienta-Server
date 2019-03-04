package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.OrganizationDao;
import com.mkyong.dao.PersonalDao;
import com.mkyong.model.Organization;
import com.mkyong.model.Personal;

@Service
@Transactional
public class OrganizationServiceImpl implements OrganizationService{

	@Autowired
	private OrganizationDao organizationDao;
	
	@Transactional
	public void addOrganization(Organization organization) {
		organizationDao.addOrganization(organization);
		
	}

	public List<Organization> getAllOrganization() {
		List<Organization> list= new ArrayList<Organization>();
		list=organizationDao.getAllOrganization();
		return list;
	}

	public void deleteOrganization(Integer id) {
		organizationDao.deleteOrganization(id);
		
	}

	public List<Organization> getOrganization(Integer id) {
		List<Organization> list= new ArrayList<Organization>();
		list=organizationDao.getOrganization(id);
		return list;
	}

	public void updateOrganization(Organization organization) {
		organizationDao.updateOrganization(organization);
		
	}

}
