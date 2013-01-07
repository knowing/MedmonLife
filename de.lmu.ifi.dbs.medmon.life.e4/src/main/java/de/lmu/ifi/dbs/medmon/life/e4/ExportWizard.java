package de.lmu.ifi.dbs.medmon.life.e4;

import javax.inject.Inject;
import org.eclipse.jface.wizard.Wizard;

public class ExportWizard extends Wizard {
	
	//@Inject Filteroptions filteroptions;

	public ExportWizard() {
		setWindowTitle("Datenexport");
	}

	@Override
	public void addPages() {
		//addPage(filteroptions);
		addPage(new Filteroptions());
		addPage(new Exportoptions());
		addPage(new FoundIDs());
		addPage(new ExportFinished());
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
