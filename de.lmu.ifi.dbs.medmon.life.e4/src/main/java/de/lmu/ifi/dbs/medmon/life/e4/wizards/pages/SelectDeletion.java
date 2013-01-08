package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;

@Creatable
public class SelectDeletion extends WizardPage {

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
		Composite compositeSelectDeletion = new Composite(parent, SWT.NULL);

		setControl(compositeSelectDeletion);
		compositeSelectDeletion.setLayout(new GridLayout(1, false));
		
		Button btnDeletePatient = new Button(compositeSelectDeletion, SWT.NONE);
		btnDeletePatient.setText("Patient l\u00F6schen");
		
		Button btnDeleteData = new Button(compositeSelectDeletion, SWT.NONE);
		btnDeleteData.setText("Daten l\u00F6schen");
	}

}
