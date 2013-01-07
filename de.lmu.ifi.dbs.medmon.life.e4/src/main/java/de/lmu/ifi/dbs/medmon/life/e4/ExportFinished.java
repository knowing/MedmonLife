package de.lmu.ifi.dbs.medmon.life.e4;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridData;

public class ExportFinished extends WizardPage {

	/**
	 * Create the wizard.
	 */
	public ExportFinished() {
		super("wizardPage");
		setTitle("Datenexport");
		setDescription("Export abgeschlossen");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);

		setControl(container);
		container.setLayout(new GridLayout(1, false));
		
		Label lblZipfileErstellt = new Label(container, SWT.NONE);
		lblZipfileErstellt.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false, 1, 1));
		lblZipfileErstellt.setText("Zipfile erstellt\r\n\r\nExport abgeschlossen");
	}
}
