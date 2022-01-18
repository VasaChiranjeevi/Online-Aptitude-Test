package com.oat.bean;

public class OATBean
{
	private String username;
	private String password;
	private String susername;
	private String spassword;
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private String question_ID;
	private String Student_ID;
	private long Score;
	private String Q_Paper_ID;
	private int Count;
	private String response;	
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public String getQuestion() 
	{
		return question;
	}
	public void setQuestion(String question) 
	{
		this.question = question;
	}
	public String getOption1() 
	{
		return option1;
	}
	public void setOption1(String option1) 
	{
		this.option1 = option1;
	}
	public String getOption2() 
	{
		return option2;
	}
	public void setOption2(String option2) 
	{
		this.option2 = option2;
	}
	public String getOption3() 
	{
		return option3;
	}
	public void setOption3(String option3) 
	{
		this.option3 = option3;
	}
	public String getOption4() 
	{
		return option4;
	}
	public void setOption4(String option4) 
	{
		this.option4 = option4;
	}
	public String getAnswer() 
	{
		return answer;
	}
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}
	public String getUid()
	{
		return username;
	}
	public void setUsr(String usr) 
	{
		this.username = usr;
	}
	public String getPswd() 
	{
		return password;
	}
	public void setPswd(String pswd) 
	{
		this.password = pswd;
	}
	public String getSusername()
	{
		return susername;
	}
	public void setSusername(String susername)
	{
		this.susername = susername;
	}
	public String getSpassword()
	{
		return spassword;
	}
	public void setSpassword(String spassword)
	{
		this.spassword = spassword;
	}
	public String getquestion_ID()
	{
		return question_ID;
	}
	public void setquestion_ID(String question_ID) 
	{
		this.question_ID=question_ID;
	}
	public void setStudent_ID(String Student_ID) 
	{
		this.Student_ID=Student_ID;
		
	}
	public String getStudent_ID()
	{
		return Student_ID;
	}
	public void setScore(long Score) 
	{
		this.Score=Score;	
	}
	public long getScore()
	{
		return Score;
	}
	public void setQ_Paper_ID(String Q_Paper_ID)
	{
		this.Q_Paper_ID=Q_Paper_ID;
		
	}
	public String getQ_Paper_ID()
	{
		return Q_Paper_ID;
	}
	public void setCount(int Count) 
	{
		this.Count=Count;			
	}
	public int getCount()
	{
		return Count;
	}
	public void setresponse(String response)
	{
		this.response=response;		
	}
	public String getresponse()
	{
		return response;
	}
}
