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

public class DeleteStudentDetailsServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("inside delete method!!");
		String id = req.getParameter("id");
		System.out.println("Deleting Student with id : "+id);
	}
	
	

}
