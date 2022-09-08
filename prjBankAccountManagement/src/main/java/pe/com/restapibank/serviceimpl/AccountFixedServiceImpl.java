package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.log4j.Log4j2;
import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.AccountFixed;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IAccountFixedRepository;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.service.IAccountFixedService;
import pe.com.restapibank.service.IAccountSavingClientService;
import pe.com.restapibank.utils.Constant;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Log4j2
@Service
public class AccountFixedServiceImpl implements IAccountFixedService{

	@Autowired
	IAccountFixedRepository fixedRepo;
	
	@Autowired
	IClientRepository clientRepo;
	
	@Autowired
	IAccountSavingClientService accountCredClient;
	
	//Obtiene todas las cuentas de plazo fijo
	@Override
	public Flux<AccountFixed> getAccountFixed() {
		return fixedRepo.findAll();
	}

	//Buscar las cuentas de plazo fijo por id del cliente
	@Override
	public Flux<AccountFixed> findAccFixedByClient(Integer idClient) {
		return fixedRepo.findAll().filter(x -> x.getIdClient().equals(idClient));
	}

	//Guardar un registro de cuenta a plazo fijo
	@Override
	public Mono<AccountFixed> create(AccountFixed fixed) {
		return fixedRepo.save(fixed);
	}

	//Actualiza el deposito
	//Actualiza el saldo y la cantidad de meses de plazo fijo
	@Override
	public Mono<AccountFixed> depositFixed(AccountFixed fixed) {
		// TODO Auto-generated method stub
		return fixedRepo.save(fixed);
	}

	@Override
	public Mono<AccountFixed> retreatFixed(AccountFixed fixed) {
		// TODO Auto-generated method stub
		return fixedRepo.save(fixed);
	}


	//Un cliente personal puede tener cuentas a plazo fijo.
	@Override
	public Mono<AccountFixed> saveAccountFixedByClient(AccountFixed accountFixed) {
		log.info("*****INICIO: Crear cuenta de credito por persona*****");
		Mono<Client> getClientById = clientRepo.findById(accountFixed.getIdClient());
		if(accountFixed.getBalance()>=0) {
			if(getClientById.block().getTypeClient().equals(Constant.Personnel)) {		
				log.info("**EXITO: Se creó correctamente la cuenta de plazo fijo Personal**");
				return fixedRepo.save(accountFixed);
			}else {
				log.info("**ERROR: El cliente no es de tipo Personal**");
				return null;
			}
		}else {
			log.info("**ERROR: El saldo no debe ser menor a 0**");
			return null;
		}
	}

}
