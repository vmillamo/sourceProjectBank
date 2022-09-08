package pe.com.restapibank.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.com.restapibank.entity.AccountCredit;
import pe.com.restapibank.entity.AccountFixed;
import pe.com.restapibank.entity.AccountSaving;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IAccountCreditRepository;
import pe.com.restapibank.repository.IAccountFixedRepository;
import pe.com.restapibank.repository.IAccountSavingRepository;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.service.IAccountSavingClientService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AccountSavingClientImpl implements IAccountSavingClientService{

//	private final CopyOnWriteArrayList<Client> mgclient = new CopyOnWriteArrayList<>();
//	private final CopyOnWriteArrayList<AccountSaving> mgaccountsaving = new CopyOnWriteArrayList<>();	
	
	@Autowired
	private IClientRepository iClientRepository;

	@Autowired
	private IAccountSavingRepository iIAccountSavingRepository;
	
	@Autowired 
	private IAccountCreditRepository iAccountCreditRepo;
	
	@Autowired 
	private IAccountFixedRepository iAccountFixedRepo;

	@Override
	public Flux<Client> getByIdClient(Integer idClient) {
//	    return Flux.fromIterable(mgclient)
//		        .filter(xmg_client -> xmg_client.getIdClient().equals(idClient))
//		        .next();
		return iClientRepository.findAll()
				.filter(xmg_client-> xmg_client.getIdClient().equals(idClient));		
	}
		
	@Override
	public Mono<AccountSaving> save(AccountSaving account_saving) {
		
		Flux<Client> objCLientData = this.getByIdClient(account_saving.getIdClient());
		
//		Flux<AccountSaving> objCLientAccountData = this.getByIdClientAccount(account_saving.getIdClient());
	
		if (!(objCLientData.equals(null))) {

			// Completar la validacion
//			objCLientData.map
//			
//			Iterator it = objCLientData.map.keySet().iterator();
//			while(it.hasNext()){
//			  Integer key = it.next();
//			  System.out.println("Clave: " + key + " -> Valor: " + map.get(key));
//			}
			
			//log.info("El cliente es de tipo Personal, solo puede tener una cuenta");
			
			return iIAccountSavingRepository.save(account_saving);
		}else {
			log.info("El cliente no existe, debe crearlo");
			return null;
		}
		
		//return null;
	}

	//Obtiene la cuenta de ahorro por cliente
	@Override
	public Flux<AccountSaving> getAccountSavingByClient(Integer idClient) {
		return iIAccountSavingRepository.findAll()
				.filter(xmg_account_saving-> xmg_account_saving.getIdClient().equals(idClient));
	}
	
	//Obtiene la cuenta de credito por cliente
	@Override
	public Flux<AccountCredit> getAccountCreditByClient(Integer idClient) {
		return iAccountCreditRepo.findAll().filter(x -> x.getIdClient().equals(idClient));
	}

	@Override
	public Flux<AccountFixed> getAccountFixedByClient(Integer idClient) {
		return iAccountFixedRepo.findAll().filter(x -> x.getIdClient().equals(idClient));
	}

	
}
