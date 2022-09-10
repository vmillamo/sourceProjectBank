package pe.com.restapibank.serviceimpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import lombok.RequiredArgsConstructor;
import pe.com.restapibank.entity.Client;
import pe.com.restapibank.repository.IAccountCreditRepository;
import pe.com.restapibank.repository.IClientRepository;
import pe.com.restapibank.repository.impl.AccountCreditRepositoryImpl;
import pe.com.restapibank.service.IAccountSavingClientService;
import pe.com.restapibank.utils.Constant;
import reactor.core.publisher.Mono;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
public class AccountCreditServiceImplTest {

    @Mock
    AccountCreditRepositoryImpl accountCreditepository;

	@Mock
	IClientRepository clientRepo;
	
    @InjectMocks
    AccountCreditServiceImpl accountCreditService;
    
    @Autowired
    private Mono<Client> cliente;

    @Mock
	IAccountCreditRepository creditRepo;
	
    @Mock
	IAccountSavingClientService accountCredClient;    
    
    @BeforeEach
    void ini(){
    	LocalDateTime dateTime = LocalDateTime.parse("2022-09-27T12:26:30.107");
    	cliente =  Mono.just(new Client(11,"empresarial",dateTime,"user01","192.66.22.33",2));
        System.out.println("cliente : " + cliente.subscribe( x -> System.out.println(x.getIdClient()+" "+x.getTypeClient())));
    }
    
	@Test
	void testclientFind() {
        Mockito.when(accountCreditepository.clientFind(11)).thenReturn(cliente);
        cliente.subscribe(a -> assertEquals(Constant.Bussiness, a.getTypeClient()));
	}

}


