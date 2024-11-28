# README do Projeto de Gerenciamento
Descrição do Projeto
Este projeto foi desenvolvido para demonstrar o uso de estruturas de dados como pilhas, filas e árvores binárias em um sistema de gerenciamento multifuncional. A aplicação contém módulos para gerenciar diferentes áreas de atuação: clínica médica, eventos, restaurante e uma seção de perguntas frequentes. O objetivo é fornecer uma interface simples e eficiente para organizar informações e tarefas relacionadas a essas áreas, destacando o uso das estruturas de dados.

# Menu Principal
O sistema possui um menu principal que divide as funcionalidades em quatro módulos principais:

Gerenciamento da Clínica Médica
Gerenciamento de Eventos
Gerenciamento do Restaurante
Perguntas Frequentes
Cada módulo possui submenus específicos para realizar tarefas relacionadas.

# Gerenciamento da Clínica Médica
Este módulo organiza tarefas de uma clínica médica, com foco em:

Atendimento emergencial de pacientes.
Histórico de ações realizadas.
Cadastro e busca de médicos.
## Estruturas de Dados Utilizadas:
Fila (FIlaEmergencial):

Organiza pacientes que precisam de atendimento emergencial.
Pacientes idosos (60 anos ou mais) têm prioridade na fila (inseridos no início).
Pilha (HistoricoAcao):

Armazena ações realizadas na clínica.
Permite desfazer a última ação registrada.
Árvore Binária (ArvMedico):

Utilizada para armazenar e buscar nomes de médicos cadastrados na clínica.
Beneficia operações como a busca por médicos em tempo eficiente.

# Gerenciamento de Eventos
Este módulo foi criado para gerenciar inscrições e palestrantes de eventos. Ele inclui:

Adição e consulta de eventos.
Gerenciamento de inscrições.
Cadastro e busca de palestrantes.
## Estruturas de Dados Utilizadas:
Pilha (StackEventos):

Armazena eventos visualizados.
Permite retornar ao último evento acessado.
Fila (FIlaIscricao):

Organiza inscrições de participantes por ordem de chegada.
Participantes menores de idade recebem um aviso especial.
Árvore Binária (ArvPalestante):

Utilizada para armazenar os nomes dos palestrantes.
Permite buscas rápidas por palestrantes cadastrados.

# Gerenciamento do Restaurante
Este módulo foca no gerenciamento de pedidos e do menu de um restaurante. Possui funcionalidades como:

Registro de pedidos.
Adição de itens ao menu.
Aplicação de descontos para médicos cadastrados.
## Estruturas de Dados Utilizadas:
Pilha (StackPedido):

Armazena modificações feitas nos pedidos.
Permite desfazer a última modificação registrada.
Fila (FIlaPedidos):

Organiza os pedidos dos clientes por ordem de chegada.
Identifica médicos cadastrados para aplicar descontos de 15%.
Árvore Binária (ArvMenu):

Armazena itens do menu do restaurante.
Facilita a busca e organização de itens disponíveis.

# Perguntas Frequentes
Este módulo fornece informações úteis para o usuário. As perguntas frequentes incluem:

Como usar o sistema.
Como funciona cada módulo.
Informações adicionais, como contato para suporte.
## Propósito das Perguntas Frequentes:
Servir como guia para novos usuários.
Fornecer respostas rápidas para dúvidas comuns.
Aumentar a usabilidade do sistema.










