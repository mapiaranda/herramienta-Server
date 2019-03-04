package com.mkyong.service;

import java.util.List;

import com.mkyong.model.DataModel;
import com.mkyong.model.DataModelDecript;
import com.mkyong.model.Organization;

public interface mdService {
	
	public void uploadFile(String path, String sistemabbdd, String version);
	
	public List<DataModel> getAllDatamodel();
	
	public List<DataModel> getDataModel(Integer id_dm);
	
	public List<String> getAllNameDatamodel();
	
	public List<String> getdmdByIdDatamodel(Integer id_datamodel);
	
	public List<String> getAttributesByTable(String table_name);
	
	public void deleteDataModel(String database_name, String version);
	
	public List<DataModelDecript> getDatamodelDescript(Integer id_datamodel);
	
	public List<String> getNameTableDescript(Integer id_datamodel);

}
