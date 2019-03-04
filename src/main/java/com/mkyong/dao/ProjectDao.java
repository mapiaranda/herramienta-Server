package com.mkyong.dao;

import java.util.List;

import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;
import com.mkyong.model.RuleProj;

public interface ProjectDao {
	
	public void addProject(Project project);

	public List<Project> getAllProject();
	
	public List<Project> getOpenProject();
	
	public List<Project> getCloseProject();
	
	public List<Project> getProject(int id);

	public List<RuleProj> getProjectByRule(Integer id_rule);

	public List<Project> getOpenProjectUser(String username);

	public List<Project> getCloseProjectUser(String username);

}
