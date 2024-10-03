package org.zerock.myapp.entity;

import java.io.Serial;
import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.zerock.myapp.listener.CommonEntityLifecyleListener;

import lombok.Data;



@Data

@EntityListeners(CommonEntityLifecyleListener.class)

@Entity(name = "Locker1")
@Table(name = "locker1")
public class Locker1 implements Serializable {	// Target, One(1)
	@Serial private static final long serialVersionUID = 1L;

	// 1. Set PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "locker_id")
	private Long id;				// PK
	
	
	// 2. 일반속성들
	@Basic(optional = false)		// Not Null Constraint
	private String name;
	
	
	// ==========================================
	// OneToOne (1:1), Uni-directional, Main(FK) 
	// ==========================================
	
	
	
   
} // end class
