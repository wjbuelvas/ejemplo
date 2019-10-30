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
     * Crea un NumeroLCD con los segmentos específicos para representar el número establecido en verdadero
     * Tamaño del tamaño de @param de la pantalla LCD
     * @param num número de un dígito para crear como NumeroLCD
     * @return
     */
    public static NumeroLCD createNumberLCD(int size, int num) {
        NumeroLCD ret = new NumeroLCD(size, num, SEGMENTOS[num]);

        return ret;
    }


}
