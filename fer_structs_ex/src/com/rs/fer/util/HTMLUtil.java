package com.rs.fer.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HTMLUtil {
	public static void displayHeaderAndLeftFrame(HttpServletRequest request,HttpServletResponse response,PrintWriter out,String username) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("layout/Header.html");
		requestDispatcher.include(request, response);
		out.println(username);
		requestDispatcher = request.getRequestDispatcher("layout/LeftFrame.html");
		requestDispatcher.include(request, response);
		
	}
	public static void displayFooter(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("layout/Footer.html");
		requestDispatcher.include(request, response);
	}

}
