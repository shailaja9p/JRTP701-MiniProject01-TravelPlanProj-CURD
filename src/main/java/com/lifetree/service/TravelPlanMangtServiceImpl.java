package com.lifetree.service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lifetree.entity.PlanCategory;
import com.lifetree.entity.TravelPlan;
import com.lifetree.repository.IPlanCategoryRepository;
import com.lifetree.repository.ITravelPlanRepository;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class TravelPlanMangtServiceImpl implements ITravelPlanMngtService {

	@Autowired
	private ITravelPlanRepository travelPlanRepo;
	@Autowired
	private IPlanCategoryRepository planCategoryRepo;
	
	@Override
	public String registerTravelPlan(TravelPlan tp) {
		TravelPlan saved = travelPlanRepo.save(tp);
		return saved.getPlanId()!=null?"Travel plan is saved with id value::  "+saved.getPlanId(): "Problem in saving the Travel plan";
	}

	@Override
	public Map<Integer, String> getTravelPlanCategories() {
		List<PlanCategory> list = planCategoryRepo.findAll();
		
		  System.out.println(list);
		 
		Map<Integer,String> categoriesMap=planCategoryRepo.findAll().stream().collect(Collectors.toMap(PlanCategory::getCategoryId, PlanCategory::getCategoryName));
		return categoriesMap;
	}

	@Override
	public List<TravelPlan> showAllTravelPlans() {
		return travelPlanRepo.findAll();
	}

	/*
	 * @Override public TravelPlan showTravelPlanById(Integer planId) { return
	 * travelPlanRepo.findById(planId).orElseThrow(()->new
	 * IllegalArgumentException("Travel plan is not found")); }
	 */
	@Override
	public TravelPlan showTravelPlanById(Integer planId) throws IllegalArgumentException{
		return travelPlanRepo.findById(planId).get();
	}

	@Override
	public String updateTravelPlan(TravelPlan plan) {
		/*
		 * TravelPlan updated = travelPlanRepo.save(plan); return
		 * updated.getPlanId()+" Travel plan is updated";
		 */
		Optional<TravelPlan> opt=travelPlanRepo.findById(plan.getPlanId());
		if(opt.isPresent()) {
			travelPlanRepo.save(plan);
			return "Travel plan is updated "+plan.getPlanId();
		}else
			return "Travel plan is not found "+plan.getPlanId();
	}

	@Override
	public String deleteTravelPlan(Integer planId) {
		Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			travelPlanRepo.deleteById(planId);
			return " Travel plan is deleted "+planId;
		}else
		return "travel plan is not found"+planId;
	}

	@Override
	public String changeTravelPlanStatus(Integer planId, String status) {
		Optional<TravelPlan> opt=travelPlanRepo.findById(planId);
		if(opt.isPresent()) {
			TravelPlan plan=opt.get(); 
			plan.setActiveSW(status);
			travelPlanRepo.save(plan);
			return planId+ "Travel plan status is changed";
		}else
		return  planId+"Travel plan id is not found for updation";
	
	}
}
