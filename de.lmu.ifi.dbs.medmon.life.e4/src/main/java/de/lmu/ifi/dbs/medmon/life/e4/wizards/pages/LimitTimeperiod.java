package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

@Creatable
public class LimitTimeperiod extends WizardPage {

	/**
	 * Create the wizard.
	 */
	@Inject
	public LimitTimeperiod() {
		super("wizardPage");
		setTitle("Zeitraum einschr\u00E4nken");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite compositeTimeperiod = new Composite(parent, SWT.NULL);

		setControl(compositeTimeperiod);
		compositeTimeperiod.setLayout(new GridLayout(2, false));
		
		Label lblSelectedPatient = new Label(compositeTimeperiod, SWT.NONE);
		lblSelectedPatient.setText("<Patientenname> ausgew\u00E4hlt");
		
		Button btnChangeSelection = new Button(compositeTimeperiod, SWT.NONE);
		btnChangeSelection.setText("\u00E4ndern");
		
		Composite compositePeriod = new Composite(compositeTimeperiod, SWT.NONE);
		compositePeriod.setLayout(new GridLayout(2, false));
		
		Label lblPeriod = new Label(compositePeriod, SWT.NONE);
		lblPeriod.setText("Zeitraum");
		new Label(compositePeriod, SWT.NONE);
		
		Label lblFrom = new Label(compositePeriod, SWT.NONE);
		lblFrom.setText("von");
		
		DateTime dateTimeFrom = new DateTime(compositePeriod, SWT.BORDER);
		
		Label lblTo = new Label(compositePeriod, SWT.NONE);
		lblTo.setText("bis");
		
		DateTime dateTimeTo = new DateTime(compositePeriod, SWT.BORDER);
		new Label(compositeTimeperiod, SWT.NONE);
	}

}
