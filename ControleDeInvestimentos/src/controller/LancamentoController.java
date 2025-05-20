package controller;

import model.Lancamento;
import model.TipoLancamento;
import repository.LancamentoRepository;
import service.LancamentoService;

import javax.security.auth.callback.LanguageCallback;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class LancamentoController {

    private LancamentoRepository repository;
    private LancamentoService service;
    private Scanner scanner;

    public LancamentoController(){
        this.repository = new LancamentoRepository();
        this.service = new LancamentoService(repository);
        this.scanner = new Scanner(System.in);
    }

    public void exibirMenu(){
        int opcao;
        do {
            System.out.println("\n--- MENU FINANCEIRO ---");
            System.out.println("1. Adicionar lançamento");
            System.out.println("2. Listar lançamentos");
            System.out.println("3. Ver saldo total");
            System.out.println("4. Ver saldo por mês");
            System.out.println("5. Total investido");
            System.out.println("6. Simular investimento");
            System.out.println("0. Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1 -> adicionarLancamento();
                case 2 -> listarLancamentos();
                case 3 -> System.out.println("Saldo total: R$ " + service.calcularSaldoTotal());
                case 4 -> mostrarSaldoMensal();
                case 5 -> System.out.println("Total investido: R$ " + service.calcularTotalInvestido());
                case 6 -> simularInvestimento();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }

    public void adicionarLancamento(){
        System.out.println("Descrição: ");
        String descricao = scanner.nextLine();

        System.out.println("Valor: ");
        double valor = scanner.nextDouble();

        System.out.println("Data (AAAA-MM-DD): ");
        LocalDate data = LocalDate.parse(scanner.next());

        System.out.println("Categoria: ");
        scanner.nextLine();
        String categoria = scanner.nextLine();

        System.out.println("Tipo (RECEITA, DESPESA, INVESTIMENTO): ");
        TipoLancamento tipo = TipoLancamento.valueOf(scanner.next().toUpperCase());

        Lancamento lancamento = new Lancamento(null, descricao, valor, data, categoria, tipo);
        repository.adicionar(lancamento);
        System.out.println("Lançamento adicionado com sucesso!");
    }

    public void listarLancamentos(){
        List<Lancamento> lista = repository.listarTodos();
        if (lista.isEmpty()){
            System.out.println("Nenhum lançamento encontrado.");
        }else {
            System.out.println("\n--- LANÇAMENTOS ---");
            for(Lancamento l : lista){
                System.out.printf("%d | %s | R$.2f | %s | %s | %s\n",
                        l.getId(), l.getDescricao(), l.getValor(), l.getData(), l.getCategoria(), l.getTipo());
            }
        }
    }

    public void mostrarSaldoMensal(){
        Map<Month, Double> saldos = service.calcularSaldoMensal();
        System.out.println("\n--- SALDO POR MÊS ---");
        saldos.forEach((mes, valor) -> System.out.printf("%s: R$%.2f", mes, valor));
    }

    public void simularInvestimento(){
        System.out.println("Aporte mensal: ");
        double aporte = scanner.nextDouble();

        System.out.println("Taxa de juros mensal (%): ");
        double taxa = scanner.nextDouble() / 100;

        System.out.println("Número de meses: ");
        int meses = scanner.nextInt();

        double resultado = service.simularInvestimento(aporte, taxa, meses);
        System.out.printf("Total após %d meses: R$%.2f\n", meses, resultado);
    }

}
