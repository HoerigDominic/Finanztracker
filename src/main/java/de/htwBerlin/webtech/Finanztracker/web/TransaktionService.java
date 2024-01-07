package de.htwBerlin.webtech.Finanztracker.web;

import de.htwBerlin.webtech.Finanztracker.web.Transaktion;
import de.htwBerlin.webtech.Finanztracker.web.TransaktionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransaktionService {

    private final TransaktionRepository repo;

    public TransaktionService(TransaktionRepository repo) {
        this.repo = repo;
    }

    public List <Transaktion> getAll() {
        List <Transaktion> transaktionen = repo.findAll();
        return transaktionen;
    }
    public Transaktion create (Transaktion transaktion) {
        return repo.save(transaktion);
    }

    public Transaktion getById(Long transaktionId) {
        return repo.findById(transaktionId).orElseThrow(()-> new RuntimeException());
    }

    public Transaktion update(Long id, Transaktion transaktion) {
        Optional<Transaktion> findTransaktion = repo.findById(id);
        if (findTransaktion.isEmpty()) {
            return null;
        }
        Transaktion cacheTransaktion = findTransaktion.get();
        cacheTransaktion.setBetrag(transaktion.getBetrag());
        cacheTransaktion.setBeschreibung(transaktion.getBeschreibung());
        cacheTransaktion.setArt(transaktion.getArt());
        cacheTransaktion.setDatum(transaktion.getDatum());
        cacheTransaktion.setKategorie(transaktion.getKategorie());
        return repo.save(cacheTransaktion);
    }

    public void delete(Long id) {repo.deleteById(id);}

    public void deleteAll() {repo.deleteAll();}


}

