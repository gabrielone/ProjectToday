package com.infosys.barniv1.client.responses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by andrei on 24.02.18.
 */
public class ContextResponseParameters {

    @SerializedName("List_item")
    @Expose
    private List<String> listItem = null;

    @SerializedName("List_item.original")
    @Expose
    private String listItemOriginal = null;

    public List<String> getListItem() {
        return listItem;
    }

    public void setListItem(List<String> listItem) {
        this.listItem = listItem;
    }

    public String getListItemOriginal() {
        return listItemOriginal;
    }

    public void setListItemOriginal(String listItemOriginal) {
        this.listItemOriginal = listItemOriginal;
    }

}