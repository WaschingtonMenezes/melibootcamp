package com.company;

import java.util.Scanner;

/* Exercício 3:  Para um protótipo de supermercado, crie um programa que leia 3 produtos e imprima no console: nome, preço, quantidade e o valor total da compra.*/
public class Exercicio3 {

    private static class Produto {
        public String name;
        public double price;
        public int amount;

        Produto (String name, double price, int amount) {
            this.name = name;
            this.price = price;
            this.amount = amount;
        }
    }

    public static void execute() {
        Scanner scanner = new Scanner(System.in);
        Produto[] produto = new Produto[3];

        String name;
        double price;
        int amount;

        for (int i=0; i < 3; i ++) {
            System.out.println(String.format("Produto %d - Nome:", i + 1));
            name = scanner.next();
            System.out.println(String.format("Produto %d - Preço:", i + 1));
            price = scanner.nextDouble();
            System.out.println(String.format("Produto %d - Quantidade:", i + 1));
            amount = scanner.nextInt();
            produto[i] = new Produto(name, price, amount);
        }

        double totalAmount = 0;
        for (int i=0; i < produto.length; i++) {
            System.out.println(String.format("Produto %d", i + 1));
            System.out.println(String.format("%s", produto[i].name));
            System.out.println(String.format("R$%.2f", produto[i].price));
            System.out.println(String.format("Quantidade: %d\n", produto[i].amount));

            totalAmount += (double) produto[i].price * produto[i].amount;
        }
        System.out.println(String.format("Valor Total: R$%.2f", totalAmount));
    }
}
