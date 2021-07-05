package com.company;

import java.util.Scanner;

public class Exercicio1 {
    public static void Execute() {
	/*
        Desenvolva um programa para mostrar os primeiros n números pares,
        sendo n um valor que o usuário irá inserir pelo console. Lembre-se
        que um número é par quando divisível por 2.
	 */
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número:");
        int n = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            if (i%2 == 0) {
                System.out.println(i);
            }
        }
    }
}
