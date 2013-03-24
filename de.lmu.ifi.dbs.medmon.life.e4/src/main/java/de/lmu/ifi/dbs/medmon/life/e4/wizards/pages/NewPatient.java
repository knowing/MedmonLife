package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.gemini.ext.di.GeminiPersistenceContext;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

import de.lmu.ifi.dbs.medmon.database.entity.Patient;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

@Creatable
public class NewPatient extends WizardPage {
	
	private Text txtFirstname;
	private Text txtLastname;
	private DateTime dateTimeBirthdate;
	private Button btnMale;
	private Button btnFemale;
	private Text textComment;
	
	private boolean flipToNextPage = false;
	private boolean add = true;

	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	@GeminiPersistenceContext(unitName = "medmon")
	EntityManager em;
	
	@Inject
	public NewPatient() {
		super("wizardPage");
		setTitle("Neuen Patient anlegen");
		setPageComplete(false);
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite compositeNewPatient = new Composite(parent, SWT.NULL);

		setControl(compositeNewPatient);
		compositeNewPatient.setLayout(new GridLayout(1, false));
		
		Composite compositeName = new Composite(compositeNewPatient, SWT.NONE);
		compositeName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeName.setLayout(new GridLayout(1, true));
		
		Label lblFirstname = new Label(compositeName, SWT.NONE);
		lblFirstname.setText("Vorname");
		
		txtFirstname = new Text(compositeName, SWT.BORDER);
		GridData gd_txtFirstname = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtFirstname.widthHint = 289;
		txtFirstname.setLayoutData(gd_txtFirstname);
		
		Label lblLastname = new Label(compositeName, SWT.NONE);
		lblLastname.setText("Nachname");
		
		txtLastname = new Text(compositeName, SWT.BORDER);
		GridData gd_txtLastname = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_txtLastname.widthHint = 289;
		txtLastname.setLayoutData(gd_txtLastname);
		
		Composite compositeBirthdate = new Composite(compositeNewPatient, SWT.NONE);
		compositeBirthdate.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		compositeBirthdate.setLayout(new GridLayout(1, false));
		
		Label lblBirthdate = new Label(compositeBirthdate, SWT.NONE);
		lblBirthdate.setText("Geburtsdatum");
		
		dateTimeBirthdate = new DateTime(compositeBirthdate, SWT.BORDER);
		
		Composite compositeGender = new Composite(compositeNewPatient, SWT.NONE);
		compositeGender.setLayout(new GridLayout(2, false));
		
		Label lblGender = new Label(compositeGender, SWT.NONE);
		lblGender.setText("Geschlecht");
		new Label(compositeGender, SWT.NONE);
		
		btnMale = new Button(compositeGender, SWT.RADIO);
		btnMale.setText("m\u00E4nnlich");
		
		btnFemale = new Button(compositeGender, SWT.RADIO);
		btnFemale.setText("weiblich");
		
		Composite compositeComment = new Composite(compositeNewPatient, SWT.NONE);
		compositeComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeComment.setLayout(new GridLayout(1, false));
		
		Label lblComment = new Label(compositeComment, SWT.NONE);
		lblComment.setText("Kommentar");
		
		textComment = new Text(compositeComment, SWT.BORDER);
		GridData gd_textComment = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_textComment.heightHint = 100;
		gd_textComment.widthHint = 400;
		textComment.setLayoutData(gd_textComment);
		
		Button btnAddPatient = new Button(compositeNewPatient, SWT.NONE);
		btnAddPatient.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		btnAddPatient.setEnabled(add);
		btnAddPatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				addPatient();
				setPageComplete(true);
				getContainer().showPage(getNextPage());
			}
		});
		btnAddPatient.setText("Patient hinzuf\u00FCgen");
	}
	
	public void addPatient(){
		
		em.getTransaction().begin();
		Patient patient = new Patient();
		
		patient.setFirstname(txtFirstname.getText());
		patient.setLastname(txtLastname.getText());
		if(btnMale.getSelection()){
			patient.setGender(Patient.MALE);
		}else if(btnFemale.getSelection()){
			patient.setGender(Patient.FEMALE);
		}
		patient.setComment(textComment.getText());
		
		em.persist(patient);
		em.getTransaction().commit();
		
	}
	
	@Override
	public boolean canFlipToNextPage() {
		return flipToNextPage;
	}
}
