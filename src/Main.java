package com.pamokos;



import com.pamokos.db.aktoriai.papildomos;



public class Main {



    public static void main(String[] args) {



        papildomos objektas = new papildomos();

        objektas.Pasisveikinimas();

        while (true) {

            objektas.Paklausimas();

            objektas.Pasirinkimas();

        }

    }

}
