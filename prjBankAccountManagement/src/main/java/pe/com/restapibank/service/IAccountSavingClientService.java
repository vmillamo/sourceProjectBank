package pe.com.restapibank.service;

import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.AccountFixed;
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountSavingClientService {
	
	Flux<Client> getByIdClient(Integer idClient);
	Mono<AccountSaving> save(AccountSaving account_saving);
	//
	Flux<AccountSaving> getAccountSavingByClient(Integer idClient);
	Flux<AccountCredit> getAccountCreditByClient(Integer idClient);
	Flux<AccountFixed> getAccountFixedByClient(Integer idClient);
}
