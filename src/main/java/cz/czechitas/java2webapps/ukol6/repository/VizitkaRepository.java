package cz.czechitas.java2webapps.ukol6.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import cz.czechitas.java2webapps.ukol6.entity.Vizitka;

@Repository
public interface VizitkaRepository extends CrudRepository<Vizitka, Long> {
}
