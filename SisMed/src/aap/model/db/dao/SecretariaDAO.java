package aap.model.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import aap.model.Secretaria;
import aap.model.db.ConnectionFactory;


public class SecretariaDAO {

	public void add(Secretaria sec) {
		
		String sql = "Insert into Secretaria (nome, dataNascimento, rg, cpf, telefoneResidencial, telefoneCelular, email, senha, estado, cidade, endereco, numero, complemento) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// par�metros do SQL da inser��o da secret�ria

		try {
			// pede para a f�brica de conex�es uma nova conex�o
			Connection con = ConnectionFactory.createConnection();
			// prepara a conex�o com os par�metros feitos na String sql acima
			PreparedStatement st = con.prepareStatement(sql);
				
			Date dt = sec.getDataNascimento();
			Long data = dt.getTime();		
			
			/*
			  Datas do java.util.Date e java.sql.Date s�o diferentes, 
			  logo � necess�rio fazer uma modifica��o de um para o outro, 
			  todas as datas s�o Longs, ent�o pega-se o valor da data de nascimento 
			  da Secretaria e innstancia-se uma data do tipo sql para salvar no BD			
			*/

			st.setString(1, sec.getNome());	
			st.setDate(2, new java.sql.Date(data));
			st.setString(3, sec.getRg());
			st.setString(4, sec.getCpf());
			st.setString(5, sec.getTelResidencial());
			st.setString(6, sec.getCelular());
			st.setString(7, sec.getEmail());
			st.setString(8, sec.getSenha());
			st.setString(9, sec.getEstado());
			st.setString(10, sec.getCidade());
			st.setString(11, sec.getEndereco());
			st.setInt(12, sec.getNumero());
			st.setString(13, sec.getComplemento());
						
			st.execute(); // executa a instru��o
			st.close();// fecha a conex�o com o BD
			con.close();
			
			System.out
					.println("Inseriu Secret�ria" + sec.getNome() + " no BD!"); // print da mensagem de sucesso

		} catch (Exception e) {
			System.out.println("N�o inseriu no Banco de dados"); // mostra a mensagem
			e.printStackTrace(); // imprime qual foi o erro
		}
	}

	public boolean remove(int id) {
		
		Connection con = ConnectionFactory.createConnection();
		String sql = "Delete from Secretaria where idSecretaria = ?";
		boolean bo = false;
		
		try {
			PreparedStatement st = con.prepareStatement(sql); // prepara a conex�o
			st.setInt(1, id);
			st.execute();
			bo = true;
			
			st.close();
			con.close();
			
		} catch (Exception e) {
			System.out.println("N�o Removeu do Banco de dados");
			e.printStackTrace(); // imprime o erro
		}
		
		return bo;
	}

