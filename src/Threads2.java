import java.util.Random;

public class Threads2 extends Threads{


    public void paraleliza(){

        // PREPARA PARA MEDIR TEMPO
        long inicio = System.nanoTime();

        //INICIALIZA AS THREADS
        Thread a1 = new Thread(t1);
        Thread a2 = new Thread(t2);


        a1.start();
        a2.start();


        //AGUARDA FINALIZAÇÃO DE AMBAS THREADS
        try {
            a1.join();
            a2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        // OBTEM O TEMPO
        long fim = System.nanoTime();
        double total = (fim-inicio)/1000000000.0;
    }

    private static Thread t1 = new Thread() {
        public void run() {
            try{
                for (int i=0 ; i<mres.length; i=i+2) {
                    for (int j=0 ; j<mres[0].length; j++) {
                        mres[i][j] = 0;
                        for (int k=0 ; k<m2.length; k++) {
                            mres[i][j] += m1[i][k] * m2[k][j];
                        }
                    }
                }

            } catch (Exception e){}

        }
    };

    private static Thread t2 = new Thread() {
        public void run() {
            try{
                for (int i=1 ; i<mres.length; i=i+2) {
                    for (int j=0 ; j<mres[0].length; j++) {
                        mres[i][j] = 0;
                        for (int k=0 ; k<m2.length; k++) {
                            mres[i][j] += m1[i][k] * m2[k][j];
                        }
                    }
                }
            } catch (Exception e){}
        }
    };






}