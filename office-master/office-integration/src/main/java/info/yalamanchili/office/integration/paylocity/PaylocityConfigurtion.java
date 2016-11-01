/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.integration.paylocity;

import info.chili.spring.SpringContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Component;

/**
 *
 * @author ayalamanchili
 */
@Component
public class PaylocityConfigurtion {

    @Value("#{officeExternalServicesProperties['paylocity.token.endpoint']}")
    protected String paylocityTokenEndpoint;

    @Value("#{officeExternalServicesProperties['paylocity.api.endpoint']}")
    protected String paylocityApiEnpoint;

    @Value("#{officeExternalServicesProperties['paylocity.clientid']}")
    protected String paylocityClientId;

    @Value("#{officeExternalServicesProperties['paylocity.clientsecret']}")
    protected String paylocityClientSecret;

    @ManagedAttribute
    public String getPaylocityTokenEndpoint() {
        return paylocityTokenEndpoint;
    }

    public void setPaylocityTokenEndpoint(String paylocityTokenEndpoint) {
        this.paylocityTokenEndpoint = paylocityTokenEndpoint;
    }

    @ManagedAttribute
    public String getPaylocityApiEnpoint() {
        return paylocityApiEnpoint;
    }

    public void setPaylocityApiEnpoint(String paylocityApiEnpoint) {
        this.paylocityApiEnpoint = paylocityApiEnpoint;
    }

    @ManagedAttribute
    public String getPaylocityClientId() {
        return paylocityClientId;
    }

    public void setPaylocityClientId(String paylocityClientId) {
        this.paylocityClientId = paylocityClientId;
    }

    @ManagedAttribute
    public String getPaylocityClientSecret() {
        return paylocityClientSecret;
    }

    public void setPaylocityClientSecret(String paylocityClientSecret) {
        this.paylocityClientSecret = paylocityClientSecret;
    }

    public static PaylocityConfigurtion instance() {
        return SpringContext.getBean(PaylocityConfigurtion.class);
    }
}
