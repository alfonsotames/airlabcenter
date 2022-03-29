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
public class GasRead implements Serializable {

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
     * @return the so2we
     */
    public Number getSo2we() {
        return so2we;
    }

    /**
     * @param so2we the so2we to set
     */
    public void setSo2we(Number so2we) {
        this.so2we = so2we;
    }

    /**
     * @return the so2ae
     */
    public Number getSo2ae() {
        return so2ae;
    }

    /**
     * @param so2ae the so2ae to set
     */
    public void setSo2ae(Number so2ae) {
        this.so2ae = so2ae;
    }

    /**
     * @return the o3n2we
     */
    public Number getO3n2we() {
        return o3n2we;
    }

    /**
     * @param o3n2we the o3n2we to set
     */
    public void setO3n2we(Number o3n2we) {
        this.o3n2we = o3n2we;
    }

    /**
     * @return the o3n2ae
     */
    public Number getO3n2ae() {
        return o3n2ae;
    }

    /**
     * @param o3n2ae the o3n2ae to set
     */
    public void setO3n2ae(Number o3n2ae) {
        this.o3n2ae = o3n2ae;
    }

    /**
     * @return the no2we
     */
    public Number getNo2we() {
        return no2we;
    }

    /**
     * @param no2we the no2we to set
     */
    public void setNo2we(Number no2we) {
        this.no2we = no2we;
    }

    /**
     * @return the no2ae
     */
    public Number getNo2ae() {
        return no2ae;
    }

    /**
     * @param no2ae the no2ae to set
     */
    public void setNo2ae(Number no2ae) {
        this.no2ae = no2ae;
    }

    /**
     * @return the cowe
     */
    public Number getCowe() {
        return cowe;
    }

    /**
     * @param cowe the cowe to set
     */
    public void setCowe(Number cowe) {
        this.cowe = cowe;
    }

    /**
     * @return the coae
     */
    public Number getCoae() {
        return coae;
    }

    /**
     * @param coae the coae to set
     */
    public void setCoae(Number coae) {
        this.coae = coae;
    }
    
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String device;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    
    private Number so2we;
    private Number so2ae;
    private Number o3n2we;
    private Number o3n2ae;
    private Number no2we;
    private Number no2ae;
    private Number cowe;
    private Number coae;
    
    private Number rh;
    private Number temp;
    private Number press;
    

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
        if (!(object instanceof GasRead)) {
            return false;
        }
        GasRead other = (GasRead) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.GasRead[ id=" + id + " ]";
    }
    
}
