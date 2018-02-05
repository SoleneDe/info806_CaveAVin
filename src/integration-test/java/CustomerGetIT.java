package fr.univ_smb.isc.m2.integration_tests;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;

public class CustomerGetIT {


    @Test
    public void should_200_On_Existing_Customer() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 9135 + "/api/customers/" + 5).toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

    @Test
    public void should_404_On_Non_Existing_Customer() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpGet(new URL("http://localhost:" + 9135 + "/api/customers/" + 1024).toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_NOT_FOUND);

    }
}
