package com.poolcarz.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poolcarz.entity.OffersEntity;

public interface OfferRepository extends JpaRepository<OffersEntity, Integer>{

}
