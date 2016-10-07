package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Contato;
import modelo.ContatoDao;

@WebServlet("/adicionacontato")
public class adicionacontatoservlet extends HttpServlet {
	
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
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;
		//out.println(dataNascimento);
		//out.println(dataEmTexto);
		
		// fazendo a conversão da data     
		try {
			//out.println("Teste de Conversao");
			Date date = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			
					dataNascimento = Calendar.getInstance();
					//out.println(dataNascimento);
					//out.println(dataEmTexto);
					dataNascimento.setTime(date);
					//out.println(dataNascimento);
					//out.println(dataEmTexto);
					
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return; //para a execução do método  
			
		}
		
		//out.println("Montando Objeto");
		
		// monta um objeto contato
		
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		// salva o contato
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		// imprime o nome do contato que foi adicionado
		
		RequestDispatcher rd = request.getRequestDispatcher("/contatoadicionado.jsp");
		rd.forward(request,response);
		
		
		
		}
	}


