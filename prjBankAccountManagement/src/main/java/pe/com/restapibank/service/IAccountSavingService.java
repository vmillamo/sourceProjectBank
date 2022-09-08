package pe.com.restapibank.service;

import pe.com.restapibank.entity.AccountFixed;
import pe.com.restapibank.entity.AccountSaving;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountSavingService {
	
	Flux<AccountSaving> getAll();
	Mono<AccountSaving> save(AccountSaving account_saving);
	Mono<Void> delete(AccountSaving account_saving);
	Flux<AccountSaving> findById(Integer id);
	Mono<AccountSaving> saveAccSavingByClient(AccountSaving accountSaving);
	Mono<AccountSaving> depositFixed(AccountSaving accountSaving);
	Mono<AccountSaving> retreatFixed(AccountSaving accountSaving);	
	Mono<AccountSaving> saveAccSavingByClientVIP(AccountSaving accountSaving);
	Mono<AccountSaving> saveAccCurrentBussinessPyme(AccountSaving accountSaving);
}
