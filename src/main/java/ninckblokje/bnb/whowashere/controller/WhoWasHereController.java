package ninckblokje.bnb.whowashere.controller;

import ninckblokje.bnb.whowashere.model.Who;
import ninckblokje.bnb.whowashere.repository.WhoWasHereRepository;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/here")
@Transactional
public class WhoWasHereController {

    private WhoWasHereRepository repository;

    public WhoWasHereController(WhoWasHereRepository repository) throws InterruptedException {
        this.repository = repository;
        Thread.sleep(55000);
    }

    @GetMapping(produces = "application/json")
    public List<Who> whoWasHere() {
        return repository.findAll();
    }

    @PostMapping("/{name}")
    @ResponseStatus(HttpStatus.CREATED)
    public void wasHere(@PathVariable("name") String name) {
        repository.save(new Who(LocalDateTime.now(), name));
    }
}
