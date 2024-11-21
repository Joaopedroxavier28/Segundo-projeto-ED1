class Eventos {
    Pilha<String> historicoVisualizacao = new Pilha<>();
    Fila<String> filaInscricoes = new Fila<>();
    Arvore<String> participantes = new Arvore<>();

    public void visualizarEvento(String evento) {
        historicoVisualizacao.push(evento);
    }

    public void inscreverParticipante(String participante) {
        filaInscricoes.enqueue(participante);
    }

    public void registrarParticipante(String participante) {
        participantes.inserir(participante);
    }
}
