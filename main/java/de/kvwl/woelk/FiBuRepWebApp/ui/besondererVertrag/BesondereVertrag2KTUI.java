package de.kvwl.woelk.FiBuRepWebApp.ui.besondererVertrag;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.icons.VaadinIcons;
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

import de.kvwl.woelk.FiBuRepWebApp.data.besondererVetrag.BesondererVertragControllerInterface;
import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.BesondererVertrag2KT;
import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.Besonderervertrag;

public class BesondereVertrag2KTUI extends VerticalLayout implements View{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Grid<BesondererVertrag2KT> grid;
	private TextField suchText;
	
	private ArrayList<BesondererVertrag2KT> bv2KT;
	private Registration gridListener;

	private HorizontalSplitPanel splitlayout;

	private BesondererVetrag2KTComponent bvs2ktComp;
	
	@Autowired
	private BesondererVertragControllerInterface bvc;
	
	public BesondereVertrag2KTUI() {
		bv2KT = new ArrayList<BesondererVertrag2KT>();
		
		HorizontalLayout suchH = getSuchFeld();
		HorizontalSplitPanel splitPanel = getSplitPanel();
		bvs2ktComp = new BesondererVetrag2KTComponent();
		
		addComponent(suchH);
		addComponent(splitPanel);
		
		setExpandRatio(suchH, 0.05f);
		setExpandRatio(splitPanel, 0.95f);
		
		setSizeFull();
		fillBV();
		updateList();
		splitPanel.setSecondComponent(bvs2ktComp);
	}
	
	private HorizontalSplitPanel getSplitPanel()
	{
		splitlayout = new HorizontalSplitPanel();
		
		grid = new Grid<>(BesondererVertrag2KT.class);
		grid.setColumns("vknr","eigene","fremd","gesamt");
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
    	
		for (int i = 0; i < 5; i++) {
			String name = namen[rnd.nextInt(namen.length)] + namen2[rnd.nextInt(namen2.length)];
			Besonderervertrag besonderervertrag = new Besonderervertrag(id++, name, "2018q" + (rnd.nextInt(4) + 1), "kon", "lg", "lug", "sachkosten");
			bv2KT.add(new BesondererVertrag2KT(id, besonderervertrag, rnd.nextInt(20000000)/100.0, rnd.nextInt(20000000)/100.0, rnd.nextInt(20000000)/100.0, "VKN1234"));
		}
		
		System.out.println(bvc);
		
//		List<BesondererVertrag2KT> l = bvc.findAll();
//		for (BesondererVertrag2KT b : l) {
//			System.out.println(b);
//			bv2KT.add(b);
//		}
		
		
    }
	
	private void updateList() {
    	
		splitlayout.setSecondComponent(null);
    	
    	ArrayList<BesondererVertrag2KT> rembv2KT = new ArrayList<BesondererVertrag2KT>();
    	ArrayList<BesondererVertrag2KT> lbv2KT = new ArrayList<BesondererVertrag2KT>(bv2KT);
    	
    	if(gridListener != null) {
    		gridListener.remove();
    	}
    	
    	if(!suchText.isEmpty()) {
    		for (BesondererVertrag2KT besonderervetrag2KT : bv2KT) {
    			if(!besonderervetrag2KT.getVknr().contains(suchText.getValue()))
    			{
    				rembv2KT.add(besonderervetrag2KT);
    			}
    		}
    	}
    	
    	lbv2KT.removeAll(rembv2KT);
    	grid.setItems(lbv2KT);
    	
    	gridListener = grid.addSelectionListener(e -> {
    		BesondererVertrag2KT bsv2KT = null;
    		if(e.getFirstSelectedItem().isPresent()) { 
    			bsv2KT = e.getFirstSelectedItem().get();
			}
    		bvs2ktComp.fill(bsv2KT);
		});
	}
	
	
	private HorizontalLayout getSuchFeld()
	{
		suchText = new TextField();
		
		suchText.setPlaceholder("Suche nach VKN...");
        suchText.addValueChangeListener(e -> updateList());
        suchText.setValueChangeMode(ValueChangeMode.LAZY);
        
        
		Button bt = new Button(VaadinIcons.CLOSE);
        bt.setDescription("Leert Suchfeld");
        bt.addClickListener(e -> {suchText.clear(); });
        
        HorizontalLayout h = new HorizontalLayout(suchText,bt);
        
        return h;
	}
	
	

}
