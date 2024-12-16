package co.edu.ue.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.edu.ue.entity.Citas;
import co.edu.ue.service.ICitasService;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("citas")
public class CitasController {

    @Autowired
    private ICitasService citasService;

    // LISTA DE TODAS LAS CITAS
    @GetMapping
    public ResponseEntity<List<Citas>> obtenerTodasLasCitas() {
        List<Citas> citas = citasService.listaCompleta();
        return new ResponseEntity<>(citas, HttpStatus.OK);
    }

    // LLAMAR UNA CITA POR ID
    @GetMapping("{id}")
    public ResponseEntity<Citas> obtenerCitaPorId(@PathVariable("id") int citId) {
        Citas cita = citasService.busquedaPorId(citId);
        if (cita != null) {
            return new ResponseEntity<>(cita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // CREAR UNA NUEVA CITA
    @PostMapping
    public ResponseEntity<Citas> crearCita(@RequestBody Citas cita) {
        Citas nuevaCita = citasService.guardarCitas(cita);
        return new ResponseEntity<>(nuevaCita, HttpStatus.CREATED);
    }

    // ACTUALIZA UNA CITA YA REGISTRADA
    @PutMapping("{id}")
    public ResponseEntity<Citas> actualizarCita(@PathVariable("id") int citId, @RequestBody Citas cita) {
        cita.setCitId(citId); // Asegúrate de que el ID se establezca en la cita
        Citas citaActualizada = citasService.actualizarCitas(cita);
        return new ResponseEntity<>(citaActualizada, HttpStatus.OK);
    }

    // ELIMINAR UNA CITA
    @DeleteMapping("{id}")
    public ResponseEntity<Void> eliminarCita(@PathVariable("id") int citId) {
        Citas citaEliminada = citasService.eliminarCitas(citId);
        if (citaEliminada != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // BUSCAR POR FECHAS
    @GetMapping("fecha/{fecha}")
    public ResponseEntity<Citas> buscarPorFecha(@PathVariable("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date citFecha) {
        Citas cita = citasService.busquedaPorFecha(citFecha);
        if (cita != null) {
            return new ResponseEntity<>(cita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // LLAMAR CITA POR ESTADO
    @GetMapping("estado/{estado}")
    public ResponseEntity<Citas> buscarPorEstado(@PathVariable("estado") String citEstado) {
        Citas cita = citasService.busquedaPorCitEstado(citEstado);
        if (cita != null) {
            return new ResponseEntity<>(cita, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}