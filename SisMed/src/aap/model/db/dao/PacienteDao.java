package aap.model.db.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import aap.model.Paciente;
import aap.model.db.ConnectionFactory;

public class PacienteDao {
	public int insert(Paciente paciente) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "" +
					"INSERT INTO Paciente (" +
					"nome," +
					"dataNascimento," +
					"rg," +
					"cpf," +
					"telefoneResidencial," +
					"telefoneCelular," +
					"email," +
					"senha," +
					"estado," +
					"cidade," +
					"endereco," +
					"numero," +
					"complemento" +
					")" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, paciente.getNome());
			st.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
			st.setString(3, paciente.getRg());
			st.setString(4, paciente.getCpf());
			st.setString(5, paciente.getTelefoneResidencial());
			st.setString(6, paciente.getTelefoneCelular());
			st.setString(7, paciente.getEmail());
			st.setString(8, paciente.getSenha());
			st.setString(9, paciente.getEstado());
			st.setString(10, paciente.getCidade());
			st.setString(11, paciente.getEndereco());
			st.setInt(12, paciente.getNumero());
			st.setString(13, paciente.getComplemento());

			int added = st.executeUpdate();
			st.close();
			c.close();
			return added;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int edit(Paciente paciente) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "" +
					"UPDATE Paciente SET " +
					"nome=?," +
					"dataNascimento=?," +
					"rg=?," +
					"cpf=?," +
					"telefoneResidencial=?," +
					"telefoneCelular=?," +
					"email=?," +
					"senha=?," +
					"estado=?," +
					"cidade=?," +
					"endereco=?," +
					"numero=?," +
					"complemento=? " +
					"WHERE idPaciente=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, paciente.getNome());
			st.setDate(2, new java.sql.Date(paciente.getDataNascimento().getTime()));
			st.setString(3, paciente.getRg());
			st.setString(4, paciente.getCpf());
			st.setString(5, paciente.getTelefoneResidencial());
			st.setString(6, paciente.getTelefoneCelular());
			st.setString(7, paciente.getEmail());
			st.setString(8, paciente.getSenha());
			st.setString(9, paciente.getEstado());
			st.setString(10, paciente.getCidade());
			st.setString(11, paciente.getEndereco());
			st.setInt(12, paciente.getNumero());
			st.setString(13, paciente.getComplemento());
			st.setInt(14, paciente.getIdPaciente());

			int added = st.executeUpdate();
			st.close();
			c.close();
			return added;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int remove(int id) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "DELETE FROM Paciente WHERE idPaciente=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, id);

			int added = st.executeUpdate();
			st.close();
			c.close();
			return added;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<Paciente> getList() {
		List<Paciente> users = new ArrayList<Paciente>();
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "SELECT * FROM Paciente";
			PreparedStatement st = c.prepareStatement(sql);
			

			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				
				Paciente user = new Paciente();
				user.setIdPaciente(result.getInt("idPaciente"));
				user.setNome(result.getString("nome"));
				user.setDataNascimento(result.getDate("dataNascimento"));
				user.setRg(result.getString("rg"));
				user.setCpf(result.getString("cpf"));
				user.setTelefoneResidencial(result.getString("telefoneResidencial"));
				user.setTelefoneCelular(result.getString("telefoneCelular"));
				user.setEmail(result.getString("email"));
				user.setSenha(result.getString("senha"));
				user.setEstado(result.getString("estado"));
				user.setCidade(result.getString("cidade"));
				user.setEndereco(result.getString("endereco"));
				user.setNumero(result.getInt("numero"));
				user.setComplemento(result.getString("complemento"));
				
				users.add(user);
			}
			
			st.close();
			c.close();
			
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Paciente> search(String nome, String rg, String cpf, String telefoneResidencial, String telefoneCelular, String email) {
		List<Paciente> users = new ArrayList<Paciente>();
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();
			
			if(nome == null)
				nome = "";
			if(rg == null)
				rg = "";
			if(cpf == null)
				cpf = "";
			if(telefoneResidencial == null)
				telefoneResidencial = "";
			if(telefoneCelular == null)
				telefoneCelular = "";
			if(email == null)
				email = "";

			String sql = "SELECT * FROM Paciente WHERE (nome LIKE ? OR ? = '') AND (rg LIKE ? OR ? = '') AND (cpf LIKE ? OR ? = '') AND (telefoneResidencial LIKE ? OR ? = '') AND (telefoneCelular LIKE ? OR ? = '') AND (email LIKE ? OR ? = '') ORDER BY nome ASC";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			st.setString(2, nome);
			st.setString(3, "%" + rg + "%");
			st.setString(4, rg);
			st.setString(5, "%" + cpf + "%");
			st.setString(6, cpf);
			st.setString(7, "%" + telefoneResidencial + "%");
			st.setString(8, telefoneResidencial);
			st.setString(9, "%" + telefoneCelular + "%");
			st.setString(10, telefoneCelular);
			st.setString(11, "%" + email + "%");
			st.setString(12, email);
			

			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				
				Paciente user = new Paciente();
				user.setIdPaciente(result.getInt("idPaciente"));
				user.setNome(result.getString("nome"));
				user.setDataNascimento(result.getDate("dataNascimento"));
				user.setRg(result.getString("rg"));
				user.setCpf(result.getString("cpf"));
				user.setTelefoneResidencial(result.getString("telefoneResidencial"));
				user.setTelefoneCelular(result.getString("telefoneCelular"));
				user.setEmail(result.getString("email"));
				user.setSenha(result.getString("senha"));
				user.setEstado(result.getString("estado"));
				user.setCidade(result.getString("cidade"));
				user.setEndereco(result.getString("endereco"));
				user.setNumero(result.getInt("numero"));
				user.setComplemento(result.getString("complemento"));
				
				users.add(user);
			}
			
			//System.out.println(st.toString());
			
			st.close();
			c.close();
			
			return users;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Paciente getPaciente(int id) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "SELECT * FROM Paciente WHERE idPaciente=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet result = st.executeQuery();
			
			while(result.next()) {	
				Paciente user = new Paciente();
				user.setIdPaciente(result.getInt("idPaciente"));
				user.setNome(result.getString("nome"));
				user.setDataNascimento(result.getDate("dataNascimento"));
				user.setRg(result.getString("rg"));
				user.setCpf(result.getString("cpf"));
				user.setTelefoneResidencial(result.getString("telefoneResidencial"));
				user.setTelefoneCelular(result.getString("telefoneCelular"));
				user.setEmail(result.getString("email"));
				user.setSenha(result.getString("senha"));
				user.setEstado(result.getString("estado"));
				user.setCidade(result.getString("cidade"));
				user.setEndereco(result.getString("endereco"));
				user.setNumero(result.getInt("numero"));
				user.setComplemento(result.getString("complemento"));
				st.close();
				c.close();
				return user;
			}
			
			st.close();
			c.close();
			
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
