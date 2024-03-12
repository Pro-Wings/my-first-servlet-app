package com.prowings.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.dao.HibernateUtil;
import com.prowings.entity.Error;
import com.prowings.entity.Student;

public class FetchStudentDetailsServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		System.out.println(">>>>>> Started fetch stuent servlet");
        int rollno = Integer.parseInt(req.getParameter("rollno"));
        
        System.out.println("Fetching Student details for roll number : "+rollno);
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction txn = session.beginTransaction();
		String hql = "FROM Student s WHERE s.rollNo = "+rollno;
		
		Query<Student> query = session.createQuery(hql);
		
        Student fetchedStudent = query.uniqueResult();
        
        System.out.println(fetchedStudent);
        
        txn.commit();
        session.close();

        if(fetchedStudent != null)
        {
        	req.setAttribute("student", fetchedStudent);
        	// Forward the request to the JSP
        	req.getRequestDispatcher("/Student.jsp").forward(req, resp);
        }
        else
        {
        	req.setAttribute("error", new Error("No Student present with given rollNo"));
        	req.getRequestDispatcher("/Error.jsp").forward(req, resp);
        }
        
        
        
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("inside delete method!!");
		String id = req.getParameter("id");
		System.out.println("Deleting Student with id : "+id);
	}
	
	

}
