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
import java.util.ArrayList;
        
import static org.apache.http.HttpStatus.SC_OK;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;

public class CasierPostIT_Test {


    @Test
    public void should_200_On_Casier_Creation() throws IOException, URISyntaxException {

        HttpPost httpPost = new HttpPost(new URL("http://localhost:" + 8080 + "/api/casiers").toURI());
        ArrayList<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("nom", "Casier Test"));
        httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
        HttpResponse response = HttpClientBuilder.create().build().execute(httpPost);

        assertThat(response.getStatusLine().getStatusCode()).isEqualTo(SC_OK);

    }

    @Test
    public void should_Have_Correct_Attributes() throws IOException, URISyntaxException {

        HttpPost httpPost = new HttpPost(new URL("http://localhost:" + 8080 + "/api/casiers").toURI());
        ArrayList<NameValuePair> postParameters = new ArrayList<>();
        postParameters.add(new BasicNameValuePair("nom", "Nom casier"));
        httpPost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));
        HttpResponse response = HttpClientBuilder.create().build().execute(httpPost);
        
        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));
        
        String result = rd.readLine();
        
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(result);
        
        assertEquals(rootNode.get("nom").asText(), "Nom casier");
        assertEquals(rootNode.get("contenu").asText(), "");
        assertEquals(rootNode.size(), 3);

    }
}
