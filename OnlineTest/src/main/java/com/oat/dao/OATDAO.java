package com.oat.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.oat.bean.OATBean;
import com.oat.util.DBUtill;

public class OATDAO 
{
	private String ADMIN_LOGIN_QUERY="select * from appadminlogin where username=? and password=?";
	private String STUDENT_LOGIN_QUERY="select * from appstudentlogin where susername=? and spassword=?";
	private String ADD_QUESTIONS_QUERY="insert into allquestions(question,option1,option2,option3,option4,answer) values (?,?,?,?,?,?)";
	private String VIEW_QUESTIONS_QUERY="select * from allquestions";
	private String SELECT_QUESTIONS="select question_ID, question from allquestions ";
	private String CREATE_QUESTION_PAPER="INSERT INTO questionpaper(question_ID) values (?) ";
	private String ADD_STUDENT_QUERY="insert into appstudentlogin(susername, spassword, Name, Email_ID, PhoneNumber, SSC, Degree, City) values (?,?,?,?,?,?,?,?)";
	public OATBean findUser(String uid, String pswd) 
	{
		OATBean bean=null;
		try {
			Connection conn=DBUtill.getDBConnection();
			String query=ADMIN_LOGIN_QUERY;
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,uid);
			ps.setString(2, pswd);
			ResultSet rs=null;
			rs=ps.executeQuery();
			System.out.print(rs);
			if(rs.next()) 
			{
				bean=new OATBean();
				bean.setUsr(rs.getString(1));
				bean.setPswd(rs.getString(2));
			}
			else
				bean=null;
			rs.close();
			conn.close();
			}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return bean;
	}
	public OATBean findUserS(String susername, String spassword) 
	{
		OATBean sbean=null;
		try {
			Connection conn=DBUtill.getDBConnection();
			String query=STUDENT_LOGIN_QUERY;
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,susername);
			ps.setString(2, spassword);
			ResultSet rs=null;
			rs=ps.executeQuery();
			System.out.print(rs);
			if(rs.next()) 
			{
				sbean=new OATBean();
				sbean.setSusername(rs.getString(1));
				sbean.setSpassword(rs.getString(2));
			}
			else
				sbean=null;
			rs.close();
			conn.close();
			}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		return sbean;
	}
	public OATBean addQuestion(String question, String option1, String option2, String option3, String option4,String answer) 
	{
		OATBean bean=null;
		try
		{
			Connection conn=DBUtill.getDBConnection();
			String query=ADD_QUESTIONS_QUERY;
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,question);
			ps.setString(2,option1);
			ps.setString(3,option2);
			ps.setString(4,option3);
			ps.setString(5,option4);
			ps.setString(6,answer);
			int rs=0;
			rs=ps.executeUpdate();
			if(rs!=0) 
			{
				bean=new OATBean();
			}
			else
			{
				bean=null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return bean;
	}
	public ArrayList<OATBean> findQuestions() 
	{
		ArrayList<OATBean> al= new ArrayList<OATBean>();
		try {
				Connection conn=DBUtill.getDBConnection();
				String query=VIEW_QUESTIONS_QUERY;
				PreparedStatement ps=conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				OATBean bean=null;
		   while(rs.next()) 
		    {
			   bean=new OATBean();
		    	bean.setQuestion(rs.getString(2));
		    	al.add(bean);		 
		    }
				rs.close();
			}
			catch(Exception e) 
			{
				System.out.print(e);
			}
			return al;
	}
	public OATBean getQuestions(String[] questions) 
	{
		OATBean bean=null;
		try
		{
			Connection conn=DBUtill.getDBConnection();
			String SEL_QUERY = SELECT_QUESTIONS;
			String DEL_QUERY = "DELETE FROM questionpaper WHERE 1";
			String RES_DEL ="DELETE FROM studentresponses WHERE 1";
	        PreparedStatement ps=conn.prepareStatement(SEL_QUERY);        
	        ResultSet rs=ps.executeQuery(SEL_QUERY);
	        PreparedStatement ps2=conn.prepareStatement(DEL_QUERY);
	        ps2.executeUpdate();
	        PreparedStatement ps3=conn.prepareStatement(RES_DEL);
	        ps3.executeUpdate();
	        while(rs.next())
	        {
	        	for(int i=0;i<questions.length;i++)
	        	{ 
	        		String compareTo = rs.getString(2); 
	        	    if(questions[i].equals(compareTo))
	        	    { 
	        	    	String id=rs.getString(1);
	        	    	System.out.println(id);
	        	    	PreparedStatement ps1=conn.prepareStatement(CREATE_QUESTION_PAPER);
	        	    	ps1.setString(1, id);
	        	    	ps1.executeUpdate();
	        	    } 
	        	}
	        	bean=new OATBean();
	        }
		}
		catch(Exception e)
		{
			System.out.print(e);
		}
		return bean;
	}
	public OATBean addStudent(String susername, String spassword, String name, String emailid, String phonenumber,String ssc, String degree, String city) 
	{
		OATBean bean=null;
		try
		{
			Connection conn=DBUtill.getDBConnection();
			String query=ADD_STUDENT_QUERY;
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1,susername);
			ps.setString(2,spassword);
			ps.setString(3,name);
			ps.setString(4,emailid);
			ps.setString(5,phonenumber);
			ps.setString(6,ssc);
			ps.setString(7,degree);
			ps.setString(8,city);
			System.out.println(city);
			int rs=0;
			rs=ps.executeUpdate();
			if(rs!=0) 
			{
				bean=new OATBean();
			}
			else
			{
				bean=null;
			}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return bean;
	}
	public ArrayList<OATBean> findQandA()
	{
		ArrayList<OATBean> al= new ArrayList<OATBean>();
		try {
				Connection conn=DBUtill.getDBConnection();
				String query=VIEW_QUESTIONS_QUERY;
				String query1="select * from questionpaper";
				PreparedStatement ps=conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery();
				PreparedStatement ps1=conn.prepareStatement(query1);
				ResultSet rs1=ps1.executeQuery(query1);
				OATBean bean=null;
				
				while(rs1.next()) 
				{
					while(rs.next())
					{
						String compareTo = rs.getString(1);
						String comparewith = rs1.getString(2);
						if(comparewith.equals(compareTo))
						{
							bean=new OATBean();
							bean.setQ_Paper_ID(rs1.getString(1));
							bean.setquestion_ID(rs1.getString(2));
							bean.setQuestion(rs.getString(2));
							bean.setOption1(rs.getString(3));
							bean.setOption2(rs.getString(4));
							bean.setOption3(rs.getString(5));
							bean.setOption4(rs.getString(6));
							al.add(bean);
							break;
						}						
					}
				}
		    rs.close();
		    rs1.close();
			}
			catch(Exception e) 
			{
				System.out.print(e);
			}
			return al;
	}
	public ArrayList<OATBean> getResponse(String student_ID) 
	{
		ArrayList<OATBean> all= new ArrayList<OATBean>();
		try 
		{
			Connection conn=DBUtill.getDBConnection();
			String query="select * from studentresponses";
			String query1="select * from allquestions";
			String query2="select * from appstudentlogin";
			PreparedStatement ps=conn.prepareStatement(query);
			ResultSet rs=ps.executeQuery(query);
			OATBean bean=null;
			while(rs.next())
			{
				String Student_ID=rs.getString(1);
				if(Student_ID.equals(student_ID))
				{
					PreparedStatement ps2=conn.prepareStatement(query2);
					ResultSet rs2=ps2.executeQuery(query2);
					while(rs2.next())
					{
						String CompareTo=rs2.getString(1);
						if(Student_ID.equals(CompareTo))
						{
							String Name=rs2.getString(2);
							bean=new OATBean();
							bean.setSusername(Name);
						}
					}
					String Question_ID=rs.getString(2);
					PreparedStatement ps1=conn.prepareStatement(query1);
					ResultSet rs1=ps1.executeQuery(query1);
					while(rs1.next())
					{
						String Q_ID=rs1.getString(1);
						if(Question_ID.equals(Q_ID))
						{
							String question=rs1.getString(2);
							String answer=rs1.getString(7);
							String response=rs.getString(3);
							//System.out.println(question);
							//System.out.println(answer);
							//System.out.println(response);
							bean.setquestion_ID(Question_ID);
							bean.setQuestion(question);
							bean.setAnswer(answer);
							bean.setresponse(response);
							all.add(bean);
						}
					}
				}
			}
			
		}
		catch(Exception e) 
		{
			System.out.print(e);
		}
		return all;
	}
	public ArrayList<OATBean> getResults() 
	{
		ArrayList<OATBean> al= new ArrayList<OATBean>();
		try
		{
			Connection conn=DBUtill.getDBConnection();
			String query="select * from studentresponses";
			String query1="select * from appstudentlogin";
			String query2="select * from allquestions";
			PreparedStatement ps1=conn.prepareStatement(query1);
			ResultSet rs1=ps1.executeQuery(query1);
			OATBean bean=null;
			while(rs1.next()) 
			{
				int Count=0;
				String s_ID=rs1.getString(1);
				PreparedStatement ps=conn.prepareStatement(query);
				ResultSet rs=ps.executeQuery(query);
				while(rs.next())
				{
					String S_ID=rs.getString(1);
					String Q_ID=rs.getString(2);
					String Ans=rs.getString(3);
					if(S_ID.equals(s_ID))
					{
						PreparedStatement ps2=conn.prepareStatement(query2);
						ResultSet rs2=ps2.executeQuery(query2);
						while(rs2.next())
						{
							String q_ID=rs2.getString(1);
							if(Q_ID.equals(q_ID))
							{
								String ans=rs2.getString(7);
								//System.out.println(ans);
								if(Ans.equals(ans))
								{
									Count=Count+1;
									break;
								}
							}
						}
					}
				}
				bean=new OATBean();
				bean.setStudent_ID(rs1.getString(1));
				bean.setSusername(rs1.getString(2));
				bean.setCount(Count);
				al.add(bean);
				//System.out.println(rs1.getString(2));
				//System.out.println(Count);
			}						
		}
		catch(Exception e) 
		{
			System.out.print(e);
		}
		return al;
	}
	public OATBean getAnswers(String[] answer, String user) 
	{
		OATBean bean=null;
		try 
		{
			Connection conn=DBUtill.getDBConnection();
			String SEL_USR="select * from appstudentlogin";
			String SEL_QUERY = "select *from questionpaper";
			String query="INSERT INTO studentresponses (Student_ID,question_ID,response) values(?,?,?)";
			PreparedStatement ps1=conn.prepareStatement(SEL_USR);
			ResultSet rs1=ps1.executeQuery();
			PreparedStatement ps2=conn.prepareStatement(SEL_QUERY);
			ResultSet rs2=ps2.executeQuery();
			while(rs1.next())
			{
				String compareTo=rs1.getString(2);
				if(user.equals(compareTo))
				{
					String Student_ID=rs1.getString(1);
					for(int i=0;rs2.next();i++)
					{
						String question_ID=rs2.getString(2);
						String response=answer[i];
						PreparedStatement ps=conn.prepareStatement(query);
						ps.setString(1,Student_ID);
						ps.setString(2,question_ID);
						ps.setString(3, response);
						int rs=ps.executeUpdate();
						if(rs!=0) 
						{
							bean=new OATBean();
						}
						else
						{
							bean=null;
						}
					}
				}
				
			}
			
		}
		catch(Exception e) 
		{
			System.out.print(e);
		}
		return bean;
	}		
}
	
