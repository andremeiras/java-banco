public class ContaBanco {

    public int numConta;
    protected String tipo; // Cc ou Cp
    private Pessoa dono;
    private double saldo;
    private boolean status;

    public ContaBanco() {
    }

    public ContaBanco(int numConta, String tipo, Pessoa dono) {
        this.numConta = numConta;
        this.tipo = tipo;
        this.dono = dono;
        this.saldo = 0;
        this.status = false;
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public Pessoa getDono() {
        return dono;
    }

    public void setDono(Pessoa dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void abrirConta(String tipo) {
        setTipo(tipo);
        setStatus(true);

        if (tipo == "Cc") {
            setSaldo(50.0);
        } else if (tipo == "Cp") {
            setSaldo(150.0);
        } else {
            setSaldo(0.0);
        }
    }

    public void fecharConta() {
        if (getStatus() && getSaldo() == 0) {
            setStatus(false);
            System.out.println("Saldo: R$ " + getSaldo() + " | Conta fechada com sucesso!");
        } else if (getSaldo() > 0) {
            setStatus(true);
            System.out.println("Saldo: R$ " + getSaldo()
                    + " | Não é possível fechar uma conta com saldo positivo. Faça um saque do mesmo valor do saldo atual antes de encerrar a conta.");
        } else {
            setStatus(false);
            System.out.println("Saldo: R$ " + getSaldo()
                    + " | Não é possível fechar uma conta com débitos. Pague o valor devido antes de encerrar a conta.");
        }
    }

    public void depositar(double valor) {
        if (getStatus()) {
            setSaldo(getSaldo() + valor);
            System.out.println("Valor depositado: R$ " + valor);
            System.out.println("Saldo atual: R$ " + getSaldo());
        } else {
            System.out.println("Conta fechada ou não foi aberta ainda.");
        }
    }

    public void sacar(double valor) {
        if (getStatus()) {
            System.out.println("Valor do saque: R$ " + valor);
            if (getSaldo() >= valor) {
                setSaldo(getSaldo() - valor);
                System.out.println("Saldo atual: R$ " + getSaldo());
            } else if (getSaldo() <= valor) {
                System.out.println("Saldo insuficiente. Saldo atual: R$ " + getSaldo());
            }
        } else {
            System.out.println("Conta está fechada. Impossível sacar!");
        }
    }

    public void pagarMensal() {

        double valor = 0;

        if (getStatus()) {
            if (getTipo() == "Cc") {
                valor = 12;
                if (getSaldo() >= valor) {
                    setSaldo(getSaldo() - valor);
                    System.out.println("Mensalidade paga. Valor R$ " + valor + " | Saldo atual: R$ " + getSaldo());
                } else {
                    System.out.println("Saldo insuficiente ou conta encerrada. Impossível cobrar mensalidade.");
                }
            } else if (getTipo() == "Cp") {
                valor = 20;
                if (getSaldo() >= valor) {
                    setSaldo(getSaldo() - valor);
                    System.out.println("Mensalidade paga. Valor R$ " + valor + " | Saldo atual: R$ " + getSaldo());
                } else {
                    System.out.println("Saldo: R$ " + getSaldo());
                    System.out.println("Conta aberta: " + getStatus());
                    System.out.println("Impossível cobrar mensalidade.");
                }
            } else {
                System.out.println("Tipo de conta desconhecido. Impossível cobrar mensalidade.");
            }
        } else {
            System.out.println("A conta não está aberta.");
        }
    }
}
