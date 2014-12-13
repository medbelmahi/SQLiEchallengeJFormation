/**
 * 
 */
package com.sqli.echallenge.jformation.bean;

/**
 * @author Mouad
 *
 */
public class AbsenceSessionBean {
	private Long idSeance;
	private Double absenceCount;
	
	public AbsenceSessionBean() {
	}

	public Long getIdSeance() {
		return idSeance;
	}

	public void setIdSeance(Long idSeance) {
		this.idSeance = idSeance;
	}

	public Double getAbsenceCount() {
		return absenceCount;
	}

	public void setAbsenceCount(Double absenceCount) {
		this.absenceCount = absenceCount;
	}
}
