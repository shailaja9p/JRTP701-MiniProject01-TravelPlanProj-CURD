package com.lifetree.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="JRTP701_TRAVEL_PLAN")
public class TravelPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO )
	@Column(name="PLAN_ID")
	private Integer planId;
	
	@Column(name="PLAN_NAME",length = 30)
	private String planName;
	
	@Column(name="PLAN_MIN-BUDGET")
	private Double planMinBudget;
	
	@Column(name="PLAN_DESCRIPTION",length = 50)
	private String planDescription;
	
	@Column(name="PLAN_CATEGORY_ID")
	private Integer planCategoryId;
	
	@Column(name="CREATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@Column(name="UPDATED_DATE",updatable = true,insertable = false)
	@UpdateTimestamp
	private LocalDateTime updatedDate;	
	
	@Column(name="CREATED_BY",length = 20)
	private String createdBy;
	
	@Column(name="UPDATED_BY",length = 20)
	private String updatedBy;

	@Column(name="ACTIVE_SW",length = 15)
	private String activeSW="active";
}
