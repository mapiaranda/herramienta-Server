package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Organization;

public interface OrganizationService {

	public void addOrganization(Organization organization);

	public List<Organization> getAllOrganization();

	public void deleteOrganization(Integer id);

	public List<Organization> getOrganization(Integer id);

	public void updateOrganization(Organization organization);

}
