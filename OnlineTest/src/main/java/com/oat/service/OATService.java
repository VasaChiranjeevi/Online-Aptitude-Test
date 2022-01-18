package com.oat.service;

import java.util.ArrayList;

import com.oat.bean.OATBean;
import com.oat.dao.OATDAO;

public class OATService 
{

	public OATBean findUser(String uid, String pswd)
	{
		OATDAO oatdao = new OATDAO();
		  OATBean oatbean =oatdao.findUser(uid,pswd);
		  return oatbean;
	}
	public OATBean findUserS(String susername, String spassword)
	{
		OATDAO soatdao = new OATDAO();
		  OATBean soatbean =soatdao.findUserS(susername,spassword);
		  return soatbean;
	}
	public OATBean addQuestion(String question, String option1, String option2, String option3, String option4,String answer)
	{
		OATDAO oatdao = new OATDAO();
		OATBean oatbean=oatdao.addQuestion(question,option1, option2, option3, option4,answer);
		return oatbean;
	}
	public ArrayList<OATBean> findQuestions()
	{
		OATDAO oatdao=new OATDAO();
		ArrayList<OATBean> al =oatdao.findQuestions();
		return al;
	}
	public OATBean getQuestions(String[] questions) 
	{
		OATDAO oatdao=new OATDAO();
		OATBean bean =oatdao.getQuestions(questions);
		return bean;
	}
	public OATBean addStudent(String susername, String spassword, String name, String emailid, String phonenumber,String ssc, String degree, String city) {
		OATDAO oatdao = new OATDAO();
		OATBean oatbean=oatdao.addStudent(susername,spassword,name,emailid,phonenumber,ssc,degree,city);
		return oatbean;
	}
	public ArrayList<OATBean> findQandA() 
	{
		OATDAO oatdao=new OATDAO();
		ArrayList<OATBean> al=oatdao.findQandA();
		return al;
	}
	public OATBean getAnswers(String[] answer, String user)
	{
		OATDAO oatdao=new OATDAO();
		OATBean bean=oatdao.getAnswers(answer,user);
		return bean;
	}
	public ArrayList<OATBean> getResults() 
	{
		OATDAO oatdao=new OATDAO();
		ArrayList<OATBean> al=oatdao.getResults();
		return al;
	}
	public ArrayList<OATBean> getResponse(String student_ID) {
		OATDAO oatdao=new OATDAO();
		ArrayList<OATBean> al =oatdao.getResponse(student_ID);
		return al;
	}
		
}
