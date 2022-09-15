package pe.com.restapibank.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "client")
public class ClientResilence {

	@Id
	private Integer idClient;
	private String typeClient;
	private String dateEntry;
	private String userCreation;
	private String ipCreation;
	private Person person;

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
        ClientResilence other = (ClientResilence) obj;
        if (idClient == null) {
            if (other.idClient != null)
                return false;
        } else if (!idClient.equals(other.idClient))
            return false;
        return true;
    }
}
