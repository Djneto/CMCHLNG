package models;

import java.util.Scanner;

public class MainMenu {
    private int option;
    private String sourceCoin;
    private String endCoin;
    private double amount;
    private boolean exit = true;

    public void generate() {
        Scanner scanner = new Scanner(System.in);

            System.out.println(
                    """
                            
                            **********************************************
                            
                            Seja bem-vindo/a ao Conversor de Moeda =)
                            
                            [1]       Dólar      >>  Peso argentino
                            [2]  Peso argentino  >>      Dólar
                            [3]       Dólar      >>  Real Brasileiro
                            [4]  Real Brasileiro >>      Dólar
                            [5]       Dólar      >>  Peso colombiano
                            [6]  Peso colombiano >>      Dólar
                            [7]       Sair
                            
                            **********************************************
                            """
            );
        System.out.print("Digite a opção: ");
        setOption(scanner.nextInt());

        scanner.nextLine();

        switch (option) {
            case 1 -> {
                setSourceCoin("USD");
                setEndCoin("ARS");
            }
            case 2 -> {
                setSourceCoin("ARS");
                setEndCoin("USD");
            }
            case 3 -> {
                setSourceCoin("USD");
                setEndCoin("BRL");
            }
            case 4 -> {
                setSourceCoin("BRL");
                setEndCoin("USD");
            }
            case 5 -> {
                setSourceCoin("USD");
                setEndCoin("COP");
            }
            case 6 -> {
                setSourceCoin("COP");
                setEndCoin("USD");
            }
            case 7 -> {
                System.out.println("Saindo...");
                System.exit(0);
                return;
            }
            default -> {
                System.out.println("Opção inválida! Tente novamente.");
                generate();
            }
        }
        System.out.printf(
                """
                **********************************************
                
                Converter de %s para %s%n
                """, getSourceCoin(), getEndCoin()
        );
        //scanner.close();
    }

    public boolean close() {
        return exit;
    }

    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getOption() {
        return option;
    }

    private void setOption(int option) {
        this.option = option;
    }

    public String getSourceCoin() {
        return sourceCoin;
    }

    public void setSourceCoin(String sourceCoin) {
        this.sourceCoin = sourceCoin;
    }

    public String getEndCoin() {
        return endCoin;
    }

    public void setEndCoin(String endCoin) {
        this.endCoin = endCoin;
    }
}
