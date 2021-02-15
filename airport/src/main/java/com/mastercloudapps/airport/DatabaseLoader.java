package com.mastercloudapps.airport;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.mastercloudapps.airport.dto.AvionRevisionMecanicoDTO;
import com.mastercloudapps.airport.dto.ComunidadAutonomaNProvinciasDTO;
import com.mastercloudapps.airport.dto.TripulanteCiudadFechaDTO;
import com.mastercloudapps.airport.dto.TripulanteTiempoVueloAcumuladosDTO;
import com.mastercloudapps.airport.dto.VueloCiudadFechaDTO;
import com.mastercloudapps.airport.entity.Aeropuerto;
import com.mastercloudapps.airport.entity.Avion;
import com.mastercloudapps.airport.entity.Mecanico;
import com.mastercloudapps.airport.entity.Provincia;
import com.mastercloudapps.airport.entity.Revision;
import com.mastercloudapps.airport.entity.Tripulante;
import com.mastercloudapps.airport.entity.Vuelo;
import com.mastercloudapps.airport.repository.AeropuertoRepository;
import com.mastercloudapps.airport.repository.AvionRepository;
import com.mastercloudapps.airport.repository.MecanicoRepository;
import com.mastercloudapps.airport.repository.ProvinciaRepository;
import com.mastercloudapps.airport.repository.RevisionRepository;
import com.mastercloudapps.airport.repository.TripulanteRepository;
import com.mastercloudapps.airport.repository.VueloRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

@Controller
public class DatabaseLoader implements CommandLineRunner {

    @Autowired
    MecanicoRepository mecanicoRepository;

    @Autowired
    TripulanteRepository tripulanteRepository;

    @Autowired
    AvionRepository avionRepository;

    @Autowired
    AeropuertoRepository aeropuertoRepository;

    @Autowired
    RevisionRepository revisionRepository;

    @Autowired
    VueloRepository vueloRepository;

    @Autowired
    ProvinciaRepository provinciaRepository;

    @Override
    public void run(String... args) {

        // Example data is being inserted from migration v1 script

        List<Mecanico> mecanicos = mecanicoRepository.findAll();
        List<Tripulante> tripulantes = tripulanteRepository.findAll();
        List<Avion> aviones = avionRepository.findAll();
        List<Aeropuerto> aeropuertos = aeropuertoRepository.findAll();
        List<Vuelo> vuelos = vueloRepository.findAll();
        List<Revision> revisiones = revisionRepository.findAll();
        List<Provincia> provincias = provinciaRepository.findAll();
        List<ComunidadAutonomaNProvinciasDTO> casNumeroProvincias = provinciaRepository.findAllCAsAndCountProvinces();

        // --- Relational (MySQL) database info ---
        
        muestraDatos("Mecanicos: ", mecanicos);
        muestraDatos("Tripulantes: ", tripulantes);
        muestraDatos("Aviones: ", aviones);
        muestraDatos("Aeropuertos: ", aeropuertos);
        muestraDatos("Vuelos: ", vuelos);
        muestraDatos("Revisiones: ", revisiones);


        // Custom queries

        try {
            this.muestraVuelosCiudadDestinoYFecha("Las Palmas", new SimpleDateFormat("yyyy-MM-dd").parse("2021-02-07"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        this.muestraMecanicosAviones();
        this.muestraTripulantesCiudadHoraDespegue();
        this.muestraTripulantesTiempoVuelosAcumulados();

        // --- Non-relational (Mongo) database info ---

        muestraDatos("Provincias y todos sus datos: ", provincias);
        muestraDatos("Comunidades autónomas y número de provincias: ", casNumeroProvincias);

        this.muestraMecanicosAvionesJson();
        this.muestraTripulantesTiempoVuelosAcumuladosJson();

    }

    private void muestraTripulantesTiempoVuelosAcumuladosJson() {
        List<TripulanteTiempoVueloAcumuladosDTO> tripulantesTiempoVuelosAcumulados = tripulanteRepository.findTripulanteTiempoVuelosAcumuladosJson();
        muestraDatos("Tripulantes con tiempo y vuelos acumulados recogidos de json: ", tripulantesTiempoVuelosAcumulados);
    }

    private void muestraMecanicosAvionesJson() {
        List<AvionRevisionMecanicoDTO> mecanicosAviones = avionRepository.findAllAvionesByMecanicosAndRevisionesJson();
        muestraDatos("Nombre de mecanicos que han revisado cada avion recogidos de json: ", mecanicosAviones);
    }

    private static void muestraDatos(String title, List<?> datos) {
        System.out.println("\n\n\n--------");
        System.out.println(title + "\n\n");
        for (Object p : datos) {
            System.out.println(p);
            System.out.println();
        }
        System.out.println("--------");
    }

    private void muestraVuelosCiudadDestinoYFecha(String ciudadDestino, Date fecha) {
        List<VueloCiudadFechaDTO> vuelos = vueloRepository.findVuelosByCiudadDestinoAndFechaOrderedByHour(ciudadDestino, fecha);
        muestraDatos("Vuelos por ciudad de destino y fecha ordenados por hora: ", vuelos);
    }

    private void muestraMecanicosAviones() {
        List<AvionRevisionMecanicoDTO> mecanicosAviones = avionRepository.findAllAvionesByMecanicosAndRevisiones();
        muestraDatos("Nombre de mecanicos que han revisado cada avion: ", mecanicosAviones);
    }

    private void muestraTripulantesCiudadHoraDespegue() {
        List<Tripulante> tripulantes = this.tripulanteRepository.findAll();
        List<TripulanteCiudadFechaDTO> tripulantesCiudadFecha = tripulanteRepository.findTripulanteByCodEmpleado(tripulantes.get(0).getCodEmpleado());
        muestraDatos("Tripulantes con ciudades de despegue y fecha: ", tripulantesCiudadFecha);
    }

    private void muestraTripulantesTiempoVuelosAcumulados() {
        List<TripulanteTiempoVueloAcumuladosDTO> tripulantesTiempoVuelosAcumulados = tripulanteRepository.findTripulanteTiempoVuelosAcumulados();
        muestraDatos("Tripulantes con tiempo y vuelos acumulados: ", tripulantesTiempoVuelosAcumulados);
    }
}
