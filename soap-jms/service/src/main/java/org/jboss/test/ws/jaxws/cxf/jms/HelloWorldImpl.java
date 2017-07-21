

package org.jboss.test.ws.jaxws.cxf.jms;
 
import javax.jws.WebService;
 
@WebService
(
   portName = "HelloWorldImplPort",
   serviceName = "HelloWorldServiceLocal",
   wsdlLocation = "WEB-INF/wsdl/HelloWorldService.wsdl",
   endpointInterface = "org.jboss.test.ws.jaxws.cxf.jms.HelloWorld",
   targetNamespace = "http://org.jboss.ws/jaxws/cxf/jms"
)
public class HelloWorldImpl implements HelloWorld
{
   public String echo(String input)
   {
	   // Testing a SOAP Fault
	   if (input.equals("error")) throw new RuntimeException("Runtime error!");
	   
	   return "Hello " + input;
   }
}