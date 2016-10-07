package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc {

	public static void main(String[] args) throws SQLException {
		// Classe do Driver de conexão com o Banco
		
		Connection conexão = DriverManager.getConnection("jdbc:mysql://localhost:3306/webbd", "root", "fe@me83");
		System.out.println("Conectado!");
		conexão.close();
	}

}
