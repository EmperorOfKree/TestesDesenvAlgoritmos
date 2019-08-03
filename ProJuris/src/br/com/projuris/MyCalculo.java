package br.com.projuris;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MyCalculo implements Calculo {

	@Override
	public List<CustoCargo> custoPorCargo(List<Funcionario> funcionarios) {
		Map<String, BigDecimal> mapCargos = getMapCargos(funcionarios);
		return getListCustoCargo(mapCargos);
	}

	private List<CustoCargo> getListCustoCargo(Map<String, BigDecimal> mapCargos) {
		List<CustoCargo> listCustoCargo = new ArrayList<CustoCargo>();
		
		mapCargos.keySet().forEach(key -> listCustoCargo.add(new CustoCargo(key, mapCargos.get(key))));
		return listCustoCargo;
	}

	private Map<String, BigDecimal> getMapCargos(List<Funcionario> funcionarios) {
		return funcionarios.stream().collect(Collectors.toMap(Funcionario::getCargo, Funcionario::getSalario, BigDecimal::add));
	}

	@Override
	public List<CustoDepartamento> custoPorDepartamento(List<Funcionario> funcionarios) {
		Map<String, BigDecimal> mapDepartamentos = getMapDepartamento(funcionarios);
		return getListCustoDepartamento(mapDepartamentos);
	}

	private List<CustoDepartamento> getListCustoDepartamento(Map<String, BigDecimal> mapDepartamentos) {
		List<CustoDepartamento> listCustoDepartamento = new ArrayList<CustoDepartamento>();
		
		mapDepartamentos.keySet().forEach(key -> listCustoDepartamento.add(new CustoDepartamento(key, mapDepartamentos.get(key))));
		return listCustoDepartamento;
	}

	private Map<String, BigDecimal> getMapDepartamento(List<Funcionario> funcionarios) {
		return funcionarios.stream().collect(Collectors.toMap(Funcionario::getDepartamento, Funcionario::getSalario, BigDecimal::add));
	}
}
