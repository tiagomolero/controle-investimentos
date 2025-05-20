package repository;

import model.Lancamento;
import model.TipoLancamento;

import java.util.ArrayList;
import java.util.List;

public class LancamentoRepository {

    private List<Lancamento> lancamentos = new ArrayList<>();
    private long proximoId = 1;

    public void adicionar(Lancamento lancamento){
        lancamento.setId(proximoId++);
        lancamentos.add(lancamento);
    }

    public List<Lancamento> listarTodos(){
        return new ArrayList<>(lancamentos);
    }

    public List<Lancamento> listarPorTipo(TipoLancamento tipo){
        return lancamentos.stream().filter(l -> l.getTipo() == tipo).toList();
    }

    public void limparTodos(){
        lancamentos.clear();
        proximoId = 1;
    }

}
