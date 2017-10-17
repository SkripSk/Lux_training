package com.luxoft.sqa.model;

import jdk.nashorn.internal.runtime.OptimisticReturnFilters;

public class GroupData {

    String name;
    String header;
    String footer;
    String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {

        this.id = id;
    }

    public GroupData(String name, String header, String footer) {
        this.id = null;
        this.name = name;
        this.header = header;
        this.footer = footer;
    }

    public GroupData(String id, String name, String header, String footer) {
        this.name = name;
        this.header = header;
        this.footer = footer;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }





}
