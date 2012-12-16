/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2012 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
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
 * @author Arun Gupta
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
