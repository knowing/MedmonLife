package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Link;

@Creatable
public class SelectDeletion extends WizardPage {

	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public SelectDeletion() {
		super("wizardPage");
		setTitle("L\u00F6schauswahl");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite compositeSelectDeletion = new Composite(parent, SWT.NULL);

		setControl(compositeSelectDeletion);
		compositeSelectDeletion.setLayout(new GridLayout(1, false));
		
		Link linkPatient = new Link(compositeSelectDeletion, SWT.NONE);
		linkPatient.setText("<a>Patient l\u00F6schen</a>");
		
		Link linkData = new Link(compositeSelectDeletion, SWT.NONE);
		linkData.setText("<a>Patient l\u00F6schen</a>");
	}

}
