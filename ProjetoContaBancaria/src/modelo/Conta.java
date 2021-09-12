package modelo;

public class Conta {

	static Movimentacao movi = new Movimentacao();

	protected String titularDaConta;
	protected String cpfTitular;
	protected String tipo;
	protected String listaDeMovimentacao = "Extrato";
	protected String exDeposito = "Extrato Deposito";
	protected String exSaque = "Extrato Saques";
	protected double saldo;

	public void setTitularDaConta(String titularDaConta) {
		this.titularDaConta = titularDaConta;
	}

	public String getTitularDaConta() {
		return titularDaConta;
	}

	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}

	public String getCpfTitular() {
		return cpfTitular;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public double getSaldo() {
		return saldo;
	}

	public String getListaDeMovimentacao() {
		return listaDeMovimentacao;
	}
	
	public String getExDeposito() {
		return exDeposito;
	}
	
	public String getExSaque() {
		return exSaque;
	}
	
	public void depositar(double valor) {
		int tipoMov = 0;
		this.saldo = this.saldo + valor;
		gerarExtrato(valor, tipoMov);
		gerarExtratoDepositos(valor);
	}

	public void sacar(double valor) {
		int tipoMov = 1;
		this.saldo = this.saldo - valor;
		gerarExtrato(valor, tipoMov);
		gerarExtratoSaques(valor);
	}

	public void gerarExtrato(double valor, int tipoMov) {
		movi.setTipo(tipo);
		movi.setValor(valor);
		movi.setData();

		if (tipoMov == 0) {
			String tipoTrans = "Deposito";
			this.listaDeMovimentacao += "\n" + "Nome do Titular: " + getTitularDaConta() + "\n CPF : "+ getCpfTitular() + "\n Conta : " + getTipo() + "\n Transação : "
					+ tipoTrans + "\n Valor : " + valor + "\n " + movi.getData() + "\n ----------------------";
		} else {
			String tipoTrans = "Sacar";
			this.listaDeMovimentacao += "\n" + "Nome do Titular: " + getTitularDaConta() + "\n CPF : "+ getCpfTitular() + "\n Conta : " + getTipo() + "\n Transação : "
					+ tipoTrans + "\n Valor : " + valor + "\n " + movi.getData() + "\n ----------------------";
		}
	}
	
	public void gerarExtratoDepositos(double valor) {
		
		this.exDeposito += "\n" + "\n Conta : " + getTipo() + "\n Transação : Deposito"
				+ "\n Valor : " + valor + "\n " + movi.getData() + "\n ----------------------";
	}
	
	public void gerarExtratoSaques(double valor) {
		
		this.exSaque += "\n" + "\n Conta : " + getTipo() + "\n Transação : Saque"
				+ "\n Valor : " + valor + "\n " + movi.getData() + "\n ----------------------";
	}

}
