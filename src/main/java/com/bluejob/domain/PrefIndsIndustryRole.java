package com.bluejob.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "pref_inds_inds_role")
public class PrefIndsIndustryRole implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pref_inds_inds_role_id")
    private Long prefIndsIndustryRoleId;
	
    @ManyToOne
    @JoinColumn(name = "industry_id")
    private Industry industry;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name="candidate_pref_id")
	private CandidatePreference candidatePreference;
	
	
	@ManyToMany
	@JoinTable(
     name = "pref_ind_ind_role_inds_role",
     joinColumns = {@JoinColumn(name = "pref_inds_inds_role_id", referencedColumnName = "pref_inds_inds_role_id")},
     inverseJoinColumns = {@JoinColumn(name = "industry_role_id", referencedColumnName = "industry_role_id")})
	// @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
	@BatchSize(size = 20)
	private Set<IndustryRole> industryRoles;
	
	
}
