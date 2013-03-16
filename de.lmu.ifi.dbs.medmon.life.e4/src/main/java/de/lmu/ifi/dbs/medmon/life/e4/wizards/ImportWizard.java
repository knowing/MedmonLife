package de.lmu.ifi.dbs.medmon.life.e4.wizards;

import java.net.URL;

import javax.inject.Inject;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.jface.wizard.Wizard;
import org.osgi.framework.FrameworkUtil;

import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.ImportFinished;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.LimitTimeperiod;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.NewPatient;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.PatientSelection;

@Creatable
public class ImportWizard extends Wizard {
	
	public int i = 1;

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
		URL url = FileLocator.find(FrameworkUtil.getBundle(this.getClass()), new Path("src/main/resources/icons/life_icon_64.png"), null);
		setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(url));
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
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
	    if (page == patientSelection ) {
	    	if (patientSelection.newPatient) {
	    		return newPatient;
	    	} else {
	    		limitTimeperiod.updateWidget(patientSelection.getSelection());
	    		return limitTimeperiod;
	    	}
	    }
	    if (page == newPatient){
	    	limitTimeperiod.updateWidget(newPatient.getSelection());
	    }
	    return super.getNextPage(page);
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
	    if (page == limitTimeperiod) {
	        return patientSelection;
	    }
	    return super.getPreviousPage(page);
	}

}
