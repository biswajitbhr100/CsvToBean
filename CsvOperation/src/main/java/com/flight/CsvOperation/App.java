package com.flight.CsvOperation;

import java.io.FileReader;
//import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;
//import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
public class App 
{
	private static List<Employee> csvToBean(String file){
		List<Employee> emps = null;
		try {
			CSVReader reader = new CSVReader(new FileReader(file),',');
			HeaderColumnNameMappingStrategy<Employee> cps = new HeaderColumnNameMappingStrategy<Employee>();
			//ColumnPositionMappingStrategy<Employee> cps = new ColumnPositionMappingStrategy<Employee>();
			cps.setType(Employee.class);
			//cps.setColumnMapping(new String[] {"id","name","city"});
			CsvToBean<Employee> ctb = new CsvToBean<Employee>();
			emps = ctb.parse(cps, reader);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return emps;
	}
    public static void main( String[] args )
    {
    	List<Employee> list = csvToBean("E:/emp.csv");
        for(Employee e : list) {
        	System.out.print(e.getId() + " " + e.getName() + " " + e.getCity() + "\n");
        }
    }
}
