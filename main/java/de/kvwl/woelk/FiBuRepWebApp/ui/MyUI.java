package de.kvwl.woelk.FiBuRepWebApp.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.annotation.WebServlet;

import org.vaadin.teemusa.sidemenu.SideMenu;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Resource;
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
import de.kvwl.woelk.FiBuRepWebApp.ui.besondererVertrag.BesondereVertrag2KTUI;

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
@Theme("default")
public class MyUI extends UI {

	private static Navigator navigator;
	private SideMenu sideMenu = new SideMenu();
	
    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	
    	setContent(sideMenu);
    	
    	
    	
    	navigator = new Navigator(this, sideMenu);
    	
    	navigator.addView("", BesondereVertrag2KTUI.class);
    	addViewToSideBar("Besonderer Vertrags Verwaltung", "BESONDERERVERTRAG", BesondereVertrag2KTUI.class, null);
    	addViewToSideBar("Reports", "REPORTVIEW", ReportView.class, null);
//    	navigator.addView("BESONDERERVERTRAG", BesondereVertragUI.class);
//    	navigator.addView("REPORTVIEW", ReportView.class);
//    	
//    	navigator.navigateTo("REPORTVIEW");
    	
    	setNavigator(navigator);
    }
    
    private void addViewToSideBar(String lableName, String viewName, Class<? extends View> view, Resource icon)
    {
    	navigator.addView(viewName, view);
		sideMenu.addNavigation(lableName, icon, viewName);
    }

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
