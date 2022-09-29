/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Personal
 */
public class clsCuenta {
     public int IdCuenta;
    public String Titular;
    public int Moneda;
    public double Saldo;

 
    public clsCuenta() {
        this.IdCuenta = 0;
        this.Titular = "";
        this.Moneda = 0;
        this.Saldo = 0.0;
    }

    public clsCuenta(int IdCuenta, String Titular, int Moneda, double Saldo) {
        this.IdCuenta = IdCuenta;
        this.Titular = Titular;
        this.Moneda = Moneda;
        this.Saldo = Saldo;
    }

    public int getIdCuenta() {
        return IdCuenta;
    }

    public void setIdCuenta(int IdCuenta) {
        this.IdCuenta = IdCuenta;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String Titular) {
        this.Titular = Titular;
    }

    public int getMoneda() {
        return Moneda;
    }

    public void setMoneda(int Moneda) {
        this.Moneda = Moneda;
    }

    public double getSaldo() {
        return Saldo;
    }

    public void setSaldo(double Saldo) {
        this.Saldo = Saldo;
    }

}
