package com.example.mongo.demo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document("rice_production")
public class RiceProductionData {

    @Id
    private String id;
    @Field("Area")
    private String area;
    @Field("Year")
    private String year;
    @Field("Unit")
    private String unit;
    @Field("Value")
    private String value;
    @Field("Flag")
    private String flag;
    @Field("Flag Description")
    private String flagDescription;

    public RiceProductionData(String area, String year, String unit, String value, String flag, String flagDescription) {
        this.area = area;
        this.year = year;
        this.unit = unit;
        this.value = value;
        this.flag = flag;
        this.flagDescription = flagDescription;
    }

    public RiceProductionData() {

    }

    public static RiceProductionData update(final String id, final RiceProductionData riceProductionData) {
        final RiceProductionData riceProductionDataUpdated =  new RiceProductionData();
        riceProductionDataUpdated.setId(id);
        riceProductionDataUpdated.setArea(riceProductionData.getArea() == null? null : riceProductionData.getArea());
        riceProductionDataUpdated.setFlag(riceProductionData.getFlag() == null? null : riceProductionData.getFlag());
        riceProductionDataUpdated.setYear(riceProductionData.getYear() == null? null : riceProductionData.getYear());
        riceProductionDataUpdated.setUnit(riceProductionData.getUnit() == null? null : riceProductionData.getUnit());
        riceProductionDataUpdated.setValue(riceProductionData.getValue() == null? null : riceProductionData.getValue());
        riceProductionDataUpdated.setFlagDescription(riceProductionData.getFlagDescription() == null? null : riceProductionData.getFlagDescription());
        return riceProductionDataUpdated;
    }

    public String getId() {
        return id;
    }

    public String getArea() {
        return area;
    }

    public String getYear() {
        return year;
    }

    public String getUnit() {
        return unit;
    }

    public String getValue() {
        return value;
    }

    public String getFlag() {
        return flag;
    }

    public String getFlagDescription() {
        return flagDescription;
    }
}