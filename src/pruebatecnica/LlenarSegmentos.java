package pruebatecnica;

/**
 * Creado por Karelys Vargas
 * Esta clase tiene funcionalidad para llenar segmentos específicos de siete segmentos en una matriz
 */
public class LlenarSegmentos {

    /**
     * Método para llenar un segmento específico de una matriz específica
     * @param segmento de segmento para ser llenado
     * @param matriz matriz para rellenar
     */
    public static void fill(int segmento, char[][] matriz){
        int mid = matriz.length/2;
        int col = 0;
        switch(segmento){
            case 0:
                filaHorizontal(matriz, 0);
                break;		
            case 1:
                col = matriz[0].length-1;
                filaVertical(matriz, col, 1, mid+1);
                break;
            case 2:
                col = matriz[0].length-1;
                filaVertical(matriz, col, mid+1, matriz.length);
                break;
            case 3:
                filaHorizontal(matriz, matriz.length-1);
                break;
            case 4:
                col = 0;
                filaVertical(matriz, col, mid+1, matriz.length);
                break;
            case 5:
                col = 0;
                filaVertical(matriz, col, 1, mid+1);
                break;
            case 6:
                filaHorizontal(matriz, mid);
                break;

        }



    }

    private static void filaHorizontal(char[][] matrix, int index){
        char[] seg = matrix[index];
        //char c = index == 0 ? '-' : '_';
        for (int i = 1; i < seg.length-1; i++) {
            if(i%2 != 0) seg[i] = '_';

        }
    }

    private static void filaVertical(char[][] matrix, int col, int inicio, int fin){
        for (int i = inicio; i < fin ; i++) {
            matrix[i][col] = '|';
        }
    }

}


