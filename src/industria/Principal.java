package industria;

import java.math.BigDecimal;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.Map;

import industria.models.Funcionario;
import industria.services.FuncionarioService;
import industria.services.ImprimirFuncionarioService;
import industria.services.SalarioService;


public class Principal {	
	public static void main(String[] args) {
		
		criarFuncionarios();
		SalarioService salarioService = new SalarioService(new BigDecimal("1212.00"));
		
		//3.2 – Remover o funcionário “João” da lista.
		Funcionario deletarFuncionario = FuncionarioService.buscarFuncionarioPorNome("João");
		FuncionarioService.removerFuncionario(deletarFuncionario);
		
		// 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
		ImprimirFuncionarioService.imprimirFuncionarios();
		
        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista de funcionários com novo valor.
		salarioService.aumentarSalarioTodosFuncionarios(FuncionarioService.getListaFuncionarios(), new BigDecimal("1.10"));
        
        //3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função” e o valor a “lista de funcionários”.
		Map<String, ArrayList<Funcionario>> funcionariosAgrupados = FuncionarioService.agruparFuncionariosPorFuncao();
        
        //3.6 – Imprimir os funcionários, agrupados por função.
		ImprimirFuncionarioService.imprimirFuncionariosAgrupados(funcionariosAgrupados);
        
        //3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
		ImprimirFuncionarioService.imprimirFuncionarios(FuncionarioService.getAniversariantesDoMes(10));
		ImprimirFuncionarioService.imprimirFuncionarios(FuncionarioService.getAniversariantesDoMes(12));
        
        //3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e idade.
        Funcionario funcionario = FuncionarioService.getFuncionarioComMaiorIdade();
        ImprimirFuncionarioService.imprimirFuncionarioMaiorIdade(funcionario);
        
        //3.10 – Imprimir a lista de funcionários por ordem alfabética.
        ImprimirFuncionarioService.imprimirFuncionarios(FuncionarioService.getFuncionariosEmOrdemAlfabetica());
        
        //3.11 – Imprimir o total dos salários dos funcionários.
        BigDecimal salarioTotalDosFuncionarios = salarioService.getSalarioTotalDosFuncionarios(FuncionarioService.getListaFuncionarios());
        ImprimirFuncionarioService.imprimirSalarioTotalDosFuncionarios(salarioTotalDosFuncionarios);
        
        //3.12 – Imprimir quantos salários mínimos ganha cada funcionário, considerando que o salário mínimo é R$1212.00.
        salarioService.salariosMinimosTodosFuncionarios(FuncionarioService.getListaFuncionarios());
	}

	private static void criarFuncionarios() {
		// 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela acima.
		FuncionarioService.adicionarFuncionario(new Funcionario("Maria", LocalDate.parse("2000-10-18"), new BigDecimal(2009.44), "Operador"));
		FuncionarioService.adicionarFuncionario(new Funcionario("João", LocalDate.parse("1990-05-12"), new BigDecimal(2284.38), "Operador"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Caio", LocalDate.parse("1961-05-02"), new BigDecimal(9836.14), "Coordenador"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Miguel", LocalDate.parse("1988-10-14"), new BigDecimal(19119.88), "Diretor"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Alice", LocalDate.parse("1995-01-05"), new BigDecimal(2234.68), "Recepcionista"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Heitor", LocalDate.parse("1999-11-19"), new BigDecimal(1582.72), "Operador"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Arthur", LocalDate.parse("1993-03-31"), new BigDecimal(4071.84), "Contador"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Laura", LocalDate.parse("1994-07-08"), new BigDecimal(3017.45), "Gerente"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Heloísa", LocalDate.parse("2003-05-24"), new BigDecimal(1606.85), "Eletricista"));
		FuncionarioService.adicionarFuncionario(new Funcionario("Helena", LocalDate.parse("1996-09-02"), new BigDecimal(2799.93), "Gerente"));
	}
}
