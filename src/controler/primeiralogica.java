package controler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class primeiralogica implements Logica{
	
	
	
	@Override
	public void executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		System.out.println("Executando a logica e redirecionando...");
		
		RequestDispatcher rd = req.getRequestDispatcher("/primeiralogica.jsp");
		rd.forward(req, res);
		
	}
		
	
}
