
public class ContaPoupanca extends Conta {
	
	private double rendimento;
	
	public ContaPoupanca(String numero, double saldo, Cliente cliente, double rendimento) {
		super(numero, saldo, cliente);
		this.rendimento = rendimento;
	}
	
	@Override
	public void imprimirExtrato() {
		super.imprimirExtrato();
		System.out.println("Rendimento: " + this.rendimento);
	}
	
	public double getRendimento() {
		return rendimento;
	}
	
	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}
	
	public double calcularRendimento() {
		double calculoRendimento = super.saldo * this.rendimento;
		super.saldo = super.saldo + calculoRendimento;
		return calculoRendimento;
	}

}
