package aap.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.db.ConnectionFactory;
import aap.model.db.dao.SecretariaDAO;

public class RemoverSecretariaServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		boolean removeu = false;
		String msg = ""; 
		String nome = req.getParameter("nome");
		
		int id = Integer.parseInt(req.getParameter("id"));
		// pede uma conex�o para a f�brica
		Connection con = ConnectionFactory.createConnection();
		// cria um Usu�rio de acesso ao banco
		SecretariaDAO dao = new SecretariaDAO();
		
		System.out.println("Id = " + id); 
		removeu = dao.remove(id); // remove pelo ID

		// operador tern�rio, verifica se secret�ria foi removida do BD e inclui na mensagem de sa�da
		msg = removeu ? "Secretária "+nome+" removida com sucesso" : "Secretária "+nome+" não pode ser removida!" ;
		req.setAttribute("msg", msg); // adiciona a mensagem na requisi��o
		// redireciona para a listagem, com a mensagem
		RequestDispatcher rd = req.getRequestDispatcher("ListarSecretarias.jsp");
		rd.forward(req, resp);
	}

}
