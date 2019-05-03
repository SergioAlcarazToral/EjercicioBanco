package Cuenta.Bancaria;

import static org.junit.Assert.fail;
import java.util.spi.CurrencyNameProvider;

import org.junit.After;
import org.junit.Assert.*;
import org.junit.Test;

public class CuentaBancTest {
	
	private Banco bankia = new Banco("Bankia", 12);
	private Banco bbva = new Banco("BBVA", 1234);
	private Banco santander = new  Banco("Santander", 49);
	private Cliente cliente1 = new Cliente("Sergio", "Alcaraz Toral", "01234567Q", "Calle nfdj", 987654321);
	private Cliente cliente2 = new Cliente("Aitor", "Artigao", "2345678W", "Calle 25", 123456789);

	private Cuenta cuenta1 = new Cuenta(cliente1, 135798462, 1000, bankia, bankia);
	private Cuenta cuenta2 =  new Cuenta(cliente2, 123456789, 2000, bbva,bbva);
	private Cuenta cuenta3 = new Cuenta(cliente1, 491111, 1000, santander, santander);
	private Cuenta cuenta4 =  new Cuenta(cliente2,  492222, 2000, santander, santander);
	
	private int saldoinicialCuenta1 = cuenta1.getDinero();
	private int saldoinicialCuenta2 = cuenta2.getDinero();
	private int saldoinicialCuenta3 = cuenta3.getDinero();
	@Test
	public void MismoCliente() {
		if (cuenta1.getCliente() == cuenta2.getCliente()) {
			System.out.println("Ok");
		}else {
			System.out.println("Error");
		}
	}
	
	//Transferencia de dinero y mostrar el saldo de la cuenta origen
	@Test
	
	public void TransferenciaDinero1() {
		System.out.println("Cuenta 1");
		System.out.println(cuenta1.getDinero());
		Cuenta.TRANSFERENCIA(cuenta1, cuenta2, 50);
		System.out.println(cuenta1.getDinero());

		if (cuenta1.getDinero() == saldoinicialCuenta1) {
			fail();
		}
	}
	//Transferencia de dinero y mostrar el saldo de la cuenta destino
	@Test
	
	public void TransferenciaDinero2() {
		System.out.println("Cuenta 2");
		System.out.println(cuenta2.getDinero());
		Cuenta.TRANSFERENCIA(cuenta1, cuenta2, 50);
		System.out.println(cuenta2.getDinero());
		if (cuenta2.getDinero() == saldoinicialCuenta2) {
			fail();
		}
	}
	//Realizar una transferencia y si se realiza de manera correcta saldra bien
	@Test
	public void TransferenciaDinero3() {
		Cuenta.TRANSFERENCIA(cuenta1, cuenta2, 50);
		if (cuenta1.getDinero() == saldoinicialCuenta1) {
			fail();
		}
	}
	//Realizar una transferencia y si se realiza de manera correcta fallara
//	@Test
//	public void TransferenciaDinero4() {
//		Cuenta.TRANSFERENCIA(cuenta1, cuenta2, 50);
//		if (cuenta1.getDinero() != saldoinicialCuenta1) {
//			fail();
//		}
//	}
	@Test
	public void TraspasoDinero() {
		System.out.println("Cuenta 3");
		System.out.println(cuenta3.getDinero());
		Cuenta.TRASPASO(cuenta3, cuenta4, 80);
		System.out.println(cuenta3.getDinero());
		if (cuenta3.getDinero() == saldoinicialCuenta3) {
			fail();
		}
	}
	
	
}
