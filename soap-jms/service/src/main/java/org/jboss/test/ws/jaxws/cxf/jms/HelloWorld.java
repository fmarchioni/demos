package org.jboss.test.ws.jaxws.cxf.jms;

import javax.jws.WebService;

@WebService(targetNamespace = "http://org.jboss.ws/jaxws/cxf/jms")
public interface HelloWorld {
	 public String echo(String input);
}
