package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MainClass {
	public static void main(String[] args) {
		FindArray findArray = new MyFindArray();
		int array[] = {4,9,3,7,8,7,8,8,7,8,7,7,8,8};
		int subArray[] = {3,7,8};
		
		System.out.println(findArray.findArray(array, subArray));
		
		FindCharachter findChar = new MyFindChar();
		String word = "aaaabbcccccdeeeefgggggh";
		
		System.out.println();
		System.out.println(findChar.findChar(word));
		
		Funcionario funcionario1 = new Funcionario("Assistente", "Administrativo", new BigDecimal(1000.0));
		Funcionario funcionario2 = new Funcionario("Gerente", "Administrativo", new BigDecimal(7000.70));
		Funcionario funcionario3 = new Funcionario("Diretor", "Administrativo", new BigDecimal(10000.45));
		Funcionario funcionario4 = new Funcionario("Assistente", "Financeiro", new BigDecimal(1300.9));
		Funcionario funcionario5 = new Funcionario("Gerente", "Financeiro", new BigDecimal(7500));
		Funcionario funcionario6 = new Funcionario("Diretor", "Financeiro", new BigDecimal(11000.0));
		Funcionario funcionario7 = new Funcionario("Estagiário", "Jurídico", new BigDecimal(700.4));
		Funcionario funcionario8 = new Funcionario("Assistente", "Jurídico", new BigDecimal(1800.90));
		Funcionario funcionario9 = new Funcionario("Gerente", "Jurídico", new BigDecimal(9500.50));
		Funcionario funcionario10 = new Funcionario("Diretor", "Jurídico", new BigDecimal(13000.0));
		
		List<Funcionario> listaFuncionario = new ArrayList<Funcionario>();
		listaFuncionario.add(funcionario1);
		listaFuncionario.add(funcionario2);
		listaFuncionario.add(funcionario3);
		listaFuncionario.add(funcionario4);
		listaFuncionario.add(funcionario5);
		listaFuncionario.add(funcionario6);
		listaFuncionario.add(funcionario7);
		listaFuncionario.add(funcionario8);
		listaFuncionario.add(funcionario9);
		listaFuncionario.add(funcionario10);
		
		Calculo calc = new MyCalculo();
		List<CustoCargo> listCustoCargo = calc.custoPorCargo(listaFuncionario);
		List<CustoDepartamento> listCustoDepartamento = calc.custoPorDepartamento(listaFuncionario);
		
		System.out.println("\nThe costs by roles are: ");
		listCustoCargo.forEach(System.out::println);

		System.out.println("\nThe costs by department are: ");
		listCustoDepartamento.forEach(System.out::println);
	}
}
