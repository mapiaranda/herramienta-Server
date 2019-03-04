package com.mkyong.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Catalogue;
import com.mkyong.model.Organization;
import com.mkyong.model.RuleProjCatalogue;

@Repository
public class CatalogueDaoImpl implements CatalogueDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addCatalogue(Catalogue catalogue) {
		sessionFactory.getCurrentSession().saveOrUpdate(catalogue);

	}

	public List<Catalogue> getAllCatalogue() {
		List<Catalogue> listCatalogue = new ArrayList<Catalogue>();
		listCatalogue = sessionFactory.getCurrentSession().createQuery("from Catalogue").list();
		if (listCatalogue != null) {
			return listCatalogue;
		} else {
			return null;
		}

	}

	public void deleteCatalogue(Integer id_catalogue) {
		Catalogue catalogue = (Catalogue) sessionFactory.getCurrentSession().load(
				Catalogue.class, id_catalogue);
		if (null != catalogue) {
			this.sessionFactory.getCurrentSession().delete(catalogue);
		}
		
	}

	public List<Catalogue> getCatalogue(Integer id_catalogue) {
		List<Catalogue> list = new ArrayList<Catalogue>();
		list = sessionFactory.getCurrentSession().createQuery("from Catalogue where id_catalogue="+id_catalogue).list();
		return list;
	}

	public void updateCatalogue(Catalogue catalogue) {
		System.out.println("-------------"+catalogue.getId_catalogue());
		sessionFactory.getCurrentSession().update(catalogue);
		
	}
	
	public List<RuleProjCatalogue> getRuleProjCatalogue(Integer id_catalogue){
		List<RuleProjCatalogue> list = new ArrayList<RuleProjCatalogue>();
		list = sessionFactory.getCurrentSession().createQuery("from RuleProjCatalogue where id_catalogue="+id_catalogue).list();
		return list;
		
	}

	public List<RuleProjCatalogue> getListRuleProjCatalogue(Integer id_rule, Integer id_project) {
		List<RuleProjCatalogue> list = new ArrayList<RuleProjCatalogue>();
		list = sessionFactory.getCurrentSession().createQuery("from RuleProjCatalogue where id_rule='"+id_rule + "' and id_project='" + id_project + "'").list();
		return list;
	}

	public List<Catalogue> getCatalogues(Integer id_rule, Integer id_project) {
		List<Catalogue> listFinal = new ArrayList<Catalogue>();
		List<RuleProjCatalogue> list = new ArrayList<RuleProjCatalogue>();
		list = sessionFactory.getCurrentSession().createQuery("from RuleProjCatalogue where id_rule='"+id_rule + "' and id_project='" + id_project + "'").list();
		for (int i= 0; i<list.size(); i++) {
			Integer id_catalogue = list.get(i).getId_catalogue();
			List<Catalogue> aux = new ArrayList<Catalogue>();
			aux = sessionFactory.getCurrentSession().createQuery("from Catalogue where id_catalogue="+id_catalogue).list();
			Catalogue catalogue = aux.get(0);
			listFinal.add(catalogue);
			
		}
		return listFinal;
	}
}
