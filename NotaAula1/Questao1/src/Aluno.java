public class Aluno {

    private double nota1;
    private double nota2;
    private double nota3;
    private String nome;
    private double notaFinal;

    public void conferir_aprovacao(){

        if (notaFinal < 40){
            System.out.println(nome + ", Voce esta reprovado!");
        } else if (notaFinal >= 40 && notaFinal < 70) {
            System.out.println(nome + ", Voce fará a prova final!");
        }else {
            System.out.println(nome + ", Voce esta aprovado!");
        }
    }





    public void calcular_media(){
        notaFinal = (nota1+nota2+nota3)/3;

    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

}
