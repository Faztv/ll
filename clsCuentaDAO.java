package modelo;

import interfaces.iCuenta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class clsCuentaDAO implements iCuenta {


    clsConexion conectar = new clsConexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    clsCuenta oC = new clsCuenta();

    @Override
    public List ListarDAO() {
        List<clsCuenta> listarDatos = new ArrayList<>();
        String sql = "SELECT IdCuenta, Titular, Moneda, Saldo FROM Cuenta";
        try {
            con = conectar.getConectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {               
                oC = new clsCuenta(); 
                oC.setIdCuenta(rs.getInt("IdCuenta"));
                oC.setTitular(rs.getString("Titular"));
                oC.setMoneda(rs.getInt("Moneda"));
                oC.setSaldo(rs.getDouble("Saldo"));
                listarDatos.add(oC);
            }
        } catch (Exception e) {
        }
        return listarDatos;
    }

    @Override
    public clsCuenta ListarDAO(int pIdCuenta) {
        String sql = "SELECT IdCuenta, Titular, Moneda, Saldo FROM Cuenta WHERE IdCuenta=" + pIdCuenta;
        try {
            con = conectar.getConectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                oC = new clsCuenta(); 
                oC.setIdCuenta(rs.getInt("IdCuenta"));
                oC.setTitular(rs.getString("Titular"));
                oC.setMoneda(rs.getInt("Moneda"));
                oC.setSaldo(rs.getDouble("Saldo"));
            }
        } catch (Exception e) {
        }
        return oC;
    }

    @Override
    public boolean agregarDAO(clsCuenta oC) {
        String sql = "INSERT INTO Cuenta (Titular, Moneda, Saldo) VALUES(?,?,?)";
        try {
            con = conectar.getConectar();
            ps = con.prepareStatement(sql); 
            ps.setString(1, oC.getTitular());
            ps.setInt(2, oC.getMoneda());
            ps.setDouble(3, oC.getSaldo());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public boolean modificarDAO(clsCuenta oC) {
        String sql = "UPDATE Cuenta SET Titular=?, Moneda=?,Saldo=? WHERE IdCuenta=?";
        try {
            con = conectar.getConectar();
            ps = con.prepareStatement(sql);
            ps.setString(1, oC.getTitular());
            ps.setInt(2, oC.getMoneda());
            ps.setDouble(3, oC.getSaldo());
            ps.setInt(4, oC.getIdCuenta());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return true;
    }

    @Override
    public void eliminarDAO(int pIdCuenta) {
        String sql = "DELETE FROM Cuenta WHERE IdCuenta = " + pIdCuenta;
        try {
            con = conectar.getConectar();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
