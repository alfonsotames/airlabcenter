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
public class GasRead implements Serializable {

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
    public BigDecimal getSo2we() {
        return so2we;
    }

    /**
     * @param so2we the so2we to set
     */
    public void setSo2we(BigDecimal so2we) {
        this.so2we = so2we;
    }

    /**
     * @return the so2ae
     */
    public BigDecimal getSo2ae() {
        return so2ae;
    }

    /**
     * @param so2ae the so2ae to set
     */
    public void setSo2ae(BigDecimal so2ae) {
        this.so2ae = so2ae;
    }

    /**
     * @return the o3n2we
     */
    public BigDecimal getO3n2we() {
        return o3n2we;
    }

    /**
     * @param o3n2we the o3n2we to set
     */
    public void setO3n2we(BigDecimal o3n2we) {
        this.o3n2we = o3n2we;
    }

    /**
     * @return the o3n2ae
     */
    public BigDecimal getO3n2ae() {
        return o3n2ae;
    }

    /**
     * @param o3n2ae the o3n2ae to set
     */
    public void setO3n2ae(BigDecimal o3n2ae) {
        this.o3n2ae = o3n2ae;
    }

    /**
     * @return the no2we
     */
    public BigDecimal getNo2we() {
        return no2we;
    }

    /**
     * @param no2we the no2we to set
     */
    public void setNo2we(BigDecimal no2we) {
        this.no2we = no2we;
    }

    /**
     * @return the no2ae
     */
    public BigDecimal getNo2ae() {
        return no2ae;
    }

    /**
     * @param no2ae the no2ae to set
     */
    public void setNo2ae(BigDecimal no2ae) {
        this.no2ae = no2ae;
    }

    /**
     * @return the cowe
     */
    public BigDecimal getCowe() {
        return cowe;
    }

    /**
     * @param cowe the cowe to set
     */
    public void setCowe(BigDecimal cowe) {
        this.cowe = cowe;
    }

    /**
     * @return the coae
     */
    public BigDecimal getCoae() {
        return coae;
    }

    /**
     * @param coae the coae to set
     */
    public void setCoae(BigDecimal coae) {
        this.coae = coae;
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
    private BigDecimal so2we;
    @Column(precision = 10, scale = 2)
    private BigDecimal so2ae;
    @Column(precision = 10, scale = 2)
    private BigDecimal o3n2we;
    @Column(precision = 10, scale = 2)
    private BigDecimal o3n2ae;
    @Column(precision = 10, scale = 2)
    private BigDecimal no2we;
    @Column(precision = 10, scale = 2)
    private BigDecimal no2ae;
    @Column(precision = 10, scale = 2)
    private BigDecimal cowe;
    @Column(precision = 10, scale = 2)
    private BigDecimal coae;
    
    @Column(precision = 10, scale = 2)
    private BigDecimal rh;
    @Column(precision = 10, scale = 2)
    private BigDecimal temp;
    @Column(precision = 10, scale = 2)
    private BigDecimal press;
    

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
