/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bean.Inventaire;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author B-M
 */
@Stateless
public class InventaireFacade extends AbstractFacade<Inventaire> {

    @PersistenceContext(unitName = "com.mycompany_Mavenprojetjee_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InventaireFacade() {
        super(Inventaire.class);
    }
    
}
