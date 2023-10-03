package com.poolcarz.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class OffersDTO {

	private Integer id;
	private String name;
	private String car;
	private Integer seatsLeft;
	private String pickup;
	private String destination;
}
