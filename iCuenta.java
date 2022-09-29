package interfaces;

import java.util.List;
import modelo.clsCuenta;

public interface iCuenta {

    public List ListarDAO(); 

    public clsCuenta ListarDAO(int pIdCuenta);

    public boolean agregarDAO(clsCuenta oC);

    public boolean modificarDAO(clsCuenta oC);

    public void eliminarDAO(int pIdCuenta);
}
