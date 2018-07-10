package com.audit.poc.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "AUDIT_LOG")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Audit {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long seqId;

	@NotNull
	@Column(name = "REQ_ID")
	private String reqId;

	@NotNull
	@Column(name = "ORIGIN_ID")
	private String originId;

	@NotNull
	@Column(name = "SOME_ID")
	private String someId;
	
	@NotNull
	@Column(name = "REQUEST_TYPE")
	private String requestType;
	
	@NotNull
	@Column(name = "TRANSACTION_DATE")
	private Date transactionDate;
	
	@NotNull
	@Column(name = "REQUEST_CODE")
	private String requestCode;
	
	@NotNull
	@Column(name = "FROM_FIRST_NAME")
	private String fromFirstName;
	
	@NotNull
	@Column(name = "FROM_LAST_NAME")
	private String fromLastName;
	
	@NotNull
	@Column(name = "FROM_AC_NUM")
	private String fromAcnum;
	
	@NotNull
	@Column(name = "FROM_BRANCH")
	private String fromBranch;
	
	@NotNull
	@Column(name = "FROM_TYPE")
	private String fromType;
	
	@NotNull
	@Column(name = "TO_FIRST_NAME")
	private String toFirstName;
	
	@NotNull
	@Column(name = "TO_LAST_NAME")
	private String toLastName;
	
	@NotNull
	@Column(name = "TO_AC_NUM")
	private String toAcnum;
	
	@NotNull
	@Column(name = "TO_BRANCH")
	private String toBranch;
	
	@NotNull
	@Column(name = "TO_TYPE")
	private String toType;
	
	@NotNull
	@Column(name = "AMOUNT")
	private BigDecimal amount;
	
}
