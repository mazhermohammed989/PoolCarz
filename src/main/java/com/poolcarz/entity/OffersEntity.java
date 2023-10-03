package com.poolcarz.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
@Entity(name="offers")
public class OffersEntity {

	@Id
	@SequenceGenerator(name = "offerIdGenerator",allocationSize = 1)
	@GeneratedValue(generator = "offerIdGenerator")
	private Integer id;
	private String name;
	private String car;
	private Integer seatsLeft;
	private String pickup;
	private String destination;
}
