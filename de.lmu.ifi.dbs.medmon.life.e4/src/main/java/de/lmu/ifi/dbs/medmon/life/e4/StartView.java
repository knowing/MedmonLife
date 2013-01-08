package de.lmu.ifi.dbs.medmon.life.e4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.lmu.ifi.dbs.medmon.life.e4.wizards.DeletionWizard;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.ExportWizard;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.ImportWizard;

public class StartView {

	@Inject
	private ExportWizard exportWizard;
	@Inject
	private ImportWizard importWizard;
	@Inject
	private DeletionWizard deletionWizard;

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(final Composite parent) {
		GridLayout gl_parent = new GridLayout(2, false);
		parent.setLayout(gl_parent);
		
		Button btnImport = new Button(parent, SWT.NONE);
		btnImport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(parent.getShell(), importWizard);
				dialog.open();
			}
		});
		btnImport.setText("Import");
		new Label(parent, SWT.NONE);

		Button btnExport = new Button(parent, SWT.NONE);
		btnExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(parent.getShell(), exportWizard);
				dialog.open();
			}
		});
		btnExport.setText("Export");
		new Label(parent, SWT.NONE);
		
		Button btnDelete = new Button(parent, SWT.NONE);
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(parent.getShell(), deletionWizard);
				dialog.open();
			}
		});
		btnDelete.setText("Daten/Patienten l\u00F6schen");
		new Label(parent, SWT.NONE);

	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
	}

}
