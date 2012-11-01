package aap.model.db.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import aap.model.Historico;
import aap.model.db.ConnectionFactory;

public class HistoricoDAO {

	public void insert(Historico historico) throws IOException {
		
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "INSERT INTO Historico (idade, foto, peso, altura, imc, observacoes, medicamentos, id_consulta)"
					+ " VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement st = c.prepareStatement(sql);

			FileItem foto = historico.getFotoItem();// pega o FotoItem e não a foto! utilizado apenas para armazenar!
			
			st.setInt(1, historico.getIdade());
			st.setBinaryStream(2, foto.getInputStream(), (int) foto.getSize()); 
			// este é o propósito de se utilizar dois parâmetros foto! (um armazena e o outro recupera)
            st.setFloat(3, historico.getPeso());
			st.setInt(4, historico.getAltura()); 
			st.setFloat(5 , historico.getImc());
			st.setString(6, historico.getObservacoes());
			st.setString(7, historico.getMedicamentos());
			st.setInt(8, historico.getId_consulta());			
			
			st.execute();
			st.close();
			c.close();
			
		} catch (SQLException e) {
			System.out.println("Erro no Insert do ConsultaDAO");
			e.printStackTrace();
		}
	}
	
	public Historico getHistorico(int id) {
		
		Historico historico = new Historico();
		
		try {
			Connection c = ConnectionFactory.createConnection();
			Statement s = c.createStatement();

			String sql = "SELECT * FROM Historico WHERE idHistorico=?";
			PreparedStatement st = c.prepareStatement(sql);
			st.setInt(1, id);

			ResultSet result = st.executeQuery();

			while (result.next()) {
				historico.setIdHistorico(result.getInt("idHistorico")); 
				historico.setIdade(result.getInt("idade"));
				historico.setFoto(result.getBlob("foto")); //pega o ByteCode da Foto (foto - utilizada para recuperação)
				historico.setPeso(result.getFloat("peso"));
				historico.setAltura(result.getInt("altura")); // altura em centimetros
				historico.setImc(result.getFloat("imc"));
				historico.setObservacoes(result.getString("observacoes"));
				historico.setId_consulta(result.getInt("id_consulta"));
			}
			
			st.close();
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return historico;
	}
	
	
	public List<Historico> getListaHistorico(int id) {
		
		List <Historico> prontuarios = new ArrayList<Historico>();
		
		try {
			
			Connection c = ConnectionFactory.createConnection();
			String sql = "SELECT * FROM Historico WHERE id_consulta=?";
			
			PreparedStatement st = c.prepareStatement(sql);
			
			st.setInt(1, id);
			
			ResultSet result = st.executeQuery();

			while (result.next()) {
				Historico historico = new Historico();
				
				historico.setIdHistorico(result.getInt("idHistorico")); 
				historico.setIdade(result.getInt("idade"));
				historico.setFoto(result.getBlob("foto")); 
				//pega o ByteCode e seta a FOTO (importante FOTO = recuperar, FOTOITEM = salvar!)
				historico.setPeso(result.getFloat("peso"));
				historico.setAltura(result.getInt("altura")); // altura em centimetros
				historico.setImc(result.getFloat("imc"));
				historico.setObservacoes(result.getString("observacoes"));
				historico.setId_consulta(result.getInt("id_consulta"));
				
				prontuarios.add(historico); // adicona  na Lista de prontuários do histórico
				
			}
			
			st.close();
			c.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return prontuarios; // retorna a lista com todo o histórico do BD
	}
	
	public List<Historico> buscaConsulta(String idPaciente) {
		Connection conexao = ConnectionFactory.createConnection();

		StringBuilder sb = new StringBuilder("SELECT * FROM Historico INNER JOIN Consulta ON Consulta.idPaciente = ? AND Historico.id_consulta=Consulta.idConsulta GROUP BY Historico.idHistorico");
		PreparedStatement st;
		ResultSet rs;
		List<Historico> achados;
		achados = new ArrayList<Historico>();

		try {
			st = (PreparedStatement) conexao.prepareStatement(sb.toString());
			st.setInt(1, Integer.parseInt(idPaciente));
			st.execute();
			rs = st.getResultSet();

			while (rs.next()) {
				Historico historico = new Historico();
				historico.setIdHistorico(rs.getInt("idHistorico"));
				historico.setIdade(rs.getInt("idade"));
				historico.setAltura(rs.getInt("altura"));
				historico.setImc(rs.getInt("imc"));
				historico.setMedicamentos(rs.getString("medicamentos"));
				historico.setObservacoes(rs.getString("observacoes"));
				historico.setPeso(rs.getInt("peso"));
				historico.setId_consulta(rs.getInt("id_consulta"));
				historico.setDataTimeConsulta(rs.getTimestamp("Consulta.dataTimeConsulta"));
				achados.add(historico);
			}
			rs.close();
			st.close();
			conexao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return achados;
	}


		
}
