/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
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
    public Number getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(Number period) {
        this.period = period;
    }

    /**
     * @return the gf
     */
    public Number getGf() {
        return gf;
    }

    /**
     * @param gf the gf to set
     */
    public void setGf(Number gf) {
        this.gf = gf;
    }

    /**
     * @return the pm1
     */
    public Number getPm1() {
        return pm1;
    }

    /**
     * @param pm1 the pm1 to set
     */
    public void setPm1(Number pm1) {
        this.pm1 = pm1;
    }

    /**
     * @return the pm25
     */
    public Number getPm25() {
        return pm25;
    }

    /**
     * @param pm25 the pm25 to set
     */
    public void setPm25(Number pm25) {
        this.pm25 = pm25;
    }

    /**
     * @return the pm10
     */
    public Number getPm10() {
        return pm10;
    }

    /**
     * @param pm10 the pm10 to set
     */
    public void setPm10(Number pm10) {
        this.pm10 = pm10;
    }

    /**
     * @return the rh
     */
    public Number getRh() {
        return rh;
    }

    /**
     * @param rh the rh to set
     */
    public void setRh(Number rh) {
        this.rh = rh;
    }

    /**
     * @return the temp
     */
    public Number getTemp() {
        return temp;
    }

    /**
     * @param temp the temp to set
     */
    public void setTemp(Number temp) {
        this.temp = temp;
    }

    /**
     * @return the press
     */
    public Number getPress() {
        return press;
    }

    /**
     * @param press the press to set
     */
    public void setPress(Number press) {
        this.press = press;
    }

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String device;
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private Number period;
    private Number gf;
    private Number pm1;
    private Number pm25;
    private Number pm10;
    private Number rh;
    private Number temp;
    private Number press;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OPCRead)) {
            return false;
        }
        OPCRead other = (OPCRead) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OPCRead[ id=" + id + " ]";
    }
    
}
