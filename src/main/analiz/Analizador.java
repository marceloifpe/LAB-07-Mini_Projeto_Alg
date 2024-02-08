package analiz;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Analizador
 */
public class Analizador {
int num_neg = -1;
    double num_pos = 0;

    public int[] acha_sequencia(double[] probs, int[] valores){
        int tam = valores.length;
        ArrayList<Integer> ordena = new ArrayList<Integer>();
        ArrayList<Integer> usar = new ArrayList<Integer>();
        while (ordena.size() < tam){ 
            int x = seleciona(probs, valores, usar);
            ordena.add(x);
            usar.add(x); 
        }
        int[] resul = new int[ordena.size()];
        for (int i = 0; i < ordena.size(); i++){
            resul[i] = ordena.get(i);
        }
        return resul;
    }

    public int seleciona(double[] probs, int[] valores, ArrayList<Integer> usados) {
        int num_neg = -1;
        double num_pos = 0;
        int n = 0;
        
        while (n < probs.length) {
            if (!usados.contains(n)) {
                double num = valores[n] * probs[n] * probs[n];
                if (num > num_pos) {
                    num_neg = n;
                    num_pos = num;
                }
            }
            n++;
        }
        return num_neg;
    }
}    