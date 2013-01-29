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
		URL url = FileLocator.find(FrameworkUtil.getBundle(this.getClass()), new Path("src/main/resources/icons/life_icon_64.png"), null);
		setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(url));
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
		return true;
	}
	
	@Override
	public IWizardPage getNextPage(IWizardPage page) {
	    if (page == selectDeletion ) {
	    	if (selectDeletion.patientDeletion) {
	    		return patientSelection;
	    	} else {
	    		return filteroptions;
	    	}
	    }
	    if (page == patientSelection){
	    	return deletionFinished;
	    }
	    return super.getNextPage(page);
	}

	@Override
	public IWizardPage getPreviousPage(IWizardPage page) {
	    if (page == filteroptions) {
	        return selectDeletion;
	    }
	    return super.getPreviousPage(page);
	}

}
