class Funcionario {
  private String nome;            // Nome do funcionario...
  private String cpf;             // CPF do funcionario...
  private String cargo;           // Cargo do funcionario...
  private double salario;         // Salario do funcionario...
  private String departamento;    // TI, Financeiro...
  private String tipoContrato;    // CLT, PJ, Estágio...
  private boolean valeTransporte; // Tem ou nao tem...
  private boolean planoSaude;     // Tem ou nao tem...
  private boolean valeRefeicao;   // Tem ou nao tem...
  private boolean ativo;          // Tem ou nao tem...

  public Funcionario(String nome, String cpf, String cargo, double salario, String departamento, String tipoContrato) {
    this.nome = nome;
    this.cpf = cpf;
    this.cargo = cargo;
    this.salario = salario;
    this.departamento = departamento;
    this.tipoContrato = tipoContrato;

    this.valeTransporte = false;
    this.planoSaude = false;
    this.valeRefeicao = false;
    this.ativo = true;
}        
  // Metodos get ( pegar )
    public String getNome(String nome) { return this.nome; }
    public String getCpf() { return this.cpf; }
    public String getCargo() { return this.cargo; }
    public double getSalario() { return this.salario; }
    public String getDepartamento() { return this.departamento; }
    public String getTipoContrato() { return this.tipoContrato; }
  // Metodos set ( definir )
}
