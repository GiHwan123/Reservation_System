package model.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	private long reservationNumber;
	
	@Column(name="res_date")
	private String resDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="customer_number")
	private	Customer customer;
	
	public Reservation(long reservation_number,String res_date) {
		this.reservationNumber=reservation_number;
		this.resDate=res_date;
	}
	@Override
	public String toString() {
		return "Reservation [reservationNumber=" + reservationNumber + ", res_date=" + resDate + ", customer=" + customer.getCustomerNumber()
				+ "]";
	}
	
	
}
