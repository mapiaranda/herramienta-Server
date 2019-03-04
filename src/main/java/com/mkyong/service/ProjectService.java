package com.mkyong.service;

import java.util.List;

import com.mkyong.model.Project;
import com.mkyong.model.ProjectForView;
import com.mkyong.model.RuleProj;

public interface ProjectService {
	
	public void addProject(Project project);
	
	public List<ProjectForView> getOpenProjectForView();
	
	public List<Project> getOpenProject();
	
	public List<ProjectForView> getCloseProjectForView();

	public List<Project> getProject(int id);

	public List<RuleProj> getProjectByRule(Integer id_rule);

	public List<ProjectForView> getOpenProjectUserForView(String username);

	public List<ProjectForView> getCloseProjectUserForView(String username);

	public List<Project> getOpenProjectUser(String username);
}
