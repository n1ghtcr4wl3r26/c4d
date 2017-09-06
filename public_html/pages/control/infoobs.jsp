<%@ page contentType="text/html; charset=UTF-8" language="java" buffer="none"%>
<html>
    <head>
        <title>Fiscalizaci&oacute;n</title>
        <link rel="stylesheet" type="text/css"
              href="/fiscalizacion/lib/bootstrap/css/bootstrap.css?${sessionScope.VERSION_ASSETS}"></link>
        <link rel="stylesheet" type="text/css"
              href="/fiscalizacion/lib/datepicker/css/bootstrap-datepicker.min.css?${sessionScope.VERSION_ASSETS}"></link>
        <link rel="stylesheet" type="text/css"
              href="/fiscalizacion/lib/font-awesome/css/font-awesome.min.css?${sessionScope.VERSION_ASSETS}"></link>
        <link rel="stylesheet" type="text/css"
              href="/fiscalizacion/lib/select2/css/select2.min.css?${sessionScope.VERSION_ASSETS}"></link>
        <link rel="stylesheet" type="text/css"
              href="/fiscalizacion/lib/datatables/css/buttons.dataTables.min.css?${sessionScope.VERSION_ASSETS}"></link>
        <link rel="stylesheet" type="text/css" href="/fiscalizacion/css/main.css?${sessionScope.VERSION_ASSETS}"/>
    </head>
    <body bgcolor="#F5F9FD">
        <table class="table table-striped table-hover" id="main-table">
            <tr>
                <td width="350px" class="text-center">
                    <strong>Informaci&oacute;n de Llenado de la Columna de Observaci&oacute;n Il&iacute;cito</strong>
                </td>
            </tr>
        </table>
        <table class="table table-striped table-hover" border="1" cellpadding="3" cellspacing="1"
               style="border-collapse:separate; " id="main-table">
            <thead>
                <tr>
                    <th width="100px" class="text-center">
                        <strong>CODIGO</strong>
                    </th>
                    <th width="250px" class="text-center">
                        <strong>DESCRIPCI&Oacute;N</strong>
                    </th>
                </tr>
            </thead>
             
            <tbody>
                <tr>
                    <td class="text-center">1</td>
                    <td class="text-center">Subvaluaci&oacute;n</td>
                </tr>
                <tr>
                    <td class="text-center">2</td>
                    <td class="text-center">Incorrecta Clasificaci&oacute;n Arancelaria</td>
                </tr>
                <tr>
                    <td class="text-center">3</td>
                    <td class="text-center">Desgravaci&oacute;n Arancelaria</td>
                </tr>
                <tr>
                    <td class="text-center">4</td>
                    <td class="text-center">Observaci&oacute;n a las Certificaciones y Autorizaciones</td>
                </tr>
                <tr>
                    <td class="text-center">5</td>
                    <td class="text-center">Otros</td>
                </tr>
            </tbody>
        </table>
    </body>
</html>