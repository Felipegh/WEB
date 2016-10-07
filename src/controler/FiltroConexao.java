package controler;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import com.mysql.jdbc.Connection;

@WebFilter("/*")
public class FiltroConexao implements javax.servlet.Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		try {
			Connection connection = (Connection) new ConnectionFactory().getConnection();
			
			//pendurando a connection na requisição
			request.setAttribute("conexao", connection);
			
			long tempoInicial = System.currentTimeMillis();
			
			chain.doFilter(request, response);
			connection.close();
			
			long tempoFinal = System.currentTimeMillis();
			System.out.println("Tempo da requisição em millis: " + (tempoFinal - tempoInicial));
			System.out.println("Passou pelo Filtro");
			
			} catch (SQLException e) {
			throw new ServletException(e);
			}
			
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
