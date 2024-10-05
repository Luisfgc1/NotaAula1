import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);
        Aluno aluno = new Aluno();

        System.out.println("Digite o seu nome: ");
        aluno.setNome(sc2.nextLine());
        System.out.println(aluno.getNome());

        System.out.println("Digite sua primeira nota - (0 a 100): ");
        aluno.setNota1(sc.nextDouble());

        System.out.println("Digite sua segunda nota - (0 a 100): ");
        aluno.setNota2(sc.nextDouble());

        System.out.println("Digite sua terceira nota - (0 a 100): ");
        aluno.setNota3(sc.nextDouble());

        aluno.calcular_media();

        aluno.conferir_aprovacao();
        System.out.println(aluno.getNotaFinal());




    }
}