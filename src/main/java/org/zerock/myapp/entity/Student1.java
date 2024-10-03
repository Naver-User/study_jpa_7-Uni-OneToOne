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
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.zerock.myapp.listener.CommonEntityLifecyleListener;

import lombok.Data;


@Data

@EntityListeners(CommonEntityLifecyleListener.class)

@Entity(name = "Student1")
@Table(name="student1")
public class Student1 implements Serializable {	// Main, One(1) with FK
	@Serial private static final long serialVersionUID = 1L;
   
	// 1. Set PK
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")	
	private Long id;				// PK
	
	
	// 2. 일반속성들
	@Basic(optional = false)		// Not Null Constraint
	private String name;
	
	
	
	// ==========================================
	// OneToOne (1:1), Uni-directional, Main(FK) 
	// ==========================================
	
	// Reference direction: Student -> Locker
	
//	@OneToOne									// 1, OK
	@OneToOne(targetEntity = Locker1.class)		// 2, OK
//	@OneToOne(cascade = CascadeType.ALL)		// 3, OK
	
//	@OneToOne(mappedBy)							// 4, XX
		
	/**
	 * -------------------------------
	 * @JoinColumn
	 * -------------------------------
	 * (1) Set the FK column name of Many (Child) table. (***)
	 * (2) If @JoinColumn annotation abbreviated,
	 * 	   The default FK column name = 
	 * 			The name of the entity + "_" + The name of the referenced primary key column.
	 * (3) @JoinColumn(table): The name of the table that contains the FK column.
	 * 	   If `table` propery *Not specified,
	 * 	   The FK column is assumed to be in the primary table of the applicable entity. 
	 * -------------------------------
	 */
	
//	@JoinColumn															// 0, XX
	@JoinColumn(name = "my_locker")										// 1, OK
//	@JoinColumn(name = "my_locker", referencedColumnName = "locker_id")	// 2, OK
//	@JoinColumn(name = "my_locker", referencedColumnName = "locker_id", table = "TEST")	// 3
	
	private Locker1 locker;						// FK, Target (1)
	
	
	
} // end class


