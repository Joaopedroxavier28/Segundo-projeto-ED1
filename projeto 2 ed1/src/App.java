import java.util.*;

public class App {

    // Árvore global compartilhada para médicos e palestrantes
    static arvorebinaria<String> ArvMedico = new arvorebinaria<>();
    static arvorebinaria<String> ArvPalestante = new arvorebinaria<>();
    static arvorebinaria<String> ArvMenu = new arvorebinaria<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n--- Sistema de Gerenciamento ---");
            System.out.println("1. Gerenciamento da Clínica Médica");
            System.out.println("2. Gerenciamento de Eventos");
            System.out.println("3. Gerenciamento de Restaurante");
            System.out.println("4. Perguntas Frequentes");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    GerenciamentodeClinica();
                    break;
                case 2:
                    GerenciamentodeEventos();
                    break;
                case 3:
                    GerenciamentodeRestaurante();
                    break;
                case 4:
                    perguntasFrequentes(scanner);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    // Gerenciamento da Clínica Médica
    static void GerenciamentodeClinica() {
        LinkedList<String> FIlaEmergencial = new LinkedList<>();
        Stack<String> HistoricoAcao = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n--- Gerenciamento da Clínica Médica ---");
            System.out.println("1. Adicionar paciente emergencial");
            System.out.println("2. Ver próximo paciente emergencial");
            System.out.println("3. Registrar ação no histórico");
            System.out.println("4. Desfazer última ação");
            System.out.println("5. Adicionar médico");
            System.out.println("6. Buscar médico");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do paciente: ");
                    String paciente = scanner.nextLine();
                    System.out.print("O paciente tem mais de 60 anos? (sim/não): ");
                    String resposta = scanner.nextLine();

                    if (resposta.equalsIgnoreCase("sim")) {
                        FIlaEmergencial.addFirst(paciente);
                        System.out.println("Paciente idoso adicionado com prioridade à fila emergencial.");
                    } else {
                        FIlaEmergencial.addLast(paciente);
                        System.out.println("Paciente adicionado à fila emergencial.");
                    }
                    break;
                case 2:
                    if (!FIlaEmergencial.isEmpty())
                        System.out.println("Próximo paciente: " + FIlaEmergencial.poll());
                    else
                        System.out.println("Nenhum paciente na fila.");
                    break;
                case 3:
                    System.out.print("Descrição da ação: ");
                    String acao = scanner.nextLine();
                    HistoricoAcao.push(acao);
                    System.out.println("Ação registrada.");
                    break;
                case 4:
                    if (!HistoricoAcao.isEmpty())
                        System.out.println("Ação desfeita: " + HistoricoAcao.pop());
                    else
                        System.out.println("Nenhuma ação para desfazer.");
                    break;
                case 5:
                    System.out.print("Nome do médico: ");
                    String medico = scanner.nextLine();
                    ArvMedico.inserir(medico);
                    System.out.println("Médico adicionado.");
                    break;
                case 6:
                    System.out.print("Nome do médico a buscar: ");
                    String searchmedico = scanner.nextLine();
                    if (ArvMedico.search(searchmedico))
                        System.out.println("Médico encontrado.");
                    else
                        System.out.println("Médico não encontrado.");
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    // Gerenciamento de Eventos
    static void GerenciamentodeEventos() {
        Stack<String> StackEventos = new Stack<>();
        Queue<String> FIlaIscricao = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n--- Gerenciamento do Sistema de Eventos ---");
            System.out.println("1. Adicionar evento ao histórico (Pilha)");
            System.out.println("2. Retornar ao último evento visualizado (Pilha)");
            System.out.println("3. Adicionar inscrição (Fila)");
            System.out.println("4. Processar próxima inscrição (Fila)");
            System.out.println("5. Adicionar palestrante (Árvore)");
            System.out.println("6. Buscar palestrante (Árvore)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do evento: ");
                    String evento = scanner.nextLine();
                    StackEventos.push(evento);
                    System.out.println("Evento adicionado ao histórico.");
                    break;
                case 2:
                    if (!StackEventos.isEmpty())
                        System.out.println("Último evento visualizado: " + StackEventos.pop());
                    else
                        System.out.println("Nenhum evento no histórico.");
                    break;
                case 3:
                    System.out.print("Digite seu nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Digite sua idade: ");
                    int idade = scanner.nextInt();
                    scanner.nextLine(); // Consome a quebra de linha

                    if (idade < 18) {
                        System.out.println("Aviso: Palestrantes menores de 18 anos só podem entrar no evento com autorização.");
                        System.out.println("Acesse o documento de autorização no site: unicapeventos.com.br");
                    }

                    FIlaIscricao.add(nome + " (Idade: " + idade + ")");
                    System.out.println("Inscrição adicionada à fila.");
                    break;
                case 4:
                    if (!FIlaIscricao.isEmpty())
                        System.out.println("Processando inscrição de: " + FIlaIscricao.poll());
                    else
                        System.out.println("Nenhuma inscrição na fila.");
                    break;
                case 5:
                    System.out.print("Nome do palestrante: ");
                    String palestrante = scanner.nextLine();
                    ArvPalestante.inserir(palestrante);
                    System.out.println("Palestrante adicionado.");
                    break;
                case 6:
                    System.out.print("Nome do palestrante a buscar: ");
                    String searchPalestrante = scanner.nextLine();
                    if (ArvPalestante.search(searchPalestrante))
                        System.out.println("Palestrante encontrado.");
                    else
                        System.out.println("Palestrante não encontrado.");
                    break;
                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }

    // Gerenciamento do Restaurante
    static void GerenciamentodeRestaurante() {
        Stack<String> StackPedido = new Stack<>();
        Queue<String> FIlaPedidos = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        int escolha;

        do {
            System.out.println("\n--- Gerenciamento do Restaurante ---");
            System.out.println("1. Adicionar modificação no pedido (Pilha)");
            System.out.println("2. Desfazer última modificação (Pilha)");
            System.out.println("3. Adicionar pedido à fila (Fila)");
            System.out.println("4. Processar próximo pedido (Fila)");
            System.out.println("5. Adicionar item ao menu (Árvore)");
            System.out.println("6. Buscar item no menu (Árvore)");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Descrição da modificação: ");
                    String modificacao = scanner.nextLine();
                    StackPedido.push(modificacao);
                    System.out.println("Modificação registrada.");
                    break;
                case 2:
                    if (!StackPedido.isEmpty())
                        System.out.println("Modificação desfeita: " + StackPedido.pop());
                    else
                        System.out.println("Nenhuma modificação para desfazer.");
                    break;
                case 3:
                    System.out.print("Você é médico(a)? (sim/não): ");
                    String resposta = scanner.nextLine();

                    boolean desconto = false;
                    if (resposta.equalsIgnoreCase("sim")) {
                        System.out.print("Digite seu nome: ");
                        String searchmedico = scanner.nextLine();

                        if (ArvMedico.search(searchmedico)) {
                            desconto = true;
                            System.out.println("Médico encontrado! Você ganhará 15% de desconto no pedido.");
                        } else {
                            System.out.println("Nome não encontrado na lista de médicos. Sem desconto aplicado.");
                        }
                    }

                    System.out.print("Descrição do pedido: ");
                    String pedido = scanner.nextLine();
                    if (desconto) {
                        pedido += " (15% de desconto aplicado)";
                    }
                    FIlaPedidos.add(pedido);
                    System.out.println("Pedido adicionado à fila.");
                    break;
                case 4:
                    if (!FIlaPedidos.isEmpty())
                        System.out.println("Processando pedido: " + FIlaPedidos.poll());
                    else
                        System.out.println("Nenhum pedido na fila.");
                    break;
                case 5:
                    System.out.print("Nome do item: ");
                    String item = scanner.nextLine();
                    ArvMenu.inserir(item);
                    System.out.println("Item adicionado ao menu.");
                    break;
                case 6:
                    System.out.print("Nome do item a buscar: ");
                    String searchItem = scanner.nextLine();
                    if (ArvMenu.search(searchItem))
                        System.out.println("Item encontrado no menu.");
                    else
                        System.out.println("Item não encontrado.");
                    break;

                case 0:
                    System.out.println("Voltando...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (escolha != 0);
    }
    static void perguntasFrequentes(Scanner scanner) {
        int choice;

        do {
            System.out.println("\n--- Perguntas Frequentes ---");
            System.out.println("1. Médico mais procurado");
            System.out.println("2. Palestrante mais procurado");
            System.out.println("3. Idade mais comum");
            System.out.println("4. Alimento mais pedido");
            System.out.println("5. Modificação mais comum");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Pergunta: Médico mais procurado.");
                    System.out.println("Resposta: Dados ainda não disponíveis.");
                    break;
                case 2:
                    System.out.println("Pergunta: Palestrante mais procurado.");
                    System.out.println("Resposta: Dados ainda não disponíveis.");
                    break;
                case 3:
                    System.out.println("Pergunta: Idade mais comum.");
                    System.out.println("Resposta: Dados ainda não disponíveis.");
                    break;
                case 4:
                    System.out.println("Pergunta: Alimento mais pedido.");
                    System.out.println("Resposta: Dados ainda não disponíveis.");
                    break;
                case 5:
                    System.out.println("Pergunta: Modificação mais comum.");
                    System.out.println("Resposta: Dados ainda não disponíveis.");
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (choice != 0);
    }
}
