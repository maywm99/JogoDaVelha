package jogodavelha;
import java.util.Scanner;
import java.util.Random;

public class JogoDaVelha {

    static void Tabuleiro (String[][] tabuleiro) {
        System.out.printf("\n-+ Jogo da Velha +-\n");
        System.out.printf("     1   2   3\n");
        System.out.printf("   1 %s | %s | %s\n", tabuleiro[0][0], tabuleiro[0][1], tabuleiro[0][2]);
        System.out.printf("    ---+---+---\n");
        System.out.printf("   2 %s | %s | %s\n", tabuleiro[1][0], tabuleiro[1][1], tabuleiro[1][2]);
        System.out.printf("    ---+---+---\n");
        System.out.printf("   3 %s | %s | %s\n\n", tabuleiro[2][0], tabuleiro[2][1], tabuleiro[2][2]);
    }
    
    static int ChecarVencedor (String[][] tabuleiro) {
        int vencedor = 0;
        
        if (tabuleiro[0][0] == tabuleiro[0][1] && tabuleiro[0][1] == tabuleiro[0][2] && tabuleiro[0][0] != "-") {
                if (tabuleiro[0][0] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[1][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[1][2] && tabuleiro[1][0] != "-") {
                if (tabuleiro[1][0] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[2][0] == tabuleiro[2][1] && tabuleiro[2][1] == tabuleiro[2][2] && tabuleiro[2][0] != "-") {
                if (tabuleiro[2][0] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[0][0] == tabuleiro[1][0] && tabuleiro[1][0] == tabuleiro[2][0] && tabuleiro[0][0] != "-") {
                if (tabuleiro[0][0] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[0][1] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][1] && tabuleiro[0][1] != "-") {
                if (tabuleiro[0][1] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[0][2] == tabuleiro[1][2] && tabuleiro[1][2] == tabuleiro[2][2] && tabuleiro[0][2] != "-") {
                if (tabuleiro[0][2] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[0][0] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][2] && tabuleiro[0][0] != "-") {
                if (tabuleiro[0][0] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            } else if (tabuleiro[0][2] == tabuleiro[1][1] && tabuleiro[1][1] == tabuleiro[2][0] && tabuleiro[0][2] != "-") {
                if (tabuleiro[0][2] == "X") {
                    System.out.println("Jogador venceu!");
                } else {
                    System.out.println("Computador venceu!");
                }
                vencedor++;
            }
            return vencedor;
    }
    
    public static void main(String[] args) {
        String[][] tabuleiro = { {"-", "-", "-"}, {"-", "-", "-"}, {"-", "-", "-"} };
        int l, c, empate, vencedor;
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        Tabuleiro(tabuleiro);
        while (true) {
            
            System.out.print("Digite a linha: ");
            l = scan.nextInt();
            System.out.print("Digite a coluna: ");
            c = scan.nextInt();
            
            while(c > 3 || l > 3 || tabuleiro[l-1][c-1] != "-") {
                System.out.println("\nTente novamente.");
                System.out.print("Digite a linha: ");
                l = scan.nextInt();
                System.out.print("Digite a coluna: ");
                c = scan.nextInt();
            }
            tabuleiro[l-1][c-1] = "X";
            
            Tabuleiro(tabuleiro);
            
            vencedor = ChecarVencedor(tabuleiro);
            if (vencedor == 1) {
                break;
            }
            
            empate = 0;
            for (l = 0; l < 3; l++) {
                for (c = 0; c < 3; c++) {
                    if (tabuleiro[l][c] != "-") {
                        empate++;
                    }
                }
            }
            if (empate == 9) {
                System.out.println("Empate!");
                break;
            }
            
            System.out.println("Vez do computador. Escolhendo...");
            l = rand.nextInt(3);
            c = rand.nextInt(3);
            
            while (tabuleiro[l][c] != "-") {
                l = rand.nextInt(3);
                c = rand.nextInt(3);
            }
            tabuleiro[l][c] = "O";
            
            Tabuleiro(tabuleiro);
            
            vencedor = ChecarVencedor(tabuleiro);
            if (vencedor == 1) {
                break;
            }
        }
    }
}