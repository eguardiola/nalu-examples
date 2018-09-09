package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.dashboard;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

import com.github.mvp4g.nalu.client.component.AbstractComponentController;
import com.github.mvp4g.nalu.client.component.annotation.Controller;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.Widget;

import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;
import gwt.material.design.client.ui.MaterialLoader;

@Controller(route = "/dashboard", selector = "content", componentInterface = IDashboardComponent.class, component = DashboardComponent.class)
public class DashboardController extends
        AbstractComponentController<NaluSimpleApplicationContext, IDashboardComponent, Widget> implements
        IDashboardComponent.Controller {

    public DashboardController() {
    }

    @Override
    public void start() {
        doRefresh();
    }
    
    @Override
    public void doRefresh() {
    	MaterialLoader.progress(true);
    	
//    	CompletableFuture<List<FlightHoursSummary>> cf1 = this.context.getFakedService().getFlightHoursSummaries();
    	
//    	cf1.thenAccept(r -> {
//    		DashboardController.this.component.updateFlightHourSummaryTable(r);
//    		MaterialLoader.progress(false);
//    	});
    	
//    	CompletableFuture.allOf(cf1).thenAccept(dummy -> {
//    		DashboardController.this.component.updateFlightHourSummaryTable(cf1.join());
//    		MaterialLoader.progress(false);
//    	});   
    	
    	this.context.getFakedService().getFlightHoursSummaries_rx().subscribe(next -> {
    		DashboardController.this.component.updateFlightHourSummaryTable(next);
    		MaterialLoader.progress(false);
    	});
    }
}
