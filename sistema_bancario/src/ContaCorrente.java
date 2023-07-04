import java.util.ArrayList;
import java.util.List;

public class ContaCorrente extends Conta {
	
	private double tarifa;
	private double limite;
	private List<Emprestimo> emprestimos;
	
	public ContaCorrente(String numero, double saldo, Cliente cliente, double tarifa) {
		super(numero, saldo, cliente);
		this.tarifa = tarifa;
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	public ContaCorrente(String numero, double saldo, Cliente cliente, double tarifa, double limite) {
		super(numero, saldo, cliente);
		this.tarifa = tarifa;
		this.limite = limite;
		this.emprestimos = new ArrayList<Emprestimo>();
	}
	
	@Override
	protected void validarSaldo(double valor) {
		if(valor > super.saldo + this.limite) {
			throw new SaldoInsuficienteException();
		}
	
	}
	
	public void imprimirExtrato() {
		super.imprimirExtrato();
		System.out.println("Tarifa: " + this.tarifa);
		System.out.println("Limite: " + this.limite);
	}
	
	public void pegarEmprestimo(Emprestimo emprestimo) {
		this.emprestimos.add(emprestimo);
		super.criarTransacao("Empréstimo: ", emprestimo.getValor());
	}
	
	public void pagarEmprestimo(int codigo) {
		for(Emprestimo emprestimo : this.emprestimos) {
			if(emprestimo.getCodigo() == codigo) {
				emprestimo.pagarParcela();
				return;
			}
		}
	}
	
	public double getTarifa() {
		return tarifa;
	}
	
	public void setTarifa(double tarifa) {
		this.tarifa = tarifa;
	}
	
	public double getLimite() {
		return limite;
	}
	
	public void setLimite(double limite) {
		this.limite = limite;
	}

	public List<Emprestimo> getEmprestimos() {
		return emprestimos;
	}
	
	

}
