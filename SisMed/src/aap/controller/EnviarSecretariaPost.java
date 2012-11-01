package aap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Secretaria;
import aap.model.db.dao.SecretariaDAO;

/**
 * This servlet sends a Secretaria for editing in page EditarSecretaria.jsp
 * so that can user can see which parameters are saved on DataBase
 * 
 * PS: If in this text was any misspelling please correct rsrs 
 */

public class EnviarSecretariaPost extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id")); // takes the request parameter "ID"
		SecretariaDAO dao = new SecretariaDAO(); 
		Secretaria sec = dao.getSecretaria(id); // takes the secretary of the Database through SecretariaDAO
		req.setAttribute("secretaria", sec);//add the secretary at the request 
		
		RequestDispatcher rd = req.getRequestDispatcher("EditarSecretaria.jsp");
		rd.forward(req, resp); // forward the request and response to EditarSecretaria.jsp
			
	}

}
