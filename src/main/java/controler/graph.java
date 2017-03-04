/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import javafx.scene.chart.PieChart;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.model.chart.PieChartModel;
@Named("graph")
@ManagedBean
@RequestScoped
public class graph {
    
    private PieChartModel pie;

    public PieChartModel getPie() {
        return pie;
    }

    public void setPie(PieChartModel pie) {
        this.pie = pie;
    }
    @PostConstruct
    public void init()
    {
        createpie();
    }


public void createpie()
{
    pie=new PieChartModel();
    pie.set("zakaria",120);
    pie.set("wijdan",80);
    pie.setTitle("pie");
  
}
}
