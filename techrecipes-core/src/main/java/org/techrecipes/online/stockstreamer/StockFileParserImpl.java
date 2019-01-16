package org.techrecipes.online.stockstreamer;

import net.sf.flatpack.DataError;
import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.field.MillisDurationField;
import org.joda.time.format.DateTimeFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import scala.sys.Prop;

import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by sjayapal on 5/5/2017.
 */
public class StockFileParserImpl implements StockFileParser {
    public String stockTickrSymbolFileName;
    public LocalDate todayDate;
    static final Logger logger = LoggerFactory.getLogger(StockFileParserImpl.class);

    /**
     * Stock file Name parser.
     *
     * @param fileName
     */
    public int parseStockFile(String fileName) {
        logger.debug("Started file parsing");
        int returnData = -1;
        Iterator errors;
        DataError dataError;
        Reader mappingReader = null;
        Instant startTime = Instant.now();
        List<StockDetailData> stockDTODataList = new ArrayList();
        try {
            defaultProperties();
            String dailyDownloadPathName = (String) propertiesData.get("tickrfilepath.pathname");
            String pathname = dailyDownloadPathName + "stocks" + DateTimeFormat.forPattern("MMDDYYYY").print(new DateTime()) + ".txt";
            String previousDayFilePath = dailyDownloadPathName + "stocks" + DateTimeFormat.forPattern("MMDDYYYY").print((new DateTime().minusDays(1))) + ".txt";
            if (StringUtils.isEmpty(dailyDownloadPathName)) {
                logger.error("Cannot load properties file. Unknown location to parse file");
            } else {
                File dailyDownloadFile = new File(pathname);
                if (!dailyDownloadFile.exists())
                    dailyDownloadFile = new File(previousDayFilePath);
                else{

                }
                if (dailyDownloadFile.exists()) {
                    InputStreamReader ios = new FileReader(dailyDownloadFile);
                    Parser pzparser = null;
                    String pzmapFile = (String) propertiesData.get("tickrfilepath.parserXMLLayout");
                    mappingReader = new InputStreamReader(
                            StockFileParserImpl.class.getResourceAsStream(pzmapFile));
                    pzparser = DefaultParserFactory.getInstance()
                            .newDelimitedParser(mappingReader, ios, '|', '\"', Boolean.FALSE);
                    pzparser.setStoreRawDataToDataSet(true);
                    pzparser.setHandlingShortLines(true);
                    final DataSet ds = pzparser.parse();
                    if (ds.getErrors() != null && ds.getErrors().size() > 0) {
                        errors = ds.getErrors().iterator();
                        while (errors.hasNext()) {
                            dataError = (DataError) errors.next();
                            if (dataError.getErrorLevel() == 2 || dataError.getErrorLevel() == 3) {
                                logger.error(
                                        "ERROR: " + dataError.getErrorDesc() + " LINE NUMBER: " + dataError
                                                .getLineNo());
                            }
                        }
                    }
                    List<DataError> dataErrors = ds.getErrors();
                    final Optional<DataError> first = dataErrors.stream()
                            .filter(dError -> dError.getErrorLevel() == 2 || dError.getErrorLevel() == 3)
                            .findFirst();
                    if (first.isPresent()) {
                        throw new Exception("Invalid entries in file.");
                    }
                    while (ds.next()) {
                        if (ds.getRowNo() == 1) {
                            logger.debug(">>>>found header");
                        } else {
                            StockDetailData stockDetailData = new StockDetailData();
                            stockDetailData.setStockid(ds.getString("Symbol"));
                            stockDetailData.setBusinessName(ds.getString("Security Name"));
                            stockDetailData.setStockExchange(ds.getString("Listing Exchange"));
                            stockDTODataList.add(stockDetailData);
                        }
                    }
                    StockStreamSplitIterator stockStreamSplitIterator = new StockStreamSplitIterator(
                            stockDTODataList);
                    Stream<StockDetailData> stream = StreamSupport.stream(stockStreamSplitIterator, true);
                    stream.forEach(
                            stockDetailData -> logger.debug(stockDetailData.getBusinessName()));
                } else {
                    logger.error("No files to process for lookups.");
                }
            }
            returnData = stockDTODataList.size();
        } catch (UnsupportedEncodingException e1) {
            logger.error("IOException  parsing file" + e1);
        } catch (FileNotFoundException e) {
            logger.error("FileNotFoundException  parsing file" + e);
        } catch (IOException e) {
            logger.error("IOException  parsing file" + e);
        } catch (Exception excep) {
            logger.error("Exception parsing file ", excep);
        } finally {
            if (mappingReader != null) {
                try {
                    mappingReader.close();
                } catch (IOException e) {
                    logger.error("Mapping reader not closed" + e.toString());
                }
            }
        }
        Instant endTime = Instant.now();
        int periodTime = MillisDurationField.INSTANCE.getDifference(endTime.getMillis(), startTime.getMillis());
        logger.debug("Time taken to parse file to object is " + periodTime + " milli seconds");
        return returnData;
    }
}
