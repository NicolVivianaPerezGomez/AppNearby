package co.edu.ue.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.CategoriasMatch;
import co.edu.ue.service.ICategoriasMatchService;

@RestController
@RequestMapping("categorias-match")
public class CategoriasMatchController {

    @Autowired
    private ICategoriasMatchService service;

    @GetMapping("{id}")
    public CategoriasMatch getById(@PathVariable int id) {
        return service.getById(id);
    }

    @GetMapping
    public List<CategoriasMatch> getAll() {
        return service.getAll();
    }

    @PostMapping
    public CategoriasMatch create(@RequestBody CategoriasMatch categoriasMatch) {
        return service.create(categoriasMatch);
    }

    @PutMapping
    public CategoriasMatch modify(@RequestBody CategoriasMatch categoriasMatch) {
        return service.modify(categoriasMatch);
    }

    @DeleteMapping("{id}")
    public CategoriasMatch remove(@PathVariable int id) {
        return service.remove(id);
    }
}
