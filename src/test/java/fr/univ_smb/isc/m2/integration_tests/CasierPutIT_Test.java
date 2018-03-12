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

public class CasierPutIT_Test {


    @Test
    public void should_200_On_Locker_Modification() throws IOException, URISyntaxException {
        
        HttpUriRequest request = new HttpPut(new URL("http://localhost:"+8080+"/api/casiers/1?nom=Test").toURI());

        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

    @Test
    public void should_Change_The_Name_Of_The_Locker() throws IOException, URISyntaxException {

        
        
        HttpUriRequest request = new HttpPut(new URL("http://localhost:"+8080+"/api/casiers/1?nom=TestCasier").toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        String result = rd.readLine();
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result);
        
        assertEquals(rootNode.get("nom").asText(), "TestCasier");


    }

    @Test
    public void should_Change_Bottle_Quantity_Of_The_Locker() throws IOException, URISyntaxException {

        
        HttpUriRequest request = new HttpPut(new URL("http://localhost:"+8080+"/api/casiers/0?idBouteille=0&quantite=5").toURI());
        HttpResponse response = HttpClientBuilder.create().build().execute(request);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        String result = rd.readLine();
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result).get("contenu");
        
        assertEquals(rootNode.get("0").asText(), "5");


    }
}
