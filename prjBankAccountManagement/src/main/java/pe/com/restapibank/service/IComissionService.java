package pe.com.restapibank.service;

import pe.com.restapibank.entity.Comission;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IComissionService {

	Flux<Comission> getAll();
	Mono<Comission> create(Comission comission);
	Flux<Comission> findById(Integer id);
	Mono<Comission> update(Comission comission);
	Mono<Void> delete(Comission comission);
	Flux<Comission> findByIdSaving(Integer id);
}
