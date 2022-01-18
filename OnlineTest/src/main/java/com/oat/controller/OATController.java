package com.oat.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oat.bean.OATBean;
import com.oat.dao.OATDAO;
import com.oat.service.OATService;
import com.oat.util.DBUtill;

@WebServlet("/OATController")
public class OATController extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    
    public OATController()
    {
        super();
    }
    
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		HttpSession Session=req.getSession();
		if(req.getParameter("Login")!=null) 
		{
		 	String username=req.getParameter("username");
			String password=req.getParameter("password");
			OATService service=new OATService();
			OATBean bean =service.findUser(username, password);			
			if(bean!=null)
			{
				res.sendRedirect("adminhomepage.html");
			}
			else 
			{
			
				res.sendRedirect("loginfail.html");
			}
		}
		else if(req.getParameter("studentLogin")!=null) 
		{
			String susername=req.getParameter("susername");
			String spassword=req.getParameter("spassword");
			//System.out.println(susername)
			OATService sservice=new OATService();
			OATBean sbean = sservice.findUserS(susername,spassword);
			if(sbean!=null)
			{
				Session.setAttribute(susername,susername);
				res.sendRedirect("studenthomepage.html");
			}
			else
			{
				res.sendRedirect("loginfail.html");
			}
			
		}
		else if(req.getParameter("addques")!=null)
		{
			String question=req.getParameter("question");
			String option1=req.getParameter("option1");
			String option2=req.getParameter("option2");
			String option3=req.getParameter("option3");
			String option4=req.getParameter("option4");
			String answer=req.getParameter("answer");
			OATService service=new OATService();
			OATBean bean=service.addQuestion(question, option1, option2, option3, option4, answer);
			if(bean!=null)
			{
				res.sendRedirect("updatesuccess.html");
			}
			else
			{
				res.sendRedirect("updatefail.html");
			}
		}
		else if(req.getParameter("profile")!=null)
		{
			try 
			{
				Connection conn=DBUtill.getDBConnection();
				String query="select * from appadminlogin";
				PreparedStatement ps=conn.prepareStatement(query);
				ResultSet rs=null;
				rs=ps.executeQuery();				
				System.out.print(rs);
				if(rs.next()) 
				{
					res.getWriter().println("<html>"
							+ "<head>"
							+ "<meta charset=\"ISO-8859-1\">"
							+ "<title>Admin Profile</title>"
							+ "</head>"
							+ "<body>"
							+ "<h3 align=\"right\"><a href=\"adminhomepage.html\">home page</a></h3>"
							+ "<center><h1>Your Profile</h1></center>"
							+ "<table align=center>"
							+ "<tr>"
							+ "<td>Name</td>"
							+ "<td>"+rs.getString("Name")+"</td>"
							+ "</tr>"
							+ "<tr>\r\n"
							+ "<td>Email_ID</td>\r\n"
							+ "<td>"+rs.getString("Email_ID")+"</td>\r\n"
							+ "</tr>\r\n"
							+ "<tr>\r\n"
							+ "<td>Phone Number</td>\r\n"
							+ "<td>"+rs.getString("PhoneNumber")+"</td>\r\n"
							+ "</tr>\r\n"
							+ "</table>\r\n"
							+ "</body>\r\n"
							+ "</html>");
					
				}
				
			}
			catch(Exception e) 
			{
				System.out.println(e);
			}		
		}
		else if(req.getParameter("questionpapers")!=null)
		{
			OATService oatservice= new OATService();
			ArrayList<OATBean> al=oatservice.findQuestions();
			if(!al.isEmpty()) 
			{
				Session.setAttribute("OATal",al);
				res.sendRedirect("viewquestions.jsp");
			}
			else 
			{
				res.sendRedirect("questionpaperfail.jsp");
			}
		}
		else if(req.getParameter("create")!=null)
		{
			String questions[]=req.getParameterValues("questions");
			OATService oatservice =new OATService();
			OATBean bean=oatservice.getQuestions(questions);
			if(bean!=null)
			{
				res.sendRedirect("updatesuccess.html");
			}
		}
		else if(req.getParameter("addstudent")!=null)
		{
			String susername=req.getParameter("susername");
			String spassword=req.getParameter("spassword");
			String name=req.getParameter("Name");
			String emailid=req.getParameter("Email_ID");
			String phonenumber=req.getParameter("Phone Number");
			String ssc=req.getParameter("SSC %");
			String degree=req.getParameter("Degree %");
			String city=req.getParameter("City");
			OATService service=new OATService();
			OATBean bean=service.addStudent(susername,spassword,name,emailid,phonenumber,ssc,degree,city);
			if(bean!=null)
			{
				res.sendRedirect("studentregsuccess.html");
			}
			else
			{
				res.sendRedirect("updatefail.html");
			}
		}
		
		else if(req.getParameter("starttest")!=null)
		{
			OATService oatservice =new OATService();
			ArrayList<OATBean> al=oatservice.findQandA();
			if(!al.isEmpty()) 
			{
				Session.setAttribute("OATal",al);
				res.sendRedirect("questionpaper.jsp");
			}
			else 
			{
				res.sendRedirect("questionpaperfail.jsp");
			}
			
		}	
		else if(req.getParameter("progress")!=null)
		{
			OATService oatservice=new OATService();
			ArrayList<OATBean> al = oatservice.getResults();
			if(!al.isEmpty()) 
			{
				Session.setAttribute("OATal",al);
				res.sendRedirect("studentprogress.jsp");
			}
			else 
			{
				res.sendRedirect("studentprogressfail.html");
			}
		}
		else if(req.getParameter("view")!=null)
		{
			String Student_ID=req.getParameter("Student_ID");
			//System.out.println(Student_ID);
			Session.setAttribute("Student_ID", Student_ID);
			OATService oatservice=new OATService();
			ArrayList<OATBean> all= oatservice.getResponse(Student_ID);
			if(!all.isEmpty())
			{
				Session.setAttribute("OATal", all);
				res.sendRedirect("studentresponse.jsp");
			}
			else
			{
				res.sendRedirect("studentprogressfail.html");
			}
		}
		else if(req.getParameter("complete")!=null)
		{
			String user=req.getParameter("username");
			//System.out.println(user);
			ArrayList<OATBean> al=(ArrayList<OATBean>)Session.getAttribute("OATal");
			int arr[]=new int[al.size()];
			String answer[]=new String[al.size()];
			for(int i=0;i<al.size();i++)
			{
				arr[i]= i;			
			}
			String[] options = new String[arr.length];
			 
	        for (int i = 0; i < arr.length; i++)
	        {
	            options[i] = String.valueOf(arr[i]); 
	            answer[i]=req.getParameter(options[i]);
	            //System.out.println(answer[i]);
			}
	        OATService service=new OATService();
	        OATBean bean=service.getAnswers(answer,user);
	        if(bean!=null)
			{
	        	res.sendRedirect("examfinish.html");
			}
			else
			{
				res.sendRedirect("examfail.html");
			}
		}
	}
}

	
