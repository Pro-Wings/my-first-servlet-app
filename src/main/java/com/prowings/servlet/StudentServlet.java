package com.prowings.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.prowings.dao.HibernateUtil;
import com.prowings.entity.Student;

public class StudentServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name = request.getParameter("name");
        String rollno = request.getParameter("rollno");
        String address = request.getParameter("address");
        
        System.out.println("Name :" +name);
        System.out.println("Roll No :" +rollno);
        System.out.println("Address :" +address);
        
        Student std = new Student();
        
        std.setName(name);
        std.setRollNo(Integer.parseInt(rollno));
        std.setAddress(address);
        
        System.out.println(std);
        
        System.out.println(">>>>>> Saving Student to DB <<<<<<<<");
        
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        
        Transaction txn = session.beginTransaction();
        
        session.save(std);
        
        txn.commit();
        session.close();
//        sessionFactory.close();

	}
	
	

}
