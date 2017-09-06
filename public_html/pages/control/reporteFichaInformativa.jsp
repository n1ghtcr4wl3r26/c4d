<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    </head>
    <body>
        <table width="100%" id="tabla-a">
            <tbody class="main">
                <tr>
                    <th colspan="2">FACTORES DE RIESGO:</th>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_a" id="factor_a"/>a) Precios ostensiblemente bajos.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_b" id="factor_b"/>b) Pagos indirectos.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_c" id="factor_c"/>c) Vinculaci&oacute;n entre el comprador y
                                                                              el vendedor.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_d" id="factor_d"/>d) Prestaciones, de manera especial las
                                                                              relativas a bienes intangibles o servicios.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_e" id="factor_e"/>e) Pagos de c&aacute;nones por el uso de
                                                                              derechos de propiedad intelectual
                                                                              especificados en el art&iacute;culo 28 de
                                                                              la Resoluci&oacute;n 1684 de la Comunidad
                                                                              Andina.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_f" id="factor_f"/>f) Inexactitud en la declaraci&oacute;n de
                                                                              los gastos inherentes a la venta y a la
                                                                              entrega de las mercanc&iacute;as.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_g" id="factor_g"/>g) Facturas presumiblemente falsas o
                                                                              inexactas.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_h" id="factor_h"/>h) Doble facturaci&oacute;n.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_i" id="factor_i"/>i) Falta de correspondencia entre la
                                                                              declaraci&oacute;n de aduana y la del
                                                                              valor y de &eacute;stas frente a los
                                                                              respectivos documentos soporte.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_j" id="factor_j"/>j) Inexactitud en el llenado de las
                                                                              casillas de la Declaraci&oacute;n Andina
                                                                              del Valor.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_k" id="factor_k"/>k) Descripci&oacute;n incompleta o
                                                                              imprecisa de las mercanc&iacute;as.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_m" id="factor_m"/>l) Mercanc&amp;iacuteas provenientes de
                                                                              zona franca o zona aduanera especial,
                                                                              m&amp;aacute;s a&uacute;n cuando los
                                                                              valores declarados sean iguales o menores
                                                                              al valor de ingreso a dichas zonas de las
                                                                              mismas mercanc&amp;iacuteas o de otra
                                                                              id&amp;eacute;ntica o similar del mismo
                                                                              pa&iacute;s de origen.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_p" id="factor_p"/>m) Niveles anormales de descuento.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_q" id="factor_q"/>n) Tipo de Mercanc&iacute;a.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_r" id="factor_r"/>o) Pa&iacute;s de origen o procedencia
                                                                              &quot;(Dudas sobre Origen o
                                                                              Clasificaci&oacute;n que no constituya
                                                                              delito)&quot;.
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="checkbox" name="factor_s" id="factor_s"/>p) Otro (Especifique) (m&aacute;ximo 2000
                                                                              caracteres).
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div class="form-group">
                            <textarea property="d_especifique" onkeydown="Counter(this,2000);"
                                      onkeyup="Counter(this,2000);" rows="2" cols="150"></textarea>
                        </div>
                    </td>
                </tr>
            </tbody>
        </table>
    </body>
</html>