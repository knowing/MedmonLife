package de.lmu.ifi.dbs.medmon.life.e4;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;

import org.eclipse.e4.ui.di.Focus;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Link;

import de.lmu.ifi.dbs.medmon.life.e4.wizards.DeletionWizard;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.ExportWizard;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.ImportWizard;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.GridData;

public class StartView {

	@Inject
	private ExportWizard exportWizard;
	@Inject
	private ImportWizard importWizard;
	@Inject
	private DeletionWizard deletionWizard;
	
	@Inject IStylingEngine styleEngine;

	/**
	 * Create contents of the view part.
	 */
	@PostConstruct
	public void createControls(final Composite parent) {
		
		
		
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		
		GridLayout gl_parent = new GridLayout(4, false);
		gl_parent.horizontalSpacing = 0;
		gl_parent.marginWidth = 0;
		gl_parent.marginHeight = 0;
		gl_parent.verticalSpacing = 0;
		parent.setLayout(gl_parent);
		
		Composite compositeLogo = new Composite(parent, SWT.NONE);
		GridLayout gl_composite = new GridLayout(1, false);
		gl_composite.verticalSpacing = 0;
		gl_composite.horizontalSpacing = 0;
		gl_composite.marginWidth = 0;
		gl_composite.marginHeight = 0;
		compositeLogo.setLayout(gl_composite);
		compositeLogo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		
		CLabel lblLogo = new CLabel(compositeLogo, SWT.NONE);
		lblLogo.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, true, false, 1, 1));
		lblLogo.setImage(SWTResourceManager.getImage(StartView.class, "/icons/life_icon_64.png"));
		styleEngine.setClassname(compositeLogo, "logo");


		Label lblSeparator1 = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator1.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		CLabel lblImport = new CLabel(parent, SWT.NONE);
		lblImport.setImage(SWTResourceManager.getImage(StartView.class, "/icons/import.gif"));
		
		Link linkImport = new Link(parent, SWT.NONE);
		linkImport.setText("<a>Import</a>");
		linkImport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(parent.getShell(), importWizard);
				dialog.open();
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
				
		Label lblSeparator2 = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		lblSeparator2.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblImportOptions = new Label(parent, SWT.NONE);
		lblImportOptions.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblImportOptions.setText("Patient ausw\u00E4hlen/anlegen\r\nZeitraum einschr\u00E4nken");
		styleEngine.setClassname(lblImportOptions, "startPageText");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFiller = new Label(parent, SWT.NONE);
		lblFiller.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);



		


		CLabel lblExport = new CLabel(parent, SWT.NONE);
		lblExport.setImage(SWTResourceManager.getImage(StartView.class, "/icons/export.gif"));

		Link linkExport = new Link(parent, SWT.NONE);
		linkExport.setText("<a>Export</a>");
		linkExport.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(parent.getShell(), exportWizard);
				dialog.open();
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);

		
		Label label = new Label(parent, SWT.SEPARATOR | SWT.HORIZONTAL);
		label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 4, 1));
				new Label(parent, SWT.NONE);
				new Label(parent, SWT.NONE);
				
										
		Label lblExportOptions = new Label(parent, SWT.NONE);
		lblExportOptions.setText("Filteroptionen\r\nExportoptionen");
		styleEngine.setClassname(lblExportOptions, "startPageText");
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFiller2 = new Label(parent, SWT.NONE);
		lblFiller2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
	
		
		CLabel lblDelete = new CLabel(parent, SWT.NONE);
		lblDelete.setImage(SWTResourceManager.getImage(StartView.class, "/icons/delete.gif"));

		Link linkDelete = new Link(parent, SWT.NONE);
		linkDelete.setText("<a>Patienten/Daten l\u00F6schen</a>");
		
		linkDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				WizardDialog dialog = new WizardDialog(parent.getShell(), deletionWizard);
				dialog.open();
			}
		});
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);
		
		Label lblFiller3 = new Label(parent, SWT.NONE);
		lblFiller3.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, true, 1, 1));
		new Label(parent, SWT.NONE);
		new Label(parent, SWT.NONE);


	}

	@PreDestroy
	public void dispose() {
	}

	@Focus
	public void setFocus() {
	}
}