	// retorna a lista de usu�rios do Banco de Dados
	public List getLista() {
	
		String sql = "Select * from Secretaria";// comando que ser� utilizado na conex�o com o BD
		List<Secretaria> Secretarias = new ArrayList<Secretaria>(); // cria um novo arrayList de Secretarias
		
		Date dt;
		Long data; 
		Date dataNormal = null;
		String msg;
		
		try {
			Connection con = ConnectionFactory.createConnection();// pede uma conex�o para a f�brica
			PreparedStatement st = con.prepareStatement(sql); // prepara a conex�o com o BD com o par�metro que foi escrito na String sql
			ResultSet rs = st.executeQuery(); // resultado da execu��o da busca no Banco de dados

			while (rs.next()) { // enquanto encontrar dados no BD ele continua
				Secretaria s = new Secretaria(); // inst�ncia uma nova secret�ria
				
				dt = rs.getDate("dataNascimento");//pega a data em sql e faz um cast para String
				dataNormal = (Date) dt;
				
				// pega cada um dos dados das secret�rias do Banco de dados e adiciona na secret�ria que foi instanciada
				
				s.setId(rs.getInt("idSecretaria")); 
				s.setNome(rs.getString("nome")); 
				s.setDataNascimento(dataNormal); // coloca a data no formato normal
				s.setRg(rs.getString("rg"));
				s.setCpf(rs.getString("cpf"));
				s.setTelResidencial(rs.getString("telefoneResidencial"));
				s.setCelular(rs.getString("telefoneCelular"));
				s.setEmail(rs.getString("email"));
				s.setSenha(rs.getString("senha")); // TODO: verificar a criptografia da Senha
				s.setEstado(rs.getString("estado"));
				s.setCidade(rs.getString("cidade"));
				s.setEndereco(rs.getString("endereco"));
				s.setNumero(rs.getInt("numero"));
				s.setComplemento(rs.getString("complemento")); 
				
				Secretarias.add(s); // adiciona a secret�ria no array de secret�rias
			}

		} catch (SQLException e) {
			System.out.println("Erro ao Listar secret�rias.");
			e.printStackTrace(); // imprime o erro
		}
		
		return Secretarias; // retorna o array que foi modificado com as secret�rias do BD
	}


public Secretaria getSecretaria(int id) {
		Secretaria sec = new Secretaria();
		String sql = "select * from Secretaria where idSecretaria = ?";

		java.sql.Date dt;// Datas normais e SQL s�o diferentes. Necess�rio convers�o
		Long data; 
		Date dataNormal;
		
		try {
			Connection c = ConnectionFactory.createConnection(); // pede a conex�o para a f�brica
			PreparedStatement st = c.prepareStatement(sql);// modela a string sql
			
			st.setInt(1, id);
			st.execute();

			ResultSet rs = st.executeQuery(); // resultado da execu��o da busca no Banco de dados

			while (rs.next()) { // enquanto encontrar dados no BD ele continua
				
				dt = rs.getDate("dataNascimento");//pega a data em sql e faz um cast para String
				dataNormal = (Date) dt;
				
				// pega cada um dos dados das secret�rias do Banco de dados e adiciona na secret�ria que foi instanciada
				sec.setId(rs.getInt("idSecretaria")); 
				sec.setNome(rs.getString("nome"));
				sec.setDataNascimento(dataNormal); // coloca a data no formato normal
				sec.setRg(rs.getString("rg"));
				sec.setCpf(rs.getString("cpf"));
				sec.setTelResidencial(rs.getString("telefoneResidencial"));
				sec.setCelular(rs.getString("telefoneCelular"));
				sec.setEmail(rs.getString("email"));
				sec.setSenha(rs.getString("senha")); // TODO: verificar a criptografia da Senha
				sec.setEstado(rs.getString("estado"));
				sec.setCidade(rs.getString("cidade"));
				sec.setEndereco(rs.getString("endereco"));
				sec.setNumero(rs.getInt("numero"));
				sec.setComplemento(rs.getString("complemento")); 
			}
			
			st.close();
			c.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao pegar usu�rio de id " + id);
		}

		return sec;
	}

	public Secretaria existe(String nome, String senha) {
		Secretaria sec = null;
		String sql = "select * from usuario where nome = ? and senha = ?";
		
		try {
			Connection con = ConnectionFactory.createConnection();
			PreparedStatement st = con.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				if (rs.getString("nome").equals(nome)
						&& rs.getString("senha").equals(senha)) {
					sec = this.getSecretaria(rs.getInt("id")); // chama a fun��o que busca o usu�rio e o retorna do BD
				}
			}
			st.close();
			con.close();
		} catch (Exception e) {
			System.out.println("Erro ao verificar se login existe");
			e.printStackTrace();
		}
		return sec;
	}

	public boolean modifica(Secretaria s) {
		String sql = "UPDATE Secretaria SET nome = ?, dataNascimento = ?, rg = ?, cpf = ?, telefoneResidencial = ?, telefoneCelular = ?, email = ?, senha = ?, estado = ?, cidade = ?, endereco = ?, numero = ?, complemento = ? WHERE idSecretaria = ?;";
				
		boolean bo = false;
		
		try {
			Connection con = ConnectionFactory.createConnection();
			PreparedStatement st = con.prepareStatement(sql);
			
			Date dt = s.getDataNascimento();
			Long data = dt.getTime(); // pega a representa��o do valor da data em Long
			
			st.setString(1, s.getNome());
			st.setDate  (2, new java.sql.Date(data)); // coloca a data em Long no formato do SQL
			st.setString(3, s.getRg());
			st.setString(4, s.getCpf());
			st.setString(5, s.getTelResidencial());
			st.setString(6, s.getCelular());
			System.out.println("Celular = "+s.getCelular());
			st.setString(7, s.getEmail());
			st.setString(8, s.getSenha());
			st.setString(9, s.getEstado());
			st.setString(10, s.getCidade());
			st.setString(11, s.getEndereco());
			st.setInt(12, s.getNumero());
			st.setString(13, s.getComplemento());
			st.setInt(14, s.getId());
			
			System.out.println("ID da Modificação = "+ s.getId());
			System.out.println("Nome da Secretária = "+ s.getNome());
			
			st.execute();
			st.executeUpdate();
			
			System.out.println("Editou Secretária!");
			bo = true;
			
			st.close(); // fecha as conex�es
			con.close();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao editar no SecretariaDAO");
		}

		return bo;
	}
	
}
