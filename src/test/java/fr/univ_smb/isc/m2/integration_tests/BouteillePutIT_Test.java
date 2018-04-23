package fr.univ_smb.isc.m2.integration_tests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedReader;
import org.apache.http.HttpResponse;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
        
import static org.apache.http.HttpStatus.SC_OK;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class BouteillePutIT_Test {


   @Test
    public void should_200_On_Bouteille_Modification() throws IOException, URISyntaxException {
        
        HttpUriRequest request = new HttpPut(new URL("http://localhost:"+8080+"/api/bouteilles/1?nom=Test&region=Test&annee=2000").toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

    @Test
    public void should_Change_The_Bottle() throws IOException, URISyntaxException {

        
        
        HttpUriRequest request = new HttpPut(new URL("http://localhost:"+8080+"/api/bouteilles/4?nom=Test&region=Test&annee=2000").toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        String result = rd.readLine();
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result);
        
        assertEquals(rootNode.get("nom").asText(), "Test");
        assertEquals(rootNode.get("region").asText(), "Test");
        assertEquals(rootNode.get("annee").asText(), "2000");
        assertEquals(rootNode.get("photo").asText(), "bouteille.jpg");


    }
}
