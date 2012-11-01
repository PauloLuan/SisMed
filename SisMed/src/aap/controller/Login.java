package aap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import aap.model.db.ConnectionFactory;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String email = request.getParameter("email");
		String senha = request.getParameter("senha");

		try {

			int logged = 0;

			// Secret�ria
			Connection c = ConnectionFactory.createConnection();

			String sql = "SELECT * FROM Secretaria WHERE email=? AND senha=?";

			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);

			ResultSet result = st.executeQuery();

			if (result.next() == true) {
				logged = 1;
				session.setAttribute("tipo", "Secretaria");
				session.setAttribute("id", result.getInt("idSecretaria"));
				session.setAttribute("nome", result.getString("nome"));
				session.setAttribute("autorizado", 1);
			}

			sql = "SELECT * FROM Medico WHERE email=? AND senha=?";

			st = c.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);

			result = st.executeQuery();

			if (result.next() == true) {
				logged = 1;
				session.setAttribute("tipo", "Medico");
				session.setAttribute("id", result.getInt("idMedico"));
				session.setAttribute("nome", result.getString("nome"));
				session.setAttribute("autorizado", 1);
			}
			
			sql = "SELECT * FROM Paciente WHERE email=? AND senha=?";

			st = c.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, senha);

			result = st.executeQuery();

			if (result.next() == true) {
				logged = 1;
				session.setAttribute("tipo", "Paciente");
				session.setAttribute("id", result.getInt("idPaciente"));
				session.setAttribute("nome", result.getString("nome"));
				session.setAttribute("autorizado", 1);
			}

			if (logged == 0) {
				response.sendRedirect("login/login.jsp?msg=Email ou Senha inválidos");
			} else {
				response.sendRedirect("index.jsp");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
