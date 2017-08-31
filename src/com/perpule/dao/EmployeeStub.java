package com.perpule.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.UUID;

import com.perpule.bean.Employee;


public class EmployeeStub implements EmployeeServiceInterface {

	/* (non-Javadoc)
	 * @see com.perpule.dao.EmployeeServiceInterface#GetUser(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<Employee> GetUser(Connection connection, String userid, String authtoken) throws Exception {
		
		ArrayList<Employee> feedData = new ArrayList<Employee>();
		try
		{
			//String uname = request.getParameter("uname");
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM authtoken where userid=? and authtoken=?");
			ps.setString(1,userid);
			ps.setString(2,authtoken);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ps = connection.prepareStatement("SELECT * FROM emp where userid=?");
				ps.setString(1,userid);
				ResultSet rs2=ps.executeQuery();
			while(rs2.next())
			{			
				Employee feedObject = new Employee();
				feedObject.setName(rs.getString("name"));
				feedObject.setPhone(rs.getString("phone"));
				feedObject.setEmail(rs.getString("email"));
				feedData.add(feedObject);
				
			}
			return feedData;
			}
		}
		catch(Exception e)
		{
			throw e;
		}
		return feedData;	
		}



	/* (non-Javadoc)
	 * @see com.perpule.dao.EmployeeServiceInterface#GetAuth(java.sql.Connection, java.lang.String, java.lang.String)
	 */
	@Override
	public String GetAuth(Connection connection, String userid, String userkey) throws Exception {
		try
		{
			//String uname = request.getParameter("uname");
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM emp where userid=? and userkey=?");
			ps.setString(1,userid);
			ps.setString(1,userkey);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				String accessToken= UUID.randomUUID().toString();
				 ps = connection.prepareStatement("insert into authtoken values(?,?)");
					ps.setString(1,userid);
					ps.setString(2,accessToken);
					int i = ps.executeUpdate();
				return accessToken;
				
				
		
			}
			return null;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	/* (non-Javadoc)
	 * @see com.perpule.dao.EmployeeServiceInterface#SetFeeds(java.sql.Connection, java.lang.String, java.lang.String, java.lang.String, double)
	 */
	@Override
	public ArrayList<Employee> SetFeeds(Connection connection, String name, String phone, String email, double userKey) throws Exception {
		int code=0;
		ArrayList<Employee> feed=new ArrayList<>();
		try
		{
			//String uname = request.getParameter("uname");
			PreparedStatement ps = connection.prepareStatement("insert into emp(name,phone,email,userkey) values(?,?,?,?)");
			ps.setString(1,name);
			ps.setString(2,phone);
			ps.setString(3,email);
			ps.setDouble(4,userKey);
			
			code = ps.executeUpdate();
			 if(code!=0)
			 {
				 ps = connection.prepareStatement("select userid, userkey from emp where name=?");
					ps.setString(1,name);
				ResultSet rs= ps.executeQuery();
				while(rs.next())
				{
					Employee emp=  new Employee();
					emp.setUserid(rs.getInt("userid"));
					emp.setUserkey(rs.getString("userkey"));
					feed.add(emp);
				}
			 }
			 return feed;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
