package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.sql.Date;

import controler.ConnectionFactory;

public class ContatoDao {
	
	// a conexão com o banco de dados
	private Connection connection;
	
	public ContatoDao() {
		//this.setConnection(new ConnectionFactory().getConnection());
		this.connection = new ConnectionFactory().getConnection();
		System.out.println("Utilizando construtor sem argumentos...");
	 }
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
		System.out.println("Utilizando construtor com argumentos...");
		}



	public void adiciona(Contato contato) {
		String sql = "insert into contatos " +
					"(nome,email,endereco,dataNascimento)" +
					" values (?,?,?,?)";
		try {
			// prepared statement para inserção
			// pega a conexão e o Statement
			//Connection con = new ConnectionFactory().getConnection();
			PreparedStatement stmt = connection.prepareStatement(sql);    //erro
			// seta os valores
			stmt.setString(1,contato.getNome());
			stmt.setString(2,contato.getEmail());
			stmt.setString(3,contato.getEndereco());
			stmt.setDate(4, (java.sql.Date) new Date(
					contato.getDataNascimento().getTimeInMillis()));
			// executa
			stmt.execute();
			stmt.close();
			
			System.out.println("Gravado");
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}



	public Connection getConnection() {
		return connection;
	}



	public void setConnection(Connection connection) {
		this.connection = connection;
	}
		
	public List<Contato> getLista() {
		 try {
		 List<Contato> contatos = new ArrayList<Contato>();
		 PreparedStatement stmt = this.connection.
				 prepareStatement("select * from contatos");
		 ResultSet rs = stmt.executeQuery();
		 
		while (rs.next()) {
			 // criando o objeto Contato
			 Contato contato = new Contato();
			 contato.setId(rs.getLong("id"));
			 contato.setNome(rs.getString("nome"));
			 contato.setEmail(rs.getString("email"));
			 contato.setEndereco(rs.getString("endereco"));
		
			 // montando a data através do Calendar
			 Calendar data = Calendar.getInstance();
			 data.setTime(rs.getDate("dataNascimento"));
			 contato.setDataNascimento(data);
			
			 // adicionando o objeto à lista
			 contatos.add(contato);
		 }
		 rs.close();
		 stmt.close();
		 return contatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		 }
		}
	
	public void altera(Contato contato) {
		 String sql = "update contatos set nome=?, email=?,"+
		 "endereco=?, dataNascimento=? where id=?";
		 
		try {
			 PreparedStatement stmt = connection
					 .prepareStatement(sql);
			 stmt.setString(1, contato.getNome());
			 stmt.setString(2, contato.getEmail());
			 stmt.setString(3, contato.getEndereco());
			 stmt.setDate(4, new Date(contato.getDataNascimento()
					 .getTimeInMillis()));
			 stmt.setLong(5, contato.getId());
			 stmt.execute();
			 stmt.close();
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	}
	
	public void remove(Contato contato) {
		 try {
			 PreparedStatement stmt = connection
					 .prepareStatement("delete from contatos where nome=?");
			 stmt.setString(1, contato.getNome());
			 stmt.execute();
			 stmt.close();
		 } catch (SQLException e) {
			 throw new RuntimeException(e);
		 }
	}
}