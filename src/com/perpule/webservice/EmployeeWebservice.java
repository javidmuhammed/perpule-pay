package com.perpule.webservice;

import java.io.IOException;
import java.util.ArrayList;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;
import com.perpule.bean.Employee;
import com.perpule.service.EmployeeService;




public class EmployeeWebservice {
	
	@Path("WebService")
	public class FeedService {
		
		/*@GET
		@Path("/Get/")
		@Produces("application/json")
		public String feed()
		{
			String feeds  = null;
			try 
			{
				ArrayList<Employee> feedData = null;
				EmployeeService employeeservice= new EmployeeService();
				feedData = employeeservice.GetFeeds();
				//StringBuffer sb = new StringBuffer();
				Gson gson = new Gson();
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);

			} catch (Exception e)
			{
				System.out.println("error");
			}
			return feeds;
		}
		*/
		
		@HeaderParam("authtoken")
	     String authtoken;
		@GET
	    @Path("getuser")  
		@Produces("application/json")
		public String GetName(@HeaderParam("userid") String userid)
		{
			String feeds  = null;
			try 
			{
				ArrayList<Employee> feedData = null;
				EmployeeService employeeservice= new EmployeeService();
				feedData = employeeservice.GetUser(userid,authtoken);
				//StringBuffer sb = new StringBuffer();
				Gson gson = new Gson();
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);

			} catch (Exception e)
			{
				System.out.println("error in userid");
			}
			return feeds;
		}
		
		
		 @POST  
		 @Path("/add")
		 @Produces(MediaType.APPLICATION_JSON)
		public Response addUser(  
		        @FormParam("name") String name,  
		        @FormParam("phone") String phone,  
		        @FormParam("email") String email) {  
			 String feeds  = null;
			 Employee emp= new Employee();
			 ArrayList<Employee> feedData = null;
			 EmployeeService employeeservice= new EmployeeService();
				try {
					int userKey=(int)Math.random();
					
					feedData = employeeservice.SetFeeds(name,phone,email,userKey);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//StringBuffer sb = new StringBuffer();
				Gson gson = new Gson();
				System.out.println(gson.toJson(feedData));
				feeds = gson.toJson(feedData);
				for(Employee i:feedData)
				{
					int userid=i.getUserid();
					String userkey=i.getUserkey();
					  return Response.status(200)  
					            .entity(" Employee added successfuly! Name: "+name+"  Phone: " + phone+" Email: "+email +"userid:"+userid+"userkey"+userkey)  
					            .build();
				}
				
				
		      
				
				return null;
		    }  
		 
		 @POST  
		 @Path("/auth")
		 @Produces("application/json")
		public String auth(  
		        @FormParam("userid") String userid,  
		        @FormParam("userkey") String userkey) throws IOException {  
			 try {
					
					/*			
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:dd:HH:mm:ss");
					String currentDateandTime = sdf.format(new Date(System.currentTimeMillis()));
					Date date = sdf.parse(currentDateandTime);
					Calendar calender = Calendar.getInstance();
					calender.setTime(date);
					String accTokenExpiry = InitializeWebServices.accTokenExp;
					int accTokenExpHour = Integer.parseInt(accTokenExpiry);
					calender.add(Calendar.Hour, accTokenExpHour);
					Date expiryTime = calender.getTime();*/
					
					String feeds  = null;
					try 
					{
						String feedData = "";
						EmployeeService employeeservice= new EmployeeService();
						feedData = employeeservice.GetAuthToken(userid,userkey);
						//StringBuffer sb = new StringBuffer();
						Gson gson = new Gson();
						System.out.println(gson.toJson(feedData));
						
						
						
						feeds = gson.toJson(feedData);
						
						return feeds;
						
						
					} catch (Exception e)
					{
						System.out.println("error");
					}
					
					
				//	insertQuery = "INSERT INTO ws_client_key(client_Id, accessToken, token_expires_in, api_Key) VALUES 
					//  ('"+clientId+"','"+ accessToken+"','"+expiryTime+"','"+apiKey+"'))";
				} catch (Exception ex) {
			       ex.printStackTrace();
				}
			 	
			 return null;
		    }  

	}

}
