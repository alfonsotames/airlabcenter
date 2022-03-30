/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
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
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import entities.OPCRead;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

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
        

        
        //JSONObject jo = new JSONObject(msg);

        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = mapper.readValue(msg, ObjectNode.class);
            String device = node.get("deviceName").asText();
            String data = node.get("data").asText();
            Number port = node.get("fPort").asInt();
            LOG.log(Level.INFO,"Device Name: {0}", device);
            LOG.log(Level.INFO,"Data: {0}", data);
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            String decodedData = new String(decodedBytes);
            LOG.log(Level.INFO, "Decoded Data: {0}", decodedData);
            String[] d = decodedData.split("\\|");
            /*
            for (String s : d) {
                LOG.info(s);
            }
            */
            if (port.equals(1)) {
                LOG.info("Port 1 - GasRead");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH);
                Date date = null;
                try {
                    date = formatter.parse(d[0]);
                } catch (ParseException ex) {
                    Logger.getLogger(AirLabController.class.getName()).log(Level.SEVERE, null, ex);
                }
                GasRead gr = new GasRead();
                gr.setDevice(device);
                gr.setDate(date);
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
                em.persist(gr);
                LOG.info("GasRead Stored");
            }
            if (port.equals(2)) {
                LOG.info("Port 1 - OPCRead");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss", Locale.ENGLISH);
                Date date = null;
                try {
                    date = formatter.parse(d[0]);
                } catch (ParseException ex) {
                    Logger.getLogger(AirLabController.class.getName()).log(Level.SEVERE, null, ex);
                }                
                OPCRead or = new OPCRead();
                or.setDevice(device);
                or.setDate(date);
                or.setPeriod(Float.parseFloat(d[1]));
                or.setGf(Float.parseFloat(d[2]));
                or.setPm1(Float.parseFloat(d[3]));
                or.setPm10(Float.parseFloat(d[4]));
                or.setPm25(Float.parseFloat(d[5]));
                or.setRh(Float.parseFloat(d[6]));
                or.setTemp(Float.parseFloat(d[7]));
                or.setPress(Float.parseFloat(d[8]));
                em.persist(or);
                LOG.info("OPCRead Stored");
            }           
        } catch (JsonProcessingException ex) {
            Logger.getLogger(AirLabController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
