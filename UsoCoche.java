package poo;



public class UsoCoche {
	
public static void main (String[] args) {
		
		coche micoche1 = new coche();
		coche micoche2 = new coche(); 
		coche micoche3 = new coche(); 
		coche micoche4 = new coche(); 
		coche micoche5 = new coche(); 
		coche micoche6 = new coche(); 
		
		micoche1.establece_color("Rojo");
		micoche2.establece_color("Verde");
		micoche3.establece_color("Azul");
		micoche4.establece_color("Amarillo");
		micoche5.establece_color("Morado");
		micoche6.establece_color("Plateado");
		
		micoche1.configura_asientos("Si");
		micoche2.configura_asientos("No");
		micoche3.configura_asientos("Si");
		micoche4.configura_asientos("Si");
		micoche5.configura_asientos("No");
		micoche6.configura_asientos("No");
		
		micoche1.configura_climatizador("No");
		micoche1.configura_climatizador("No");
		micoche1.configura_climatizador("No");
		micoche1.configura_climatizador("No");
		micoche1.configura_climatizador("Si");
		micoche1.configura_climatizador("Si");
		
		Furgoneta mifurgoneta1 = new Furgoneta(7, 580);
		Furgoneta mifurgoneta2 = new Furgoneta(1, 880);
		Furgoneta mifurgoneta3 = new Furgoneta(3, 600);
		Furgoneta mifurgoneta4 = new Furgoneta(5, 350);
		Furgoneta mifurgoneta5 = new Furgoneta(9, 200);
		Furgoneta mifurgoneta6 = new Furgoneta(4, 900);
		
		mifurgoneta1.establece_color("Rojo");
		mifurgoneta2.establece_color("Verde");
		mifurgoneta3.establece_color("Azul");
		mifurgoneta4.establece_color("Amarillo");
		mifurgoneta5.establece_color("Morado");
		mifurgoneta6.establece_color("Plateado");
		
		mifurgoneta1.configura_asientos("Si");
		mifurgoneta2.configura_asientos("No");
		mifurgoneta3.configura_asientos("Si");
		mifurgoneta4.configura_asientos("Si");
		mifurgoneta5.configura_asientos("No");
		mifurgoneta6.configura_asientos("No");
		
		mifurgoneta1.configura_climatizador("No");
		mifurgoneta1.configura_climatizador("No");
		mifurgoneta1.configura_climatizador("No");
		mifurgoneta1.configura_climatizador("No");
		mifurgoneta1.configura_climatizador("Si");
		
		System.out.println(micoche1.dime_datos_totales() 
				+". "+ micoche1.dime_asientos() + ". " + micoche1.dime_climatizador());
		System.out.println(micoche2.dime_datos_totales() 
				+". "+ micoche2.dime_asientos() + ". " + micoche2.dime_climatizador());
		System.out.println(micoche3.dime_datos_totales() 
				+". "+ micoche3.dime_asientos() + ". " + micoche3.dime_climatizador());
		System.out.println(micoche4.dime_datos_totales() 
				+". "+ micoche4.dime_asientos() + ". " + micoche4.dime_climatizador());
		System.out.println(micoche5.dime_datos_totales() 
				+". "+ micoche5.dime_asientos() + ". " + micoche5.dime_climatizador());
		System.out.println(micoche6.dime_datos_totales() 
				+". "+ micoche6.dime_asientos() + ". " + micoche6.dime_climatizador());
		
		
		System.out.println(mifurgoneta1.dimeDatosFurgoneta()
				+". "+ mifurgoneta1.dime_asientosF() + ". " + mifurgoneta1.dime_climatizadorF());
		System.out.println(mifurgoneta2.dimeDatosFurgoneta()
				+". "+ mifurgoneta2.dime_asientosF() + ". " + mifurgoneta2.dime_climatizadorF());
		System.out.println(mifurgoneta3.dimeDatosFurgoneta()
				+". "+ mifurgoneta3.dime_asientosF() + ". " + mifurgoneta3.dime_climatizadorF());
		System.out.println(mifurgoneta4.dimeDatosFurgoneta()
				+". "+ mifurgoneta4.dime_asientosF() + ". " + mifurgoneta4.dime_climatizadorF());
		System.out.println(mifurgoneta5.dimeDatosFurgoneta()
				+". "+ mifurgoneta5.dime_asientosF() + ". " + mifurgoneta5.dime_climatizadorF());
		System.out.println(mifurgoneta6.dimeDatosFurgoneta()
				+". "+ mifurgoneta6.dime_asientosF() + ". " + mifurgoneta6.dime_climatizadorF());
		
		
		
		
		
		
		
		
		
	}

}