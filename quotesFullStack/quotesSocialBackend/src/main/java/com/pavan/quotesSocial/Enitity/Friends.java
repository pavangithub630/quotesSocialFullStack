package com.pavan.quotesSocial.Enitity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Friends {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long friendsId;
	
	private Long userId;

}
