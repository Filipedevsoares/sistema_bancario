
public abstract class Emprestimo implements Imprimivel {
	
	private int codigo;
	private double juros;
	protected double valor;
	protected double parcelas;
	
	public Emprestimo(int codigo, double juros, double valor, double parcelas) {
		super();
		this.codigo = codigo;
		this.juros = juros;
		this.valor = valor;
		this.parcelas = parcelas;
	}

	public double getJuros() {
		return juros;
	}

	public void setJuros(double juros) {
		this.juros = juros;
	}

	public double getParcelas() {
		return parcelas;
	}

	public void setParcelas(double parcelas) {
		this.parcelas = parcelas;
	}

	public int getCodigo() {
		return codigo;
	}

	public double getValor() {
		return valor;
	}
	
	public abstract void imprimirExtrato();
	
	public void pagarParcela() {
		this.valor += this.juros * this.valor;
		double valorParcela = this.valor / this.parcelas;
		this.parcelas = this.parcelas - 1;
		this.valor -= valorParcela;
	}

}
