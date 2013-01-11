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
public class FoundIDs extends WizardPage {

	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public FoundIDs() {
		super("wizardPage");
		setTitle("zutreffende IDs");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite containerFoundIDs = new Composite(parent, SWT.NULL);

		setControl(containerFoundIDs);
		containerFoundIDs.setLayout(new GridLayout(1, false));
		
		Label lblIDs = new Label(containerFoundIDs, SWT.NONE);
		lblIDs.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblIDs.setText("ID 1\r\nID 2\r\nID 3\r\n...");
	}
}
