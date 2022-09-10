package pe.com.restapibank.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "client")
@AllArgsConstructor
@NoArgsConstructor
public class Client {

	@Id
	private Integer idClient;
	private String typeClient;
	private LocalDateTime dateEntry;
	private String userCreation;
	private String ipCreation;
	private Integer idPerson;
	
    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", typeClient='" + typeClient + '\'' +
                ", dateEntry='" + dateEntry + '\'' +
                ", userCreation='" + userCreation + '\'' +
                ", ipCreation='" + ipCreation + '\'' +
                ", idPerson='" + idPerson + '\'' +
                '}';
    }
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (idClient == null) {
            if (other.idClient != null)
               return false;
        } else if (!idClient.equals(other.idClient))
            return false;
        return true;
    }
    
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Client client = (Client) o;
//        return idClient.equals(client.idClient) && typeClient.equals(client.typeClient) 
//        		&& dateEntry.equals(client.dateEntry) && userCreation.equals(client.userCreation) 
//        		&& ipCreation.equals(client.ipCreation) && idPerson.equals(client.idPerson);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(idClient, typeClient, dateEntry, userCreation, ipCreation, idPerson);
//    }    
      
}
