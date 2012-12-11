package de.lmu.ifi.dbs.medmon.life.core.services.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lmu.ifi.dbs.medmon.database.entity.Patient;
import de.lmu.ifi.dbs.medmon.database.entity.Patient_;
import de.lmu.ifi.dbs.medmon.life.core.services.ISearchService;
import de.lmu.ifi.dbs.medmon.services.IEntityManagerService;

public class SearchService implements ISearchService {

	private static final Logger log = LoggerFactory.getLogger(ISearchService.class);

	private IEntityManagerService emService;

	public List<Patient> findPatient(String firstName, String lastName) {
		EntityManager em = emService.createEntityManager();
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Patient> query = cb.createQuery(Patient.class);
		Root<Patient> patient = query.from(Patient.class);

		query.select(patient).where(cb.and( //
				cb.equal(patient.get(Patient_.firstname), firstName), //
				cb.equal(patient.get(Patient_.lastname), lastName)));

		return em.createQuery(query).getResultList();
	}

	protected void bindEntityManagerService(IEntityManagerService emService) {
		this.emService = emService;
	}

	protected void unbindEntityManagerService(IEntityManagerService emService) {
		this.emService = null;
	}

	protected void activate() {
		log.info("SearchService activated");
	}
}
