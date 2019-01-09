package org.techrecipes.online.streams;
import org.apache.commons.lang3.StringUtils;

/**
 * Created by sjayapal on 12/14/2016.
 */
public class CollectionsSample {
    public static boolean inTexas(CollectionsSampleData collectionsSampleData) {
        return StringUtils.equalsIgnoreCase(collectionsSampleData.getState(), "TX");
    }
    public static boolean inIL(CollectionsSampleData collectionsSampleData) {
        return StringUtils.equalsIgnoreCase(collectionsSampleData.getState(), "IL");
    }
}
