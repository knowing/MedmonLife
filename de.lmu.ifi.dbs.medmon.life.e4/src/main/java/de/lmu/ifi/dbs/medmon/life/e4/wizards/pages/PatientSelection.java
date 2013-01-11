package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.widgets.Button;

@Creatable
public class PatientSelection extends WizardPage {
	private Text txtPatientInput;

	@Inject IStylingEngine styleEngine;

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
		
		List patientList = new List(compositePatientSelection, SWT.BORDER);
		patientList.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 2, 1));
		patientList.setItems(new String[] {"Patient", "Patient", "Patient", "Patient", "Patient", "Patient"});
		
		Button btnDeletePatient = new Button(compositePatientSelection, SWT.NONE);
		btnDeletePatient.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnDeletePatient.setText("Patient l\u00F6schen");
		
		Button btnAddPatient = new Button(compositePatientSelection, SWT.NONE);
		btnAddPatient.setText("Patient hinzuf\u00FCgen");
	}

}