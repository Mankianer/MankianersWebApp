package de.kvwl.woelk.FiBuRepWebApp.ui.besondererVertrag;

import java.util.ArrayList;
import java.util.Random;

import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.Besonderervertrag;

public class BesondereVertragUI extends VerticalLayout implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grid<Besonderervertrag> grid;
	private TextField suchText;
	private TextField suchTextQ;
	
	private ArrayList<Besonderervertrag> bv;
	private Registration gridListener;

	private HorizontalSplitPanel splitlayout;
	
	public BesondereVertragUI() {
		bv = new ArrayList<Besonderervertrag>();
		
		
		HorizontalLayout suchH = getSuchFeld();
		Component splitPanel = getSplitPanel();
		
		addComponent(suchH);
		addComponent(splitPanel);
		
		setExpandRatio(suchH, 0.05f);
		setExpandRatio(splitPanel, 0.95f);
		
		setSizeFull();
		fillBV();
		updateList();
	}
	
	private Component getSplitPanel()
	{
		splitlayout = new HorizontalSplitPanel();
		
		grid = new Grid<>(Besonderervertrag.class);
		grid.setSizeFull();
		splitlayout.setFirstComponent(grid);
		
		return splitlayout;
	}
	
	private void fillBV()
    {
    	Random rnd = new Random();
    	String[] namen = {"Name","Test","Daten","Vertrag","Demo","Blabla"};
    	String[] namen2 = {"Peter","Müller","Kauz","Olaf","Demo","Blub"};
    	
    	int id = 0;
    	
    	for (String s1 : namen) {
			for (int i = 0; i < 5; i++) {
				String name = s1 + namen2[rnd.nextInt(namen2.length)];
				bv.add(new Besonderervertrag(id++, name, "2018q" + (rnd.nextInt(4) + 1), "kon", "lg", "lug", "sachkosten"));
			}
		}
    }
	
	private void updateList() {
    	
		splitlayout.setSecondComponent(null);
    	
    	ArrayList<Besonderervertrag> rembv = new ArrayList<Besonderervertrag>();
    	ArrayList<Besonderervertrag> lbv = new ArrayList<Besonderervertrag>(bv);
    	
    	if(gridListener != null) {
    		gridListener.remove();
    	}
    	
    	if(!suchText.isEmpty()) {
    		for (Besonderervertrag besonderervetrag : bv) {
    			if(!besonderervetrag.getName().contains(suchText.getValue()))
    			{
    				rembv.add(besonderervetrag);
    			}
    		}
    	}
    	if(!suchTextQ.isEmpty())
    	{
    		for (Besonderervertrag besonderervetrag : bv) {
    			if(!besonderervetrag.getQuartal().contains(suchTextQ.getValue()))
    			{
    				rembv.add(besonderervetrag);
    			}
    		}
    	}
    	
    	lbv.removeAll(rembv);
    	grid.setItems(lbv);
    	
    	gridListener = grid.addSelectionListener(e -> {if(e.getFirstSelectedItem().isPresent()) splitlayout.setSecondComponent(anzeigeRight(e.getFirstSelectedItem().get()));});
	}
	
	private Component anzeigeRight(Besonderervertrag bsv) {
        TextField name = new TextField("Name");
        name.setMaxLength(50);
        
        TextField quartal = new TextField("Quartal");
        
        TextField lg = new TextField("LG");
        lg.setMaxLength(2);
        TextField lug = new TextField("LUG");
        lug.setMaxLength(2);
        
        TextField sachkosten = new TextField("Sachkonten");
        name.setMaxLength(20);
        
        Label kontextL = new Label("Kontext");
        TextField kontext = new TextField();
        kontext.setMaxLength(50);
        kontext.setSizeFull();
        
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
        
        
		return new VerticalLayout(anzeige, kontextL, kontext, speichern);
	}
	
	private HorizontalLayout getSuchFeld()
	{
		suchText = new TextField();
		suchTextQ = new TextField();
		
		suchText.setPlaceholder("Suche nach Name...");
        suchText.addValueChangeListener(e -> updateList());
        suchText.setValueChangeMode(ValueChangeMode.LAZY);
        
        suchTextQ.setPlaceholder("Suche nach Quartal...");
        suchTextQ.addValueChangeListener(e -> updateList());
        suchTextQ.setValueChangeMode(ValueChangeMode.LAZY);
        
        @SuppressWarnings("deprecation")
		Button bt = new Button(FontAwesome.TIMES);
        bt.setDescription("Leert Suchfeld");
        bt.addClickListener(e -> {suchText.clear(); suchTextQ.clear(); });
        
        HorizontalLayout h = new HorizontalLayout(suchText,suchTextQ,bt);
        
        return h;
	}
	
	

}
