package com.servlets;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Resume;

@WebServlet("/addCV")
public class CVmanagement extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = (String) request.getParameter("name");
		String education = (String) request.getParameter("education");
		String experience = (String) request.getParameter("experience");
		String skills = (String) request.getParameter("skills");
		Resume resume=new Resume(education,experience,skills);
		HttpSession session=request.getSession();
		if(session.getAttribute("ListCV") != null){
			Map<String,Resume> listCV=(HashMap<String,Resume>)session.getAttribute("ListCV");
			listCV.put(name, resume);
		}
		session.setAttribute("CV", resume);
		
		getServletContext().getRequestDispatcher("/page2.jsp").forward(request, response);
		
	}
}
