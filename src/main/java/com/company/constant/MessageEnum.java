package com.company.constant;

import java.io.Serializable;

public enum MessageEnum implements Serializable {
    LIST_FETCHED_SUCCESSFULLY("List fetched successfully"),
    OBJECT_FETCHED_SUCCESSFULLY("Data fetched successfully"),
    SAVE_SUCCESSFULLY("Saved successfully"),
    UPDATE_SUCCESSFULLY("Updated successfully"),
    DELETED_SUCCESSFULLY("Deleted successfully");

    private final String value;

    MessageEnum(String value) {
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
