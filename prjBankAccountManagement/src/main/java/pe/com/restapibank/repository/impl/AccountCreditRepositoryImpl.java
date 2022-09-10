package pe.com.restapibank.repository.impl;

import java.time.LocalDateTime;

import org.springframework.stereotype.Repository;

import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IAccountCreditRepositorySinCRUD;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class AccountCreditRepositoryImpl implements IAccountCreditRepositorySinCRUD {

	@Override
	public Flux<AccountCredit> getAccountCredit() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Flux<AccountCredit> findAccCreditByClient(Integer idClient) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<AccountCredit> create(AccountCredit fixed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Void> delete(AccountCredit fixed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<AccountCredit> depositCredit(AccountCredit fixed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<AccountCredit> retreatCredit(AccountCredit fixed) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<AccountCredit> saveAccountCreditByClient(AccountCredit accountCredit) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mono<Client> clientFind(Integer idCLient) {
    	LocalDateTime dateTime = LocalDateTime.parse("2022-09-27T12:26:30.107");
    	Mono<Client> client = Mono.just(new Client(11,"empresarial",dateTime,"user01","192.66.22.33",2));
    	return  client;
	}

}
