class ClinicaMedica {
    Pilha<String> historicoAcoes = new Pilha<>();
    Fila<String> filaAtendimento = new Fila<>();
    Arvore<String> medicos = new Arvore<>();

    public void registrarAcao(String acao) {
        historicoAcoes.push(acao);
    }

    public void agendarPaciente(String paciente) {
        filaAtendimento.enqueue(paciente);
    }

    public void adicionarMedico(String medico) {
        medicos.inserir(medico);
    }
}
