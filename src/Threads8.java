
public class Threads8 extends Threads{

    public void paraleliza(){

        // PREPARA PARA MEDIR TEMPO
        long inicio = System.nanoTime();

        //INICIALIZA AS THREADS
        Thread c1 = new Thread(t1);
        Thread c2 = new Thread(t2);
        Thread c3 = new Thread(t3);
        Thread c4 = new Thread(t4);
        Thread c5 = new Thread(t5);
        Thread c6 = new Thread(t6);
        Thread c7 = new Thread(t7);
        Thread c8 = new Thread(t8);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
        c6.start();
        c7.start();
        c8.start();

        //AGUARDA FINALIZAÇÃO DAS THREADS
        try {

            c1.join();
            c2.join();
            c3.join();
            c4.join();
            c5.join();
            c6.join();
            c7.join();
            c8.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }


        // OBTEM O TEMPO
        long fim = System.nanoTime();
        double total = (fim-inicio)/1000000000.0;
   
        System.out.printf("%s%f ", "Tempo de execu��o 8 threads ", total);
        return;
    }


    private static Thread t1 = new Thread() {
        public void run() {
            try{
                for (int i=0 ; i<mres.length; i=i+8) {
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
                for (int i=1 ; i<mres.length; i=i+8) {
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
                for (int i=2 ; i<mres.length; i=i+8) {
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
                for (int i=3 ; i<mres.length; i=i+8) {
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

    private static Thread t5 = new Thread() {
        public void run() {
            try{
                for (int i=4 ; i<mres.length; i=i+8) {
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

    private static Thread t6 = new Thread() {
        public void run() {
            try{
                for (int i=5 ; i<mres.length; i=i+8) {
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

    private static Thread t7 = new Thread() {
        public void run() {
            try{
                for (int i=6 ; i<mres.length; i=i+8) {
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

    private static Thread t8 = new Thread() {
        public void run() {
            try{
                for (int i=7 ; i<mres.length; i=i+8) {
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