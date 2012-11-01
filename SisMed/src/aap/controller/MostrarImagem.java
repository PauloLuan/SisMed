package aap.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aap.model.Historico;
import aap.model.db.dao.HistoricoDAO;

/**
 * Servlet implementation class MostrarImagem
 */
public class MostrarImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
	
	    try {
	    
	    	int id = Integer.parseInt(req.getParameter("idFoto")); // pega o ID da JSP
	    	HistoricoDAO dao = new HistoricoDAO();
	        Historico his = dao.getHistorico(id);
	        
	        Blob  b = his.getFoto(); // pega o Blobo da Foto
	        
	        System.out.println("Servlet");
	        resp.setContentType("image/jpeg");
	        resp.setContentLength( (int) b.length());
	        
	        InputStream is = b.getBinaryStream();
	        OutputStream os = resp.getOutputStream();
	        
	        byte buf[] = new byte[(int) b.length()];
	        is.read(buf);
	        os.write(buf);
	        os.close();

	    }
	    catch(Exception ex) {
	        System.out.println("Erro da Servlet de Display" + ex.getMessage());
	        ex.printStackTrace();
	    }
	}
	

}

