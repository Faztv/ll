<%-- 
    Document   : agregar
    Author     : ALAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP-Agregar</title>
    </head>
    <body>
        <div>
            <h1>Agregar Cuenta</h1>
            <form action="clsControlador" class="form-control" style="width: 500px;height:400px">
                Id: <br><br>
                Titular:<br>               
                <input type="text" name="txtTitular" class="form-control"><br>
                Moneda:<br>  
                <input type="text" name="txtMoneda" class="form-control"><br>
                Saldo:<br>  
                <input type="text" name="txtSaldo" class="form-control"><br>
                <input type="submit" name="opv" value="Guardar" class="btn btn-primary btn-lg"><br>
                <a href="clsControlador?opv=listar">Regresar</a>    
            </form>
        </div>          
    </body>
</html>
