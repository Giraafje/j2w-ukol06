package cz.czechitas.java2webapps.ukol6.service;

import cz.czechitas.java2webapps.ukol6.entity.Vizitka;
import cz.czechitas.java2webapps.ukol6.repository.VizitkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

  public Vizitka getById(long id) {
    return vizitkaRepository.findById(id).orElse(null);
  }

  public Vizitka append(Vizitka vizitka) {
    vizitka.setId(null); //Cannot have existing id if new entity
    vizitkaRepository.save(vizitka);
    return vizitka;
  }

  public void deleteById(long id) {
    vizitkaRepository.deleteById(id);
  }
}
