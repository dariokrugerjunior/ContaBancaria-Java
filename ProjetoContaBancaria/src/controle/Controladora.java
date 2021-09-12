package controle;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import vizualizacao.InterfaceGrafica;

public class Controladora {

	public void exibirMenu() {

		int opcao = 0;
		Boolean verificador = true;
		String cpfTitular = "";

		String titularDaConta = JOptionPane.showInputDialog("Informe o nome do Titular");

		do {

			cpfTitular = JOptionPane.showInputDialog(titularDaConta + ", informe seu cpf", "00000000000");

			if (cpfTitular.equals("00000000000") || cpfTitular.equals("11111111111") || cpfTitular.equals("22222222222")
					|| cpfTitular.equals("33333333333") || cpfTitular.equals("44444444444")
					|| cpfTitular.equals("55555555555") || cpfTitular.equals("66666666666")
					|| cpfTitular.equals("77777777777") || cpfTitular.equals("88888888888")
					|| cpfTitular.equals("99999999999") || (cpfTitular.length() != 11)) {

				JOptionPane.showMessageDialog(null, "CPF informado incorreto");

				verificador = false;
			} else {
				verificador = true;
			}
		} while (verificador != true);

		String[] bancoTipos = new String[] { "Conta Corrente", "Conta Poupança" };

		JComboBox<String> escolha = new JComboBox<String>(bancoTipos);

		JOptionPane.showConfirmDialog(null, escolha, "Selecione o tipo da sua conta",
				JOptionPane.OK_CANCEL_OPTION);
		String tipo = (String) escolha.getSelectedItem();

		InterfaceGrafica.GerarUsuario(titularDaConta, cpfTitular, tipo);

		do {

			opcao = Integer.parseInt(JOptionPane.showInputDialog("Informe a opcao desejada" + "\n" + "\n 1 - Depositar"
					+ "\n 2 - Sacar " + "\n 3 - Consultar saldo" + "\n 4 - Exibir Dados Da Conta" + "\n 5 - Extrato Completo"
					+ "\n 6 - Extrato Deposito" + "\n 7 - Extrato Saques" + "\n 8 - Sair"));

			switch (opcao) {
			case 1:
				InterfaceGrafica.solicitarInformacoesDeposito();
				break;
			case 2:
				InterfaceGrafica.solicitarInformacoesSaque();
				break;
			case 3:
				InterfaceGrafica.consultarSaldo();
				break;
			case 4:
				InterfaceGrafica.exibirDadosDaConta();
				break;
			case 5:
				InterfaceGrafica.exibirExtratoCompleto();
				break;
			case 6:
				InterfaceGrafica.exibirExtratoDeDeposito();
				break;
			case 7:
				InterfaceGrafica.exibirExtratoDeSaques();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcão Incorreta");
			}
		} while (opcao != 8);

	}

}
