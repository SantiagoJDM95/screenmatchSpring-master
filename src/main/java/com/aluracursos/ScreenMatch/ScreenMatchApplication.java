package com.aluracursos.ScreenMatch;

import com.aluracursos.ScreenMatch.model.DatosEpisodio;
import com.aluracursos.ScreenMatch.model.DatosSerie;
import com.aluracursos.ScreenMatch.model.DatosTemporadas;
import com.aluracursos.ScreenMatch.principal.EjemploStreams;
import com.aluracursos.ScreenMatch.principal.Principal;
import com.aluracursos.ScreenMatch.service.ConsumoAPI;
import com.aluracursos.ScreenMatch.service.ConvierteDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenMatchApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(ScreenMatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		Principal principal = new Principal();
//		principal.muestraElMenu();

		EjemploStreams ejemploStreams = new EjemploStreams();
		ejemploStreams.muestraEjemplo();


//		var consumoApi = new ConsumoAPI();
//
//		//var json = consumoApi.obtenerDatos("https://coffee.alexflipnote.dev/random.json");
//		System.out.println(json);
//		ConvierteDatos conversor = new ConvierteDatos();
//		var datos = conversor.obtenerDatos(json, DatosSerie.class);
//		System.out.println(datos);
//		json = consumoApi.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&Episode=1&apikey=85753089");
//		DatosEpisodio episodios = conversor.obtenerDatos(json, DatosEpisodio.class);
//		System.out.println(episodios);
//
//
	}

}
