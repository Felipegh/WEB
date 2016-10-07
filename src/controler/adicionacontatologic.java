package controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Contato;
import modelo.ContatoDao;

public class adicionacontatologic implements Logica{
	
	public void executa(HttpServletRequest request, HttpServletResponse response)
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
				
				out.println("Montando Objeto no adiciona contato logic");
				
				// monta um objeto contato
				
				
				Contato contato = new Contato();
				contato.setNome(nome);
				contato.setEndereco(endereco);
				contato.setEmail(email);
				contato.setDataNascimento(dataNascimento);
				
				out.println(contato);
				
				Connection connection = (Connection) request.getAttribute("conexao");
				// salva o contato
				out.println(connection);
				out.println(contato);
				ContatoDao dao = new ContatoDao(connection);
				out.println("Depois de instanciar dao connection");
				dao.adiciona(contato);    //erro
				out.println("Chamou o método adiciona contato logic");
				
				// imprime o nome do contato que foi adicionado
				
				RequestDispatcher rd = request.getRequestDispatcher("/contatoadicionado.jsp");
				rd.forward(request,response);
				
				
				
				}

	
		
	}


