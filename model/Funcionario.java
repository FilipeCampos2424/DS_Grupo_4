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
    public String getNome() { return this.nome; }
    public String getCpf() { return this.cpf; }
    public String getCargo() { return this.cargo; }
    public double getSalario() { return this.salario; }
    public String getDepartamento() { return this.departamento; }
    public String getTipoContrato() { return this.tipoContrato; }

    public boolean getValeTransporte() { return this.valeTransporte; }
    public boolean getPlanoSaude() { return this.planoSaude; }
    public boolean getValeRefeicao() { return this.valeRefeicao; }
    public boolean getAtivo() { return this.ativo; }
  
  // Metodos set ( definir )
  public void setNome(String nome) { this.nome = nome; }
  public void setCargo(String cargo) { this.cargo = cargo; }
  public void setSalario(double salario) { this.salario = salario; }
  public void setDepartamento(String departamento) { this.departamento = departamento; }
  public void setTipoContrato(String tipoContrato) { this.tipoContrato = tipoContrato; }
}
