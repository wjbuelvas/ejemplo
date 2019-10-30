package pruebatecnica;

/**
 * Creado por Karelys Vargas
 */
public class MostrarNumeroLCD {

    private static boolean[][] SEGMENTOS = {{true, true, true, true, true, true, false},
                                            {false, true, true, false, false, false, false},
                                            {true, true, false, true, true, false, true},
                                            {true, true, true, true, false, false, true},
                                            {false, true, true, false, false, true, true},
                                            {true, false, true, true, false, true, true},
                                            {true, false, true, true, true, true, true},
                                            {true, true, true, false, false, false, false},
                                            {true, true, true, true, true, true, true},
                                            {true, true, true, false, false, true, true}};


    /**
     * Crea un NumeroLCD con los segmentos espec�ficos para representar el n�mero establecido en verdadero
     * Tama�o del tama�o de @param de la pantalla LCD
     * @param num n�mero de un d�gito para crear como NumeroLCD
     * @return
     */
    public static NumeroLCD createNumberLCD(int size, int num) {
        NumeroLCD ret = new NumeroLCD(size, num, SEGMENTOS[num]);

        return ret;
    }


}
