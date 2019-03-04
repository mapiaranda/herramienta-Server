package com.mkyong.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.RuleDao;
import com.mkyong.model.Attribute;
import com.mkyong.model.Organization;
import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;

@Service
@Transactional
public class RuleServiceImpl implements RuleService{
	
	@Autowired
	private RuleDao ruleDao;
	
	@Transactional
	public void addRule(Rule rule) {
		ruleDao.addRule(rule);
		
	}
	@Transactional
	public List<Rule> getLastRule() {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = ruleDao.getLastRule();
		return listRule;
	}
	@Transactional
	public void addRuleProj(RuleProj ruleProj) {
		ruleDao.addRuleProj(ruleProj);
	}
	@Transactional
	public void addAttribute(Attribute attribute) {
		ruleDao.addAttribute(attribute);
		
	}
	@Transactional
	public void addRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		ruleDao.addRuleProjCatalogue(ruleProjCatalogue);
	}
	@Transactional
	public List<Rule> getAllRule() {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = ruleDao.getAllRule();
		return listRule;
	}
	@Transactional
	public List<Attribute> getAttributesByRule(int id_rule) {
		List<Attribute> listAttribute = new ArrayList<Attribute>();
		listAttribute = ruleDao.getAttributesByRule(id_rule);
		return listAttribute;
	}
	
	@Transactional
	public void deleteRule(int id_rule) {
		ruleDao.deleteRule(id_rule);
	}
	
	@Transactional
	public void updateRule(Rule rule) {
		ruleDao.updateRule(rule);
	}
	
	@Transactional
	public RuleProjCatalogue getRuleProjCatalogue(int id_rule) {
		List<RuleProjCatalogue> list= new ArrayList<RuleProjCatalogue>();
		list=ruleDao.getRuleProjCatalogue(id_rule);
		return list.get(0);
	}
	
	@Transactional
	public void updateRuleProjCatalogue(RuleProjCatalogue ruleProjCatalogue) {
		ruleDao.updateRuleProjCatalogue(ruleProjCatalogue);
		
	}
	
	@Transactional
	public List<RuleProj> getRulesByProject(int id_project) {
		List<RuleProj> listRule = new ArrayList<RuleProj>();
		listRule = ruleDao.getRulesByProject(id_project);
		return listRule;
	}
	public List<Rule> getRule(int id_rule) {
		List<Rule> listRule = new ArrayList<Rule>();
		listRule = ruleDao.getRule(id_rule);
		return listRule;
	}

}
