package aap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Paciente;
import aap.model.db.dao.PacienteDao;

public class PacienteEditServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		PacienteDao u = new PacienteDao();
		
		Paciente paciente = null;
		
		paciente = u.getPaciente(id);
		
		if(paciente != null) {
			request.setAttribute("paciente", paciente);
			RequestDispatcher rd = request.getRequestDispatcher("editarPaciente.jsp");
			rd.forward(request, response);
		}
	}
}
