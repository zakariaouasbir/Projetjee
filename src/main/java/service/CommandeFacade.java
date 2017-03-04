/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Commande;
import bean.Fournisseur;
import bean.Livraison;
import bean.Magasin;
import controler.util.SearchUtil;
import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author B-M
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> {

    @PersistenceContext(unitName = "com.mycompany_Mavenprojetjee_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
   public List<Commande> search(Magasin magasin,Fournisseur fournisseur,Date datemin,Date datemax)
    {
        String requette="SELECT c FROM Commande c WHERE 1=1 ";
   requette+=SearchUtil.addConstraintMinMaxDate("c"," datecommande",datemin,datemax);
     requette+=SearchUtil.addConstraint("c","magasin.id","=", magasin.getId());
    requette+=SearchUtil.addConstraint("c","fournisseur.id","=",fournisseur.getId());
    return em.createQuery(requette).getResultList();
}
    
}
