package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

@Creatable
public class DeletionFinished extends WizardPage {

	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public DeletionFinished() {
		super("wizardPage");
		setTitle("L\u00F6schvorgang abgeschlossen");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite compositeDeletionFinished = new Composite(parent, SWT.NULL);

		setControl(compositeDeletionFinished);
		compositeDeletionFinished.setLayout(new GridLayout(1, false));
		
		Label lblDeletionFinished = new Label(compositeDeletionFinished, SWT.NONE);
		lblDeletionFinished.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblDeletionFinished.setText("L\u00F6schvorgang erfolgreich abgeschlossen");
	}

}
