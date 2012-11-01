package aap.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Historico;
import aap.model.db.dao.HistoricoDAO;

public class HistoricoEnviarPost extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("idHistorico"));
		HistoricoDAO dao = new HistoricoDAO();
		Historico his = dao.getHistorico(id);
		req.setAttribute("historico", his);

		RequestDispatcher rd = req.getRequestDispatcher("prontuario/EditarHistorico.jsp");
		rd.forward(req, resp);

	}

}
