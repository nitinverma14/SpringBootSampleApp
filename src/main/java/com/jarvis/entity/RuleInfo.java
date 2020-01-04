package com.jarvis.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RuleInfo")
public class RuleInfo extends BaseEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6882752121194539517L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 	@Column(name = "ID")
    private Long id;
	
	@Column(name = "RULE_NAME")
	private String ruleName;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "RULE_CONDITION")
	private String ruleCondition;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRuleName() {
		return ruleName;
	}
	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRuleCondition() {
		return ruleCondition;
	}
	public void setRuleCondition(String ruleCondition) {
		this.ruleCondition = ruleCondition;
	}
	
}
