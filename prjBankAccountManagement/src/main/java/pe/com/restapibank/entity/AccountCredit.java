package pe.com.restapibank.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Document(collection = "account_credit")
public class AccountCredit {

	@Id
	private Integer idCredit;
	private String typeCurrency;
	private String accountNumber;
	private LocalDateTime depositDate;
	private LocalDateTime datePay;
	private Double balance;
	private Double totalConsumed;
	private String countMonth;
	private Double interestPay;
	private Integer idClient;
	private Integer idBank;
	private Integer numberMovMax;
	
    @Override
    public String toString() {
        return "Afiliado{" +
                "idCredit=" + idCredit +
                ", typeCurrency='" + typeCurrency + '\'' +
                ", accountNumber='" + accountNumber + '\'' +
                ", depositDate='" + depositDate + '\'' +
                ", datePay='" + datePay + '\'' +
                ", balance='" + balance + '\'' +
                ", totalConsumed='" + totalConsumed + '\'' +
                ", countMonth='" + countMonth + '\'' +
                ", interestPay='" + interestPay + '\'' +
                ", idClient='" + idClient + '\'' +
                ", idBank='" + idBank + '\'' +
                ", numberMovMax='" + numberMovMax + '\'' +
                '}';
    }	
	
	@Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idCredit == null) ? 0 : idCredit.hashCode());
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
        AccountCredit other = (AccountCredit) obj;
        if (idCredit == null) {
            if (other.idCredit != null)
                return false;
        } else if (!idCredit.equals(other.idCredit))
            return false;
        return true;
    }

	public AccountCredit(int idCredit2, String typeCurrency2, String accountNumber2, String string, String string2,
			int i, int j, int k, int l, int idClient2, int idBank2, int numberMovMax2) {
		// TODO Auto-generated constructor stub
	}
}
