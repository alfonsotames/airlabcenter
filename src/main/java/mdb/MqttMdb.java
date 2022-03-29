/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mdb;
//import events.TestEvent;
//import events.TestEventQualifier;
import controllers.AirLabController;
import fish.payara.cloud.connectors.mqtt.api.MQTTListener;
import fish.payara.cloud.connectors.mqtt.api.OnMQTTMessage;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 *
 * @author mufufu
 */

@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "serverURIs", propertyValue = "tcp://74.208.53.197:1883"),
    @ActivationConfigProperty(propertyName = "cleanSession", propertyValue = "false"),
    @ActivationConfigProperty(propertyName = "automaticReconnect", propertyValue = "true"),
    @ActivationConfigProperty(propertyName = "filePersistence", propertyValue = "false"),
    @ActivationConfigProperty(propertyName = "connectionTimeout", propertyValue = "30"),
    @ActivationConfigProperty(propertyName = "maxInflight", propertyValue = "3"),
    @ActivationConfigProperty(propertyName = "keepAliveInterval", propertyValue = "5"),
    @ActivationConfigProperty(propertyName = "topicFilter", propertyValue = "application/3/device/+/event/up"),
    @ActivationConfigProperty(propertyName = "qos", propertyValue = "1")
})

public class MqttMdb implements MQTTListener {

    private static final Logger LOG = Logger.getLogger(MqttMdb.class.getName());

    
/*    
    @Inject
    @TestEventQualifier
    Event<TestEvent> testEvent;
*/    
    @Inject
    AirLabController alc;
    
    @OnMQTTMessage
    public void getMessageTest(String topic, MqttMessage message) {
        String msg = new String(message.getPayload());
        System.out.println("Topic: " + topic);
        System.out.println("Message: " + msg);
        System.out.println();
        LOG.info("Persisting from the MDB...");
        alc.storeData(new String(message.getPayload()));
        
        /*
        TestEvent te = new TestEvent(new String(message.getPayload()));
        testEvent.fire(te);
        */
    }
}