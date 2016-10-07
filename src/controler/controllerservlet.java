package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class controllerservlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
							throws ServletException, IOException {
	
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "controler.";
		nomeDaClasse+=parametro;
			System.out.println(nomeDaClasse);
		try {
			
			Class<?> classe = Class.forName(nomeDaClasse);
			Logica logica = (Logica) classe.newInstance();
			logica.executa(request, response);  //erro
			System.out.println("Try do Controller ok");
			System.out.println(logica);
		 } catch (Exception e) {
		 throw new ServletException("A lógica de negócios causou uma exceção", e);
		 }
	
	}
}
