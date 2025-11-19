package cz.czechitas.java2webapps.ukol6.service;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VizitkaService {
  private final VizitkaRepository vizitkaRepository;

  //Connection to the repository
  @Autowired
  public VizitkaService(VizitkaRepository vizitkaRepository) {
    this.vizitkaRepository = vizitkaRepository;
  }

  public Iterable<Vizitka> getAll() {
    return vizitkaRepository.findAll();
  }

  public Vizitka newCard() {
    return new Vizitka();
  }

  public Optional<Vizitka> getById(Integer id) {
    return vizitkaRepository.findById(id);
  }

  public Vizitka append(Vizitka vizitka) {
    vizitka.setId(null); //Cannot have existing id if new entity
    vizitkaRepository.save(vizitka);
    return vizitka;
  }

  public void deleteById(Integer id) {
    vizitkaRepository.deleteById(id);
  }
}
