package de.kvwl.woelk.FiBuRepWebApp.ui.besondererVertrag;

import com.vaadin.event.MouseEvents.ClickListener;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.BesondererVertrag2KT;

public class BesondererVetrag2KTComponent extends HorizontalLayout{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8602763443428280283L;
	private BesondererVertrag2KT bsv2kt;
	private BesonderenVetragComponent besonderenVetragComponent;
	private TextField vknr;
	private TextField eigen;
	private TextField fremd;
	private TextField gesamt;
	private Button close;
	private FormLayout top;
	
	public BesondererVetrag2KTComponent() {
		
		vknr = new TextField("VKNR");
		vknr.setMaxLength(5);
		eigen = new TextField("Eigen");
		fremd = new TextField("Fremd");
		gesamt = new TextField("Gesamt");
		
		besonderenVetragComponent = new BesonderenVetragComponent();
		
		close = new Button(VaadinIcons.CLOSE_CIRCLE);
		close.addClickListener(e -> fill(null));
		
		top = new FormLayout(vknr, eigen, fremd, gesamt, besonderenVetragComponent);
		
		fill(null);
		
	}
	
	public void fill(BesondererVertrag2KT bsv2KT)
	{
		removeAllComponents();
		
		if(bsv2KT != null)
		{
			addComponents(top, close);
			setComponentAlignment(close, Alignment.TOP_RIGHT);
			setComponentAlignment(top, Alignment.TOP_LEFT);
			
			bsv2kt = bsv2KT;
			vknr.setValue(bsv2KT.getVknr());
			eigen.setValue("" + bsv2KT.getEigene());
			fremd.setValue("" + bsv2KT.getFremd());
			gesamt.setValue("" + bsv2KT.getGesamt());
			
			besonderenVetragComponent.fill(bsv2KT.getBsv());
		}
		else
		{
			empty();
		}
	}
	
	private void empty()
	{
		Button neu = new Button("Besonderer Vetrag anlegen", VaadinIcons.PLUS_CIRCLE);
		neu.addClickListener(getNewClickedListener());
		neu.addStyleNames("primary","success");
		
		addComponent(neu);
	}
	
	private Button.ClickListener getNewClickedListener()
	{
		return new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				fill(new BesondererVertrag2KT());
				
			}
		};
	}

}
