package aap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Secretaria;
import aap.model.db.dao.SecretariaDAO;

public class EditarSecretariaServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Variáveis auxiliares
		String msg = "";
		String dtStr = null;
		
		// variáveis de Parâmetros
		int id = Integer.parseInt(req.getParameter("id"));//não é necessário checar pois o atributo vem automaticamente
		String nome = null;
		Date dt = null;
		String rg = null;
		String cpf = null;
		String telResidencial = null;
		String celular = null;
		String email = null;
		String senha = null;
		String estado = null;
		String cidade = null;
		String endereco = null;
		int numero = -1;
		String complemento = null;
		
		// Verificação de cada campo, identificando se é nulo ou não
		if (req.getParameter("nome") != null) {
			nome = req.getParameter("nome");
		}
		else {
			msg = "Nome Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (req.getParameter("dataNascimento") != null) {
			dtStr = req.getParameter("dataNascimento");
		}
		else {
			msg = "Data Inválida";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try{ // bloco de formata��o da data
			dt = new SimpleDateFormat("dd/mm/yyyy").parse(dtStr);
		}catch (ParseException e) {
			msg = "Erro na Formataçao da Data";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception ex) { 
				ex.printStackTrace();
			}
		}
		
		if (req.getParameter("rg") != null) {
			rg = req.getParameter("rg");
		}
		else {
			msg = "RG Inv‡lido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (req.getParameter("cpf") != null) {
			cpf = req.getParameter("cpf");
		}
		else {
			msg = "CPF Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (req.getParameter("telefoneResidencial") != null) {
			telResidencial = req.getParameter("telefoneResidencial");
		}
		else {
			msg = "Telefone Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (req.getParameter("telefoneCelular") != null) {
			celular = req.getParameter("telefoneCelular");
		}
		else {
			msg = "Celular Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (req.getParameter("email") != null) {
			email = req.getParameter("email");
		}
		else {
			msg = "Email Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (req.getParameter("senha") != null) {
			senha = req.getParameter("senha");
		}
		else {
			msg = "Senha Inválida";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (req.getParameter("estado") != null) {
			estado = req.getParameter("estado");
		}
		else {
			msg = "Estado Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (req.getParameter("cidade") != null) {
			cidade = req.getParameter("cidade");
		}
		else {
			msg = "Estado Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (req.getParameter("endereco") != null) {
			endereco = req.getParameter("endereco");
		}
		else {
			msg = "Endereco Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (Integer.parseInt(req.getParameter("numero")) != -1) {
			numero = Integer.parseInt(req.getParameter("numero"));
		}
		else {
			msg = "Nœmero Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (req.getParameter("complemento") != null) {
			complemento = req.getParameter("complemento");
		}
		else {
			msg = "Complemento Inválido";
			try {
				req.setAttribute("msg", msg);
				RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
				rd.forward(req, resp);	
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try {
			SecretariaDAO dao = new SecretariaDAO();
			// cria um Usuário de acesso ao banco

			// cria o usuario e salva os parametros
			Secretaria sec = new Secretaria();
			
			sec.setId(id);
			sec.setNome(nome);// adiciona cada parâmetro da requisição no objeto que será salvo
			sec.setDataNascimento(dt); // Verifique esta questão do Cast
			sec.setRg(rg);
			sec.setCpf(cpf);
			sec.setTelResidencial(telResidencial);
			sec.setCelular(celular);
			sec.setEmail(email);
			sec.setSenha(senha);
			sec.setEstado(estado);
			sec.setCidade(cidade);
			sec.setEndereco(endereco);
			sec.setNumero(numero);
			sec.setComplemento(complemento);
			
			dao.modifica(sec);

		} catch (Exception e) {
			System.out
					.println("Erro ao modificar usuário no EditarSecretariaServlet");
			e.printStackTrace();
		}
		resp.sendRedirect("ListarSecretarias.jsp");
	}
	
	
	/*
	public void despachar(String mensagem, HttpServletRequest req, HttpServletResponse resp){
		Erro ao editar no SecretariaDAO
		try {
			req.setAttribute("msg", mensagem);
			RequestDispatcher rd = req.getRequestDispatcher("secretaria/CadastroSecretaria.jsp");
			rd.forward(req, resp);	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/ 

}
