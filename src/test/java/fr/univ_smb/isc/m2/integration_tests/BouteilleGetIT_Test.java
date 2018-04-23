package fr.univ_smb.isc.m2.integration_tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
        
import static org.apache.http.HttpStatus.SC_NOT_FOUND;
import static org.apache.http.HttpStatus.SC_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class BouteilleGetIT_Test {


    @Test
    public void should_200_On_All_Bouteilles() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpGet(new URL("http://localhost:"+8080+"/api/bouteilles").toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
        
    }
    
    @Test
    public void should_200_On_Existing_Bouteille() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpGet(new URL("http://localhost:"+8080+"/api/bouteilles/" + 1).toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);
        
    }

    @Test
    public void should_404_On_Non_Existing_Bouteille() throws IOException, URISyntaxException {

        HttpUriRequest request = new HttpGet(new URL("http://localhost:"+8080+"/api/bouteilles/" + 99999).toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_NOT_FOUND);

    }
    
    @Test
    public void should_Have_The_Good_Amount_Of_Attributes() throws IOException, URISyntaxException
    {
        HttpUriRequest request = new HttpGet(new URL("http://localhost:"+8080+"/api/bouteilles/" + 1).toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);
        
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        String result = rd.readLine();
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result);
        
        assertEquals(rootNode.get("id").asText(), "1");
        assertEquals(rootNode.size(), 5);
        
    }
}
