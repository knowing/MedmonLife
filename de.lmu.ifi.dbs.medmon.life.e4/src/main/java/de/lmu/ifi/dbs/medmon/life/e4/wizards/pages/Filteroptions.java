package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

@Creatable
public class Filteroptions extends WizardPage {
	private Text inputPatient;

	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public Filteroptions() {
		super("wizardPage");
		setTitle("Filteroptionen");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite compositeFilteroptions = new Composite(parent, SWT.NULL);
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);

		setControl(compositeFilteroptions);
		compositeFilteroptions.setLayout(new GridLayout(1, false));

		Composite compositePatient = new Composite(compositeFilteroptions, SWT.NONE);
		compositePatient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositePatient.setLayout(new GridLayout(1, false));

		Label lblPatient = new Label(compositePatient, SWT.NONE);
		lblPatient.setText("Patient");

		inputPatient = new Text(compositePatient, SWT.BORDER);
		inputPatient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite compositeAge = new Composite(compositeFilteroptions, SWT.NONE);
		compositeAge.setLayout(new GridLayout(3, false));

		Label lblAge = new Label(compositeAge, SWT.NONE);
		lblAge.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblAge.setText("Alter");

		Combo comboAgeFrom = new Combo(compositeAge, SWT.NONE);

		Label lblTo = new Label(compositeAge, SWT.NONE);
		lblTo.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblTo.setText("bis");

		Combo comboAgeTo = new Combo(compositeAge, SWT.NONE);

		Composite compositeGender = new Composite(compositeFilteroptions, SWT.NONE);
		compositeGender.setLayout(new GridLayout(3, false));

		Label lblGender = new Label(compositeGender, SWT.NONE);
		lblGender.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblGender.setText("Geschlecht");

		Button btnMale = new Button(compositeGender, SWT.RADIO);
		btnMale.setText("m\u00E4nnlich");

		Button btnFemale = new Button(compositeGender, SWT.RADIO);
		btnFemale.setText("weiblich");

		Button btnBoth = new Button(compositeGender, SWT.RADIO);
		btnBoth.setText("beides");

		Composite compositePeriod = new Composite(compositeFilteroptions, SWT.NONE);
		compositePeriod.setLayout(new GridLayout(3, false));

		Label lblPeriod = new Label(compositePeriod, SWT.NONE);
		lblPeriod.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblPeriod.setText("Zeitraum");

		DateTime dateTimeFrom = new DateTime(compositePeriod, SWT.BORDER);

		Label lblTimeTo = new Label(compositePeriod, SWT.NONE);
		lblTimeTo.setText("bis");

		DateTime dateTimeTo = new DateTime(compositePeriod, SWT.BORDER);

		Composite compositeDatatype = new Composite(compositeFilteroptions, SWT.NONE);
		compositeDatatype.setLayout(new GridLayout(2, false));

		Button btnRawdata = new Button(compositeDatatype, SWT.RADIO);
		btnRawdata.setText("Rohdaten");

		Button btnAnalysisdata = new Button(compositeDatatype, SWT.RADIO);
		btnAnalysisdata.setText("Analysedaten");
	}
}
