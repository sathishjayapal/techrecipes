package org.techrecipes.online.stockstreamer;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;

/**
 * Created by sjayapal on 12/21/2016.
 */
public class StockTicklrSampleImpl implements StockTicklrSample {
    @Override
    public Optional<StockDetailData> getPrice(String symbol) {
        Instant start = Instant.now();
        URL symbolURL = null;
        Optional returnVal = Optional.empty();
        try {
            HttpClient httpClient = HttpClientBuilder.create().build();
            String tickr = "https://api.robinhood.com/fundamentals/MSFT/";
            HttpResponse httpResponse = httpClient.execute(new HttpGet(tickr));
            HttpEntity entity = httpResponse.getEntity();
            String returnStr = getStringFromInputStream(entity.getContent());
            System.out.println("The return str is " + returnStr);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String collectedStr = buildDataString(symbolURL);
        Optional someCrapStr = Optional.empty();
// = parseJSONToString(collectedStr);
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toMillis();
        System.out.println("The time taken is " + timeElapsed);
        return someCrapStr;
    }

    private static String getStringFromInputStream(InputStream is) {

        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {

            br = new BufferedReader(new InputStreamReader(is));
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();

    }


    private Optional<StockDetailData> parseJSONToString(String collectedStr) {
        System.out.println(collectedStr);
        JSONParser parser = new JSONParser();
        StockDetailData stockDetailData = new StockDetailData();
        Optional optionalData = Optional.ofNullable(stockDetailData);
        try {
            JSONObject jsonObject = (JSONObject) parser.parse(collectedStr.toString());
            stockDetailData.setStockid("id");
            stockDetailData
                    .setStockTickr((String) ObjectUtils.defaultIfNull(jsonObject.get("t"), "NA"));
            stockDetailData.setStockExchange(
                    (String) ObjectUtils.defaultIfNull(jsonObject.get("e"), "0L"));
            stockDetailData.setCurrentdaylow(
                    (String) ObjectUtils.defaultIfNull(jsonObject.get("l"), "0L"));
            stockDetailData.setTodayFixed(
                    (String) ObjectUtils.defaultIfNull(jsonObject.get("l_fix"), "0L"));
            stockDetailData.setStockPriceDateTime(
                    (String) ObjectUtils.defaultIfNull(jsonObject.get("lt_dts"), "0L"));
            stockDetailData
                    .setTodayChange((String) ObjectUtils.defaultIfNull(jsonObject.get("c"), "0L"));
            Optional.of(stockDetailData);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return optionalData;
    }

    private String buildDataString(URL inputurl) {
        StringBuilder finalInputLine = new StringBuilder();
        String inputLine;
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(inputurl.openStream()));
            while ((inputLine = in.readLine()) != null) {
                if (inputLine != null) {
                    finalInputLine = finalInputLine.append(inputLine);
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String collectedStr = finalInputLine.toString();
        collectedStr = StringUtils.replace(collectedStr, "[", "");
        collectedStr = StringUtils.replace(collectedStr, "]", "");
        collectedStr = StringUtils.replace(collectedStr, "//", "");
        return collectedStr;
    }
}
