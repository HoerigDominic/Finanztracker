package de.htwBerlin.webtech.Finanztracker.web;

import de.htwBerlin.webtech.Finanztracker.web.Transaktion;
import de.htwBerlin.webtech.Finanztracker.web.TransaktionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransaktionService {

    @Autowired
    TransaktionRepository repo;
    public TransaktionService(TransaktionRepository repo) {
        this.repo = repo;
    }
    public Transaktion save (Transaktion transaktion) {
        return repo.save(transaktion);
    }

    public Transaktion get(Long id) {
        return repo.findById(id).orElseThrow(()-> new RuntimeException());
    }

    //getAll Methode
    public void delete(Long id) {repo.deleteById(id);}

    //update


}
