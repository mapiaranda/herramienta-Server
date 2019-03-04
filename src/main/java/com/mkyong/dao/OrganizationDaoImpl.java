package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Organization;
import com.mkyong.model.Personal;
@Repository
public class OrganizationDaoImpl implements OrganizationDao{
	
	@Autowired
	private SessionFactory sessionFactory;

	public void addOrganization(Organization organization) {
		sessionFactory.getCurrentSession().saveOrUpdate(organization);
		
	}

	public List<Organization> getAllOrganization() {
		List<Organization> listOrganization = new ArrayList<Organization>();
		listOrganization = sessionFactory.getCurrentSession().createQuery("from Organization").list();
		if (listOrganization != null) {
			return listOrganization;
		} else {
			return null;
		}
	}

	public void deleteOrganization(Integer id) {
		Organization organization = (Organization) sessionFactory.getCurrentSession().load(
				Organization.class, id);
		if (null != organization) {
			this.sessionFactory.getCurrentSession().delete(organization);
		}
		
	}

	public List<Organization> getOrganization(Integer id) {
		List<Organization> list = new ArrayList<Organization>();
		list = sessionFactory.getCurrentSession().createQuery("from Organization where id="+id).list();
		return list;
	}

	public void updateOrganization(Organization organization) {
		sessionFactory.getCurrentSession().update(organization);
		
	}

}
