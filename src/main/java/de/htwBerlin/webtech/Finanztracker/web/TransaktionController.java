package de.htwBerlin.webtech.Finanztracker.web;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TransaktionController {

    private final TransaktionService service;

    public TransaktionController(TransaktionService service) {
        this.service = service;
    }

    @GetMapping("/transaktionen")
    public List<Transaktion> getAllTransaktionen() {return service.getAll();}

    @PostMapping("/transaktionen")
    public Transaktion createTransatkion(@RequestBody Transaktion transaktion) {
        return service.create(transaktion);
    }

    @GetMapping("/transaktionen/{id}")
    public Transaktion getTransaktion(@PathVariable Long id) {
        return service.getById(id);
    }

    @PutMapping("/transaktionen/{id}")
    public void updateTransaktion(@PathVariable Long id, @RequestBody Transaktion transaktion) {service.update(id, transaktion);}

   @DeleteMapping("/transaktionen/{id}")
   public void deleteTransaktion(@PathVariable Long id) {
       service.delete(id);
   }
}
