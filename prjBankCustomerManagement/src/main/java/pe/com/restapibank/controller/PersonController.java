package pe.com.restapibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.Person;
import pe.com.restapibank.service.IPersonService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
@Slf4j
public class PersonController {
	
	@Autowired
	private IPersonService personService;
	
	@GetMapping
	public ResponseEntity<Flux<Person>> getAll(){
		Flux<Person> getAll = personService.getAll();
		log.info("*************************************************************");
		log.info("*****Inicio: Listar Persona*****");
		log.info("*************************************************************");
		return new ResponseEntity<Flux<Person>>(getAll,HttpStatus.OK);
	}
	
    @GetMapping("/{id}")
    public ResponseEntity<Flux<Person>> findById(@PathVariable Integer id){
    	Flux<Person> p = personService.findById(id);
        return new ResponseEntity<Flux<Person>>(p, HttpStatus.OK);
    }
    
    @GetMapping("/dni/{dni}")
    public ResponseEntity<Flux<Person>> findByDni(@PathVariable String dni){
    	Flux<Person> p = personService.findByDNI(dni);
        return new ResponseEntity<Flux<Person>>(p, HttpStatus.OK);
    }
    
	@PostMapping
	public ResponseEntity<Mono<Person>> create (@RequestBody Person person){
		log.info("*****Inicio: Crear Persona*****");
		log.info("*************************************************************");
		Mono<Person> p = personService.create(person);
		return new ResponseEntity<Mono<Person>>(p, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Mono<Person>> update (@RequestBody Person person){
		Mono<Person> p = personService.update(person);
		return new ResponseEntity<Mono<Person>>(p, HttpStatus.CREATED);
	}
	
    @DeleteMapping("/delete")
    public ResponseEntity<Mono<Void>> delete(@RequestBody Person person ){
    	Mono<Void> p = personService.delete(person);
        return new ResponseEntity<Mono<Void>>(p, HttpStatus.NO_CONTENT);
    }
    	
}
