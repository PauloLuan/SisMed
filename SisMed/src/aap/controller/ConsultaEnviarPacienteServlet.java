package aap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Paciente;
import aap.model.db.dao.PacienteDao;

/**
 * Servlet implementation class ConsultaEnviarPacienteServlet
 */
public class ConsultaEnviarPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaEnviarPacienteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PacienteDao dao = new PacienteDao();
		Paciente paciente = dao.getPaciente(Integer.parseInt(request.getParameter("id")));
		
		request.setAttribute("paciente", paciente);
		
		RequestDispatcher rd = request
				.getRequestDispatcher("/consulta/cadastrarConsulta.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
