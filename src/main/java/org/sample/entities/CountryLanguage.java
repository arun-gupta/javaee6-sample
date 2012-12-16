/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.sample.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author arungup
 */
@Entity
@Table(name = "CountryLanguage")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CountryLanguage.findAll", query = "SELECT c FROM CountryLanguage c"),
    @NamedQuery(name = "CountryLanguage.findByCountryCode", query = "SELECT c FROM CountryLanguage c WHERE c.countryLanguagePK.countryCode = :countryCode"),
    @NamedQuery(name = "CountryLanguage.findByLanguage", query = "SELECT c FROM CountryLanguage c WHERE c.countryLanguagePK.language = :language"),
    @NamedQuery(name = "CountryLanguage.findByIsOfficial", query = "SELECT c FROM CountryLanguage c WHERE c.isOfficial = :isOfficial"),
    @NamedQuery(name = "CountryLanguage.findByPercentage", query = "SELECT c FROM CountryLanguage c WHERE c.percentage = :percentage")})
public class CountryLanguage implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CountryLanguagePK countryLanguagePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "IsOfficial")
    private String isOfficial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Percentage")
    private float percentage;

    public CountryLanguage() {
    }

    public CountryLanguage(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public CountryLanguage(CountryLanguagePK countryLanguagePK, String isOfficial, float percentage) {
        this.countryLanguagePK = countryLanguagePK;
        this.isOfficial = isOfficial;
        this.percentage = percentage;
    }

    public CountryLanguage(String countryCode, String language) {
        this.countryLanguagePK = new CountryLanguagePK(countryCode, language);
    }

    public CountryLanguagePK getCountryLanguagePK() {
        return countryLanguagePK;
    }

    public void setCountryLanguagePK(CountryLanguagePK countryLanguagePK) {
        this.countryLanguagePK = countryLanguagePK;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryLanguagePK != null ? countryLanguagePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CountryLanguage)) {
            return false;
        }
        CountryLanguage other = (CountryLanguage) object;
        if ((this.countryLanguagePK == null && other.countryLanguagePK != null) || (this.countryLanguagePK != null && !this.countryLanguagePK.equals(other.countryLanguagePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.sample.entities.CountryLanguage[ countryLanguagePK=" + countryLanguagePK + " ]";
    }
    
}
