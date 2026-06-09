package view; //nome do package pra importar no Main

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import model.Funcionario;
import service.GerenciadorFuncionarios; //Importa tudo do java swing

public class TelaPrincipal extends JFrame { //Classe TelaPrincipal, o extends JFrame "avisa" a classe que ela vai ser um JFrame (janela)
    private GerenciadorFuncionarios gerenciador;
  private JTable tabela;

    //Propriedades básicas da janela
    public TelaPrincipal() { 
        gerenciador = new GerenciadorFuncionarios();
        setTitle("Gerenciador de Funcionários"); //Título da janela
        setSize(800, 600); //Tamanho da janela
        setLocationRelativeTo(null); //Centraliza a janela na tela do pc
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Esse código avisa ao programa que quando eu fechar a janela, o programa vai finalizar

        JMenuBar barraMenu = new JMenuBar(); //Cria a barra de menu
        JMenu menuFuncionarios = new JMenu("Funcionários"); //Menu funcionários
        JMenuItem itemListar = new JMenuItem("Listar"); //item pra ir para a página de listar (criada posteriormente)
        JMenu menuRelatorios = new JMenu("Relatórios"); //Menu relatórios
        JMenuItem itemResumo = new JMenuItem("Resumo por Departamento"); //item pra ir para a página de resumo (criada posteriormente)
        JMenu menuSair = new JMenu("Sair"); //Menu sair
        JMenuItem itemSair = new JMenuItem("Encerrar"); //novo item ao clicar no sair (encerrar)
        itemSair.addActionListener(e -> System.exit(0)); //coloca a função de encerrar o programa ao clicar no encerrar
        
        menuSair.add(itemSair);
        menuFuncionarios.add(itemListar);
        barraMenu.add(menuFuncionarios);
        barraMenu.add(menuRelatorios);
        barraMenu.add(menuSair);
        setJMenuBar(barraMenu); // adiciona ao JFrame

        //Criação das abas e paineis que estarão nelas
        JTabbedPane abas = new JTabbedPane();
        JPanel painelCadastro = new JPanel();
      JPanel painelListagem = new JPanel();
        JPanel painelRelatorio = new JPanel();
        
        abas.addTab("Cadastro", painelCadastro);
        abas.addTab("Listagem", painelListagem);
        abas.addTab("Resumo", painelRelatorio);
        add(abas); 

        itemListar.addActionListener(e -> abas.setSelectedIndex(1)); //coloca a função de mudar de aba quando clicar no botão, o index 1 é o indíce da aba, que começa em 0
        itemResumo.addActionListener(e -> abas.setSelectedIndex(2)); //explicando mais sobre o indice, se eu tiver 3 abas, os indices respectivos vão ser 0,1 e 2
        menuFuncionarios.add(itemListar);
        menuRelatorios.add(itemResumo);

        //Novo painel pro formulario, após isso, eu crio um novo box layout pra alinhar os itens do painel
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout(new BoxLayout(painelFormulario, BoxLayout.Y_AXIS)); //o y axis é pra tudo ser organizado em coluna

        //Campo do nome
        painelFormulario.add(new JLabel("Nome:"));
        JTextField txtNome = new JTextField(20); // o numero 20 reserva espaço na tela para aproximadamente 20 caracteres
        txtNome.setAlignmentX(LEFT_ALIGNMENT); //ele alinha o texto à esquerda, como se fosse um documento no word
        painelFormulario.add(txtNome);

        //Campo do CPF
        painelFormulario.add(new JLabel("CPF:"));
        JTextField txtCpf = new JTextField(11);
        txtCpf.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(txtCpf);

        //Campo do Cargo        
        painelFormulario.add(new JLabel("Cargo:"));
        JTextField txtCargo = new JTextField(20);
        txtCargo.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(txtCargo);

        //Campo do Salário
        painelFormulario.add(new JLabel("Salário:"));
        JTextField txtSalario = new JTextField(20);
        txtSalario.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(txtSalario);

        //Campo Departamento     
        painelFormulario.add(new JLabel("Departamento:"));

        //Esse combobox cria basicamente uma caixa de seleção de opções, como se fosse um menu hamburguer
        String[] opcoes = {"Selecione o Departamento", "TI", "Financeiro", "Comercial"};
        JComboBox<String> cmbStatus = new JComboBox<>(opcoes);
        cmbStatus.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(cmbStatus);

        //Radiobutton tipo de contrato 
        //são botões que você clica pra selecionar o tipo de contrato
        painelFormulario.add(new JLabel("Tipo de Contrato:"));
        JPanel painelRadios = new JPanel();
        JRadioButton rbClt = new JRadioButton("CLT");
        JRadioButton rbPj = new JRadioButton("PJ");
        JRadioButton rbEstagio = new JRadioButton("Estágio");
        
        //primeiro coloca esses botões em um grupo
        ButtonGroup grupo = new ButtonGroup();
        grupo.add(rbClt);
        grupo.add(rbPj);
        grupo.add(rbEstagio);

        //Depois coloca no painel
        painelRadios.add(rbClt);
        painelRadios.add(rbPj);
        painelRadios.add(rbEstagio);
        
        //Por fim coloca o painelRadios no painelFormulario pra aparecer nele
        painelRadios.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(painelRadios);

        //Check box de benefícios organizado em uma linha e 4 colunas
        painelFormulario.add(new JLabel("Benefícios:"));
        JPanel painelChecks = new JPanel();
        JCheckBox chkVt = new JCheckBox("Vale-transporte");
        JCheckBox chkPs = new JCheckBox("Plano de saúde");
        JCheckBox chkVr = new JCheckBox("Vale-refeição");  

        //Mesmo processo do painelRadios     
        painelChecks.add(chkVt);
        painelChecks.add(chkPs);
        painelChecks.add(chkVr);
        painelChecks.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(painelChecks);

        
        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.addActionListener(e -> {
            String nome = txtNome.getText();
            String cpf = txtCpf.getText();
            String cargo = txtCargo.getText();
            double salario = Double.parseDouble(txtSalario.getText());
            String departamento = (String) cmbStatus.getSelectedItem();
            
            String tipoContrato = "";
            if (rbClt.isSelected()) tipoContrato = "CLT";
            if (rbPj.isSelected()) tipoContrato = "PJ";
            if (rbEstagio.isSelected()) tipoContrato = "Estágio";

            Funcionario funcionario = new Funcionario(nome, cpf, cargo, salario, departamento, tipoContrato);
            funcionario.setValeTransporte(chkVt.isSelected());
            funcionario.setPlanoSaude(chkPs.isSelected());
            funcionario.setValeRefeicao(chkVr.isSelected());

            boolean sucesso = gerenciador.cadastrarFuncionario(funcionario);
            if (sucesso) {
                atualizarTabela();
                JOptionPane.showMessageDialog(null, "Funcionário foi cadastrado");
            } else {
                JOptionPane.showMessageDialog(null, "Esse CPF já foi cadastrado");
            }
        });
        btnCadastrar.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(btnCadastrar);
        

        painelCadastro.add(painelFormulario);


        painelListagem.setLayout(new BoxLayout(painelListagem, BoxLayout.Y_AXIS));
        painelListagem.add(new JLabel("Lista de Funcionários"));
        painelListagem.add(Box.createVerticalStrut(15));

        //busca
        JPanel painelBusca = new JPanel();
        painelBusca.add(new JLabel("Buscar (CPF):"));
        JTextField txtBusca = new JTextField(20);
        painelBusca.add(txtBusca);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(e -> {
            String cpf = txtBusca.getText();
            Funcionario funcionario = gerenciador.buscarPorCpf(cpf);

            if (funcionario != null) {
                JOptionPane.showMessageDialog(null, funcionario.toString()); //o toString do funcionario ta na classe model
            } else {
                JOptionPane.showMessageDialog(null, "Funcionário não encontrado!");
            }
        });
        painelBusca.add(btnBuscar);
        painelListagem.add(painelBusca);

        //Tabela
        String[] colunas = {"Nome", "CPF", "Cargo", "Departamento"};
        String[][] dados = {};
        tabela = new JTable(dados, colunas);
        JScrollPane scrollTabela = new JScrollPane(tabela);
        painelListagem.add(scrollTabela);

        //Botões
        JPanel painelBotoes = new JPanel();
        JButton btnAdicionar = new JButton("Adicionar");
        
        //esse botão só muda pra aba que é o cadrastro
        btnAdicionar.addActionListener(e -> abas.setSelectedIndex(0));
        painelBotoes.add(btnAdicionar);
        
      JButton btnExcluir = new JButton("Excluir");
        btnExcluir.addActionListener(e -> {
            String cpf = JOptionPane.showInputDialog("Digite o CPF:");
            gerenciador.desativarFuncionario(cpf);
            atualizarTabela();
        });
        painelBotoes.add(btnExcluir);
        painelListagem.add(painelBotoes);
    
        JToggleButton tglFiltro = new JToggleButton("Mostrar apenas ativos");
        tglFiltro.addActionListener(e -> {    if (tglFiltro.isSelected()) {        
        System.out.println("Filtro ativado");
            } else 
        {        System.out.println("Filtro desativado");    }});
        tglFiltro.setAlignmentX(LEFT_ALIGNMENT);
        painelListagem.add(tglFiltro);
        
        //Organiza tudo em coluna
        painelRelatorio.setLayout(new BoxLayout(painelRelatorio, BoxLayout.Y_AXIS));
        painelRelatorio.add(new JLabel("Resumo Geral"));
        painelRelatorio.add(Box.createVerticalStrut(20));

        //as informacoes de cada setor
        JPanel painelInfo = new JPanel();
        painelInfo.setLayout(new BoxLayout(painelInfo, BoxLayout.Y_AXIS));
        painelInfo.add(new JLabel("TI: " + gerenciador.contarPorDepartamento("TI") + " funcionário(s) ativo(s)"));
        painelInfo.add(Box.createVerticalStrut(10));
        painelInfo.add(new JLabel("Financeiro: " + gerenciador.contarPorDepartamento("Financeiro") + " funcionário(s) ativo(s)"));
        painelInfo.add(Box.createVerticalStrut(10));
        painelInfo.add(new JLabel("Comercial: " + gerenciador.contarPorDepartamento("Comercial") + " funcionário(s) ativo(s)"));
        painelInfo.add(Box.createVerticalStrut(10));
        painelInfo.add(new JLabel("Total de salários ativos: R$ " + gerenciador.calcularTotalSalarios()));
        painelRelatorio.add(Box.createVerticalStrut(20));
        painelRelatorio.add(painelInfo);
        setVisible(true);
    }

    

  private void atualizarTabela() {
        ArrayList<Funcionario> lista = gerenciador.listarFuncionarios();
        String[] colunas = {"Nome", "CPF", "Cargo", "Departamento"};
        String[][] dados = new String[lista.size()][4];

        for (int i = 0; i < lista.size(); i++) {
            Funcionario f = lista.get(i);
            dados[i][0] = f.getNome();
            dados[i][1] = f.getCpf();
            dados[i][2] = f.getCargo();

            String departamento = f.getDepartamento();
            if (!f.isAtivo()) {
                departamento += " (Inativo)"; //coloca inativo do lado pra ficar visivel na tabela
            }
            dados[i][3] = departamento;
        }

        tabela.setModel(new DefaultTableModel(dados, colunas));

  }
}
