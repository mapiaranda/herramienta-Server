package com.mkyong.readerFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.mkyong.model.DataModelDecript;

public class readerMysql{
	
	public readerMysql() {
		
	}

	public Document abrirXmlJDOM(File fichero) {
		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		try {
            doc = (Document) builder.build(fichero);
           
        } catch(Exception e) {
            e.printStackTrace();
        } 
		 return doc;
    }
		
	
	public ArrayList<DataModelDecript> recorrerJDOMyMostrar(Document doc, String version, int id) {
		ArrayList<DataModelDecript> rowList = new ArrayList();
		DataModelDecript dataModel;
		try {
			Element rootNode = doc.getRootElement();
			List list = rootNode.getChildren( "ROW" );
			for (int i=0; i < list.size();i++) {
				Element row = (Element) list.get(i);
				String database_name = row.getChildTextTrim("db_name");
				String table_name = row.getChildTextTrim("table_name");
				String table_type = row.getChildTextTrim("table_type");
				String column_name = row.getChildTextTrim("column_name");
				String column_type = row.getChildTextTrim("column_type");
				String column_key = row.getChildTextTrim("column_key");
				String isnullable = row.getChildTextTrim("is_nullable");
				
				dataModel = new DataModelDecript(database_name,table_name,table_type,column_name,
						column_type,column_key,isnullable, version, id);
				rowList.add(dataModel);
			}            
		} catch (Exception e) {
			e.printStackTrace();
		}
		/*for (int i=0; i < rowList.size();i++) {
			DataModel prueba = rowList.get(i);
			System.out.println(prueba);
		} */
		return rowList;
		
	}
	
	public String getDatabaseName(Document doc) {
		String database_name ="";
		try {
			Element rootNode = doc.getRootElement();
			List list = rootNode.getChildren( "ROW" );
			for (int i=0; i < list.size();i++) {
				Element row = (Element) list.get(i);
				database_name = row.getChildTextTrim("db_name");
			}            
		} catch (Exception e) {
			e.printStackTrace();
		}
		return database_name;
		
	}

}
