package com.flying.xiao.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.flying.xiao.entity.Base;

public class BaseServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected PrintWriter pw;
	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		pw=response.getWriter() ;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}

	protected void printErrorMsg(int errorCode, String errorMsg, PrintWriter pw) {
		Base base = new Base();
		base.setErrorCode(errorCode);
		base.setErrorMsg(errorMsg);
		pw.write(base.toJson());
		pw.flush();
		pw.close();
	}

	protected void printSuccessMsg(PrintWriter pw) {
		Base base = new Base();
		base.setErrorCode(0);
		pw.write(base.toJson());
		pw.flush();
		pw.close();
	}

}
