package com.perpule.service;

import java.sql.Connection;
import java.util.ArrayList;


import com.perpule.bean.Employee;
import com.perpule.dao.EmployeeServiceInterface;
import com.perpule.dao.EmployeeStub;
import com.perpule.util.DBConnection;



public class EmployeeService {
	
	/*public ArrayList<Employee> GetFeeds()throws Exception {
		ArrayList<Employee> feeds = null;
		try {
			    DBConnection database= new DBConnection();
			    Connection connection = database.Get_Connection();
				EmployeeStub project= new EmployeeStub();
				feeds=project.GetFeeds(connection);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}
	
	public ArrayList<Employee> GetName(String name)throws Exception {
		ArrayList<Employee> feeds = null;
		try {
			    DBConnection database= new DBConnection();
			    Connection connection = database.Get_Connection();
				EmployeeStub project= new EmployeeStub();
				feeds=project.GetFeeds(connection,name);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}*/

	public ArrayList<Employee> SetFeeds(String name, String phone, String email, double userKey) throws Exception {
		
		ArrayList<Employee> feeds = null;
		try {
			    DBConnection database= new DBConnection();
			    Connection connection = database.Get_Connection();
				EmployeeServiceInterface project= new EmployeeStub();
				feeds=project.SetFeeds(connection,name,phone,email,userKey);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	
	}

	public String GetAuthToken(String userid, String userkey) throws Exception {
		String feeds = "";
		try {
			    DBConnection database= new DBConnection();
			    Connection connection = database.Get_Connection();
				EmployeeServiceInterface project= new EmployeeStub();
				feeds=project.GetAuth(connection,userid,userkey);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	}

	public ArrayList<Employee> GetUser(String userid, String authtoken) throws Exception {
		ArrayList<Employee> feeds = null;
		try {
			    DBConnection database= new DBConnection();
			    Connection connection = database.Get_Connection();
				EmployeeServiceInterface project= new EmployeeStub();
				feeds=project.GetUser(connection,userid,authtoken);
		
		} catch (Exception e) {
			throw e;
		}
		return feeds;
	
	
	}

}
