/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package contenidosacuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static Connection conn;

    public static Connection getConnection() {
        try {
//            String uname = "enovasoft";
//            String pwd = "enovasoft";
//            String servidor = "jdbc:mysql://172.16.1.50/aventura";
			
            String uname = "root";
            String pwd = "";
            String servidor = "jdbc:mysql://localhost/acuario";

            Class.forName("com.mysql.jdbc.Driver");
            try	{
                conn = DriverManager.getConnection(servidor,uname,pwd);
            } catch (SQLException ex) {
		ex.printStackTrace();
            }
	} catch(ClassNotFoundException e) {
            System.out.println(e);
	}
	return conn;
    }
    public void desconectar() throws SQLException {
        conn.close();
    }

}