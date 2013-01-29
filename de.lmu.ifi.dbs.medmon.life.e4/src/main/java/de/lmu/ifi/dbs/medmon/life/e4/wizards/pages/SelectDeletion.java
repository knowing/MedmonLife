package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import javax.inject.Inject;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.e4.ui.services.IStylingEngine;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Link;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

@Creatable
public class SelectDeletion extends WizardPage {

	public boolean patientDeletion = true;
	
	@Inject IStylingEngine styleEngine;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public SelectDeletion() {
		super("wizardPage");
		setTitle("L\u00F6schauswahl");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		Composite compositeSelectDeletion = new Composite(parent, SWT.NULL);
		setPageComplete(false);

		setControl(compositeSelectDeletion);
		compositeSelectDeletion.setLayout(new GridLayout(1, false));
		
		Link linkPatient = new Link(compositeSelectDeletion, SWT.NONE);
		linkPatient.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				patientDeletion = true;
				getContainer().showPage(getNextPage());
			}
		});
		linkPatient.setText("<a>Patient l\u00F6schen</a>");
		
		Link linkData = new Link(compositeSelectDeletion, SWT.NONE);
		linkData.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				patientDeletion = false;
				getContainer().showPage(getNextPage());
			}
		});
		linkData.setText("<a>Daten l\u00F6schen</a>");
	}

}
