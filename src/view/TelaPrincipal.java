package view; //nome do package pra importar no Main

import javax.swing.*; //Importa tudo do java swing


public class TelaPrincipal extends JFrame { //Classe TelaPrincipal, o extends JFrame "avisa" a classe que ela vai ser um JFrame (janela)

//Propriedades básicas da janela
    public TelaPrincipal() { 
        setTitle("Gerenciador de Funcionários"); //Título da janela
        setSize(800,600); //Tamanho da janela
        setLocationRelativeTo(null); //Centraliza a janela na tela do pc
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Esse código avisa ao programa que quando eu fechar a janela, o programa vai finalizar

//Criação das abas e paineis que estarão nelas
        JTabbedPane abas = new JTabbedPane();
        JPanel painelCadastro = new JPanel();
        JPanel painelListagem = new JPanel();
        JPanel painelRelatorio = new JPanel();
        abas.addTab("Cadastro", painelCadastro);
        abas.addTab("Listagem", painelListagem);
        abas.addTab("Resumo", painelRelatorio);
        add(abas); 

    //Novo painel pro formulario, após isso, eu crio um novo box layout pra alinhar os itens do painel
        JPanel painelFormulario = new JPanel();
        painelFormulario.setLayout((new BoxLayout(painelFormulario, BoxLayout.Y_AXIS))); //o y axis é pra tudo ser organizado em coluna

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

//Botão de cadastrar no final, ele tem um addActionListener pra quando eu clicar nele, mostrar uma mensagem no terminal

        JButton btnCadastrar = new JButton("Cadastrar");btnCadastrar.addActionListener(e -> {System.out.println("Botão clicado!");});
        btnCadastrar.setAlignmentX(LEFT_ALIGNMENT);
        painelFormulario.add(btnCadastrar);

//Adiciona o painel formulario completo ao painel cadastro
        painelCadastro.add(painelFormulario);


        setVisible(true);
    }
}
