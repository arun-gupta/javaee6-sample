/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.sample.entities.CountryLanguage;

/**
 *
 * @author arungup
 */
@Stateless
public class CountryLanguageFacade extends AbstractFacade<CountryLanguage> {
    @PersistenceContext(unitName = "helloworld2_helloworld2_war_1.0PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CountryLanguageFacade() {
        super(CountryLanguage.class);
    }
    
}
