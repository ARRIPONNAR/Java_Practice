package com.Registeration;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterLogin")
public class RegisterLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private String getname;
    private String getpass;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter ps=response.getWriter();
		
		String getname=request.getParameter("name");
		String getpass=request.getParameter("pass");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ponnar","root","12345");
			PreparedStatement p=con.prepareStatement("insert into arriponnar1(name,password) values(?,?)");
			
			Model obj=new Model(getname, getpass);
			
			p.setString(1,obj.getName());
			p.setString(2,obj.getPass());
			
			int a=p.executeUpdate();
			
			if(a==1)
			{
				ps.println("inserted successfully");
			}
			else
			{
				ps.println("not inserted");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
