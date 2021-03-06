package model.dto;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@SequenceGenerator(name="cus_seq", sequenceName="cus_seq_id", initialValue=1, allocationSize=1)
public class Customer{
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cus_seq")
	@Column(name="customer_number")
	private Long customerNumber;
	
	@Column(name="customer_id")
	private String Id;
	
	@Column(name="customer_password")
	private String password;
	
	@OneToMany(mappedBy="customer")//, fetch = FetchType.EAGER)
	List<Reservation> reservations = new ArrayList<>();
	
	public Customer(String Id,String password) {
		this.Id=Id;
		this.password=password;
	}
	
	@Override
	public String toString() {
		return "Customer [customerNumber=" + customerNumber + ", Id=" + Id + ", password=" + password
				+ ", reservations=" + reservations + "]";
	}
	
	
}
