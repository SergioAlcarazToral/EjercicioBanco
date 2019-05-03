package Cuenta.Bancaria;

public class Cuenta {

	Cliente cliente;
	int id;
	int dinero;
	Banco nombre;
	Banco idBanco;

	public Cuenta() {

	}
//Cambio con un comentario
	public Cuenta(Cliente cliente, int id, int dinero, Banco nombre, Banco idBanco) {
		super();
		this.cliente = cliente;
		this.id = id;
		this.dinero = dinero;
		this.nombre = nombre;
		this.idBanco = idBanco;
	}

	public static boolean TRANSFERENCIA(Cuenta cuenta1, Cuenta cuenta2, int dineroTransferido) {

		if (cuenta1.getDinero() < dineroTransferido || cuenta1.getDinero() < 0) {
			return false;
		} else {
			cuenta1.setDinero(cuenta1.getDinero() - dineroTransferido);
			cuenta2.setDinero(cuenta2.getDinero() + dineroTransferido);
			return true;
		}
	}

	public static boolean TRASPASO(Cuenta cuenta1, Cuenta cuenta2, int dineroTransferido) {
		if (cuenta1.getIdBanco() == cuenta2.getIdBanco() && cuenta1.getDinero() > dineroTransferido
				&& cuenta1.getDinero() > 0) {

		} else {
			cuenta1.setDinero(cuenta1.getDinero() - dineroTransferido);
			cuenta2.setDinero(cuenta2.getDinero() + dineroTransferido);
			return true;
		}
		return false;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Banco getNombre() {
		return nombre;
	}

	public void setNombre(Banco nombre) {
		this.nombre = nombre;
	}

	public Banco getIdBanco() {
		return idBanco;
	}

	public void setIdBanco(Banco idBanco) {
		this.idBanco = idBanco;
	}

	public int getDinero() {
		return dinero;
	}

	public void setDinero(int dinero) {
		this.dinero = dinero;
	}

}
