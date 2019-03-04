package com.mkyong.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mkyong.model.Attribute;
import com.mkyong.model.Organization;
import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;

@Repository
public class RuleDaoImpl implements RuleDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRule(Rule rule) {
		sessionFactory.getCurrentSession().saveOrUpdate(rule);

	}

	public List<Rule> getLastRule() {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = sessionFactory.getCurrentSession().createQuery("from Rule order by id_rule DESC").list();
		if (listRule != null) {
			return listRule;
		} else {
			return null;
		}
	}

	public List<Rule> getAllRule() {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = sessionFactory.getCurrentSession().createQuery("from Rule").list();
		if (listRule != null) {
			return listRule;
		} else {
			return null;
		}
	}

	public void addRuleProj(RuleProj ruleProj) {
		sessionFactory.getCurrentSession().saveOrUpdate(ruleProj);

	}

	public void addAttribute(Attribute attribute) {
		sessionFactory.getCurrentSession().saveOrUpdate(attribute);

	}

	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		sessionFactory.getCurrentSession().saveOrUpdate(ruleProjCatalogue);

	}

	public List<Attribute> getAttributesByRule(int id_rule) {
		List<Attribute> list = new ArrayList<Attribute>();
		list = sessionFactory.getCurrentSession().createQuery("from Attribute where id_rule=" + id_rule).list();
		return list;
	}

	public void deleteRule(int id_rule) {
		Rule rule = (Rule) sessionFactory.getCurrentSession().load(Rule.class, id_rule);
		if (null != rule) {
			this.sessionFactory.getCurrentSession().delete(rule);
		}

	}

	public void updateRule(Rule rule) {
		sessionFactory.getCurrentSession().update(rule);

	}

	public void updateRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		sessionFactory.getCurrentSession().saveOrUpdate(ruleProjCatalogue);

	}

	public List<RuleProjCatalogue> getRuleProjCatalogue(int id_rule) {
		List<RuleProjCatalogue> list = new ArrayList<RuleProjCatalogue>();
		list = sessionFactory.getCurrentSession().createQuery("from RuleProjCatalogue where id_rule=" + id_rule).list();
		return list;
	}

	public List<RuleProj> getRulesByProject(int id_project) {
		List<RuleProj> listRuleProj = new ArrayList<RuleProj>();
		listRuleProj = sessionFactory.getCurrentSession().createQuery("from RuleProj where id_project=" + id_project)
				.list();

		return listRuleProj;

	}

	public List<Rule> getRule(int id_rule) {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = sessionFactory.getCurrentSession().createQuery("from Rule where id_rule="+id_rule).list();
		if (listRule != null) {
			return listRule;
		} else {
			return null;
		}
	}

}
