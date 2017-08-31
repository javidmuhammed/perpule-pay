package com.perpule.dao;

import java.sql.Connection;
import java.util.ArrayList;

import com.perpule.bean.Employee;


public interface EmployeeServiceInterface {

	ArrayList<Employee> GetUser(Connection connection, String userid, String authtoken) throws Exception;

	String GetAuth(Connection connection, String userid, String userkey) throws Exception;

	ArrayList<Employee> SetFeeds(Connection connection, String name, String phone, String email, double userKey) throws Exception;

	
}