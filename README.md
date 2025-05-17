# 💰 Simulador Financeiro Pessoal em Java

## 📘 Descrição

Este é um sistema de **controle financeiro pessoal** desenvolvido em Java, com funcionalidades que permitem:

- Cadastrar **receitas**, **despesas** e **investimentos**.
- Organizar lançamentos por **tipo**, **categoria** e **data**.
- Calcular automaticamente:
  - **Saldo total**
  - **Saldo por mês**
  - **Total investido**
- Simular o crescimento de um investimento com **juros compostos**, utilizando:
  - Valor de aporte mensal
  - Taxa de juros mensal
  - Prazo em meses

O projeto segue uma arquitetura baseada em camadas (`model`, `repository`, `service`, `controller`), com foco em **boas práticas de programação orientada a objetos**.

---

## 🧠 Conceitos aplicados

- Programação orientada a objetos (POO)
- Enumerações (`Enum`)
- Estruturas de dados (`List`, `Map`, filtros)
- Manipulação de datas com `LocalDate`
- Tratamento de exceções
- Separação de responsabilidades (SRP, SOLID)
- Testes com JUnit (versão futura)
- (Opcional) Persistência com arquivos ou banco de dados

---

## 🗂️ Estrutura do Projeto

```
src/
│
├── model/          # Classes de domínio (Lancamento, Enums)
├── repository/     # Armazena dados em memória (List<Lancamento>)
├── service/        # Regras de negócio (cálculos, simulações)
├── controller/     # Interação com usuário/sistema (menus, ações)
└── Main.java       # Classe principal para execução
```

---

## 🚀 Como executar

1. Clone este repositório
2. Compile com um IDE (como IntelliJ ou Eclipse) ou via terminal
3. Rode a classe `Main.java`
4. Interaja com o sistema via console

---

## 📌 Versões Futuras (planejamento)

- [ ] Exportação de dados para CSV
- [ ] Interface gráfica com JavaFX ou API REST com Spring Boot
- [ ] Persistência em banco de dados (JDBC ou JPA)
- [ ] Testes automatizados com JUnit e Mockito

---

## 👨‍💻 Autor

Desenvolvido por [Tiago Molero] como projeto de prática para consolidar conhecimentos em Java.
