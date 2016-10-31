package my.vaadin.wordquiz;

import com.vaadin.addon.charts.Chart;
import com.vaadin.addon.charts.model.ChartType;
import com.vaadin.addon.charts.model.Configuration;
import com.vaadin.addon.charts.model.DataSeries;
import com.vaadin.addon.charts.model.DataSeriesItem;
import com.vaadin.addon.charts.model.PlotOptionsLine;
import com.vaadin.addon.charts.model.style.SolidColor;

import my.vaadin.wordquiz.ChartsData.ShoeSizeInfo;

public class ProfilePage extends ProfilePageLayout {
	
	
	
	public void initChart(){
		Chart chart = this.progressChart;
		
		Configuration conf = chart.getConfiguration();
		conf.setTitle("Hello Charts!");
		
		conf.getChart().setType(ChartType.LINE);
		
		ChartsData data = new ChartsData();
		DataSeries girls = new DataSeries("Girls");
		for(ShoeSizeInfo shoeSizeInfo : data.getGirlsData()) {
		   // Shoe size on the X-axis, age on the Y-axis
		   girls.add(new DataSeriesItem(
		         shoeSizeInfo.getSize(),
		         shoeSizeInfo.getAgeMonths()/12.0f));
		}
		conf.addSeries(girls);
		
		conf.getxAxis().setTitle("Shoe size (EU)");
		conf.getyAxis().setTitle("Age (Years)");
		
		DataSeries boys = new DataSeries("Boys");
		for(ShoeSizeInfo shoeSizeInfo : data.getBoysData()) {
		   // Shoe size on the X-axis, age on the Y-axis
		   boys.add(new DataSeriesItem(
		        shoeSizeInfo.getSize(),
		        shoeSizeInfo.getAgeMonths()/12.0f));
		}
		conf.addSeries(boys);
		
		PlotOptionsLine girlsOpts = new PlotOptionsLine();
		girlsOpts.setColor(SolidColor.HOTPINK);
		girls.setPlotOptions(girlsOpts);

		PlotOptionsLine boysOpts = new PlotOptionsLine();
		boysOpts.setColor(SolidColor.BLUE);
		boys.setPlotOptions(boysOpts);
	}
}
