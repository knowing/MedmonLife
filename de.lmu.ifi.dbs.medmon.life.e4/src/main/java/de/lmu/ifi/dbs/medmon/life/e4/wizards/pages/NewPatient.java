package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

@Creatable
public class NewPatient extends WizardPage {

	/**
	 * Create the wizard.
	 */
	@Inject
	public NewPatient() {
		super("wizardPage");
		setTitle("Neuen Patient anlegen");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite compositeNewPatient = new Composite(parent, SWT.NULL);

		setControl(compositeNewPatient);
		compositeNewPatient.setLayout(new GridLayout(1, false));
		
		Composite compositeName = new Composite(compositeNewPatient, SWT.NONE);
		compositeName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeName.setLayout(new GridLayout(1, false));
		
		Label lblName = new Label(compositeName, SWT.NONE);
		lblName.setText("Name");
		
		Text txtName = new Text(compositeName, SWT.BORDER);
		GridData gd_txtName = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtName.widthHint = 289;
		txtName.setLayoutData(gd_txtName);
		
		Composite compositeBirthdate = new Composite(compositeNewPatient, SWT.NONE);
		compositeBirthdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeBirthdate.setLayout(new GridLayout(1, false));
		
		Label lblBirthdate = new Label(compositeBirthdate, SWT.NONE);
		lblBirthdate.setText("Geburtsdatum");
		
		DateTime dateTimeBirthdate = new DateTime(compositeBirthdate, SWT.BORDER);
		
		Composite compositeGender = new Composite(compositeNewPatient, SWT.NONE);
		compositeGender.setLayout(new GridLayout(2, false));
		
		Label lblGender = new Label(compositeGender, SWT.NONE);
		lblGender.setText("Geschlecht");
		new Label(compositeGender, SWT.NONE);
		
		Button btnMale = new Button(compositeGender, SWT.RADIO);
		btnMale.setText("m\u00E4nnlich");
		
		Button btnFemale = new Button(compositeGender, SWT.RADIO);
		btnFemale.setText("weiblich");
		
		Composite compositeComment = new Composite(compositeNewPatient, SWT.NONE);
		compositeComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeComment.setLayout(new GridLayout(1, false));
		
		Label lblComment = new Label(compositeComment, SWT.NONE);
		lblComment.setText("Kommentar");
		
		Text textComment = new Text(compositeComment, SWT.BORDER);
		textComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
	}
}
