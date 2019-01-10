package org.techrecipes.online.httpclients;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingClientConnectionManager;
import org.apache.http.ssl.TrustStrategy;

import java.io.IOException;

import static org.apache.http.conn.ssl.SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER;

public class SamplePinger {
    public static final String Google_Website = "https://sathishjayapal.me";

    public void checkSiteStatus() {
        HttpClient httpClient = HttpClientBuilder.create().build();
        try {
            HttpResponse httpResponse = httpClient.execute(new HttpGet(Google_Website));
            Header[] headers = httpResponse.getAllHeaders();
            for (Header header : headers) {
                System.out.println("Key : " + header.getName()
                        + " ,Value : " + header.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
