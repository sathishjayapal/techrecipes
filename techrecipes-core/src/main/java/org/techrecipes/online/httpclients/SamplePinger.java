package org.techrecipes.online.httpclients;

import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;

public class SamplePinger {
    public static final String Sathish_Website= "https://sathishjayapal.me";
    public void checkSiteStatus(){
        HttpClient httpClient= HttpClientBuilder.create().build();
        try {
            HttpResponse httpResponse= httpClient.execute(new HttpGet(Sathish_Website));
            HeaderElement headerElement[] = httpResponse.getEntity().getContentType().getElements();
            for(HeaderElement headerElement1:headerElement){
                System.out.println(headerElement1.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
