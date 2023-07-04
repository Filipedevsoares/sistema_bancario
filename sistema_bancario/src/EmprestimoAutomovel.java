
public class EmprestimoAutomovel extends Emprestimo {

	public EmprestimoAutomovel(int codigo, double juros, double valor, double parcelas) {
		super(codigo, juros, valor, parcelas);
		
	}
	
	@Override
	public void imprimirExtrato() {
		
		System.out.println("Valor: " + super.valor);
		System.out.println("Parcelas: " + super.parcelas);
		System.out.println("Juros: " + super.getJuros());
		
	}
	
	

}
