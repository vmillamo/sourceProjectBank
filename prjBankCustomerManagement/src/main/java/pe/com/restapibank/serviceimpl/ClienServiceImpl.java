package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.entity.ClientResilence;
import pe.com.restapibank.entity.Person;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.service.IClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class ClienServiceImpl implements IClientService{

	private final WebClient webClient;
	
	public ClienServiceImpl(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.baseUrl("http://localhost:8083").build();
	}
	
	@Autowired
	IClientRepository clientRepo;
	
	@Override
	public Flux<Client> getAll() {
		return clientRepo.findAll();
	}

	@Override
	public Mono<Client> create(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public Flux<Client> findById(Integer id) {
		return clientRepo.findAll().filter(x -> x.getIdClient().equals(id));
	}

	@Override
	public Mono<Client> update(Client client) {
		return clientRepo.save(client);
	}

	@Override
	public Mono<Client> save(Client client) {
		
		if (!(Constant.Personnel.equals(client.getTypeClient()) || Constant.Bussiness.equals(client.getTypeClient()))) {
			log.info("El campo idTypeClient debe ser de tipo: 0 Personal, 1 Empresarial");
			return null;
		}else {		
			return clientRepo.save(client);
		}
		
	}

	@Override
	public Mono<ClientResilence> getClientById(Integer id) {
		Person person = new Person();
		Mono<Person> personByClient = this.webClient.get().uri("/person/{id}", id).retrieve().bodyToMono(Person.class);
		return personByClient.flatMap(x ->{
			person.setIdPerson(x.getIdPerson());
			person.setFullName(x.getFullName());
			person.setTypeDoc(x.getTypeDoc());
			person.setNumberDoc(x.getNumberDoc());
			person.setDateBirth(x.getDateBirth());
			person.setEmail(x.getEmail());
			person.setPhone(x.getPhone());
			person.setActive(x.getActive());
			person.setUserCreation(x.getUserCreation());
			person.setIpCreation(x.getIpCreation());
			
			Mono<ClientResilence> clientResilence = Mono.just(new ClientResilence(10,"Personal","2022-08-30T12:26:30.107","ROM01","10.21.12.122",person));
			return clientResilence;
		});
	}	
	
	@Override
	public Mono<Person> getPersonByIdEmployee(Integer id) {
		return this.webClient.get().uri("/person/{id}", id).retrieve().bodyToMono(Person.class);
	}

	
}
