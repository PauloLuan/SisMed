package aap.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import aap.model.Consulta;
import aap.model.Historico;
import aap.model.db.dao.ConsultaDAO;
import aap.model.db.dao.HistoricoDAO;

public class HistoricoCadastrarServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
				
		FileItem foto = null; // parse especial para salvar a foto no BD
		
		int idade = 0;
		float peso = 0;
		int altura = 0; 
		String observacoes = null;
		String medicamentos = null;
		int id_consulta = 0;
				
		try {
            // Apache Commons-Fileupload library classes
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload sfu  = new ServletFileUpload(factory);
            
            // parse request
            List items = sfu.parseRequest(req);//tranforma a requisição em uma lista de elementos   
            // get uploaded file
            foto = (FileItem) items.get(0);
            //pega o primeiro parâmetro da requisição (foto) e faz o cast pro tipo "arquivo"
            
            System.out.println(foto.getInputStream());
            
            FileItem  idad = (FileItem) items.get(1);
            idade =  Integer.parseInt(idad.getString());
            
            FileItem  pes = (FileItem) items.get(2);
            peso =  Integer.parseInt(pes.getString());
            
            FileItem alt = (FileItem) items.get(3);
            altura =  Integer.parseInt(alt.getString());

            FileItem obser = (FileItem) items.get(4);
            observacoes =  obser.getString();
            
            FileItem medicamen = (FileItem) items.get(5);
            medicamentos =  medicamen.getString();
            
            FileItem id = (FileItem) items.get(6);
            id_consulta =  Integer.parseInt(id.getString());
            
			// TODO: atenção o parâmetro nome não está no BD!! mas está nos
			// requisitos e agora?? não tem como armazenar o nome no histórico
			// ele está armazenado na consulta!!         		
    		
		}catch (Exception e) {
        	System.out.println("Erro ao Pegar a foto do Parâmetro");
			e.printStackTrace();
		}
		
		Historico his = new Historico();
		
		his.setIdade(idade);
		his.setFotoItem(foto); // fotoItem é utilizado para guardar no BD (IMPORTANTE foto é para recuperar fotoItem é para armazenar)
		his.setAltura(altura);
		his.setPeso(peso);
		his.setImc(peso/((altura/100f)*(altura/100f)));
		his.setObservacoes(observacoes);
		his.setMedicamentos(medicamentos);		
		his.setId_consulta(id_consulta);
		
		ConsultaDAO daoC = new ConsultaDAO();
		Consulta consulta = daoC.getConsulta(id_consulta);
		
		HistoricoDAO dao = new HistoricoDAO();
		dao.insert(his);// insere no BD através do DAO
		
		resp.sendRedirect("prontuario/ProntuarioPacienteServlet.do?idPaciente="+consulta.getIdPaciente());
	}

}
