/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import entities.GasRead;
import java.util.Base64;

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
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.Locale;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.LineChartModel;
import org.primefaces.model.chart.LineChartSeries;

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
    

    public LineChartModel getChartModel(String device, String sensor) {
        LineChartModel chartModel = new LineChartModel();
        LineChartSeries series = new LineChartSeries();
        
        if (sensor.equals("PM10")) {
            List<OPCRead> lista = 
                    em.createQuery("select o from OPCRead o where o.device=?1")
                    .setParameter(1, device).setMaxResults(1500).getResultList();
            int c=0;
            for (OPCRead o : lista) {
                double val = (o.getPm10().doubleValue()*1.6)+11;
                series.set(c, val);
                c++;
            }
            chartModel.addSeries(series);
            chartModel.setTitle(sensor);
            return chartModel;
        }
        
        if (sensor.equals("PM25")) {
            List<OPCRead> lista = 
                    em.createQuery("select o from OPCRead o where o.device=?1")
                    .setParameter(1, device).setMaxResults(1500).getResultList();
            int c=0;
            for (OPCRead o : lista) {
                double val = (o.getPm25().doubleValue()*1.6)+11;
                series.set(c, val);
                c++;
            }
            chartModel.addSeries(series);
            chartModel.setTitle(sensor);
            return chartModel;
        }        
        
        List<GasRead> lista = 
                em.createQuery("select g from GasRead g where g.device=?1")
                        .setParameter(1, device).setMaxResults(1500).getResultList();
        int c=0;
        for (GasRead g : lista) {
            if (sensor.equals("SO2")) {
                double val =  ((g.getSo2we().doubleValue())-331)*0.4;
                if (val > 0.0) {
                    series.set(c, val);
                }
                c++;                
            }
            if (sensor.equals("O3")) {
                double val =  ((g.getO3n2we().doubleValue())+25)*2;
                if (val > 0.0) {
                    series.set(c, val);
                }
                c++;                
            }
            if (sensor.equals("NO2")) {
                double val =  ((g.getNo2we().doubleValue())-220)*1.2;
                if (val > 0.0) {
                    series.set(c, val);
                }
                c++;                
            }
            if (sensor.equals("CO")) {
                double val =  ((g.getCowe().doubleValue())*0.002504)-0.7;
                if (val > 0.0) {
                    series.set(c, val);
                }
                c++;                
            }
            if (sensor.equals("TEMP")) {
                double val =  g.getTemp().doubleValue();
                series.set(c, val);
                c++;                
            }
            if (sensor.equals("RH")) {
                double val =  g.getRh().doubleValue();
                series.set(c, val);
                c++;                
            }
            if (sensor.equals("PRESS")) {
                double val =  g.getPress().doubleValue();
                series.set(c, val);
                c++;                
            }
            
            
        }
        chartModel.addSeries(series);
        chartModel.setTitle(sensor);
        return chartModel;
    }
    

    
    
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
            String[] d = decodedData.substring(0,decodedData.length()-1).split("\\|");
            /*
            for (String s : d) {
                LOG.info(s);
            }
            */
            if (port.equals(1)) {
                LOG.info("Port 1 - GasRead");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                Date date = null;
                /*
                if (d[0].equals("0000-00-00 00:00:00")) {
                    date = new Date();
                } else {
                    try {
                        date = formatter.parse(d[0]);
                    } catch (ParseException ex) {
                        Logger.getLogger(AirLabController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }*/
                
                date = Calendar.getInstance().getTime();
                
                GasRead gr = new GasRead();
                gr.setDevice(device);
                gr.setDate(date);
                gr.setSo2we(new BigDecimal(d[1]));
                gr.setSo2ae(new BigDecimal(d[2]));
                gr.setO3n2we(new BigDecimal(d[3]));
                gr.setO3n2ae(new BigDecimal(d[4]));
                gr.setNo2we(new BigDecimal(d[5]));
                gr.setNo2ae(new BigDecimal(d[6]));
                gr.setCowe(new BigDecimal(d[7]));
                gr.setCoae(new BigDecimal(d[8]));
                gr.setRh(new BigDecimal(d[9]));
                gr.setTemp(new BigDecimal(d[10]));
                gr.setPress(new BigDecimal(d[11]));                
                em.persist(gr);
                LOG.info("GasRead Stored");
            }
            if (port.equals(2)) {
                LOG.info("Port 1 - OPCRead");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", Locale.ENGLISH);
                Date date = null;
                /*
                if (d[0].equals("0000-00-00 00:00:00")) {
                    date = new Date();
                } else {
                    try {
                        date = formatter.parse(d[0]);
                    } catch (ParseException ex) {
                        Logger.getLogger(AirLabController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                */
                date = Calendar.getInstance().getTime();
                
                OPCRead or = new OPCRead();
                try {
                or.setDevice(device);
                or.setDate(date);
                or.setPeriod(new BigDecimal(d[1]));
                or.setGf(new BigDecimal(d[2]));
                or.setPm1(new BigDecimal(d[3]));
                or.setPm10(new BigDecimal(d[4]));
                or.setPm25(new BigDecimal(d[5]));
                or.setRh(new BigDecimal(d[6]));
                or.setTemp(new BigDecimal(d[7]));
                or.setPress(new BigDecimal(d[8]));
                } catch(NumberFormatException e) {
                    LOG.log(Level.SEVERE, "Error at OPCRead init: {0}",e.getMessage());
                }
                em.persist(or);
                LOG.info("OPCRead Stored");
            }           
        } catch (JsonProcessingException ex) {
            Logger.getLogger(AirLabController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
