package model.application;

import model.entities.Cachorro;

public class Program {

    public static void main(String[] args) {

            Cachorro pitbull = new Cachorro("Drogo", 2);
            Cachorro salsicha = new Cachorro("Billy", 5);

            pitbull.reproduz(5);
            System.out.println();
            pitbull.reproduz();
            System.out.println();
            System.out.println(pitbull);
            Cachorro.infoCanil();

            System.out.println();
            System.out.println();
            salsicha.reproduz(2);
            System.out.println();
            salsicha.reproduz();
            System.out.println();
            System.out.println(salsicha);
            Cachorro.infoCanil();

    }
}
