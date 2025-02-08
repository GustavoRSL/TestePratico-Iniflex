package industria.services;
import industria.models.Funcionario;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ImprimirFuncionarioService {
    public static void imprimirFuncionarios() {
        imprimirFuncionarios(FuncionarioService.getListaFuncionarios());
    }
    
	public static void imprimirFuncionarios(List<Funcionario> funcionarios) {
	    if (funcionarios.isEmpty()) { 
	        System.out.println("Não há funcionários para exibir.\n");
	        return;
	    }
	    
		System.out.println("+---------------------+------------+--------------+-----------------+");
        System.out.printf("| %-14s | %-15s | %-12s | %-15s |\n", "Nome", "Data Nascimento", "Salário", "Função");
        System.out.println("+---------------------+------------+--------------+-----------------+");
        
        for (Funcionario f : funcionarios) {
            System.out.printf("| %-14s | %-15s | R$%-10s | %-15s |\n", f.getNome(), DataService.formatarData(f.getDataNascimento()), SalarioService.formatarSalario(f.getSalario()), f.getFuncao());
        }
		
        System.out.println("+---------------------+------------+--------------+-----------------+\n");
	}
	
	public static void imprimirFuncionariosAgrupados(Map<String, ArrayList<Funcionario>> funcionariosAgrupados) {
		for(Map.Entry<String, ArrayList<Funcionario>> funcionario : funcionariosAgrupados.entrySet()) {
			System.out.println("Função: " + funcionario.getKey());
			ArrayList<Funcionario> funcionariosPorCategoria = funcionario.getValue(); 
	        imprimirFuncionarios(funcionariosPorCategoria);
		}
	}
	
	public static void imprimirFuncionariosAgrupadosPorFuncao(Map<String, ArrayList<Funcionario>> funcionariosAgrupados, String funcao) {
		ArrayList<Funcionario> funcionariosPorCategoria = funcionariosAgrupados.get(funcao);
		System.out.println("Função: " + funcao);
		if (funcionariosPorCategoria != null) {
		    imprimirFuncionarios(funcionariosPorCategoria);
		} else {
		    System.out.println("Categoria não encontrada.\n");
		}
	}
	
	public static void imprimirFuncionarioMaiorIdade(Funcionario funcionario) {
		System.out.println("Funcionário com maior idade: Nome " + funcionario.getNome() + " " + DataService.calcularIdade(funcionario.getDataNascimento()) + " Anos.\n");
	}
	
	public static void imprimirSalarioTotalDosFuncionarios(BigDecimal salarioTotal) {
		System.out.println("Salário total dos funcionários é: R$" + SalarioService.formatarSalario(salarioTotal));
	}
}
