public class App {
    public static void main(String[] args) throws Exception {
        
        Pessoa dono = new Pessoa("André");

        ContaBanco contaBanco = new ContaBanco();
        contaBanco.abrirConta("Cp");
        contaBanco.setDono(dono);
        contaBanco.getDono();
        contaBanco.depositar(100);

        contaBanco.sacar(35);
        contaBanco.sacar(35);
        contaBanco.sacar(10);
        contaBanco.sacar(10);
        contaBanco.sacar(150);
        // contaBanco.sacar(67);
        contaBanco.pagarMensal();

    }
}
