package org.jboss.as.quickstarts.jms;

import javax.jms.*;

public class ResponseListener implements MessageListener {
	 public void onMessage(Message message) {
	        String messageText = null;
	        try {
	            if (message instanceof TextMessage) {
	                TextMessage textMessage = (TextMessage) message;
	                messageText = textMessage.getText();
	                System.out.println("messageText = " + messageText);
	            }
	        } catch (JMSException e) {
	            //Handle the exception appropriately
	        }
	    }
}
