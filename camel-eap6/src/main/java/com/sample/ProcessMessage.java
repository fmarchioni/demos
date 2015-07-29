/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sample;

import java.util.List;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.spi.BrowsableEndpoint;

/**
 *
 * @author francesco
 */
public class ProcessMessage {
    private CamelContext context;
 
 public void browse() {
     
     BrowsableEndpoint browse = context.getEndpoint("browse:orderReceived", BrowsableEndpoint.class);
      List<Exchange> exchanges = browse.getExchanges();
     
     // then we can inspect the list of received exchanges from Java
     for (Exchange exchange : exchanges) {
          String payload = (String) exchange.getIn().getBody();
        System.out.println(payload);
      }
}
}
