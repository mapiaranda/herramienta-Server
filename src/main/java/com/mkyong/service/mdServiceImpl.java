package com.mkyong.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mkyong.dao.OrganizationDao;
import com.mkyong.model.DataModel;
import com.mkyong.model.DataModelDecript;
import com.mkyong.model.Organization;
import com.mkyong.model.Personal;
import com.mkyong.readerFile.readerMysql;
import com.mkyong.dao.mdDao;

@Service
@Transactional
public class mdServiceImpl implements mdService{
	
	readerMysql r = new readerMysql();
	@Autowired
	private mdDao md;
	
	@Transactional
	public void uploadFile(String path, String sistemabbdd, String version) {
		String database_name;
		int id_datamodel=0;
		ArrayList<DataModelDecript> datamodelList = new ArrayList();
		DataModelDecript descriptDataModel = new DataModelDecript();
		String archivo_xml = path;
		File fichero = new File(archivo_xml);
		Document doc = r.abrirXmlJDOM(fichero);
		database_name = r.getDatabaseName(doc);
		DataModel dataModel = new DataModel(id_datamodel,database_name, version);
		md.addDataModel(dataModel);
		List<Integer> ids = md.getIdDataModel(database_name, version);
		int id = ids.get(0);
		//System.out.println("-----------"+version+ id);
		
		//md.getIdDataModel(database_name,version);
		
		datamodelList = r.recorrerJDOMyMostrar(doc, version, id);
		for (int i=0; i < datamodelList.size();i++) {
			descriptDataModel = datamodelList.get(i);
			md.addDecriptDataModel(descriptDataModel);
		}
	}
	
	@Transactional
	public List<DataModel> getAllDatamodel() {
		List<DataModel> list = new ArrayList<DataModel>();
		list = md.getAllDatamodel();
		return list;
	}
	
	@Transactional
	public List<String> getAllNameDatamodel() {
		List<String> list = new ArrayList<String>();
		list = md.getAllNameDatamodel();
		return list;
	}
	
	@Transactional
	public List<String> getdmdByIdDatamodel(Integer id_datamodel) {
		List<String> list = new ArrayList<String>();
		list = md.getdmdByIdDatamodel(id_datamodel);
		return list;
	}
	
	@Transactional
	public List<String> getAttributesByTable(String table_name) {
		List<String> list = new ArrayList<String>();
		list = md.getAttributesByTable(table_name);
		return list;
	}

	public void deleteDataModel(String database_name, String version) {
		md.deleteDataModel(database_name,version);
		
	}

	public List<DataModel> getDataModel(Integer id_dm) {
		List<DataModel> list= new ArrayList<DataModel>();
		list=md.getDatamodel(id_dm);
		return list;
	}

	public List<DataModelDecript> getDatamodelDescript(Integer id_datamodel) {
		List<DataModelDecript> list= new ArrayList<DataModelDecript>();
		list=md.getDatamodelDescript(id_datamodel);
		return list;
	}
	
	public List<String> getNameTableDescript(Integer id_datamodel) {
		List<String> list= new ArrayList<String>();
		list=md.getNameTableDescript(id_datamodel);
		return list;
	}

}
