<%-- 
    Document   : modificar
    Author     : Alan
--%>


<%@page import="modelo.clsCuenta"%>
<%@page import="modelo.clsCuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP-Modificar</title>
    </head>
    <body>
        <div class="container">
            <%
                clsCuentaDAO dao = new clsCuentaDAO();
                int nIdCuenta = Integer.parseInt((String) request.getAttribute("IdCuenta"));
                clsCuenta oC = dao.ListarDAO(nIdCuenta);
            %>
            <h1>Modificar Cuenta</h1>
            <form action="clsControlador" class="form-control" style="width: 500px;height:400px">
                Id: <br><br>
                <input type="text" name="txtIdCuenta" value="<%= oC.getIdCuenta()%>" class="form-control" readonly="true"><br>
                Titular: <br>
                <input type="text" name="txtTitular" value="<%= oC.getTitular()%>" class="form-control"><br>
                Moneda: <br>
                <input type="text" name="txtMoneda" value="<%= oC.getMoneda()%>" class="form-control"><br>
                Saldo: <br>
                <input type="text" name="txtSaldo" value="<%= oC.getSaldo()%>" class="form-control"><br>
                <input type="submit" name="opv" value="Actualizar" class="btn btn-warning btn-lg"><br>
                <a href="clsControlador?opv=listar">Regresar</a>     
            </form>
        </div>
    </body>
</html>
