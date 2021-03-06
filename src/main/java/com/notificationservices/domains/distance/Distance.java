package com.notificationservices.domains.distance;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
public class Distance {
    private String text;

    private String value;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Distance{" +
                "text='" + text + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
