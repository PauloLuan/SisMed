package aap.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.db.dao.ConsultaDAO;

/**
 * Servlet implementation class RemoveConsultaServlet
 */
public class ConsultaRemoverServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		ConsultaDAO dao = new ConsultaDAO();

		int rep = dao.remove(id);

		if (rep == 1)
			response.sendRedirect("consultas.jsp?msg=Consulta apagada com sucesso!");
		else
			response.sendRedirect("consultas.jsp?msg2=Consulta não foi apagada!");

	}

}
