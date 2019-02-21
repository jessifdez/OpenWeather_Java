
public class ClimaOpenWeather {
	private double t_minima, t_maxima;
	private long salida_sol, puesta_de_sol;
	
	public ClimaOpenWeather(double t_minima, double t_maxima, long salida_sol, long puesta_de_sol) {
		this.t_minima = t_minima;
		this.t_maxima = t_maxima;
		this.salida_sol = salida_sol;
		this.puesta_de_sol = puesta_de_sol;
		
		
	}

	public double getT_minima() {
		return t_minima;
	}

	public double getT_maxima() {
		return t_maxima;
	}

	public long getSalida_sol() {
		return salida_sol;
	}

	public long getPuesta_de_sol() {
		return puesta_de_sol;
	}

	
	
}
