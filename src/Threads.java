import java.util.Random;

public class Threads {



    private static Random random;

    // DIMENSOES DAS MATRIZES
    public static int SIZE = 0;
    // ESTRUTURAS DE DADOS COMPARTILHADA
    public static int[][] m1;
    public static int[][] m2;
    public static int[][] mres;


    public static void main(String[] args) {


        //Gerador de números
        random = new Random();

        //Número de processadores da máquina
        int cores = Runtime.getRuntime().availableProcessors();

        do {
            SIZE = random.nextInt(2000 + 1 - 100) + 100;
        } while (SIZE % 100 != 0);


        // INICIALIZA OS ARRAYS A SEREM MULTIPLICADOS
        m1 = new int[SIZE][SIZE];
        m2 = new int[SIZE][SIZE];
        mres = new int[SIZE][SIZE];

        populaMatriz(m1);
        populaMatriz(m2);


        if (m1[0].length != m2.length || mres.length != m1.length || mres[0].length != m2[0].length) {
            System.err.println("Impossivel multiplicar matrizes: parametros invalidos.");
            System.exit(1);
        }

        int k = 1;
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (k % 2 == 0)
                    m1[i][j] = -k;
                else
                    m1[i][j] = k;
            }
            k++;
        }
        k = 1;
        for (int j = 0; j < SIZE; j++) {
            for (int i = 0; i < SIZE; i++) {
                if (k % 2 == 0)
                    m2[i][j] = -k;
                else
                    m2[i][j] = k;
            }
            k++;
        }

        // PREPARA PARA MEDIR TEMPO
        long inicio = System.nanoTime();

        // OBTEM O TEMPO
        long fim = System.nanoTime();
        double total = (fim - inicio) / 1000000000.0;

        // REALIZA A MULTIPLICACAO
        for (int i=0 ; i<mres.length; i++) {
            for (int j=0 ; j<mres[0].length; j++) {
                mres[i][j] = 0;
                for (k=0 ; k<m2.length; k++) {
                    mres[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }

        // VERIFICA SE O RESULTADO DA MULTIPLICACAO ESTA CORRETO
        for (int i = 0; i < SIZE; i++) {
            k = SIZE * (i + 1);
            for (int j = 0; j < SIZE; j++) {
                int k_col = k * (j + 1);
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (mres[i][j] != k_col)
                            System.exit(1);
                    } else {
                        if (mres[i][j] != -k_col)
                            System.exit(1);
                    }
                } else {
                    if (j % 2 == 0) {
                        if (mres[i][j] != -k_col)
                            System.exit(1);
                    } else {
                        if (mres[i][j] != k_col)
                            System.exit(1);
                    }
                }
            }
        }


        // MOSTRA O TEMPO DE EXECUCAO
        System.out.printf("%s%f ", "Tempo de execução ", total);

    }

    private static Runnable t1 = new Runnable() {
        public void run() {


        }
    };

    public static void populaMatriz(int[][] array) {
        for (int k = 0; k < array.length; k++) {
            for (int j = 0; j < array.length; j++) {
                array[k][j] = random.nextInt();
            }
        }

    }


}