package com.lifetree.service;

import java.util.List;
import java.util.Map;

import com.lifetree.entity.TravelPlan;

public interface ITravelPlanMngtService {

		public String registerTravelPlan(TravelPlan tp);
		public Map<Integer,String> getTravelPlanCategories();
		public List<TravelPlan> showAllTravelPlans();
		public TravelPlan showTravelPlanById(Integer planId);
		public String updateTravelPlan(TravelPlan plan);
		public String deleteTravelPlan(Integer planId);
		public String changeTravelPlanStatus(Integer planId,String status);
}
