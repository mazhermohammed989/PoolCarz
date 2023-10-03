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
@Entity(name="rides")
public class RidesEntity {

	@Id
	@SequenceGenerator(name = "rideIdGenerator",allocationSize = 1)
	@GeneratedValue(generator = "rideIdGenerator")
	private Integer rideId;
	private String riderName;
	private String rideeName;
	private String pickup;
	private String destination;
	private String status;
}
