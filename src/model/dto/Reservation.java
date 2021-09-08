package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@SequenceGenerator(name="res_seq", sequenceName="res_seq_id", initialValue=1, allocationSize=1)
public class Reservation {
	@Id
	@Column(name="reservation_number")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="res_seq")
	private Long reservationNumber;
	
	@Column(name="date")
	private String date;
	
	@ManyToOne
	@JoinColumn(name="customer_id")
	private	Customer customer;

	@Override
	public String toString() {
		return "Reservation [reservationNumber=" + reservationNumber + ", date=" + date + ", customer=" + customer.getCustomerNumber()
				+ "]";
	}
	
	
}
