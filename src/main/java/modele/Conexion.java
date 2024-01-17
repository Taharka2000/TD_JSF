package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public Connection getConexion() {
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/bdtest", "root", "");
		}catch(SQLException | ClassNotFoundException e) {
			 e.printStackTrace();
		}
		return con;
	}
}
