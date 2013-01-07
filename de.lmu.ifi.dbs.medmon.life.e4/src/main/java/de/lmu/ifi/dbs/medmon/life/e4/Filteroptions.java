package de.lmu.ifi.dbs.medmon.life.e4;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
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

	/**
	 * Create the wizard.
	 */
	@Inject
	public Filteroptions() {
		super("wizardPage");
		setTitle("Datenexport");
		setDescription("Filteroptionen");
	}

	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite compositeFilteroptionen = new Composite(parent, SWT.NULL);

		setControl(compositeFilteroptionen);
		compositeFilteroptionen.setLayout(new GridLayout(1, false));

		Composite compositePatient = new Composite(compositeFilteroptionen, SWT.NONE);
		compositePatient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositePatient.setLayout(new GridLayout(1, false));

		Label lblPatient = new Label(compositePatient, SWT.NONE);
		lblPatient.setText("Patient");

		inputPatient = new Text(compositePatient, SWT.BORDER);
		inputPatient.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Composite compositeAlter = new Composite(compositeFilteroptionen, SWT.NONE);
		compositeAlter.setLayout(new GridLayout(3, false));

		Label lblAlter = new Label(compositeAlter, SWT.NONE);
		lblAlter.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblAlter.setText("Alter");

		Combo comboAlterVon = new Combo(compositeAlter, SWT.NONE);

		Label lblBis = new Label(compositeAlter, SWT.NONE);
		lblBis.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblBis.setText("bis");

		Combo comboAlterBis = new Combo(compositeAlter, SWT.NONE);

		Composite compositeGeschlecht = new Composite(compositeFilteroptionen, SWT.NONE);
		compositeGeschlecht.setLayout(new GridLayout(3, false));

		Label lblGeschlecht = new Label(compositeGeschlecht, SWT.NONE);
		lblGeschlecht.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblGeschlecht.setText("Geschlecht");

		Button btnMnnlich = new Button(compositeGeschlecht, SWT.RADIO);
		btnMnnlich.setText("m\u00E4nnlich");

		Button btnWeiblich = new Button(compositeGeschlecht, SWT.RADIO);
		btnWeiblich.setText("weiblich");

		Button btnBeides = new Button(compositeGeschlecht, SWT.RADIO);
		btnBeides.setText("beides");

		Composite compositeZeitraum = new Composite(compositeFilteroptionen, SWT.NONE);
		compositeZeitraum.setLayout(new GridLayout(3, false));

		Label lblZeitraum = new Label(compositeZeitraum, SWT.NONE);
		lblZeitraum.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblZeitraum.setText("Zeitraum");

		DateTime dateTimeVon = new DateTime(compositeZeitraum, SWT.BORDER);

		Label lblBis_1 = new Label(compositeZeitraum, SWT.NONE);
		lblBis_1.setText("bis");

		DateTime dateTimeBis = new DateTime(compositeZeitraum, SWT.BORDER);

		Composite compositeDatenart = new Composite(compositeFilteroptionen, SWT.NONE);
		compositeDatenart.setLayout(new GridLayout(2, false));

		Button btnRohdaten = new Button(compositeDatenart, SWT.RADIO);
		btnRohdaten.setText("Rohdaten");

		Button btnAnalysedaten = new Button(compositeDatenart, SWT.RADIO);
		btnAnalysedaten.setText("Analysedaten");
	}
}
