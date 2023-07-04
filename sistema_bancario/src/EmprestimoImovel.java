
public class EmprestimoImovel extends Emprestimo {
	
	private double reforco;
	
	public EmprestimoImovel( int codigo, double juros, double valor, double parcelas, double reforco) {
		super(codigo, juros, valor, parcelas);
		this.reforco = reforco;
	}
	
	public void pagarReforco() {
		super.valor -= this.reforco;
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("Valor: " + super.valor);
		System.out.println("Parcelas: " + super.parcelas);
		System.out.println("Reforco: " + this.reforco);
		
	}
	
	public double getReforco() {
		return reforco;
	}
	
	public void setReforco(double reforco) {
		this.reforco = reforco;
	}

}
