package ninckblokje.bnb.whowashere.repository;

import ninckblokje.bnb.whowashere.model.Who;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface WhoWasHereRepository extends JpaRepository<Who,Long> {
}
