import java.util.Random;

public class Main {

    private static int SIZE = 0;
    public static void main (String args[]){
        //Gerador de números
        Random random = new Random();

        //Número de processadores da máquina
        int cores = Runtime.getRuntime().availableProcessors();

        do {
            SIZE = random.nextInt(2000 + 1 - 100) + 100;
        } while (SIZE % 100 != 0);

        Threads sequencial = new Threads();
        sequencial.inicializaMatriz(SIZE);
        sequencial.populaMatriz();
        sequencial.populaMatriz2();
        sequencial.padroniza();
        sequencial.multiplica();

        Threads2 v2 = new Threads2();
        v2.inicializaMatriz(SIZE);
        v2.populaMatriz();
        v2.populaMatriz2();
        v2.padroniza();
        v2.paraleliza();

        Threads4 v4 = new Threads4();
        v4.inicializaMatriz(SIZE);
        v4.populaMatriz();
        v4.populaMatriz2();
        v4.padroniza();
        v4.paraleliza();

        Threads8 v8 = new Threads8();
        v8.inicializaMatriz(SIZE);
        v8.populaMatriz();
        v8.populaMatriz2();
        v8.padroniza();
        v8.paraleliza();

       
    }
}
