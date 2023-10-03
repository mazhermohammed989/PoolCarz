package com.poolcarz.dto;

import com.poolcarz.entity.RidesEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class RidesDTO {

	private Integer rideId;
	private String riderName;
	private String rideeName;
	private String pickup;
	private String destination;
	private String status;
}
