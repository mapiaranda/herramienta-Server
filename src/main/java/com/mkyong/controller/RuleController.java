package com.mkyong.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mkyong.model.Rule;
import com.mkyong.model.RuleProj;
import com.mkyong.model.RuleProjCatalogue;
import com.mkyong.service.RuleService;
import com.mkyong.model.Attribute;
import com.mkyong.model.Organization;

@RestController
@RequestMapping(value = "/rule")
public class RuleController {

	@Autowired
	private RuleService ruleService;

	@RequestMapping(value = "/addRule", method = RequestMethod.POST)
	public void addRule(@RequestParam(value = "id_rule") int id_rule, @RequestParam(value = "operator") String operator,
			@RequestParam(value = "property") String property, @RequestParam(value = "state") String state,
			@RequestParam(value = "criticity") String criticity, @RequestParam(value = "priority") String priority,
			@RequestParam(value = "version") String version) throws ServletException, IOException, Exception {

		String operator1 = URLDecoder.decode(operator);
		String property1 = URLDecoder.decode(property);
		String state1 = URLDecoder.decode(state);
		String criticity1 = URLDecoder.decode(criticity);
		String priority1 = URLDecoder.decode(priority);
		String version1 = URLDecoder.decode(version);
		
		
		Rule rule = new Rule(id_rule, operator1, property1, state1, criticity1,
		priority1, version1); 
		ruleService.addRule(rule);
		
	}

	@RequestMapping(value = "/addRuleProj", method = RequestMethod.POST)
	public void addRuleProj(@RequestParam(value = "id_rule") int id_rule,
			@RequestParam(value = "id_project") int id_project) throws ServletException, IOException, Exception {
		RuleProj ruleProj = new RuleProj(id_rule, id_project);
		ruleService.addRuleProj(ruleProj);
	}

	@RequestMapping(value = "/addAttribute", method = RequestMethod.POST)
	public void addAttribute(@RequestParam(value = "id_attribute") int id_attribute,
			@RequestParam(value = "id_rule") int id_rule, @RequestParam(value = "modal_operator") String modal_operator,
			@RequestParam(value = "term") String term, @RequestParam(value = "verb") String verb,
			@RequestParam(value = "logical_operator") String logical_operator,
			@RequestParam(value = "term_value") String term_value) throws ServletException, IOException, Exception {

		String modal_operator1 = URLDecoder.decode(modal_operator);
		String term1 = URLDecoder.decode(term);
		String verb1 = URLDecoder.decode(verb);
		String logical_operator1 = URLDecoder.decode(logical_operator);
		String term_value1 = URLDecoder.decode(term_value);

		Attribute attribute = new Attribute(id_attribute, id_rule, modal_operator1, term1, verb1, logical_operator1,
				term_value1);
		ruleService.addAttribute(attribute);
	}

	@RequestMapping(value = "/addRuleProjCatalogue", method = RequestMethod.POST)
	public void addRuleProjCatalogue(@RequestParam(value = "id_rule") int id_rule,
			@RequestParam(value = "id_project") int id_project, @RequestParam(value = "id_catalogue") int id_catalogue)
			throws ServletException, IOException, Exception {
		RuleProjCatalogue ruleProjectCatalogue = new RuleProjCatalogue(id_rule, id_project, id_catalogue);
		ruleService.addRuleProjCatalogue(ruleProjectCatalogue);
	}

	@RequestMapping(value = "/getLastRule", method = RequestMethod.GET, produces = "application/json")
	public List<Rule> getLastRule() {
		List<Rule> list = new ArrayList<Rule>();
		list = ruleService.getLastRule();
		return list;

	}



	@RequestMapping(value = "/getAttributesByRule", method = RequestMethod.GET, produces = "application/json")
	public List<Attribute> getAttributesByRule(int id_rule) {
		List<Attribute> list = new ArrayList<Attribute>();
		list = ruleService.getAttributesByRule(id_rule);
		return list;

	}

	@RequestMapping(value = "/deleteRule", method = RequestMethod.POST)
	public void deleteRule(@RequestParam(value = "id_rule") int id_rule)
			throws ServletException, IOException, Exception {
		ruleService.deleteRule(id_rule);

	}

	@RequestMapping(value = "/updateRule", method = RequestMethod.POST)
	public void updateRule(@RequestParam(value = "id_rule") int id_rule,
			@RequestParam(value = "id_project") int id_project,
			@RequestParam(value = "operator") String operator, @RequestParam(value = "property") String property,
			@RequestParam(value = "state") String state, @RequestParam(value = "criticity") String criticity,
			@RequestParam(value = "priority") String priority, @RequestParam(value = "version") String version,
			@RequestParam(value = "id_catalogue") int id_catalogue) throws ServletException, IOException, Exception {
		
		String operator1 = URLDecoder.decode(operator);
		String property1 = URLDecoder.decode(property);
		String state1 = URLDecoder.decode(state);
		String criticity1 = URLDecoder.decode(criticity);
		String priority1 = URLDecoder.decode(priority);
		String version1 = URLDecoder.decode(version);
		
		Rule rule = new Rule(id_rule,operator,property,state,criticity,priority,version);
		ruleService.updateRule(rule);
		
		
		
		if(id_catalogue==0) {
			System.out.println("¿Quieres realmente eliminar la regla de todos los catalogos a los que esta asignada?");
			//ruleService.deleteRuleProjCatalogue(id_rule, id_project, id_catalogueOld);
		}else {
			RuleProjCatalogue newRpc = new RuleProjCatalogue(id_rule, id_project, id_catalogue);
			ruleService.updateRuleProjCatalogue(newRpc);
		}
	}
	
	@RequestMapping(value = "/getRulesByProject", method = RequestMethod.GET, produces = "application/json")
	public List<RuleProj> getRulesByProject(@RequestParam(value = "id_project") int id_project) {
		List<RuleProj> list = new ArrayList<RuleProj>();
		list = ruleService.getRulesByProject(id_project);
		return list;

	}
	
	@RequestMapping(value = "/getRule", method = RequestMethod.GET, produces = "application/json")
	public List<Rule> getRule(@RequestParam(value = "id_rule") int id_rule) {
		List<Rule> list = new ArrayList<Rule>();
		list = ruleService.getRule(id_rule);
		return list;

	}
	
	@RequestMapping(value = "/getAllRule", method = RequestMethod.GET, produces = "application/json")
	public List<Rule> getAllRule() {
		List<Rule> list = new ArrayList<Rule>();
		list = ruleService.getAllRule();
		return list;

	}

}
