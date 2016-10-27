/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.yalamanchili.office.server;

import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import java.io.IOException;
import java.io.InputStreamReader;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.ResponseErrorHandler;

/**
 *
 * @author ayalamanchili
 */
public class ServiceExceptionResponseHandler implements ResponseErrorHandler {

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        throw new RuntimeException(CharStreams.toString(new InputStreamReader(response.getBody(), Charsets.UTF_8)));
    }

    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().value() >= 400) {
            return true;
        } else {
            return false;
        }
    }
}
