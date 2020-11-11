package com.blumm.springbootsoapconsumerexample.service;

import com.blumm.generated.wsdl.GetEmployeeRequest;
import com.blumm.generated.wsdl.GetEmployeeResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class EmployeeClient extends WebServiceGatewaySupport {

    public GetEmployeeResponse getEmployeeResponse(String name) {

        GetEmployeeRequest request = new GetEmployeeRequest();
        request.setName(name);

        log.info("Requesting object for: " + name);

        return (GetEmployeeResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/employees", request, new SoapActionCallback("http://blumm.com/producing-ws/GetEmployeeRequest"));
    }

}
