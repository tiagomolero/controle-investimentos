package service;

import model.TipoLancamento;
import repository.LancamentoRepository;

import java.time.Month;
import java.util.Map;
import java.util.stream.Collectors;

public class LancamentoService {

    private LancamentoRepository repository;

    public LancamentoService(LancamentoRepository repository){
        this.repository = repository;
    }

    public double calcularSaldoTotal(){
        return repository.listarTodos().stream()
                .mapToDouble(l -> l.getTipo() == TipoLancamento.RECEITA
                ? l.getValor() :
                -l.getValor())
                .sum();
    }

    public Map<Month, Double> calcularSaldoMensal(){
        return repository.listarTodos().stream()
                .collect(Collectors.groupingBy(l -> l.getData().getMonth(),
                        Collectors.summingDouble(l -> l.getTipo() == TipoLancamento.RECEITA
                        ? l.getValor()
                        : -l.getValor())
                ));
    }

    public double simularInvestimento(double aporteMensal, double taxaJurosMensal, int meses){
        double total = 0.0;
        for (int i = 1; i <= meses; i++){
            total = (total + aporteMensal) * (i + taxaJurosMensal);
        }
        return total;
    }

}
