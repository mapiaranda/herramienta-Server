package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;
import com.mkyong.model.RuleProjCatalogue;

public interface CatalogueService {
	
	public void addCatalogue(Catalogue catalogue);
	
	public List<Catalogue> getAllCatalogue();
	
	public void deleteCatalogue(Integer id_catalogue);

	public List<Catalogue> getCatalogue(Integer id_catalogue);
	
	public void updateCatalogue(Catalogue catalogue);

	public List<RuleProjCatalogue> getRuleProjCatalogue(Integer id_catalogue);

	public List<RuleProjCatalogue> getListRuleProjCatalogue(Integer id_rule, Integer id_project);

	public List<Catalogue> getCatalogues(Integer id_rule, Integer id_project);
}
