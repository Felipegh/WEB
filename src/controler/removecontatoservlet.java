package controler;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Contato;
import modelo.ContatoDao;

@WebServlet("/removecontato")
public class removecontatoservlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
				
				//Busca o Writer
				PrintWriter out = response.getWriter();
				
				// pegando os parâmetros do request
				String nome = request.getParameter("nome");
				
							
				//System.out.println(nome);
				
				//System.out.println("Montando Objeto");
				// monta um objeto contato
				Contato contato = new Contato();
				contato.setNome(nome);
				
				//System.out.println("Montado o Objeto");
				// Remove o contato
				ContatoDao dao = new ContatoDao();
			    dao.remove(contato);
				
				out.println("Contato " + contato.getNome() +
						" removido com sucesso");
			
			
	}
}
