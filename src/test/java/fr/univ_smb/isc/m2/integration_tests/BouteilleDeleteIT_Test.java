package fr.univ_smb.isc.m2.integration_tests;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
        
import static org.apache.http.HttpStatus.SC_OK;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import static org.assertj.core.api.Assertions.assertThat;

public class BouteilleDeleteIT_Test {


    @Test
    public void should_200_On_Bouteille_Deletion() throws IOException, URISyntaxException {
        
        HttpUriRequest request = new HttpDelete(new URL("http://localhost:"+8080+"/api/bouteilles/2").toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

    @Test
    public void should_Not_Exist_Anymore() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpDelete(new URL("http://localhost:"+8080+"/api/bouteilles/3").toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        HttpUriRequest requestGet = new HttpGet(new URL("http://localhost:"+8080+"/api/bouteilles/3").toURI());
        HttpResponse responseGet = HttpClientBuilder.create().build().execute(requestGet);

        assertThat(responseGet.getStatusLine().getStatusCode()).isEqualTo(SC_NOT_FOUND);


    }
}
