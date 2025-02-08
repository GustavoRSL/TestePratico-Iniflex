package industria;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class SalarioService {
	public BigDecimal salarioMinimo;
	
	public BigDecimal getSalarioMinimo() {
		return salarioMinimo;
	}

	public void setSalarioMinimo(BigDecimal salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}

	public SalarioService(BigDecimal salarioMinimo) {
		this.salarioMinimo = salarioMinimo;
	}
	
	public void salariosMinimosFuncionario(Funcionario funcionario) {
		BigDecimal quantidadeSalariosMinimos = getSalariosMinimosFuncionario(funcionario.getSalario(), this.salarioMinimo);
		if (quantidadeSalariosMinimos.compareTo(BigDecimal.ONE) <= 0) {
		    System.out.println("Funcionário " + funcionario.getNome() + " recebe " + quantidadeSalariosMinimos + " salário mínimo.\n");
		} else {
		    System.out.println("Funcionário " + funcionario.getNome() + " recebe " + quantidadeSalariosMinimos + " salários mínimos.\n");
		}	
	}
	
	public void salariosMinimosTodosFuncionarios(List<Funcionario> listaFuncionarios) {
		System.out.println("\nQuantidade de sálarios mínimos de cada funcionario.\n");
		listaFuncionarios.forEach(f -> salariosMinimosFuncionario(f));
	}
	
	public BigDecimal getSalarioTotalDosFuncionarios(List<Funcionario> listaFuncionarios) {
		BigDecimal totalSalarios = listaFuncionarios.stream().map(Funcionario::getSalario).reduce(BigDecimal.ZERO, BigDecimal::add);
		return totalSalarios;
	}
	
	public void aumentarSalarioFuncionario(Funcionario funcionario, BigDecimal porcentagem) {
		funcionario.setSalario(funcionario.getSalario().multiply(porcentagem));
	}
	
	public void aumentarSalarioTodosFuncionarios(List<Funcionario> listaFuncionarios, BigDecimal porcentagem) {
		listaFuncionarios.forEach(f -> aumentarSalarioFuncionario(f, porcentagem));
	}
	
	public static String formatarSalario(BigDecimal salario) {
		NumberFormat formatoBR = NumberFormat.getNumberInstance(Locale.of("pt", "BR"));
        formatoBR.setMinimumFractionDigits(2);
        formatoBR.setMaximumFractionDigits(2);
        
        return formatoBR.format(salario);
	}
	
	public BigDecimal getSalariosMinimosFuncionario(BigDecimal salario, BigDecimal salarioMinimo) {
		return salario.divide(salarioMinimo, 0, RoundingMode.FLOOR);
	}
}
