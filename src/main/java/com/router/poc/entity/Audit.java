package com.router.poc.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="AUDIT_LOG")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Audit {
	
	@Id
	@Column(name="SEQ_ID")
	@GeneratedValue(generator="SEQ_AUDIT_LOG", strategy= GenerationType.SEQUENCE)
	@SequenceGenerator(name="SEQ_AUDIT_LOG", sequenceName="audit_log_seq")
	private Long seqId;
	
	@NotNull
	@Column(name="REQ_ID")
	private String reqId;
	
	

}
