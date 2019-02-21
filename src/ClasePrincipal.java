import java.util.ArrayList;

import org.w3c.dom.Document;

public class ClasePrincipal {

	public static void main(String[] args) {
		Ciudad c1=new Ciudad(1,"Madrid");
		Ciudad c2=new Ciudad(2,"Barcelona");
		Ciudad c3=new Ciudad(3,"Sevilla");
		ArrayList<Ciudad> lista_ciudades=new ArrayList<>();
		lista_ciudades.add(c1);
		lista_ciudades.add(c2);
		lista_ciudades.add(c3);
		int opcion=EntradaSalida.mostrarMenu(lista_ciudades);
		String nombre_ciudad="";
		switch(opcion)
		{
		case 1:
			nombre_ciudad="Madrid";
			break;
		case 2:
			nombre_ciudad="Barcelona";
			break;
		case 3:
			nombre_ciudad="Sevilla";
			break;
		}
		String texto_json=AccesoWeb.pedirCiudad(nombre_ciudad);
		ClimaOpenWeather c=ParsearJSON.devolverClima(texto_json);
		//System.out.println(c.getSalida_sol()+", "+c.getPuesta_de_sol()+", "+c.getT_minima()+", "+c.getT_maxima());
		EntradaSalida.mostrarClima(c);
	}

}
