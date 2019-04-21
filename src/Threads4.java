
public class Threads4 extends Threads2{

    public void paraleliza(){

        // PREPARA PARA MEDIR TEMPO
        long inicio = System.nanoTime();

        //INICIALIZA AS THREADS
        Thread b1 = new Thread(t1);
        Thread b2 = new Thread(t2);
        Thread b3 = new Thread(t3);
        Thread b4 = new Thread(t4);

        b1.start();
        b2.start();
        b3.start();
        b4.start();

        //AGUARDA FINALIZAÇÃO DE AMBAS THREADS
        try {

            b1.join();
            b2.join();
            b3.join();
            b4.join();
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
                for (int i=0 ; i<mres.length; i=i+4) {
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
                for (int i=1 ; i<mres.length; i=i+4) {
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

    private static Thread t3 = new Thread() {
        public void run() {
            try{
                for (int i=2 ; i<mres.length; i=i+4) {
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

    private static Thread t4 = new Thread() {
        public void run() {
            try{
                for (int i=3 ; i<mres.length; i=i+4) {
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