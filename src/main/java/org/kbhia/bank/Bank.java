package org.kbhia.bank;

import java.util.Scanner;

/**
 * GPT Bank feladat
 *
 * Kezdő egyenleg: 10 000 Ft
 * A program addig fusson, amíg a felhasználó ki nem lép
 * Minden körben jelenjen meg egy menü:
 * 1 - Egyenleg lekérdezése
 * 2 - Befizetés
 * 3 - Kifizetés
 * 4 - Kilépés
 *
 * @author hia
 * @author kissb
 * @version 1.0
 */
public class Bank {
    private final String ui = """
        BifBanking zrt.
        1 - Egyenleg lekérdezése
        2 - Befizetés
        3 - Kifizetés
        4 - Kilépés
        Választás:\s""";
    private Scanner input = new Scanner(System.in);
    private int balance = 10000;

    public void run() {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.print(ui);
            int choice = input.nextByte();
            switch (choice) {
                case 1:
                    getBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    System.out.println("Viszlát!");
                    loggedIn = false;
                    break;
                default:
                    System.out.println("Nincs ilyen menüpont!");
            }
        }
    }
    private void getBalance() {
        System.out.printf("Egyenleg: %,dFt.\n", balance);
    }
    private void deposit() {
        System.out.print("Adja meg mennyit szeretne befizetni: ");
        int depo = input.nextInt();
        if(depo > 0) {
            balance += depo;
            System.out.printf("Sikeresen feltöltötte a %dFt-ot.\n", depo);
            getBalance();
        }
        else{
            System.out.print("Nem sikerült feltölteni a kért összeget, mert helytelen értéket adott meg!");
        }

    }

    private void withdraw() {
        System.out.print("Adja meg mennyit szeretne kivenni: ");
        int with = input.nextInt();
        if (with > 0 && balance - with >= 0) {
            balance -= with;
            System.out.printf("Sikeres kifizetés %dFt értékben.\n", with);
            getBalance();
        } else {
            System.out.print("Nem sikerült levenni a kért összeget, mert nincs elég pénz a számlán vagy vagy nem pozitív értéket adott meg!\n");
        }
    }
}