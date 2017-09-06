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
                    <strong>Informaci&oacute;n de Llenado de la Columna de Il&iacute;cito</strong>
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
                    <td class="text-center">CA DUI</td>
                    <td class="text-center">Contravenci&oacute;n Aduanera relacionada con la DUI</td>
                </tr>
                <tr>
                    <td class="text-center">CAO</td>
                    <td class="text-center">Contravenci&oacute;n Aduanera relacionada con la Orden</td>
                </tr>
                <tr>
                    <td width="100" class="text-center">
                        <p>OP</p>
                    </td>
                    <td width="250" class="text-center">
                        <p>Omisi&oacute;n de Pago</p>
                    </td>
                </tr>
                <tr>
                    <td width="100" class="text-center">
                        <p>CC</p>
                    </td>
                    <td width="250" class="text-center">
                        <p>Contrabando Contravencional</p>
                    </td>
                </tr>
                <tr>
                    <td width="100" class="text-center">
                        <p>CD</p>
                    </td>
                    <td width="250" class="text-center">
                        <p>Contrabando Delito</p>
                    </td>
                </tr>
                <tr>
                    <td width="100" class="text-center">
                        <p>DF</p>
                    </td>
                    <td width="250" class="text-center">
                        <p>Defraudaci&oacute;n</p>
                    </td>
                </tr>
                <tr>
                    <td width="100" class="text-center">
                        <p>OD</p>
                    </td>
                    <td width="250" class="text-center">
                        <p>Otros Delitos</p>
                    </td>
                </tr>
                <tr>
                    <td width="100" class="text-center">
                        <p>S/O</p>
                    </td>
                    <td width="250" class="text-center">
                        <p>Sin Observaci&oacute;n</p>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>