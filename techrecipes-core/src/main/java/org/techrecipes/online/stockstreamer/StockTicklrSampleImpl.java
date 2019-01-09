package org.techrecipes.online.stockstreamer;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Optional;
/**
 * Created by sjayapal on 12/21/2016.
 */
public class StockTicklrSampleImpl implements StockTicklrSample {
    @Override
    public Optional<StockDetailData> getPrice(String symbol) {
        URL symbolURL = null;
        Optional returnVal = Optional.empty();
        try {
            symbolURL = new URL("https://www.google.com/finance/info?q=NASDAQ%3a" + symbol);
        } catch (MalformedURLException e) {
            e.fillInStackTrace();
            return returnVal;
        } catch (IOException e) {
            e.fillInStackTrace();
            return returnVal;
        }
        String collectedStr = buildDataString(symbolURL);
        return parseJSONToString(collectedStr);
    }
    private Optional<StockDetailData> parseJSONToString(String collectedStr) {
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
