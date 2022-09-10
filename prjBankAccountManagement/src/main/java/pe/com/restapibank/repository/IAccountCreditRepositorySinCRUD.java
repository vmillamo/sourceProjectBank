package pe.com.restapibank.repository;

import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.Client;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IAccountCreditRepositorySinCRUD {
	Flux<AccountCredit> getAccountCredit();
	Flux<AccountCredit> findAccCreditByClient(Integer idClient);
	Mono<AccountCredit> create(AccountCredit fixed);
	Mono<Void> delete(AccountCredit fixed);
	Mono<AccountCredit> depositCredit(AccountCredit fixed);
	Mono<AccountCredit> retreatCredit(AccountCredit fixed);
	Mono<AccountCredit> saveAccountCreditByClient(AccountCredit accountCredit);
	Mono<Client> clientFind(Integer idCLient);
}
