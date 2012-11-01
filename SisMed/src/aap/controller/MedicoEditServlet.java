package aap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Medico;
import aap.model.db.dao.MedicoDao;

public class MedicoEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		MedicoDao u = new MedicoDao();
		
		Medico medico = null;
		
		medico = u.getMedico(id);
		
		if(medico != null) {
			request.setAttribute("medico", medico);
			RequestDispatcher rd = request.getRequestDispatcher("editarMedico.jsp");
			rd.forward(request, response);
		}
	}
}
