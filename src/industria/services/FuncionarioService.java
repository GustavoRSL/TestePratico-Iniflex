package industria.services;
import industria.models.Funcionario;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

//FuncionarioService

public class FuncionarioService {
	private static final List<Funcionario> LISTA_FUNCIONARIOS = new ArrayList<>();
	
	public static List<Funcionario> getListafuncionarios() {
		return LISTA_FUNCIONARIOS;
	}
	
	public static List<Funcionario> getListaFuncionarios() {
	    return LISTA_FUNCIONARIOS;
	}

    public static void adicionarFuncionario(Funcionario funcionario) {
    	LISTA_FUNCIONARIOS.add(funcionario);
    }
    
    public static void removerFuncionario(Funcionario funcionario) {
        if (LISTA_FUNCIONARIOS.contains(funcionario)) {
        	LISTA_FUNCIONARIOS.remove(funcionario);
            System.out.println("Funcionário " + funcionario.getNome() + " removido com sucesso.");
        } else {
            System.out.println("Funcionário não encontrado na lista.");
        }
    }
    
    public static Funcionario buscarFuncionarioPorNome(String nome) {
        return LISTA_FUNCIONARIOS.stream()
                .filter(f -> f.getNome().equalsIgnoreCase(nome)) 
                .findFirst()
                .orElse(null);  
    }
	
	public static ArrayList<Funcionario> getAniversariantesDoMes(Integer mes) {
		ArrayList<Funcionario> aniversariantes = new ArrayList<Funcionario>();
		System.out.println("Aniversariantes no mês " + mes);
		LISTA_FUNCIONARIOS.forEach(f -> { if(f.getDataNascimento().getMonthValue() == mes) {aniversariantes.add(f); }});
		return aniversariantes;
	}
	
	@SuppressWarnings("unused")
	public static Map<String, ArrayList<Funcionario>> agruparFuncionariosPorFuncao() {
		Map<String, ArrayList<Funcionario>> funcionariosAgrupados = new HashMap<>();
		LISTA_FUNCIONARIOS.forEach(f -> funcionariosAgrupados.computeIfAbsent(f.getFuncao(), k -> new ArrayList<Funcionario>()).add(f));		
		return funcionariosAgrupados;
	}
	
	public static Funcionario getFuncionarioComMaiorIdade() {
	    return LISTA_FUNCIONARIOS.stream()
	        .reduce((f1, f2) -> f1.getDataNascimento().compareTo(f2.getDataNascimento()) < 0 ? f1 : f2)
	        .orElse(null);
	}
	
	public static List<Funcionario> getFuncionariosEmOrdemAlfabetica() {
		 System.out.println("Lista de funcionários Ordenados por ordem alfabética");
		 List<Funcionario> listaFuncionariosOrdenados = new ArrayList<Funcionario>(LISTA_FUNCIONARIOS);
		 listaFuncionariosOrdenados.sort(Comparator.comparing(Funcionario::getNome));
		 return listaFuncionariosOrdenados;
	}
}
