package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class clsConexion {
     Connection conectar;

    public Connection getConectar() {
        String url = "jdbc:mysql://localhost:3306/dbBanco";
        String usuario = "root";
        String clave = "Uni$2022.";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(url, usuario, clave);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return conectar;
    }
}
