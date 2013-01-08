package de.lmu.ifi.dbs.medmon.life.e4.wizards;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.Wizard;

import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.ImportFinished;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.LimitTimeperiod;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.NewPatient;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.PatientSelection;

@Creatable
public class ImportWizard extends Wizard {

	@Inject
	PatientSelection patientSelection;
	@Inject
	NewPatient newPatient;
	@Inject
	LimitTimeperiod limitTimeperiod;
	@Inject
	ImportFinished importFinished;
	
	@Inject
	public ImportWizard() {
		setWindowTitle("Datenimport");
	}

	@Override
	public void addPages() {
		addPage(patientSelection);
		addPage(newPatient);
		addPage(limitTimeperiod);
		addPage(importFinished);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
