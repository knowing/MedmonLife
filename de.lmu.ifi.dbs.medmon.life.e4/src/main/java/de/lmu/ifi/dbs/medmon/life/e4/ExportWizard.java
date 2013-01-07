package de.lmu.ifi.dbs.medmon.life.e4;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.Wizard;

@Creatable
public class ExportWizard extends Wizard {

	@Inject
	Filteroptions filteroptions;

	@Inject
	public ExportWizard() {
		setWindowTitle("Datenexport");
	}

	@Override
	public void addPages() {
		addPage(filteroptions);
		addPage(new Exportoptions());
		addPage(new FoundIDs());
		addPage(new ExportFinished());
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
