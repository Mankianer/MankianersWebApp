package de.kvwl.woelk.FiBuRepWebApp.ui.Report;

import com.vaadin.navigator.View;
import com.vaadin.ui.Button;
import com.vaadin.ui.VerticalLayout;

public class ReportView extends VerticalLayout implements View {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ReportView() {
		Button bt = new Button("Klick");
		bt.addClickListener(e -> {
			getUI().getNavigator().navigateTo("BESONDERERVERTRAG");
		});
		
		addComponent(bt);
	}
}
