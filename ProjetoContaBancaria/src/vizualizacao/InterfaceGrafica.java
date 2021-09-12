package vizualizacao;

import javax.swing.JOptionPane;

import modelo.Conta;

public class InterfaceGrafica {

	static Conta conta = new Conta();

	public static void solicitarInformacoesDeposito() {

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja depositar"));
		conta.depositar(valor);

	}

	public static void solicitarInformacoesSaque() {

		double valor = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar"));

		double saldo = conta.getSaldo() - valor;

		if (saldo < -1000) {
			JOptionPane.showMessageDialog(null,
					"Banco não aprovou seu saque, seu limite é de R$1000" + "\n Saldo : " + conta.getSaldo());
		} else {
			conta.sacar(valor);
		}
	}

	public static void exibirDadosDaConta() {

		JOptionPane.showMessageDialog(null, "Nome: " + conta.getTitularDaConta() + "\n CPF: " + conta.getCpfTitular()
				+ "\n Conta: " + conta.getTipo() + "\n Saldo = " + conta.getSaldo());
	}

	public static void GerarUsuario(String titularDaConta, String cpfTitular, String tipo) {

		conta.setTitularDaConta(titularDaConta);
		conta.setCpfTitular(cpfTitular);
		conta.setTipo(tipo);

	}

	public static void consultarSaldo() {

		JOptionPane.showMessageDialog(null, "Conta: " + conta.getTipo() + "\n Saldo = " + conta.getSaldo());
	}

	public static void exibirExtratoCompleto() {

		if (conta.getListaDeMovimentacao() == "Extrato") {
			JOptionPane.showMessageDialog(null, "Nenhum historico recente na sua conta");
		} else {
			JOptionPane.showMessageDialog(null, conta.getListaDeMovimentacao() + "\n Saldo :" + conta.getSaldo());
		}
	}

	public static void exibirExtratoDeDeposito() {
		if (conta.getExDeposito() == "Extrato Deposito") {
			JOptionPane.showMessageDialog(null, "Nenhum historico de deposito recente na sua conta");
		} else {
			JOptionPane.showMessageDialog(null, conta.getExDeposito() + "\n Saldo :" + conta.getSaldo());
		}
	}

	public static void exibirExtratoDeSaques() {
		if (conta.getExSaque() == "Extrato Saques") {
			JOptionPane.showMessageDialog(null, "Nenhum historico de saque recente na sua conta");
		} else {
			JOptionPane.showMessageDialog(null, conta.getExSaque() + "\n Saldo :" + conta.getSaldo());
		}
	}

}
