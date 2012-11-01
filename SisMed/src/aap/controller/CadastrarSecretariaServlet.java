package aap.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Secretaria;
import aap.model.db.dao.SecretariaDAO;

public class CadastrarSecretariaServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		// Vari�veis auxiliares
		String msg = "";
		String dtStr = null;
		
		// vari�veis de Par�metros
		String nome = null;
		java.util.Date dt = null;
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
		
		// Verifica��o de cada campo, identificando se � nulo ou n�o
		if (req.getParameter("nome") != "") {
			System.out.println("Entrou no If do nome");
			nome = req.getParameter("nome"); 
		}
		else {
			msg = "Nome Inválido";
			req.setAttribute("msg", msg);
			RequestDispatcher rd = req.getRequestDispatcher("CadastroSecretaria.jsp");
			rd.forward(req, resp);
			System.out.println("Entrou no Else do nome , Despachou!");
		}
		
		
		if (req.getParameter("dataNascimento") != null) {
			dtStr = req.getParameter("dataNascimento");
		}
		else {
			msg = "Data Inválida";
			despachar(msg, req, resp);
		}
		
		try{ // bloco de formata��o da data
			dt = new SimpleDateFormat("dd/mm/yyyy").parse(dtStr);
		}catch (ParseException e) {
			msg = "Erro na Formatação da Data";
			despachar(msg, req, resp);
		}
		
		if (req.getParameter("rg") != null) {
			rg = req.getParameter("rg");
		}
		else {
			msg = "RG Inválido";
			despachar(msg, req, resp);
		}
		
		if (req.getParameter("cpf") != null) {
			cpf = req.getParameter("cpf");
		}
		else {
			msg = "CPF Inválido";
			despachar(msg, req, resp);
		}

		if (req.getParameter("telefone") != null) {
			telResidencial = req.getParameter("telefone");
		}
		else {
			msg = "Telefone Inválido";
			despachar(msg, req, resp);
		}

		if (req.getParameter("celular") != null) {
			celular = req.getParameter("celular");
		}
		else {
			msg = "Celular Inválido";
			despachar(msg, req, resp);
		}

		if (req.getParameter("email") != null) {
			email = req.getParameter("email");
		}
		else {
			msg = "Email Inválido";
			despachar(msg, req, resp);
		}

		if (req.getParameter("senha") != null) {
			senha = req.getParameter("senha");
		}
		else {
			msg = "Senha Inválida";
			despachar(msg, req, resp);
		}

		if (req.getParameter("estado") != null) {
			estado = req.getParameter("estado");
		}
		else {
			msg = "Estado Inválido";
			despachar(msg, req, resp);
		}
		
		if (req.getParameter("cidade") != null) {
			cidade = req.getParameter("cidade");
		}
		else {
			msg = "Estado Inválido";
			despachar(msg, req, resp);
		}
		
		if (req.getParameter("endereco") != null) {
			endereco = req.getParameter("endereco");
		}
		else {
			msg = "Endereco Inválido";
			despachar(msg, req, resp);
		}
		
		if (req.getParameter("numero") != null) {
			numero = Integer.parseInt(req.getParameter("numero"));
		}
		else {
			msg = "Número Inválido";
			despachar(msg, req, resp);
		}
		
		if (req.getParameter("complemento") != null) {
			complemento = req.getParameter("complemento");
		}
		else {
			msg = "Complemento Inválido";
			despachar(msg, req, resp);
		}
		
		List <Secretaria> secretarias; // lista das secret�rias do BD
		
		// cria o usuario e salva os parametros da requisi��o
		Secretaria sec = new Secretaria(); // Objeto que ser� armazenado no BD
		sec.setNome(nome);// adiciona cada par�metro da requisi��o no objeto que ser� salvo
		sec.setDataNascimento(dt);
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
				
		try {
			SecretariaDAO secDao = new SecretariaDAO();// cria um Usu�rio de acesso ao banco
			secretarias = secDao.getLista(); // pega a lista das secret�rias cadastradas no BD
						
			for (Secretaria s : secretarias) {
				if (s.getRg().equals(sec.getRg())
						|| s.getCpf().equals(sec.getCpf())) { // rg e cpf s�o �nicos!
					msg = "Secretária Já existe no Banco de dados";
					despachar(msg,req,resp);
					System.out.println("Secretária já existe!");
				
				}
			}

			secDao.add(sec); // adiciona a secret�ria (encapsulada) no BD atrav�s da SecretariaDAO

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao cadastrar Secretária No BD");
		}

		// redireciona para a listagem, com a mensagem
		resp.sendRedirect("ListarSecretarias.jsp");

	}
	
	public void despachar(String mensagem, HttpServletRequest req, HttpServletResponse resp){
		req.setAttribute("msg", mensagem);
		RequestDispatcher rd = req.getRequestDispatcher("CadastroSecretaria.jsp");
		
		try {
			rd.forward(req, resp);
		} catch (ServletException e) {
			System.out.println("Erro de Servlet");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Erro de IO");
		}	
	}

}
