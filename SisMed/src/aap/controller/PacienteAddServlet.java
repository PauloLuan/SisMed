package aap.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Paciente;

import aap.model.db.dao.PacienteDao;

/**
 * Servlet implementation class UserAdd
 */
public class PacienteAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public PacienteAddServlet() {
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
		
		Date dataNascimento = null;
		
		try {
			dataNascimento = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(request.getParameter("dataNascimento"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Paciente a = new Paciente();
		a.setNome(request.getParameter("nome"));
		a.setDataNascimento(dataNascimento);
		a.setRg(request.getParameter("rg"));
		a.setCpf(request.getParameter("cpf"));
		a.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
		a.setTelefoneCelular(request.getParameter("telefoneCelular"));
		a.setEmail(request.getParameter("email"));
		a.setSenha(request.getParameter("senha"));
		a.setEstado(request.getParameter("estado"));
		a.setCidade(request.getParameter("cidade"));
		a.setEndereco(request.getParameter("endereco"));
		a.setNumero(Integer.parseInt(request.getParameter("numero")));
		a.setComplemento(request.getParameter("complemento"));
		
		PacienteDao dao = new PacienteDao();
		
		int resp = dao.insert(a);
		
		if(resp == 1)
			response.sendRedirect("pacientes.jsp?msg=Paciente cadastrado com sucesso!");
		else
			response.sendRedirect("pacientes.jsp?msg2=Paciente não cadastrado!");

	}

}
