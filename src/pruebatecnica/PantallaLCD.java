package pruebatecnica;

import java.io.*;

public class PantallaLCD {

    private NumeroLCD[] numero;
    private int size;

    public PantallaLCD(int size, String numero) {
        this.numero = convertirNumeroLCD(size, numero);
    }

    /**
     * Devuelve la representación de un número como una cadena
     * @return String: la cadena representa una pantalla LCD de 7 segmentos
     */
    public String getString(){
        int rows = numero[0].numeroFila();
        StringBuilder stb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (NumeroLCD aNumero : numero) {
                stb.append(aNumero.getRowAsString(i)).append(" ");
            }

            stb.append(System.lineSeparator());
        }
        return stb.toString();
    }

    /**
     * Método para convertir de una cadena a una representación en 7 segmentos
     * Pre: num debe ser un número en base 10 en formato de cadena. Este método tiene la intención de ser llamado dentro de la construcción de PantallaLCD solo, si es público es
     * por motivos de prueba
     * @param size: tamaño de la pantalla lcd
     * @param num: número a convertir
     * @return una matriz de NumeroLCD correspondiente al número pasado como parámetro
     */
    public NumeroLCD[] convertirNumeroLCD(int size,String num){
        NumeroLCD[] ret = new NumeroLCD[num.length()];
        esNumero(num);
        for (int i = 0; i < num.length(); i++) {
            //Converts the char to int
            int digit = num.charAt(i) - '0';
            ret[i] = MostrarNumeroLCD.createNumberLCD(size, digit);
        }
        return ret;
    }

    public boolean esNumero(String test){
        char[] temp = test.toCharArray();
        for (char c: temp) {
            if(!Character.isDigit(c)) throw new NumberFormatException("la cadena no es un número para valido: "+c);
        }
        return true;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        out.println("Bienvnido a el lcd display");
        out.println("Para empezar escriba el tamano de pantalla que desea (entre 1 y 10) y el numero en formato decimal que desea mostrar, separados por comas");
        out.println("Ej: 2,12345");
        out.println("Para terminar escriba 0,0");
        out.flush();

        String ln;
        while(true){
            ln = in.readLine();
            String[] valor = ln.split(",");
            try{
                int size = Integer.parseInt(valor[0]);
                if(size > 10) throw new Exception("El tamaño de la pantalla no puede ser mayor a 10");

                if(size == 0 || valor[1].equals("0")) break;
                String num = valor[1];
                PantallaLCD lcd = new PantallaLCD(size, num);
                out.write(lcd.getString());
                out.println();
                out.flush();
            }catch(Exception e){
                out.println("Recuerde que ambos numeros deben ser digitos en base 10 (0123456789) y separados por comas");
                out.println(e.getMessage());
                //e.printStackTrace();
                out.flush();
            }
        }
        in.close();
        out.close();
    }




}
