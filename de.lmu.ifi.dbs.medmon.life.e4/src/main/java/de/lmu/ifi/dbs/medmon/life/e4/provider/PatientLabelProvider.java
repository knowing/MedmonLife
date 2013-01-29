package de.lmu.ifi.dbs.medmon.life.e4.provider;

import org.eclipse.e4.core.di.annotations.Creatable;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

@Creatable
public class PatientLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		return null;
	}
	
	@Override
	public String getColumnText(Object element, int columnIndex) {
		return element.toString();
	}

}