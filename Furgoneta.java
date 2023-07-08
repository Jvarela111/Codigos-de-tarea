package poo;

public class Furgoneta  extends coche{

	private int capacidad_carga; 
	private int plazas_extras; 
	
	public Furgoneta(int plazas_extra, int capacidad_carga) {
		
		super(); //llamar al constructor de la clase padre 
		this.capacidad_carga = capacidad_carga; 
		this.plazas_extras = plazas_extra; 
	}
	
	public String dimeDatosFurgoneta() {
		return super.dime_datos_totales() + ". La capacidad de carga es: "+ capacidad_carga +
				"Kg y las plazas extras son "+ plazas_extras ;
	}
	
	
}