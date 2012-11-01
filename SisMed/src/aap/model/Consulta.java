package aap.model;


import java.util.Date;

public class Consulta {
	private int idConsulta;
	private Date dataTimeConsulta;
	private String observacoes;
	private int idMedico;
	private int idPaciente;
	private String nomeMedico;
	private String nomePaciente;

	public int getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public int getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(int idMedico) {
		this.idMedico = idMedico;
	}

	public int getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(int idPaciente) {
		this.idPaciente = idPaciente;
	}

	public Date getDataTimeConsulta() {
		return (Date) dataTimeConsulta;
	}

	public void setDataTimeConsulta(Date dataConsulta) {
		this.dataTimeConsulta = dataConsulta;
	}

	public String getNomeMedico() {
		return nomeMedico;
	}

	public void setNomeMedico(String nomeMedico) {
		this.nomeMedico = nomeMedico;
	}

	public String getNomePaciente() {
		return nomePaciente;
	}

	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}

}
