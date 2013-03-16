package de.lmu.ifi.dbs.medmon.life.e4.wizards.pages;

import java.io.IOException;
import java.util.Date;

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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.DateTime;

import de.lmu.ifi.dbs.medmon.database.entity.Data;
import de.lmu.ifi.dbs.medmon.database.entity.Patient;
import de.lmu.ifi.dbs.medmon.database.entity.Sensor;
import de.lmu.ifi.dbs.medmon.life.e4.wizards.ImportWizardOptions;
import de.lmu.ifi.dbs.medmon.sensor.core.ISensor;

import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.joda.time.Interval;

import weka.core.Instances;

@Creatable
public class LimitTimeperiod extends WizardPage {

	@Inject IStylingEngine styleEngine;
	
	@Inject
	@GeminiPersistenceContext(unitName = "medmon")
	EntityManager em;
	
	Label lblSelectedPatient;
	Composite compositeTimeperiod;
	DateTime dateTimeFrom;
	Composite compositePeriod;
	Patient patient;
	
	/**
	 * Create the wizard.
	 */
	@Inject
	public LimitTimeperiod() {
		super("wizardPage");
		setTitle("Zeitraum einschr\u00E4nken");
	}

	/**
	 * Create contents of the wizard.
	 * @param parent
	 */
	public void createControl(Composite parent) {
		styleEngine.setId(parent, "WizardStyle");
		parent.setBackgroundMode(SWT.INHERIT_DEFAULT);
		compositeTimeperiod = new Composite(parent, SWT.NULL);

		setControl(compositeTimeperiod);
		compositeTimeperiod.setLayout(new GridLayout(2, false));
		
		lblSelectedPatient = new Label(compositeTimeperiod, SWT.NONE);
		lblSelectedPatient.setText("kein Patient ausgew\u00E4hlt");
		
		
		Button btnChangeSelection = new Button(compositeTimeperiod, SWT.NONE);
		btnChangeSelection.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				getContainer().showPage(getWizard().getStartingPage());
			}
		});
		btnChangeSelection.setText("\u00E4ndern");
		
		compositePeriod = new Composite(compositeTimeperiod, SWT.NONE);
		compositePeriod.setLayout(new GridLayout(2, false));
		
		Label lblPeriod = new Label(compositePeriod, SWT.NONE);
		lblPeriod.setText("Zeitraum");
		new Label(compositePeriod, SWT.NONE);
		
		Label lblFrom = new Label(compositePeriod, SWT.NONE);
		lblFrom.setText("von");
		
		dateTimeFrom = new DateTime(compositePeriod, SWT.BORDER);
		
		Label lblTo = new Label(compositePeriod, SWT.NONE);
		lblTo.setText("bis");
		
		DateTime dateTimeTo = new DateTime(compositePeriod, SWT.BORDER);
		new Label(compositeTimeperiod, SWT.NONE);
	}
	
	public void updateWidget(Patient patient){
		
			
			lblSelectedPatient.setText(patient.getFirstname() + " " + patient.getLastname() + " ausgew\u00E4hlt");
			System.out.println(patient.getFirstname());
		
		lblSelectedPatient.redraw();
		lblSelectedPatient.update();
		compositeTimeperiod.update();
		compositeTimeperiod.pack();
		compositeTimeperiod.layout();
		
		ISensor sens = ImportWizardOptions.sensor;
		//System.out.println(sens.getId());
		
		//Sensor sensor = em.find(Sensor.class, ImportWizardOptions.sensor.getId());
		
		//Date date = sensor.getData().get(sensor.getData().size()).getFrom();
		/*try {
			Date date = sens.getInterval().getStart().toDate();
			dateTimeFrom.setDate(date.getYear(), date.getMonth(), date.getDay());
			dateTimeFrom.update();
			compositePeriod.update();
			compositePeriod.layout();
			compositePeriod.pack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}*/
		

		
		// Getting all data from the sensor
		/*try {
			Instances instances = sens.getData();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}*/

		// Gets the time interval of the data
		/*try {
			Interval interval = sensor.getInterval();
			sensor.getData().get(0).getFrom().
			interval.getStart();
			Date date = interval.getEnd().toDate();
			dateTimeFrom.setDate(date.getYear(), date.getMonth(), date.getDay());
			dateTimeFrom.update();
			compositePeriod.update();
			compositePeriod.layout();
			compositePeriod.pack();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		/*Sensor sensor = em.find(Sensor.class, ImportWizardOptions.sensor.getId());

		
		Data data = new Data(new Date(0), new Date(10), sensor);
		em.persist(data);*/
	}

}
