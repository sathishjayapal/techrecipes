package org.techrecipes.online.streams;
import com.github.javafaker.Faker;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
/**
 * Created by sjayapal on 12/14/2016.
 */
public class CollectionsSampleData {
    private String name;
    private String addressLine1;
    private String state;
    private String zipCode;
    private Integer custId;
    public CollectionsSampleData() {
        Faker fake = new Faker();
        this.name = fake
          .name()
          .fullName();
        this.addressLine1 = new StringBuilder()
          .append(fake
            .address()
            .buildingNumber())
          .append(" ")
          .append(fake
            .address()
            .streetName())
          .append(" ")
          .
            append(fake
              .address()
              .cityName())
          .toString();
        this.state = fake
          .address()
          .stateAbbr();
        this.zipCode = fake
          .address()
          .zipCode();
        this.custId = Integer.valueOf(fake
          .code()
          .isbnGs1());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddressLine1() {
        return addressLine1;
    }
    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public Integer getCustId() {
        return custId;
    }
    public void setCustId(Integer custId) {
        this.custId = custId;
    }
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SIMPLE_STYLE);
    }
}
