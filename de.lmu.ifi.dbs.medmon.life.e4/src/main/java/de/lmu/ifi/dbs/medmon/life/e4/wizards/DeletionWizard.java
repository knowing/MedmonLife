package de.lmu.ifi.dbs.medmon.life.e4.wizards;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.Wizard;

import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.DeletionFinished;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.Filteroptions;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.FoundIDs;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.PatientSelection;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.SelectDeletion;

@Creatable
public class DeletionWizard extends Wizard {

	@Inject
	SelectDeletion selectDeletion;
	@Inject
	PatientSelection patientSelection;
	@Inject
	Filteroptions filteroptions;
	@Inject
	FoundIDs foundIDs;
	@Inject
	DeletionFinished deletionFinished;
	
	@Inject
	public DeletionWizard() {
		setWindowTitle("Daten/Patienten l\u00F6schen");
	}

	@Override
	public void addPages() {
		addPage(selectDeletion);
		addPage(patientSelection);
		addPage(filteroptions);
		addPage(foundIDs);
		addPage(deletionFinished);
	}

	@Override
	public boolean performFinish() {
		return false;
	}

}
