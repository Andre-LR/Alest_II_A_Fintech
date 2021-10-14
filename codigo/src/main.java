public class main{
    public static void main(String[] args) {
        Sistema sistema = new Sistema();

        sistema.lerArquivo();
        System.out.println(sistema.showDados());
    }
}