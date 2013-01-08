package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

@Creatable
public class Exportoptions extends WizardPage {
	private Text textComment;

	/**
	 * Create the wizard.
	 */
	@Inject
	public Exportoptions() {
		super("wizardPage");
		setTitle("Exportoptionen");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite containerExportoptions = new Composite(parent, SWT.NULL);

		setControl(containerExportoptions);
		containerExportoptions.setLayout(new GridLayout(1, false));
		
		Composite compositeAnon = new Composite(containerExportoptions, SWT.NONE);
		compositeAnon.setLayout(new GridLayout(2, false));
		
		Label lblAnon = new Label(compositeAnon, SWT.NONE);
		lblAnon.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblAnon.setText("Sollen die Daten anonymisiert werden?");
		
		Button btnAnonYes = new Button(compositeAnon, SWT.RADIO);
		btnAnonYes.setText("ja");
		
		Button btnAnonNo = new Button(compositeAnon, SWT.RADIO);
		btnAnonNo.setText("nein");
		
		Composite compositeDatatype = new Composite(containerExportoptions, SWT.NONE);
		compositeDatatype.setLayout(new GridLayout(3, false));
		
		Label lblDatatype = new Label(compositeDatatype, SWT.NONE);
		lblDatatype.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblDatatype.setText("Datenformat");
		
		Button btnXls = new Button(compositeDatatype, SWT.RADIO);
		btnXls.setText("xls");
		
		Button btnCsv = new Button(compositeDatatype, SWT.RADIO);
		btnCsv.setText("csv");
		
		Button btnSdr = new Button(compositeDatatype, SWT.RADIO);
		btnSdr.setText("sdr");
		
		Composite compositeComment = new Composite(containerExportoptions, SWT.NONE);
		compositeComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeComment.setLayout(new GridLayout(1, false));
		
		Label lblComment = new Label(compositeComment, SWT.NONE);
		lblComment.setText("Kommentar");
		
		textComment = new Text(compositeComment, SWT.BORDER);
		textComment.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

	}

}
