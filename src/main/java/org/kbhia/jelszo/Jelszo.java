package org.kbhia.jelszo;

import java.util.Scanner;

public class Jelszo {
    /*
    Erősségi tényezők:
    legalább 8 karakter hosszú
    tartalmaz legalább egy számot
    tartalmaz legalább egy nagybetűt
    */
    String password = "";
    public void run() {
        Scanner input = new Scanner(System.in);

        System.out.print("Jelszó: ");
        password = input.nextLine();
        if (password.isEmpty()) {
            System.out.println("Nem adott meg jelszót");
        } else if (validate() >= 2) {
            System.out.println("Erős jelszót választott");
        } else {
            System.out.println("Gyenge jelszót választott");
        }
    }
    private int validate() {
        boolean[] conditions = {false, false, false};

        if (password.length() >= 8) {
            conditions[0] = true;
        }
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isDigit(c)) {
                conditions[1] = true;
            } else if (Character.isUpperCase(c)) {
                conditions[2] = true;
            }
        }

        int strength = 0;
        for (boolean condition : conditions) {
            if (condition) {
                strength++;
            }
        }
        return strength;
    }
}
