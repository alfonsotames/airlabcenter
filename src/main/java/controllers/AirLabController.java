/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import entities.GasRead;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;


/**
 *
 * @author mufufu
 */
@Named(value="alc")
@Stateless
public class AirLabController {

    private static final Logger LOG = Logger.getLogger(AirLabController.class.getName());
    

    @PersistenceContext(unitName = "airlabPU")
    private EntityManager em;
    
    public void test() {
        LOG.info("Test invoked!");
        GasRead gr = new GasRead();
        gr.setDevice("testerion");
        em.persist(gr);
        LOG.info("He persistido");
    }
    
    public void test2(String msg) {
        LOG.info("Test2 invoked!");
        GasRead gr = new GasRead();
        gr.setDevice("testerention");
        em.persist(gr);
        LOG.info("He persistido");        
    }
    
    public void storeGasRead(String device, String data) {
        byte[] decodedBytes = Base64.getDecoder().decode(data);
        String decodedString = new String(decodedBytes);
        String[] d = decodedString.split("|");
        
        GasRead gr = new GasRead();
        gr.setDevice(device);
        gr.setDate(new Date());
        gr.setSo2we(Float.parseFloat(d[1]));
        gr.setSo2ae(Float.parseFloat(d[2]));
        gr.setO3n2we(Float.parseFloat(d[3]));
        gr.setO3n2ae(Float.parseFloat(d[4]));
        gr.setNo2we(Float.parseFloat(d[5]));
        gr.setNo2ae(Float.parseFloat(d[6]));
        gr.setCowe(Float.parseFloat(d[7]));
        gr.setCoae(Float.parseFloat(d[8]));
        gr.setRh(Float.parseFloat(d[9]));
        gr.setTemp(Float.parseFloat(d[10]));
        gr.setPress(Float.parseFloat(d[11]));
        
        LOG.log(Level.INFO, "Device: {0}", gr.getDevice());
        em.persist(gr);
        
    }
    
    public void storeOPCRead(String device, String data) {
        
    }
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void storeData(String msg) {
        LOG.log(Level.INFO, "Soy storeData y esto es mi payload: {0}", msg);
        /*
        GasRead gr = new GasRead();
        gr.setDevice("testedata");
        em.persist(gr);
        LOG.info("He persistido");
        */
        JSONObject jo = new JSONObject(msg);
        Number port = jo.getNumber("port");
        String data = jo.getString("data");
        String device = jo.getString("deviceName");
        if (port.equals(1)) {
            LOG.info("Port 1");
            
        }
    }
}
