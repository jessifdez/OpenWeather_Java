import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	static Scanner sc=new Scanner(System.in);

	public static int mostrarMenu(ArrayList<Ciudad> lista_ciudades) {
		for (Ciudad ciudad : lista_ciudades) 
		{
			System.out.println(ciudad.getOpcion()+"-"+ciudad.getNombre());
		}
		int opcion=sc.nextInt();
		return opcion; 
	}
	
	public static void mostrarClima(ClimaOpenWeather c) {
		System.out.println("T. Mínima: "+c.getT_minima()+" K" );
		System.out.println("T. Maxima: "+c.getT_maxima()+" K");
		System.out.println("Salida del sol: "+epoch2UTC(c.getSalida_sol()));
		System.out.println("Puesta del sol: "+epoch2UTC(c.getPuesta_de_sol()));
	}
	
	public static String epoch2UTC(long epoch) {//Para pasar el tiempo de epoch a día, hora...
		long t=epoch;
		LocalDateTime dateTime=LocalDateTime.ofEpochSecond(t, 0, ZoneOffset.UTC);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE,MMMM d,yyyy h:mm,a");
		String formattedDate = dateTime.format(formatter);
		return formattedDate;
		
	}

}
