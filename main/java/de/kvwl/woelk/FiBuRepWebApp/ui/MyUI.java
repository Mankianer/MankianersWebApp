package de.kvwl.woelk.FiBuRepWebApp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.Registration;
import com.vaadin.shared.ui.ValueChangeMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Grid.SelectionMode;

import de.kvwl.woelk.FiBuRepWebApp.modul.besonderervertrag.Besonderervertrag;
import de.kvwl.woelk.FiBuRepWebApp.ui.Report.ReportView;
import de.kvwl.woelk.FiBuRepWebApp.ui.besondererVertrag.BesondereVertragUI;

import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of an HTML page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	private static Navigator navigator;
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	VerticalLayout cont = new VerticalLayout();
    	VerticalLayout left = new VerticalLayout();
    	
    	HorizontalSplitPanel hsp = new HorizontalSplitPanel(left, cont);
    	
    	setContent(hsp);
    	
    	navigator = new Navigator(this, cont);
    	navigator.addView("BESONDERERVERTRAG", BesondereVertragUI.class);
    	navigator.addView("", BesondereVertragUI.class);
    	navigator.addView("REPORTVIEW", ReportView.class);
    	
    	navigator.navigateTo("REPORTVIEW");
    	
    	setNavigator(navigator);
    }

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
