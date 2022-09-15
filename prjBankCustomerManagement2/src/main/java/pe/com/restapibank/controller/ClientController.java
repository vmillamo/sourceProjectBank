package pe.com.restapibank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.entity.ClientResilence;
import pe.com.restapibank.entity.Person;
import pe.com.restapibank.service.IClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/client")
@Log4j2
public class ClientController {

	@Autowired 	
	private IClientService clientService;
	
	@GetMapping
	public ResponseEntity<Flux<Client>> getAll(){
		Flux<Client> getAll = clientService.getAll();
		log.info("*************************************************************");
		log.info("*****Inicio: Listar Cliente*****");
		log.info("*************************************************************");
		return new ResponseEntity<Flux<Client>>(getAll,HttpStatus.OK);
	}
	
//    @GetMapping("/{id}")
//    public ResponseEntity<Flux<Client>> findById(@PathVariable Integer id){
//    	Flux<Client> c = clientService.findById(id);
//        return new ResponseEntity<Flux<Client>>(c, HttpStatus.OK);
//    }
    
	@PostMapping
	public ResponseEntity<Mono<Client>> create (@RequestBody Client client){
		log.info("*****Inicio: Crear Cliente*****");
		log.info("*************************************************************");
		Mono<Client> c = clientService.create(client);
		return new ResponseEntity<Mono<Client>>(c, HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Mono<Client>> update (@RequestBody Client client){
		Mono<Client> c = clientService.update(client);
		return new ResponseEntity<Mono<Client>>(c, HttpStatus.CREATED);
	}
	
}
