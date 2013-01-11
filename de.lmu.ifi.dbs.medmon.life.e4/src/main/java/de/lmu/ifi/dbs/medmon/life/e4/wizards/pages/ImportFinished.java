package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;

@Creatable
public class ImportFinished extends WizardPage {

	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public ImportFinished() {
		super("wizardPage");
		setTitle("Import abgeschlossen");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite compositeImportFinished = new Composite(parent, SWT.NULL);

		setControl(compositeImportFinished);
		compositeImportFinished.setLayout(new GridLayout(1, false));
		
		Label lblImportFinished = new Label(compositeImportFinished, SWT.NONE);
		lblImportFinished.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblImportFinished.setText("Daten erfolgreich importiert");
	}

}
