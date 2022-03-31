/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mufufu
 */
@Entity
public class OPCRead implements Serializable {

    /**
     * @return the device
     */
    public String getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(String device) {
        this.device = device;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the period
     */
    public BigDecimal getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(BigDecimal period) {
        this.period = period;
    }

    /**
     * @return the gf
     */
    public BigDecimal getGf() {
        return gf;
    }

    /**
     * @param gf the gf to set
     */
    public void setGf(BigDecimal gf) {
        this.gf = gf;
    }

    /**
     * @return the pm1
     */
    public BigDecimal getPm1() {
        return pm1;
    }

    /**
     * @param pm1 the pm1 to set
     */
    public void setPm1(BigDecimal pm1) {
        this.pm1 = pm1;
    }

    /**
     * @return the pm25
     */
    public BigDecimal getPm25() {
        return pm25;
    }

    /**
     * @param pm25 the pm25 to set
     */
    public void setPm25(BigDecimal pm25) {
        this.pm25 = pm25;
    }

    /**
     * @return the pm10
     */
    public BigDecimal getPm10() {
        return pm10;
    }

    /**
     * @param pm10 the pm10 to set
     */
    public void setPm10(BigDecimal pm10) {
        this.pm10 = pm10;
    }

    /**
     * @return the rh
     */
    public BigDecimal getRh() {
        return rh;
    }

    /**
     * @param rh the rh to set
     */
    public void setRh(BigDecimal rh) {
        this.rh = rh;
    }

    /**
     * @return the temp
     */
    public BigDecimal getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(BigDecimal temp) {
        this.temp = temp;
    }

    /**
     * @return the press
     */
    public BigDecimal getPress() {
        return press;
    }

    /**
     * @param press the press to set
     */
    public void setPress(BigDecimal press) {
        this.press = press;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String device;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(precision = 10, scale = 2)
    private BigDecimal period;
    @Column(precision = 10, scale = 2)
    private BigDecimal gf;
    @Column(precision = 10, scale = 2)
    private BigDecimal pm1;
    @Column(precision = 10, scale = 2)
    private BigDecimal pm25;
    @Column(precision = 10, scale = 2)
    private BigDecimal pm10;
    @Column(precision = 10, scale = 2)
    private BigDecimal rh;
    @Column(precision = 10, scale = 2)
    private BigDecimal temp;
    @Column(precision = 10, scale = 2)
    private BigDecimal press;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OPCRead)) {
            return false;
        }
        OPCRead other = (OPCRead) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OPCRead[ id=" + getId() + " ]";
    }
    
}
