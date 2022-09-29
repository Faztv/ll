<%-- 
    Document   : listar 
    Author     : ALAN
--%>

<%@page import="java.util.Iterator"%>
<%@page import="modelo.clsCuenta"%>
<%@page import="java.util.List"%>
<%@page import="modelo.clsCuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP_Listar</title>
    </head>
    <body>
        <div class="container">
            <h1>Lista de Cuentas</h1>
            <a href="clsControlador?opv=agregar" class="btn btn-success btn-lg">Agregar</a>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center>Titular</th>
                        <th class="text-center>Moneda</th>
                        <th class="text-center>Saldo</th>
                        <th class="text-center>Acciones</th>
                    </tr>
                </thead>
                <%
                    clsCuentaDAO dao = new clsCuentaDAO();
                    List<clsCuenta> listaDAO = dao.ListarDAO();
                    Iterator<clsCuenta> iteraccion = listaDAO.iterator();
                    clsCuenta oC = null;
                    while (iteraccion.hasNext()) {
                        oC = iteraccion.next();

                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= oC.getIdCuenta()%></td>
                        <td class="text-center"><%= oC.getTitular()%></td>
                        <td class="text-center"><%= oC.getMoneda()%></td>
                        <td class="text-center"><%= oC.getSaldo()%></td>
                        <td>
                            <a href="clsControlador?opv=modificar&id=<%=oC.getIdCuenta()%>" class="btn btn-warning">Modificar</a>
                            <a href="clsControlador?opv=mostrar&id=<%=oC.getIdCuenta()%>" class="btn btn-danger">Eliminar</a>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>

    </body>
</html>
