package anb.negocio;


import anb.general.Respuesta;

import anb.persistencia.SubirExcelDao;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class SubirHojaNeg {
    private final SubirExcelDao dao = new SubirExcelDao();
    private final String CORRECTO_BD = "CORRECTO";
    private final String ERROR_BD = "ERROR";

    private boolean estaConectadoBd() {
        return dao != null;
    }

    public Respuesta<Boolean> leerArchivoExcel(String archivo, String codigo, String usuario) {
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        int cont = 0;
        int grab = 0;
        String marcador = "";
        String fila = "";
        try {
            File excel = new File(archivo);
            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet ws = wb.getSheetAt(0);
            String dui;
            String item;
            String partida;
            long dpartida = -1;
            double fob = -1;
            double flete = -1;
            double seguro = -1;
            double otros = -1;
            double cifusd = -1;
            double cifbob = -1;
            double contrav = -1;
            double contravorden = -1;
            String ilicito;
            String observacion;
            String res;
            int rowNum = ws.getLastRowNum() + 1;
            int colNum = ws.getRow(0).getLastCellNum();
            String[][] data = new String[rowNum][colNum];
            long idalcance = 0;

            for (int i = 1; i < rowNum; i++) {
                idalcance = 0;
                fob = -1;
                flete = -1;
                seguro = -1;
                otros = -1;
                cifusd = -1;
                cifbob = -1;
                contrav = -1;
                contravorden = -1;
                ilicito = "";
                observacion = "";
                partida = "";
                dpartida = -1;
                cont++;
                XSSFRow row = ws.getRow(i);
                XSSFCell cell;
                boolean sw = false;
                String error = "";
                try {
                    cell = row.getCell(4);
                    dui = cell.toString();
                    if (dui.length() >= 12) {
                        sw = true;
                        //marcador = marcador + "Fila " + String.valueOf(cont) + " la DUI " + dui;
                        fila = "Fila " + String.valueOf(cont) + " la DUI " + dui;
                        cell = row.getCell(1);
                        item = cell.getRawValue().toString();

                        cell = row.getCell(21);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    idalcance = (long)cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error =
                                            ", el C&oacute;digo del Tr&aacute;mite no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        if (idalcance > 0) {
                            try {
                                cell = row.getCell(3);
                                if (!(cell == null)) {
                                    String prueba2 = cell.toString();
                                    if (prueba2.length() > 0) {
                                        if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                            dpartida = (long)cell.getNumericCellValue();
                                            sw = true;
                                        } else {
                                            error = ", la columna PARTIDA no es un n&uacute;mero v&aacute;lido ";
                                        }
                                    }
                                }
                            } catch (Exception exe) {
                                dpartida = -1;
                            }
                            cell = row.getCell(16);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                        fob = cell.getNumericCellValue();
                                        sw = true;
                                    } else {
                                        error = ", la columna FOB no es un n&uacute;mero v&aacute;lido ";
                                    }
                                }
                            }
                            /*
                            cell = row.getCell(17);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                        flete = cell.getNumericCellValue();
                                        sw = true;
                                    } else {
                                        error = ", la columna FLETE no es un n&uacute;mero v&aacute;lido ";
                                    }
                                }
                            }
                            cell = row.getCell(18);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                        seguro = cell.getNumericCellValue();
                                        sw = true;
                                    } else {
                                        error = ", la columna SEGURO no es un n&uacute;mero v&aacute;lido ";
                                    }
                                }
                            }
                            cell = row.getCell(19);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                        otros = cell.getNumericCellValue();
                                        sw = true;
                                    } else {
                                        error = ", la columna OTROS no es un n&uacute;mero v&aacute;lido ";
                                    }
                                }
                            }
                            */
                            cell = row.getCell(17);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                        contrav = cell.getNumericCellValue();
                                        sw = true;
                                    } else {
                                        error =
                                                ", la columna CONTRAVENCI&Oacute;N no es un n&uacute;mero v&aacute;lido ";
                                    }
                                }
                            }
                            cell = row.getCell(18);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                        contravorden = cell.getNumericCellValue();
                                        sw = true;
                                    } else {
                                        error =
                                                ", la columna CONTRAVENCI&Oacute;N ORDEN no es un n&uacute;mero v&aacute;lido ";
                                    }
                                }
                            }
                            cell = row.getCell(19);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    ilicito = cell.toString();
                                    sw = true;
                                }
                            }

                            cell = row.getCell(20);
                            if (!(cell == null)) {
                                String prueba2 = cell.toString();
                                if (prueba2.length() > 0) {
                                    observacion = cell.toString();
                                    sw = true;
                                }
                            }

                            if (error.length() > 0) {
                                marcador = marcador + " <label style=background-color:red>"+fila+ " no pudo ser grabada:" + error + "</label><br>";
                            } else {
                                if (sw) {
                                    res =
dao.graba_resultados(dui, item, String.valueOf(dpartida), fob, flete, seguro, otros, cifusd, cifbob, contrav, ilicito,
                     observacion, usuario, codigo, contravorden, String.valueOf(idalcance));
                                    if (res.equals("CORRECTO")) {
                                        grab++;
                                        marcador = marcador + fila+ " se grab&oacute; correctamente.<br>";
                                    } else {
                                        marcador = marcador + " <label style=background-color:red>"+fila+ " no pudo ser grabada:" + res + "</label> <br>";
                                    }
                                } else {
                                    marcador = marcador + " <label style=background-color:red>"+fila+ " no hay datos para actualizar el item</label><br>";
                                }
                            }
                        } else {
                            marcador =
                                    marcador + "<label style=background-color:red>Fila " + String.valueOf(cont) + " error el C&oacute;digo del Tr&aacute;mite no es un n&uacute;mero v&aacute;lido.</label><br>";
                        }

                    } else {
                        marcador =
                                marcador + "<label style=background-color:red>Fila " + String.valueOf(cont) + " error no tiene la longitud de una declaracion.</label><br>";
                    }
                } catch (Exception ex) {
                    //marcador = marcador + "Fila " + String.valueOf(cont) +" error no tiene valores legibles.";
                    i = rowNum;
                }

            }
            respuesta.setMensaje("Se grabaron " + String.valueOf(grab) + " de " + String.valueOf(cont) + "<br>" +
                                 marcador);
            respuesta.setCodigo(1);

        } catch (Exception e) {
            respuesta.setMensaje("Se produjo un error al leer el archivo excel en la fila: " + String.valueOf(cont));
            respuesta.setCodigo(-1);
        } finally {


        }


        return respuesta;
    }

    public Respuesta<Boolean> leerArchivoExcelTramite(String archivo, String codigo, String usuario) {
        Respuesta<Boolean> respuesta = new Respuesta<Boolean>();
        respuesta.setCodigo(-1);
        int cont = 0;
        int grab = 0;
        String marcador = "";
        String fila = "";
        try {

            File excel = new File(archivo);

            FileInputStream fis = new FileInputStream(excel);
            XSSFWorkbook wb = new XSSFWorkbook(fis);

            XSSFSheet ws = wb.getSheetAt(0);
            String tramite;
            String mercancia;
            double fob = -1;
            double flete = -1;
            double seguro = -1;
            double otros = -1;
            double cifusd = -1;
            double cifbob = -1;
            double cifufv = -1;
            double contrav = -1;
            String ilicito;
            String res;
            int rowNum = ws.getLastRowNum() + 1;
            int colNum = ws.getRow(0).getLastCellNum();
            long idalcance = 0;
            String[][] data = new String[rowNum][colNum];


            for (int i = 1; i < rowNum; i++) {

                idalcance = 0;
                tramite = "";
                mercancia = "";
                fob = -1;
                flete = -1;
                seguro = -1;
                otros = -1;
                cifusd = -1;
                cifbob = -1;
                cifufv = -1;
                ilicito = "";
                contrav = -1;

                cont++;
                XSSFRow row = ws.getRow(i);
                XSSFCell cell;
                boolean sw = false;
                String error = "";
                try {
                    cell = row.getCell(15);
                    if (!(cell == null)) {
                        String prueba2 = cell.toString();
                        if (prueba2.length() > 0) {
                            if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                idalcance = (long)cell.getNumericCellValue();
                                sw = true;
                            } else {
                                error = ", el C&oacute;digo del Tr&aacute;mite no es un n&uacute;mero v&aacute;lido ";
                            }
                        }
                    }
                    cell = row.getCell(2);
                    tramite = cell.toString();
                    if (idalcance > 0) {
                        //marcador = marcador + "Fila " + String.valueOf(cont) + " el Tr&aacute;mite " + tramite;
                        fila = "Fila " + String.valueOf(cont) + " el Tr&aacute;mite " + tramite;

                        cell = row.getCell(5);
                        mercancia = cell.toString();
                        cell = row.getCell(6);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    fob = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna FOB no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        cell = row.getCell(7);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    flete = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna FLETE no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        cell = row.getCell(8);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    seguro = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna SEGURO no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        cell = row.getCell(9);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    otros = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna OTROS no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        cell = row.getCell(10);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    cifusd = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna CIF USD no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        cell = row.getCell(11);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    cifbob = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna CIF Bs. no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }
                        cell = row.getCell(12);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    cifufv = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error = ", la columna CIF UFV's no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }

                        cell = row.getCell(13);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                ilicito = cell.toString();
                                sw = true;
                            }
                        }

                        cell = row.getCell(14);
                        if (!(cell == null)) {
                            String prueba2 = cell.toString();
                            if (prueba2.length() > 0) {
                                if (cell.getCellType() == cell.CELL_TYPE_NUMERIC) {
                                    contrav = cell.getNumericCellValue();
                                    sw = true;
                                } else {
                                    error =
                                            ", el columna Contravenci&oacute;n Aduanera Relacionada con la Orden no es un n&uacute;mero v&aacute;lido ";
                                }
                            }
                        }


                        if (error.length() > 0) {
                            marcador = marcador +  "<label style=background-color:red>"+fila+ " no pudo ser grabada:" + error + " </label><br>";
                        } else {
                            if (sw) {
                                res =
dao.graba_resultados_tramite(codigo, String.valueOf(idalcance), mercancia, fob, flete, seguro, otros, cifusd, cifbob,
                             cifufv, usuario, ilicito, contrav);
                                if (res.equals("CORRECTO")) {
                                    grab++;
                                    marcador = marcador + fila+ " se grab&oacute; correctamente.<br>";
                                } else {
                                    marcador = marcador + " <label style=background-color:red>"+fila+" no pudo ser grabada:" + res + " </label><br>";
                                }
                            } else {
                                marcador = marcador + " <label style=background-color:red>"+fila+" no hay datos para actualizar el item</label><br>";
                            }
                        }

                    } else {
                        marcador =
                                marcador + "<label style=background-color:red>Fila " + String.valueOf(cont) + " error el Código del Tramite no es un n&uacute;mero v&aacute;lido.</label><br>";
                    }
                } catch (Exception ex) {
                    //marcador = marcador + "Fila " + String.valueOf(cont) +" error no tiene valores legibles.";
                    i = rowNum;
                }

            }
            respuesta.setMensaje("Se grabaron " + String.valueOf(grab) + " de " + String.valueOf(cont) + "<br>" +
                                 marcador);
            respuesta.setCodigo(1);

        } catch (Exception e) {
            respuesta.setMensaje("Se produjo un error al leer el archivo excel en la fila: " + String.valueOf(cont));
            respuesta.setCodigo(-1);
        } finally {


        }


        return respuesta;
    }


}
