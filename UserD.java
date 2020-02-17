package App;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@SuppressWarnings("serial")
@WebServlet("/UserD")
public class UserD extends HttpServlet
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String name=request.getParameter("name"); 
		String pass=request.getParameter("password");
		String email=request.getParameter("email");
		String sex=request.getParameter("sex");
		int id=Integer.parseInt(request.getParameter("id"));
		try{  
	        Class.forName("com.mysql.jdbc.Driver");  
	Connection  con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","Jktech@123");  
	    try {
       PreparedStatement ps=con.prepareStatement("insert into user_db(id,name,password,email,sex) values(?,?,?,?,?)");
       User u=new User();
       u.setId(id);
       u.setName(name);
       u.setEmail(email);
       u.setPassword(pass);
       u.setSex(sex);
       ps.setInt(1,u.getId());
	   ps.setString(2,u.getName());  
       ps.setString(3,u.getPassword());  
       ps.setString(4,u.getEmail());  
       ps.setString(5,u.getSex());  
      int st=ps.executeUpdate();  
      if(st>0)
		   pw.print("Added to database.");}
	    catch (Exception e)
	    {	
		   pw.print("Something went wrong!");
	     }}
	catch(Exception e1)
    {
	System.out.println(e1);
	}
		
		
		
   }
  }



