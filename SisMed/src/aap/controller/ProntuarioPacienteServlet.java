package aap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Historico;
import aap.model.Paciente;
import aap.model.db.dao.HistoricoDAO;
import aap.model.db.dao.PacienteDao;

public class ProntuarioPacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub

		String idPaciente = request.getParameter("idPaciente");

		HistoricoDAO dao = new HistoricoDAO();

		List<Historico> achado = dao.buscaConsulta(idPaciente);
		
		PacienteDao pacienteDao = new PacienteDao();
		
		Paciente paciente = pacienteDao.getPaciente(Integer.parseInt(idPaciente));
		
		request.setAttribute("paciente", paciente);

		request.setAttribute("prontuarios", achado);
		RequestDispatcher rd = request
				.getRequestDispatcher("/prontuario/prontuario.jsp");
		rd.forward(request, response);
	}

}
