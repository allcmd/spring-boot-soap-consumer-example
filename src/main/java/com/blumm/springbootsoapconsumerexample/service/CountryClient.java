package com.blumm.springbootsoapconsumerexample.service;

import com.blumm.generated.wsdl.GetCountryRequest;
import com.blumm.generated.wsdl.GetCountryResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Slf4j
public class CountryClient extends WebServiceGatewaySupport {

    public GetCountryResponse getCountryResponse(String country) {

        GetCountryRequest request = new GetCountryRequest();
        request.setName(country);

        log.info("Requesting object for: " + country);

        return (GetCountryResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http://localhost:8080/ws/countries", request, new SoapActionCallback("http://blumm.com/producing-ws/GetCountryRequest"));
    }

}
