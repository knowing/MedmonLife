package de.lmu.ifi.dbs.medmon.life.e4.wizards;

import java.net.URL;

import javax.inject.Inject;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.wizard.Wizard;
import org.osgi.framework.FrameworkUtil;

import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.ExportFinished;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.Exportoptions;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.Filteroptions;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.pages.FoundIDs;

@Creatable
public class ExportWizard extends Wizard {

	@Inject
	Filteroptions filteroptions;
	@Inject
	Exportoptions exportoptions;
	@Inject
	FoundIDs foundIDs;
	@Inject
	ExportFinished exportFinished;

	@Inject
	public ExportWizard() {
		setWindowTitle("Datenexport");
		URL url = FileLocator.find(FrameworkUtil.getBundle(this.getClass()), new Path("src/main/resources/icons/life_icon_64.png"), null);
		setDefaultPageImageDescriptor(ImageDescriptor.createFromURL(url));
	}

	@Override
	public void addPages() {
		addPage(filteroptions);
		addPage(exportoptions);
		addPage(foundIDs);
		addPage(exportFinished);
	}

	@Override
	public boolean performFinish() {
		return true;
	}

}
