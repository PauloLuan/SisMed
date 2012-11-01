package aap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Consulta;
import aap.model.db.dao.ConsultaDAO;

/**
 * Servlet implementation class EditSaveConsultaServlet
 */
public class ConsultaEditSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = request.getParameter("data") + " - " + request.getParameter("hora");

		Date dataConsulta = null;

		try {
			dataConsulta = (Date) new SimpleDateFormat("dd/MM/yyyy - HH:mm")
					.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Consulta consulta = new Consulta();

		consulta.setIdConsulta(Integer.parseInt(request.getParameter("idConsulta")));
		consulta.setDataTimeConsulta(dataConsulta);
		consulta.setObservacoes(request.getParameter("observacoes"));
		consulta.setIdMedico(Integer.parseInt(request.getParameter("idMedico")));
		
		//System.out.println(consulta.getIdConsulta() + " - " + consulta.getDataTimeConsulta() + " - " + consulta.getObservacoes() + " - " + consulta.getIdMedico());

		ConsultaDAO dao = new ConsultaDAO();


		int resp = dao.edit(consulta);

		if (resp == 1)
			response.sendRedirect("consultas.jsp?msg=Consulta alterada com sucesso!");
		else
			response.sendRedirect("consultas.jsp?msg2=Consulta não foi alterada!");

	}

}
