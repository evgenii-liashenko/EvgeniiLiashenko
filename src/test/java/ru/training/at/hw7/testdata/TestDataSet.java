package ru.training.at.hw7.testdata;

import java.util.List;

public class TestDataSet {
    //Fields matching the json
    private List<Integer> summary;
    private String color;
    private List<String> elements;
    private String metals;
    private List<String> vegetables;


    //Constructor
    public TestDataSet(List<Integer> summary, String color, List<String> elements, String metals, List<String> vegetables) {
        this.summary = summary;
        this.color = color;
        this.elements = elements;
        this.metals = metals;
        this.vegetables = vegetables;
    }

    //String representation
    @Override
    public String toString(){
        return "Data set values:\n" +
                "summary = " + summary + ";\n" +
                "color = " + color + ";\n" +
                "elements = " + elements + ";\n" +
                "metals = " + metals + ";\n" +
                "vegetables = " + vegetables;
    }

    //Getters and setters
    public List<Integer> getSummary() {
        return summary;
    }
    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public List<String> getElements() {
        return elements;
    }
    public void setElements(List<String> elements) {
        this.elements = elements;
    }
    public String getMetals() {
        return metals;
    }
    public void setMetals(String metals) {
        this.metals = metals;
    }
    public List<String> getVegetables() {
        return vegetables;
    }
    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}
