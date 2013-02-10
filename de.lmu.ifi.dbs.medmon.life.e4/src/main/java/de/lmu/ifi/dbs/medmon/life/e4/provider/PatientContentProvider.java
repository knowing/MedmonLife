package de.lmu.ifi.dbs.medmon.life.e4.provider;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.Viewer;

import de.lmu.ifi.dbs.medmon.database.entity.Patient;

@Creatable
public class PatientContentProvider implements IStructuredContentProvider {

	@Inject
	@GeminiPersistenceContext(unitName = "medmon")
	EntityManager em;

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Patient[])
			return (Patient[]) inputElement;
		return getPatients();
	}

	private Patient[] getPatients() {
		TypedQuery<Patient> allPatients = em.createNamedQuery("Patient.findAll", Patient.class);
		List<Patient> patients = allPatients.getResultList();
		if (patients.isEmpty())
			return new Patient[0];
		return patients.toArray(new Patient[patients.size()]);
	}

}
