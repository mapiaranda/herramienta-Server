package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.CatalogueDao;
import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;
import com.mkyong.model.RuleProjCatalogue;

@Service
@Transactional
public class CatalogueServiceImpl implements CatalogueService{
	
	@Autowired
	private CatalogueDao catalogueDao;
	
	@Transactional
	public void addCatalogue(Catalogue catalogue) {
		System.out.println(catalogue);
		catalogueDao.addCatalogue(catalogue);
		
	}
	@Transactional
	public List<Catalogue> getAllCatalogue() {
		List<Catalogue> list= new ArrayList<Catalogue>();
		list=catalogueDao.getAllCatalogue();
		return list;
	}
	@Transactional
	public void deleteCatalogue(Integer id_catalogue) {
		catalogueDao.deleteCatalogue(id_catalogue);
		
	}
	@Transactional
	public List<Catalogue> getCatalogue(Integer id_catalogue) {
		List<Catalogue> list= new ArrayList<Catalogue>();
		list=catalogueDao.getCatalogue(id_catalogue);
		return list;
	}
	
	public void updateCatalogue(Catalogue catalogue) {
		catalogueDao.updateCatalogue(catalogue);
		
	}
	
	public List<RuleProjCatalogue> getRuleProjCatalogue(Integer id_catalogue){
		List<RuleProjCatalogue> list= new ArrayList<RuleProjCatalogue>();
		list = catalogueDao.getRuleProjCatalogue(id_catalogue);
		return list;
	}
	public List<RuleProjCatalogue> getListRuleProjCatalogue(Integer id_rule, Integer id_project) {
		List<RuleProjCatalogue> list= new ArrayList<RuleProjCatalogue>();
		list = catalogueDao.getListRuleProjCatalogue(id_rule,id_project);
		return list;
	}
	public List<Catalogue> getCatalogues(Integer id_rule, Integer id_project) {
		List<Catalogue> list= new ArrayList<Catalogue>();
		list=catalogueDao.getCatalogues(id_rule, id_project);
		return list;
	}

}
