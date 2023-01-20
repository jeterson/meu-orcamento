export enum ELogin {
  Name = "login",
  Path = "/login",
}

export enum ECadastroLivro {
  Name = "cadastro-livro",
  Title = "Cadastro de Livros",
  Path = "/cadastro/livros",
}

export enum EEmprestimoLivro {
  Name = "emprestimo-livros",
  Title = "Empréstimo de Livros",
  Path = "/lancamentos/emprestimo-livros",
}

export enum EDevolverLivro {
  Name = "devolucao-livros",
  Title = "Devolução de Livros",
  Path = "/lancamentos/devolucao-livros",
}

export enum ERenovarLivro {
  Name = "renovacao-livros",
  Title = "Renovação de Empréstimos",
  Path = "/lancamentos/renovacao-emprestimo",
}

export enum EMovimentacoes {
  Name = "movimentacoes",
  Title = "Movimentações",
  Path = "/movimentacoes/listagem",
}

export enum EMovimentacoesColaborador {
  Name = "movimentacoes-colab",
  Title = "Movimentações do Colaborador",
  Path = "/biblioteca/colaborador",
}

export enum EConfigEmprestimo {
  Name = "configuracoes",
  Title = "Configurações de Empréstimos",
  Path = "/configuracoes/emprestimo",
}
