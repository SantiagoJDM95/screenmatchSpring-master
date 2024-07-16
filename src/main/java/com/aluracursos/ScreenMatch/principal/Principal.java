package com.aluracursos.ScreenMatch.principal;

import com.aluracursos.ScreenMatch.model.DatosEpisodio;
import com.aluracursos.ScreenMatch.model.DatosSerie;
import com.aluracursos.ScreenMatch.model.DatosTemporadas;
import com.aluracursos.ScreenMatch.service.ConsumoAPI;
import com.aluracursos.ScreenMatch.service.ConvierteDatos;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner userInput = new Scanner(System.in);
    private ConsumoAPI consumoApi = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE = "http://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=85753089";

    public void muestraElMenu(){

        System.out.println("Ingrese el nombre de la serie: ");
        //Busca la serie
        var nombreSerie = userInput.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + API_KEY);
        var datos = conversor.obtenerDatos(json, DatosSerie.class);
        System.out.println(datos);

        //Buscar datos temporadas
        List<DatosTemporadas> temporadas = new ArrayList<>();
        for (int i = 1; i <= datos.totalDeTemporadas() ; i++) {
            json = consumoApi.obtenerDatos(URL_BASE + nombreSerie.replace(" ", "+") + "&Season="+i+ API_KEY);
            var datosTemporadas = conversor.obtenerDatos(json, DatosTemporadas.class);
            temporadas.add(datosTemporadas);
        }

//        temporadas.forEach(System.out::println);
//        //Mostrar solo el titulo de los episodios de las temp
//        for (int i = 0; i < datos.totalDeTemporadas() ; i++) {      //temporadas.forEach(t -> t.episodios()
//            List<DatosEpisodio> episodiosTemporada = temporadas.get(i).episodios();
//            for (int j = 0; j < episodiosTemporada.size() ; j++) {
//                System.out.println(episodiosTemporada.get(j).titulo());     //.forEach(e -> System.out.println(e.titulo())));
//            }
//        }

        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }

}
