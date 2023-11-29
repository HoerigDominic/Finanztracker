package de.htwBerlin.webtech.Finanztracker.web;

import de.htwBerlin.webtech.Finanztracker.web.Transaktion;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaktionRepository extends CrudRepository<Transaktion, Long> {}
