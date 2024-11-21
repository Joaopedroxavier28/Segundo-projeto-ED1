import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Instâncias dos sistemas
        ClinicaMedica clinica = new ClinicaMedica();
        Restaurante restaurante = new Restaurante();
        Eventos eventos = new Eventos();

        // Dados adicionais para perguntas frequentes
        HashMap<String, Integer> itensVendidos = new HashMap<>();
        HashMap<String, Integer> especialidadesMedicas = new HashMap<>();
        HashMap<String, Integer> idadesEventos = new HashMap<>();
        HashMap<String, Integer> nomesEventos = new HashMap<>();

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Sistema de Gerenciamento ---");
            System.out.println("1. Gerenciar Clínica Médica");
            System.out.println("2. Gerenciar Restaurante");
            System.out.println("3. Gerenciar Eventos");
            System.out.println("4. Perguntas Frequentes");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (escolha) {
                case 1 -> {
                    boolean voltarClinica = false;
                    while (!voltarClinica) {
                        System.out.println("\n--- Gerenciamento de Clínica Médica ---");
                        System.out.println("1. Adicionar Médico");
                        System.out.println("2. Remover Médico");
                        System.out.println("3. Buscar Médico");
                        System.out.println("4. Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoClinica = scanner.nextInt();
                        scanner.nextLine();
                
                        switch (opcaoClinica) {
                            case 1 -> {
                                System.out.print("Digite o nome e especialidade do médico: ");
                                String medico = scanner.nextLine();
                                clinica.adicionarMedico(medico);
                                especialidadesMedicas.put(medico, especialidadesMedicas.getOrDefault(medico, 0) + 1);
                                System.out.println("Médico adicionado!");
                            }
                            case 2 -> {
                                System.out.print("Digite o nome do médico para remover: ");
                                String medicoRemover = scanner.nextLine();
                                boolean removido = clinica.medicos.remover(medicoRemover);
                                if (removido) {
                                    especialidadesMedicas.remove(medicoRemover);
                                    System.out.println("Médico removido com sucesso!");
                                } else {
                                    System.out.println("Médico não encontrado!");
                                }
                            }
                            case 3 -> {
                                System.out.print("Digite o nome do médico para buscar: ");
                                String medico = scanner.nextLine();
                                boolean encontrado = clinica.medicos.buscar(medico);
                                System.out.println("Médico encontrado? " + (encontrado ? "Sim" : "Não"));
                            }
                            case 4 -> voltarClinica = true;
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }

                case 2 -> {
                    boolean voltarRestaurante = false;
                    while (!voltarRestaurante) {
                        System.out.println("\n--- Gerenciamento de Restaurante ---");
                        System.out.println("1. Adicionar Pedido");
                        System.out.println("2. Remover Pedido");
                        System.out.println("3. Buscar Pedido");
                        System.out.println("4. Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoRestaurante = scanner.nextInt();
                        scanner.nextLine();
                
                        switch (opcaoRestaurante) {
                            case 1 -> {
                                System.out.print("Digite o pedido: ");
                                String pedido = scanner.nextLine();
                                restaurante.adicionarPedido(pedido);
                                itensVendidos.put(pedido, itensVendidos.getOrDefault(pedido, 0) + 1);
                                System.out.println("Pedido adicionado!");
                            }
                            case 2 -> {
                                if (restaurante.filaPedidos.isEmpty()) {
                                    System.out.println("A fila de pedidos está vazia. Não há pedidos para remover.");
                                } else {
                                    String pedidoRemovido = restaurante.filaPedidos.dequeue();
                                    itensVendidos.put(pedidoRemovido, itensVendidos.getOrDefault(pedidoRemovido, 1) - 1);
                                    System.out.println("Pedido removido: " + pedidoRemovido);
                                }
                            }
                            case 3 -> {
                                System.out.print("Digite o nome do pedido para buscar: ");
                                String pedidoBuscado = scanner.nextLine();
                                boolean encontrado = itensVendidos.containsKey(pedidoBuscado) && itensVendidos.get(pedidoBuscado) > 0;
                                System.out.println("Pedido encontrado? " + (encontrado ? "Sim" : "Não"));
                            }
                            case 4 -> voltarRestaurante = true;
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 3 -> {
                    boolean voltarEventos = false;
                    while (!voltarEventos) {
                        System.out.println("\n--- Gerenciamento de Eventos ---");
                        System.out.println("1. Inscrever Participante");
                        System.out.println("2. Remover Participante");
                        System.out.println("3. Buscar Participante");
                        System.out.println("4. Voltar");
                        System.out.print("Escolha uma opção: ");
                        int opcaoEventos = scanner.nextInt();
                        scanner.nextLine();
                
                        switch (opcaoEventos) {
                            case 1 -> {
                                System.out.print("Digite o nome do participante: ");
                                String inscricao = scanner.nextLine();
                                eventos.inscreverParticipante(inscricao);
                                nomesEventos.put(inscricao, nomesEventos.getOrDefault(inscricao, 0) + 1);
                                System.out.println("Participante inscrito!");
                            }
                            case 2 -> {
                                System.out.print("Digite o nome do participante para remover: ");
                                String participante = scanner.nextLine();
                                boolean removido = eventos.participantes.remover(participante);
                                if (removido) {
                                    nomesEventos.remove(participante);
                                    System.out.println("Participante removido com sucesso!");
                                } else {
                                    System.out.println("Participante não encontrado!");
                                }
                            }
                            case 3 -> {
                                System.out.print("Digite o nome do participante para buscar: ");
                                String participante = scanner.nextLine();
                                boolean encontrado = eventos.participantes.buscar(participante);
                                System.out.println("Participante encontrado? " + (encontrado ? "Sim" : "Não"));
                            }
                            case 4 -> voltarEventos = true;
                            default -> System.out.println("Opção inválida!");
                        }
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Perguntas Frequentes ---");
                
                    // Item mais procurado no restaurante
                    String itemPopular = calcularMaisProcurado(itensVendidos);
                    System.out.println("Item mais procurado no restaurante: " + itemPopular);
                
                    // Nome do médico mais adicionado
                    String medicoMaisAdicionado = calcularMaisProcurado(especialidadesMedicas);
                    System.out.println("Nome do médico mais adicionado: " + medicoMaisAdicionado);
                
                    // Nome do médico menos adicionado
                    String medicoMenosAdicionado = calcularMenosProcurado(especialidadesMedicas);
                    System.out.println("Nome do médico menos adicionado: " + medicoMenosAdicionado);
                
                    // Idade mais frequente em eventos
                    String idadePopular = calcularMaisProcurado(idadesEventos);
                    System.out.println("Idade mais frequente em eventos: " + idadePopular);
                
                    // Nome mais frequente em eventos
                    String nomePopular = calcularMaisProcurado(nomesEventos);
                    System.out.println("Nome mais frequente em eventos: " + nomePopular);
                }
                case 5 -> {
                    continuar = false;
                    System.out.println("Encerrando o sistema. Até logo!");
                }
                default -> System.out.println("Opção inválida! Tente novamente.");
            }
        }

        scanner.close();
    }

    
    

    // Métodos auxiliares para calcular mais/menos procurados
    public static String calcularMaisProcurado(HashMap<String, Integer> mapa) {
        String maisProcurado = "Nenhum registro encontrado";
        int maiorFrequencia = -1;

        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            if (entrada.getValue() > maiorFrequencia) {
                maiorFrequencia = entrada.getValue();
                maisProcurado = entrada.getKey() + " (" + entrada.getValue() + " ocorrências)";
            }
        }
        return maisProcurado;
    }

    public static String calcularMenosProcurado(HashMap<String, Integer> mapa) {
        String menosProcurado = "Nenhum registro encontrado";
        int menorFrequencia = Integer.MAX_VALUE;

        for (Map.Entry<String, Integer> entrada : mapa.entrySet()) {
            if (entrada.getValue() < menorFrequencia) {
                menorFrequencia = entrada.getValue();
                menosProcurado = entrada.getKey() + " (" + entrada.getValue() + " ocorrências)";
            }
        }
        return menosProcurado;
    }
}
