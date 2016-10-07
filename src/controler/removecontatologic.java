package controler;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Contato;
import modelo.ContatoDao;

public class removecontatologic implements Logica {
	
	
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Contato contato = new Contato();
		long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEmail(request.getParameter("email"));
		
		//Converte a data de String para Calendar
		String dataEmTexto = request.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		
		contato.setDataNascimento(dataNascimento);
		
		Connection connection = (Connection) request.getAttribute("conexao");
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Removendo contato ..." + contato.getNome());
		
	}

}
