package models;

import java.util.Scanner;

public class ConversorMenu {
    private double amount;

    public void generate() {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("Digite o valor para conversão: ");
        setAmount(scanner.nextDouble());

        //scanner.close();
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
