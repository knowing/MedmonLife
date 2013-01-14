package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.lmu.ifi.dbs.medmon.database.entity.Patient;

@Creatable
public class PatientSelection extends WizardPage {

	private static final Logger log = LoggerFactory.getLogger(PatientSelection.class);

	private Text txtPatientInput;

	@Inject
	IStylingEngine styleEngine;

	@Inject
	@GeminiPersistenceContext(unitName = "medmon")
	EntityManager em;

	/**
	 * Create the wizard.
	 */
	@Inject
	public PatientSelection() {
		super("wizardPage");
		setTitle("Patientenauswahl");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite compositePatientSelection = new Composite(parent, SWT.NULL);

		setControl(compositePatientSelection);
		GridLayout gl_compositePatientSelection = new GridLayout(2, true);
		compositePatientSelection.setLayout(gl_compositePatientSelection);

		Label lblSelectPatient = new Label(compositePatientSelection, SWT.NONE);
		lblSelectPatient.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblSelectPatient.setText("Bitte Patient ausw\u00E4hlen");

		txtPatientInput = new Text(compositePatientSelection, SWT.BORDER);
		GridData gd_txtPatientInput = new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1);
		gd_txtPatientInput.widthHint = 400;
		txtPatientInput.setLayoutData(gd_txtPatientInput);

		ListViewer patientList = new ListViewer(compositePatientSelection, SWT.BORDER);
		patientList.getList().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		patientList.setContentProvider(new ArrayContentProvider());

		Button btnDeletePatient = new Button(compositePatientSelection, SWT.NONE);
		btnDeletePatient.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnDeletePatient.setText("Patient l\u00F6schen");

		Button btnAddPatient = new Button(compositePatientSelection, SWT.NONE);
		btnAddPatient.setText("Patient hinzuf\u00FCgen");

		selectAllPatients();
	}

	private List<Patient> selectAllPatients() {
		// FIXME this code should be inside the ContentProvider. Make the
		// ContentProvider @Creatable and inject it here

		// This logic comes into the ContentProvider#getElements method
		List<Patient> patients = em.createNamedQuery("Patient.findAll", Patient.class).getResultList();
		log.debug("Found patients " + patients);

		return patients;
	}

}
