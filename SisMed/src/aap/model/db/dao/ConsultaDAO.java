package aap.model.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import aap.model.Consulta;
import aap.model.db.dao.PacienteDao;
import aap.model.db.dao.MedicoDao;
import aap.model.db.ConnectionFactory;

public class ConsultaDAO {
	public List<Consulta> getList() {
		Connection conexao = ConnectionFactory.createConnection();
		List<Consulta> consulta = new ArrayList<Consulta>();
		String sql = "SELECT * FROM Consulta";
		PreparedStatement st;
		ResultSet rs;

		try {
			st = (PreparedStatement) conexao.prepareStatement(sql);
			st.execute();
			rs = st.getResultSet();

			while (rs.next()) {
				Consulta consultar = new Consulta();
				consultar.setIdConsulta(rs.getInt("idConsulta"));
				consultar.setObservacoes(rs.getString("observacoes"));
				consultar.setIdMedico(rs.getInt("idMedico"));
				consultar.setIdPaciente(rs.getInt("idPaciente"));
				consultar.setDataTimeConsulta(rs.getDate("dataTimeConsulta"));
				consulta.add(consultar);
			}

			rs.close();
			st.close();
			conexao.close();
			return consulta;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public int insert(Consulta consulta) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "INSERT INTO Consulta (dataTimeConsulta, observacoes, idMedico, idPaciente)"
					+ " VALUES(?, ?, ?, ?)";
			PreparedStatement st = c.prepareStatement(sql);
			
			st.setTimestamp(1, new java.sql.Timestamp(consulta.getDataTimeConsulta()
					.getTime()));
			
			st.setString(2, consulta.getObservacoes());
			st.setInt(3, consulta.getIdMedico());
			st.setInt(4, consulta.getIdPaciente());

			int added = st.executeUpdate();
			st.close();
			c.close();
			return added;
		} catch (SQLException e) {
			System.out.println("Erro no Insert do ConsultaDAO");
			e.printStackTrace();
		}
		return 0;
	}

	public int remove(int id) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "DELETE FROM Consulta WHERE idConsulta=?";
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

	public int edit(Consulta consulta) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "UPDATE Consulta SET dataTimeConsulta=?, observacoes=?, idMedico=? WHERE idConsulta=?";
			PreparedStatement st = c.prepareStatement(sql);
			
			st.setTimestamp(1, new java.sql.Timestamp(consulta.getDataTimeConsulta()
					.getTime()));
			st.setString(2, consulta.getObservacoes());
			st.setInt(3, consulta.getIdMedico());
			st.setInt(4, consulta.getIdConsulta());

			int added = st.executeUpdate();
			st.close();
			c.close();
			return added;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	public Consulta getConsulta(int id) {
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "SELECT * FROM Consulta WHERE idConsulta=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet result = st.executeQuery();

			while (result.next()) {
				Consulta consulta = new Consulta();
				consulta.setIdConsulta(result.getInt("idConsulta"));
				consulta.setIdMedico(result.getInt("idMedico"));
				consulta.setIdPaciente(result.getInt("idPaciente"));
				consulta.setObservacoes(result.getString("observacoes"));
				consulta.setDataTimeConsulta(result.getTimestamp("dataTimeConsulta"));
				consulta.setNomeMedico(new MedicoDao().getMedico(consulta.getIdMedico()).getNome());
				consulta.setNomePaciente(new PacienteDao().getPaciente(consulta.getIdPaciente()).getNome());
				
			

				st.close();
				c.close();
				return consulta;
			}

			st.close();
			c.close();

			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Consulta> search(String paciente, String medico, String data) {
		List<Consulta> consultas = new ArrayList<Consulta>();
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();
			
			if(paciente == null)
				paciente = "";
			if(medico == null)
				medico = "";
			if(data == null)
				data = "";

			String sql = "SELECT *, DATE_FORMAT(Consulta.dataTimeConsulta, '%d/%m/%X') as sort_date FROM Consulta INNER JOIN Paciente ON (Paciente.nome LIKE ? OR '' = ?) AND Consulta.idPaciente = Paciente.idPaciente INNER JOIN Medico ON (Medico.nome LIKE ? OR '' = ?) AND Consulta.idMedico = Medico.idMedico WHERE (DATE_FORMAT(Consulta.dataTimeConsulta, '%d/%m/%X') = ? OR '' = ? ) GROUP BY Consulta.idConsulta ORDER BY sort_date DESC, dataTimeConsulta ASC";
			PreparedStatement st = c.prepareStatement(sql);
			st.setString(1, "%" + paciente + "%");
			st.setString(2, paciente);
			st.setString(3, "%" + medico + "%");
			st.setString(4, medico);
			st.setString(5, data);
			st.setString(6, data);
			

			ResultSet result = st.executeQuery();
			
			while(result.next()) {
				
				Consulta consulta = new Consulta();
				consulta.setDataTimeConsulta(result.getTimestamp("dataTimeConsulta"));
				consulta.setNomeMedico(result.getString("Medico.nome"));
				consulta.setNomePaciente(result.getString("Paciente.nome"));
				consulta.setIdConsulta(result.getInt("Consulta.idConsulta"));
				consulta.setIdPaciente(result.getInt("Consulta.idPaciente"));
				consulta.setIdMedico(result.getInt("Consulta.idMedico"));
				
				consultas.add(consulta);
			}
			
			//System.out.println(st.toString());
			
			st.close();
			c.close();
			
			return consultas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
