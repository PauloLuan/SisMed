package aap.model.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aap.model.Medico;
import aap.model.db.ConnectionFactory;


public class MedicoDao {
	public int insert(Medico medico) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "" +
					"INSERT INTO Medico (" +
					"nome," +
					"dataNascimento," +
					"rg," +
					"cpf," +
					"crm," +
					"telefoneResidencial," +
					"telefoneCelular," +
					"email," +
					"senha," +
					"estado," +
					"cidade," +
					"endereco," +
					"numero," +
					"complemento" +
					")" + " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, medico.getNome());
			st.setDate(2, new java.sql.Date(medico.getDataNascimento().getTime()));
			st.setString(3, medico.getRg());
			st.setString(4, medico.getCpf());
			st.setString(5, medico.getCrm());
			st.setString(6, medico.getTelefoneResidencial());
			st.setString(7, medico.getTelefoneCelular());
			st.setString(8, medico.getEmail());
			st.setString(9, medico.getSenha());
			st.setString(10, medico.getEstado());
			st.setString(11, medico.getCidade());
			st.setString(12, medico.getEndereco());
			st.setInt(13, medico.getNumero());
			st.setString(14, medico.getComplemento());

			int added = st.executeUpdate();
			st.close();
			c.close();
			return added;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public int edit(Medico medico) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "" +
					"UPDATE Medico SET " +
					"nome=?," +
					"dataNascimento=?," +
					"rg=?," +
					"cpf=?," +
					"crm=?," +
					"telefoneResidencial=?," +
					"telefoneCelular=?," +
					"email=?," +
					"senha=?," +
					"estado=?," +
					"cidade=?," +
					"endereco=?," +
					"numero=?," +
					"complemento=? " +
					"WHERE idMedico=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, medico.getNome());
			st.setDate(2, new java.sql.Date(medico.getDataNascimento().getTime()));
			st.setString(3, medico.getRg());
			st.setString(4, medico.getCpf());
			st.setString(5, medico.getCrm());
			st.setString(6, medico.getTelefoneResidencial());
			st.setString(7, medico.getTelefoneCelular());
			st.setString(8, medico.getEmail());
			st.setString(9, medico.getSenha());
			st.setString(10, medico.getEstado());
			st.setString(11, medico.getCidade());
			st.setString(12, medico.getEndereco());
			st.setInt(13, medico.getNumero());
			st.setString(14, medico.getComplemento());
			st.setInt(15, medico.getIdMedico());

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

			String sql = "DELETE FROM Medico WHERE idMedico=?";
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
	
	public List<Medico> getList() {
		List<Medico> users = new ArrayList<Medico>();
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "SELECT * FROM Medico";
			PreparedStatement st = c.prepareStatement(sql);
			

			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				
				Medico user = new Medico();
				user.setIdMedico(result.getInt("idMedico"));
				user.setNome(result.getString("nome"));
				user.setDataNascimento(result.getDate("dataNascimento"));
				user.setRg(result.getString("rg"));
				user.setCpf(result.getString("cpf"));
				user.setCrm(result.getString("crm"));
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
	
	public List<Medico> search(String nome, String rg, String cpf, String crm, String telefoneResidencial, String telefoneCelular, String email) {
		List<Medico> users = new ArrayList<Medico>();
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();
			
			if(nome == null)
				nome = "";
			if(rg == null)
				rg = "";
			if(cpf == null)
				cpf = "";
			if(crm == null)
				crm = "";
			if(telefoneResidencial == null)
				telefoneResidencial = "";
			if(telefoneCelular == null)
				telefoneCelular = "";
			if(email == null)
				email = "";

			String sql = "SELECT * FROM Medico WHERE (nome LIKE ? OR ? = '') AND (rg LIKE ? OR ? = '') AND (cpf LIKE ? OR ? = '') AND (crm LIKE ? OR ? = '') AND (telefoneResidencial LIKE ? OR ? = '') AND (telefoneCelular LIKE ? OR ? = '') AND (email LIKE ? OR ? = '') ORDER BY nome ASC";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, "%" + nome + "%");
			st.setString(2, nome);
			st.setString(3, "%" + rg + "%");
			st.setString(4, rg);
			st.setString(5, "%" + cpf + "%");
			st.setString(6, cpf);
			st.setString(7, "%" + crm + "%");
			st.setString(8, crm);
			st.setString(9, "%" + telefoneResidencial + "%");
			st.setString(10, telefoneResidencial);
			st.setString(11, "%" + telefoneCelular + "%");
			st.setString(12, telefoneCelular);
			st.setString(13, "%" + email + "%");
			st.setString(14, email);
			

			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				
				Medico user = new Medico();
				user.setIdMedico(result.getInt("idMedico"));
				user.setNome(result.getString("nome"));
				user.setDataNascimento(result.getDate("dataNascimento"));
				user.setRg(result.getString("rg"));
				user.setCpf(result.getString("cpf"));
				user.setCrm(result.getString("crm"));
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
	
	public Medico getMedico(int id) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "SELECT * FROM Medico WHERE idMedico=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet result = st.executeQuery();
			
			while(result.next()) {	
				Medico user = new Medico();
				user.setIdMedico(result.getInt("idMedico"));
				user.setNome(result.getString("nome"));
				user.setDataNascimento(result.getDate("dataNascimento"));
				user.setRg(result.getString("rg"));
				user.setCpf(result.getString("cpf"));
				user.setCrm(result.getString("crm"));
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
