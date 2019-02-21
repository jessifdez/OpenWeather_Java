import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;


public class ParsearJSON {
	
public static ClimaOpenWeather devolverClima(String json) {
		
		ClimaOpenWeather c=null;
		try {
			JSONParser parseador=new JSONParser();
			JSONObject objeto=(JSONObject)parseador.parse(json);
			JSONObject objeto_main=(JSONObject)objeto.get("main");
			double t_minima=(double)objeto_main.get("temp_min");
			double t_maxima=(double)objeto_main.get("temp_max");
			JSONObject objeto_sys=(JSONObject)objeto.get("sys");
			long salida_sol=(long)objeto_sys.get("sunrise");
			long puesta_de_sol=(long)objeto_sys.get("sunset");
			String nombre=(String)objeto.get("name");
			System.out.println("NOMBRE CIUDAD: "+nombre);
			c=new ClimaOpenWeather(t_minima,t_maxima,salida_sol,puesta_de_sol);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return c;
	}


}
