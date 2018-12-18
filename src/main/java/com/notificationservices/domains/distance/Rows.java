package com.notificationservices.domains.distance;

import java.util.Arrays;

/**
 * @author Ehtiram_Abdullayev on 18.12.2018
 * @project notificationservices
 */
public class Rows {
    private Elements[] elements;

    public Elements[] getElements() {
        return elements;
    }

    public void setElements(Elements[] elements) {
        this.elements = elements;
    }

    @Override
    public String toString() {
        return "Rows{" +
                "elements=" + Arrays.toString(elements) +
                '}';
    }
}
