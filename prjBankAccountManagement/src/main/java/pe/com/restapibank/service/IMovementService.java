package pe.com.restapibank.service;

import pe.com.restapibank.entity.Movement;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IMovementService {

	Flux<Movement> getAll();
	Mono<Movement> create(Movement movement);
	Flux<Movement> findById(Integer id);
	Mono<Movement> update(Movement movement);
	Mono<Void> delete(Movement movement);
	Flux<Movement> findByIdSaving(Integer id);
	Flux<Movement> findByIdFixed(Integer id);
	Flux<Movement> findByIdCredit(Integer id);
	Flux<Movement> findByIdSavingForMonth(Integer id, Integer month);
}
