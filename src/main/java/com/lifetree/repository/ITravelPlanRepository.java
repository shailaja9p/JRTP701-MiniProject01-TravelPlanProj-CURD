package com.lifetree.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lifetree.entity.TravelPlan;

public interface ITravelPlanRepository extends JpaRepository<TravelPlan, Integer> {

}
