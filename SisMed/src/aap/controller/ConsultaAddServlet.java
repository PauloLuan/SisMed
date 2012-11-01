package aap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.db.dao.ConsultaDAO;
import aap.model.Consulta;

public class ConsultaAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String data = request.getParameter("data") + " - " + request.getParameter("hora");

		Date dataConsulta = null;

		try {
			dataConsulta = (Date) new SimpleDateFormat("dd/MM/yyyy - HH:mm")
					.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Consulta consulta = new Consulta();

	
		consulta.setObservacoes(request.getParameter("observacoes"));
		consulta.setIdMedico (Integer.parseInt( request.getParameter("idMedico")));
		consulta.setIdPaciente (Integer.parseInt( request.getParameter("idPaciente")));
		consulta.setDataTimeConsulta(dataConsulta);

		ConsultaDAO dao = new ConsultaDAO();

		int resp = dao.insert(consulta);

		if (resp == 1)
			response.sendRedirect("consultas.jsp?msg=Consulta cadastrada com sucesso!");
		else
			response.sendRedirect("consultas.jsp?msg2=Consulta não cadastrada!");

	}

}
