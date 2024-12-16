package co.edu.ue.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.edu.ue.entity.Fotografias;
import co.edu.ue.service.IFotografiasService;

@RestController
@RequestMapping("fotografias")
public class FotografiasController {

    @Autowired
    private IFotografiasService service;

    @GetMapping("{id}")
    public ResponseEntity<Fotografias> getFotografiaById(@PathVariable int id) {
        Fotografias fotografia = service.getFotografiaById(id);
        if (fotografia != null) {
            return ResponseEntity.ok(fotografia);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Fotografias>> getAllFotografias() {
        List<Fotografias> fotografias = service.getAllFotografias();
        return ResponseEntity.ok(fotografias);
    }

    @PostMapping
    public ResponseEntity<Fotografias> createFotografia(@RequestBody Fotografias fotografia) {
        Fotografias nuevaFotografia = service.guardarFotografia(fotografia);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaFotografia);
    }

    @PutMapping
    public ResponseEntity<Fotografias> updateFotografia(@RequestBody Fotografias fotografia) {
        Fotografias fotografiaActualizada = service.guardarFotografia(fotografia);
        return ResponseEntity.ok(fotografiaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Fotografias> deleteFotografia(@PathVariable int id) {
        Fotografias fotografiaEliminada = service.eliminarFotografiaPorId(id);
        if (fotografiaEliminada != null) {
            return ResponseEntity.ok(fotografiaEliminada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}