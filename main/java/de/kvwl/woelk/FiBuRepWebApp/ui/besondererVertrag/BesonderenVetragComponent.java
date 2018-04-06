package de.kvwl.woelk.FiBuRepWebApp.ui.besondererVertrag;

import com.vaadin.icons.VaadinIcons;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.BesondererVertrag2KT;
import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.Besonderervertrag;

public class BesonderenVetragComponent extends VerticalLayout{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Besonderervertrag bsv;

	private TextField name;

	private TextField quartal;

	private TextField lg;

	private TextField lug;

	private TextField sachkosten;

	private Label kontextL;

	private TextField kontext;
	
	public BesonderenVetragComponent() {
		name = new TextField("Name");
        name.setMaxLength(50);
        
        quartal = new TextField("Quartal");
        
        lg = new TextField("LG");
        lg.setMaxLength(2);
        lug = new TextField("LUG");
        lug.setMaxLength(2);
        
        sachkosten = new TextField("Sachkonten");
        name.setMaxLength(20);
        
        kontextL = new Label("Kontext");
        kontext = new TextField();
        kontext.setMaxLength(50);
        kontext.setSizeFull();
        
        fill(null);
	}
	
	public void fill(Besonderervertrag bsv)
	{
		this.bsv = bsv;
		if(bsv != null)
		{
			show(bsv);
		}
		else
		{
			empty();
		}
	}
	
	private void empty()
	{
		removeAllComponents();
		
		Button neu = new Button("Besonderer Vetrag anlegen", VaadinIcons.PLUS_CIRCLE);
		neu.addClickListener(getNewClickedListener());
		neu.addStyleNames("primary","success");
		
		addComponent(neu);
	}
	
	private void show(Besonderervertrag bsv)
	{
		removeAllComponents();
		
        FormLayout fl = new FormLayout(name, quartal, lg, lug, sachkosten);
        final HorizontalLayout anzeige = new HorizontalLayout(fl);
        anzeige.setSizeFull();
        
        //füllen
        name.setValue(bsv.getName());
        quartal.setValue(bsv.getQuartal());
        lg.setValue(bsv.getlG());
        lug.setValue(bsv.getlUG());
        sachkosten.setValue(bsv.getSachkonto());
        kontext.setValue(bsv.getKontext());
        
        Button speichern = new Button("Speichern");
        speichern.addStyleNames("primary");
        
        
		addComponents(anzeige, kontextL, kontext, speichern);
	}
	
	private Button.ClickListener getNewClickedListener()
	{
		return new Button.ClickListener() {
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				fill(new Besonderervertrag());
				
			}
		};
	}
}
