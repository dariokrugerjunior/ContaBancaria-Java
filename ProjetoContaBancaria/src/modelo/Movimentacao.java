package modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Movimentacao {
	protected String tipo;
	protected double valor;
	protected String data;

	public String getTipo() {
		return tipo;
	}

	public double getValor() {
		return valor;
	}

	public String getData() {
		return data;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public void setData() {
		Date dNow = new Date();
		SimpleDateFormat date = new SimpleDateFormat(" dd.MM.yyyy 'as' hh:mm:ss");

		this.data = date.format(dNow);
	}


}
