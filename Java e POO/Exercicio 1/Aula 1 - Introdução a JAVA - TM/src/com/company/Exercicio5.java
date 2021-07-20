package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercicio5 {
    public static void Execute() {
	/*
	Exercício 5
    Desenvolver um programa para exibição por console os n primeiros números naturais que têm pelo menos de m dígitos de d, sendo n, m e d valores que o utilizador vai enviar pelo console.
    Por exemplo: se o usuário inserir n = 5, m = 2 e d = 3, o programa deve exibir os primeiros 5 números naturais que tenham pelo menos 2 dígitos 3 no console. Neste caso, a saída será: 33, 133 , 233, 303, 313.
    Dependendo de como você decidir abordar a solução para este exercício, pode ser necessário usar recursos que ainda não estudamos. O desafio é pesquisar no Google como usar esses recursos e usá-los!*/

        int n, m, d, count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o número N:");
        n = scanner.nextInt();

        System.out.println("Digite o número M:");
        m = scanner.nextInt();

        System.out.println("Digite o número D:");
        d = scanner.nextInt();

        List<Integer> naturalNumbers = new ArrayList<>();
        while(naturalNumbers.size() != n) {
            count++;
            String stringNumber = Integer.toString(count);
            if (stringNumber.length() - stringNumber.replaceAll(Integer.toString(d),"").length() >= m) {
                naturalNumbers.add(count);
            }
        }
        System.out.println(naturalNumbers);
    }
}
