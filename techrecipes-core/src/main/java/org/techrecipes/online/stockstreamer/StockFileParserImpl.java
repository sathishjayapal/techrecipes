package org.techrecipes.online.stockstreamer;

import net.sf.flatpack.DataError;
import net.sf.flatpack.DataSet;
import net.sf.flatpack.DefaultParserFactory;
import net.sf.flatpack.Parser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by sjayapal on 5/5/2017.
 */
public class StockFileParserImpl implements StockFileParser {
    public String stockTickrSymbolFileName;
    public LocalDate todayDate;
    Logger logger = LoggerFactory.getLogger(StockFileParserImpl.class);

    @Override
    public void parseStockFile(String fileName) {
        Reader byteArrayReader = null;
        Iterator errors;
        DataError dataError;
        Reader mappingReader = null;
        List<StockDetailData> stockDTODataList = new ArrayList();
        logger.debug("Started file parsing");
        try {
            InputStreamReader ios = new InputStreamReader(StockFileParserImpl.class.getResourceAsStream("/stocks3275081060503613123.txt"));
            Parser pzparser = null;
            mappingReader = new InputStreamReader(
                    StockFileParserImpl.class.getResourceAsStream("/stockfileparser.pzmap.xml"));
            pzparser = DefaultParserFactory.getInstance()
                    .newDelimitedParser(mappingReader, byteArrayReader, '|', '\"', Boolean.FALSE);
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
                    stockDetailData -> System.out.println(stockDetailData.getBusinessName()));
            logger.error("Total information is " + stockDTODataList.size());
        } catch (UnsupportedEncodingException e1) {
            logger.error("IOException  parsing file" + e1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
            if (byteArrayReader != null) {
                try {
                    byteArrayReader.close();
                } catch (IOException e) {
                    logger.error("Data File reader not closed" + e.toString());
                }
            }
        }
    }
}
