package de.htwBerlin.webtech.Finanztracker.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransaktionController {

    @Autowired
    TransaktionService service;
    @PostMapping("/transaktionen")
    public Transaktion createTransatkion(@RequestBody Transaktion transaktion) {
        return service.save(transaktion);
    }

    @GetMapping("/transaktionen/{id}")
    public Transaktion getTransaktion(@PathVariable String id) {
        Long transaktionId = Long.parseLong(id);
        return service.get(transaktionId);
    }

   @DeleteMapping("/{id}")
   public void deleteTransaktion(@PathVariable ("id") Long transaktionid) {
       service.delete(transaktionid);
   }
}
