package de.lmu.ifi.dbs.medmon.life.core.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import de.lmu.ifi.dbs.medmon.database.entity.Patient;

/**
 * Usage:
 * 
 * <pre>
 * {@code
 * ISearchService searchService = ...
 * Search search = searchService.getSearch(); // Search Session
 * CriteriaBuilder cb = search.getCriteriaBuilder();
 * 
 * // Build predicates
 * Predicate p1 = cb.equal(patient.get(Patient_.firstname), "Max");
 * Predicate p2 = cb.equal(patient.get(Patient_.lastname), "Mustermann");
 * Predicate p1Andp2 = cb.equal(p1, p2)
 * 
 * List<Patient> patients = search.getPatients(); // Load patients from db
 * }
 * </pre>
 * 
 * @author Nepomuk Seiler
 * 
 */
public class Search {

	private final EntityManager em;
	private final CriteriaBuilder criteraBuilder;
	private final CriteriaQuery<Patient> query;
	private final Root<Patient> patient;

	public Search(EntityManager em) {
		this.em = em;
		this.criteraBuilder = em.getCriteriaBuilder();
		this.query = criteraBuilder.createQuery(Patient.class);
		this.patient = query.from(Patient.class);
	}

	public List<Patient> getPatients(Predicate... predicates) {
		List<Patient> resultList = em.createQuery(query.select(patient).where(predicates)).getResultList();
		em.close();
		return resultList;
	}

	public CriteriaBuilder getCriteraBuilder() {
		return criteraBuilder;
	}

	public Root<Patient> getPatient() {
		return patient;
	}

}
