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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.ue.entity.Matches;
import co.edu.ue.service.IMatchesService;

@RestController
@RequestMapping("matches")
public class MatchesController {

	@Autowired 
    IMatchesService service;

    public MatchesController(IMatchesService matchesService) {
        this.service = matchesService;
    }

    @PostMapping
    public ResponseEntity<Matches> createMatch(@RequestBody Matches match) {
        Matches createdMatch = service.guardarMatch(match);
        return new ResponseEntity<>(createdMatch, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Matches> updateMatch(@RequestBody Matches match) {
        Matches updatedMatch = service.actualizarMatch(match);
        return ResponseEntity.ok(updatedMatch);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable int matId) {
        service.eliminarMatch(matId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/matches")
    public ResponseEntity<List<Matches>> getAllMatches() {
        List<Matches> matches = service.getAllMatches();
        return ResponseEntity.ok(matches);
    }

    @GetMapping("/match-id") 
    public ResponseEntity<Matches> getMatchById(@RequestParam("id") int matId) {
        Matches match = service.encontrarporId(matId);
        return ResponseEntity.ok(match);
    }
}
