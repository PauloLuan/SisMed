package aap.model;

import java.sql.Blob;
import java.util.Date;

import org.apache.commons.fileupload.FileItem;

public class Historico {
	private int idHistorico; 
	private int idade;
	private Blob foto; // utiilizado para recuperar e mostrar na tela
	private FileItem fotoItem; // utilizado para salvar no BD (para pegar a stream de Bytes e fazer a conversão)
	private float peso;
	private int altura;
	private float imc;
	private String observacoes;
	private String medicamentos;
	private int id_consulta;
	private Date dataTimeConsulta;
	
	public int getIdHistorico() {
		return idHistorico;
	}
	public void setIdHistorico(int idHistorico) {
		this.idHistorico = idHistorico;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Blob getFoto() {
		return foto;
	}
	public void setFoto(Blob foto) {
		this.foto = foto;
	}
	public float getPeso() {
		return peso;
	}
	public void setPeso(float f) {
		this.peso = f;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public float getImc() {
		return imc;
	}
	public void setImc(float f) {
		this.imc = f;
	}
	public String getObservacoes() {
		return observacoes;
	}
	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}
	public String getMedicamentos() {
		return medicamentos;
	}
	public void setMedicamentos(String medicamentos) {
		this.medicamentos = medicamentos;
	}
	public int getId_consulta() {
		return id_consulta;
	}
	public void setId_consulta(int id_consulta) {
		this.id_consulta = id_consulta;
	}
	public void setFotoItem(FileItem fotoItem) {
		this.fotoItem = fotoItem;
	}
	public FileItem getFotoItem() {
		return fotoItem;
	}
	public Date getDataTimeConsulta() {
		return dataTimeConsulta;
	}
	public void setDataTimeConsulta(Date dataTimeConsulta) {
		this.dataTimeConsulta = dataTimeConsulta;
	}

}
