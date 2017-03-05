/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.Produit;
import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.chart.PieChart;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import static org.eclipse.persistence.platform.database.oracle.plsql.OraclePLSQLTypes.Int;
import org.primefaces.model.chart.PieChartModel;
import service.ProduitFacade;
@Named("graph")
@ManagedBean
@RequestScoped
public class graph {
    @EJB ProduitFacade produitFacade;
    private PieChartModel pie;
    List<Produit> produits;
   

    public PieChartModel getPie() {
        return pie;
    }

    public void setPie(PieChartModel pie) {
        this.pie = pie;
    }

    public List<Produit> getProduits() {
       if(produits==null)
           produits=produitFacade.findAll();
                   return produits;
    }

    public void setProduits(List<Produit> produits) {
        this.produits = produits;
    }
    
    @PostConstruct
    public void init()
    {
        createpie();
    }


public void createpie()
{ 
    pie=new PieChartModel();
    produits=produitFacade.findAll();
   for(int i=0;i<produits.size();i++)
   {pie.set(produits.get(i).getNom(), produits.get(i).getQteg());
       
   }
   pie.setTitle("Produits Existant ");
   pie.setShowDataLabels(true);
        pie.setLegendPosition("w");
}



}
