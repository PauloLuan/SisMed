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

import aap.model.Medico;

import aap.model.db.dao.MedicoDao;

/**
 * Servlet implementation class UserAdd
 */
public class MedicoAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public MedicoAddServlet() {
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
		
		Medico a = new Medico();
		a.setNome(request.getParameter("nome"));
		a.setDataNascimento(dataNascimento);
		a.setRg(request.getParameter("rg"));
		a.setCpf(request.getParameter("cpf"));
		a.setCrm(request.getParameter("crm"));
		a.setTelefoneResidencial(request.getParameter("telefoneResidencial"));
		a.setTelefoneCelular(request.getParameter("telefoneCelular"));
		a.setEmail(request.getParameter("email"));
		a.setSenha(request.getParameter("senha"));
		a.setEstado(request.getParameter("estado"));
		a.setCidade(request.getParameter("cidade"));
		a.setEndereco(request.getParameter("endereco"));
		a.setNumero(Integer.parseInt(request.getParameter("numero")));
		a.setComplemento(request.getParameter("complemento"));
		
		MedicoDao dao = new MedicoDao();
		
		int resp = dao.insert(a);
		
		if(resp == 1)
			response.sendRedirect("medicos.jsp?msg=Médico cadastrado com sucesso!");
		else
			response.sendRedirect("medicos.jsp?msg2=Médico não cadastrado!");

	}

}
