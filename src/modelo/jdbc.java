package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	public static void main(String[] args) throws SQLException {
		// Classe do Driver de conex�o com o Banco
		
		Connection conex�o = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbd", "root", "fe@me83");
		System.out.println("Conectado!");
		conex�o.close();
	}

}
