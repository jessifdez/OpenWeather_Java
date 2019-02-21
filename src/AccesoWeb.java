import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class AccesoWeb {
	
	
	public static ClimaOpenWeather devolverClima(String json) {
		
		ClimaOpenWeather c=null;
		try {
			FileReader fr=new FileReader(json);
			JSONParser parseador=new JSONParser();
			JSONObject objeto=(JSONObject)parseador.parse(fr);
			JSONObject objeto_main=(JSONObject)objeto.get("main");
			double t_minima=(double)objeto_main.get("temp_min");
			double t_maxima=(double)objeto_main.get("temp_max");
			JSONObject objeto_sys=(JSONObject)objeto.get("sys");
			long salida_sol=(long)objeto_sys.get("sunrise");
			long puesta_de_sol=(long)objeto_sys.get("sunset");
			String nombre=(String)objeto.get("name");
			System.out.println("NOMBRE CIUDAD: "+nombre);
			c=new ClimaOpenWeather(t_minima,t_maxima,salida_sol,puesta_de_sol);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}

	public static String pedirCiudad(String nombre_ciudad) {
		String url="http://api.openweathermap.org/data/2.5/weather?q="+nombre_ciudad+"&appid=57703a7a9ab7b873a99116a3ea379748";
		String aux="";  
		try {
			URL direccion=new URL(url);
			URLConnection conexion_web=direccion.openConnection();
			BufferedReader br=new BufferedReader(new InputStreamReader(conexion_web.getInputStream()));
			String linea=br.readLine();
			while(linea!=null) 
			{
				aux+=linea;
				linea=br.readLine();
			}
			br.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return aux;
	}
	

}
