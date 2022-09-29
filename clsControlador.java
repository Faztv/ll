package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.clsCuenta;
import modelo.clsCuentaDAO;

public class clsControlador extends HttpServlet {

    String agregarJSP = "vista/agregar.jsp";
    String listarJSP = "vista/listar.jsp";
    String modificarJSP = "vista/modificar.jsp";
    String eliminarJSP = "vista/eliminar.jsp";
    clsCuenta oC = new clsCuenta(); 
    clsCuentaDAO dao = new clsCuentaDAO();

    public clsControlador() {
    }
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
        String enviarApagina = ""; 
        String accion = request.getParameter("opv");
        if (accion.equalsIgnoreCase("listar")) {
            enviarApagina = listarJSP;
        } else if (accion.equalsIgnoreCase("agregar")) {
            enviarApagina = agregarJSP;
        } else if (accion.equalsIgnoreCase("Guardar")) {
            String cTitular = request.getParameter("txtTitular");
            String cMoneda = request.getParameter("txtMoneda");
            String cSaldo = request.getParameter("txtSaldo");
            oC.setTitular(cTitular);;
            oC.setMoneda(Integer.parseInt(cMoneda));
            oC.setSaldo(Double.parseDouble(cSaldo));
            dao.agregarDAO(oC);
            enviarApagina = listarJSP;
        } else if (accion.equalsIgnoreCase("Modificar")) {
            request.setAttribute("IdCuenta", request.getParameter("id"));
            enviarApagina = modificarJSP;
        } else if (accion.equalsIgnoreCase("Actualizar")) {
            int id = Integer.parseInt(request.getParameter("txtIdCuenta"));
            String cTitular = request.getParameter("txtTitular");
            String cMoneda = request.getParameter("txtMoneda");
            String cSaldo = request.getParameter("txtSaldo");
            oC.setIdCuenta(id);
            oC.setTitular(cTitular);;
            oC.setMoneda(Integer.parseInt(cMoneda));
            oC.setSaldo(Double.parseDouble(cSaldo));
            dao.modificarDAO(oC);
            enviarApagina = listarJSP;
        } else if (accion.equalsIgnoreCase("mostrar")) {
            request.setAttribute("IdCuenta", request.getParameter("id"));
            enviarApagina = eliminarJSP;
        } else if (accion.equalsIgnoreCase("Eliminar")) {
            int id = Integer.parseInt(request.getParameter("txtIdCuenta"));
            dao.eliminarDAO(id);
            enviarApagina = listarJSP;
        }
        RequestDispatcher rVista = request.getRequestDispatcher(enviarApagina);
        rVista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
