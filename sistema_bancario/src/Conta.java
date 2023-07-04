import java.util.ArrayList;
import java.util.Date;

public abstract class Conta implements Imprimivel {
	
	private String numero;
	protected double saldo;
	private Gerente gerente;
	private Cliente cliente;
	private ArrayList<Transacao> transacoes;
	
	public Conta(String numero, double saldo, Cliente cliente) {
		this.numero = numero;
		this.saldo = 0.0;
		this.cliente = cliente;
		this.transacoes = new ArrayList<Transacao>();
	}
	
	public Conta(String numero, Gerente gerente, Cliente cliente) {
		this.numero = numero;
		this.gerente = gerente;
		this.cliente = cliente;
		this.saldo = 0.0;
		this.transacoes = new ArrayList<Transacao>();
	}
	
	public void saque(double valor) {
		try {
			this.validarSaldo(valor); 
			this.saldo = saldo - valor;
			this.criarTransacao("saque", valor);
		} catch (SaldoInsuficienteException saldoInsuficiente) {
			System.out.println("Saque não realizado - " + saldoInsuficiente.getMessage());
		}
		
	}
	
	public void deposito(double valor) {
		this.saldo = this.saldo + valor;
		this.criarTransacao("depósito", valor);
	}
	
	public void imprimirExtrato() {
		for (Transacao transacao : this.transacoes) {
			System.out.println(transacao.getData() + " - " + transacao.getTipo() + " - " + transacao.getValor());
		}
		System.out.println("Saldo atual: " + saldo);
	}
	
	public void transferencia(double valor, Conta conta) {
		try {
			this.validarSaldo(valor);
			this.saque(valor);
			conta.deposito(valor);
			this.criarTransacao("Tranferência: ", valor);
		} catch (SaldoInsuficienteException saldoInsuficiente) {
			System.out.println("Transferência não realizada - " + saldoInsuficiente.getMessage());
		}
		
	}
	
	protected void criarTransacao(String tipo, double valor) {
		Transacao transacao = new Transacao(new Date(), tipo, valor);
		this.transacoes.add(transacao);
	}
	
	protected void validarSaldo(double valor) {
		if(valor > this.saldo) {
			throw new SaldoInsuficienteException();
		}
	}
	
	public String getNumero() {
		return numero;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public Gerente getGerente() {
		return gerente;
	}
	
	public void setGerente(Gerente gerente) {
		this.gerente = gerente;
	}
	public Cliente getCliente() {
		return cliente;
	}

}
