package com.hanoigame;

import java.util.Scanner;

public class App {
    public static boolean invalid(String command) {

        if (command.length() != 2 || command.charAt(0) == command.charAt(1)) {
            return true;
        }

        if (!Character.isLetter(command.charAt(0)) || !Character.isLetter(command.charAt(1))) {
            return true;
        }

        return false;
    }

    public static int[] strToCommand(String str) {
        int[] indexes = new int[2];
        indexes[0] = str.charAt(0) - 'A';
        indexes[1] = str.charAt(1) - 'A';
        return indexes;
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int input;

        do {
            System.out.println("Defina a dificuldade:\n(1) Fácil\n(2) Médio\n(3) Difícil\n(4) Difícil +");
            input = kb.nextInt();
        } while (input < 1 || input > 4);
        int[] dificulties = { 3, 5, 7, 8 };
        Game game = new Game(dificulties[input - 1]);
        do {
            System.out.println("Defina a ordem:\n(1) Crescente\n(2) Decrescente");
            input = kb.nextInt();
        } while (input < 1 || input > 2);
        int order = input;
        String command;
        do {
            game.show();
            System.out.println("(0) Sair\n(1) Movimentar\n(2) Resolver Sozinho");
            input = kb.nextInt();
            if (input == 1) {
                System.out.println("Escreva a letra da torre de saida e da de chegada (ex: AB)");
                do {
                    command = kb.nextLine();
                } while (invalid(command));
                int[] move = strToCommand(command);
                game.move(move[0], move[1]);
            }
            if (input == 2) {
                if (order == 1) {
                    game.solveAsc();
                }
                if (order == 2) {
                    game.solveDes();
                }
                break;
            }
            if ((order == 1 && game.ascending()) || (order == 2 && game.descending())) {
                break;
            }
        } while (input != 0);

        game.show();
        System.out.println("Vitoria! Movimentos realizados: " + game.getMoves());

        kb.close();
    }
}