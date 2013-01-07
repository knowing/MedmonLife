package de.lmu.ifi.dbs.medmon.life.e4;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class Exportoptions extends WizardPage {
	private Text textKommentar;

	/**
	 * Create the wizard.
	 */
	public Exportoptions() {
		super("wizardPage");
		setTitle("Datenexport");
		setDescription("Exportoptionen");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite containerExportoptionen = new Composite(parent, SWT.NULL);

		setControl(containerExportoptionen);
		containerExportoptionen.setLayout(new GridLayout(1, false));
		
		Composite compositeAnon = new Composite(containerExportoptionen, SWT.NONE);
		compositeAnon.setLayout(new GridLayout(2, false));
		
		Label lblAnon = new Label(compositeAnon, SWT.NONE);
		lblAnon.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
		lblAnon.setText("Sollen die Daten anonymisiert werden?");
		
		Button btnAnonJa = new Button(compositeAnon, SWT.RADIO);
		btnAnonJa.setText("ja");
		
		Button btnAnonNein = new Button(compositeAnon, SWT.RADIO);
		btnAnonNein.setText("nein");
		
		Composite compositeDatenformat = new Composite(containerExportoptionen, SWT.NONE);
		compositeDatenformat.setLayout(new GridLayout(3, false));
		
		Label lblDatenformat = new Label(compositeDatenformat, SWT.NONE);
		lblDatenformat.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
		lblDatenformat.setText("Datenformat");
		
		Button btnXls = new Button(compositeDatenformat, SWT.RADIO);
		btnXls.setText("xls");
		
		Button btnCsv = new Button(compositeDatenformat, SWT.RADIO);
		btnCsv.setText("csv");
		
		Button btnSdr = new Button(compositeDatenformat, SWT.RADIO);
		btnSdr.setText("sdr");
		
		Composite compositeKommentar = new Composite(containerExportoptionen, SWT.NONE);
		compositeKommentar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		compositeKommentar.setLayout(new GridLayout(1, false));
		
		Label lblKommentar = new Label(compositeKommentar, SWT.NONE);
		lblKommentar.setText("Kommentar");
		
		textKommentar = new Text(compositeKommentar, SWT.BORDER);
		textKommentar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

	}

}
