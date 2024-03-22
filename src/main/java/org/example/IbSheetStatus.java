package org.example;

public enum IbSheetStatus {
    I,
    U,
    D;

    public static IbSheetStatus from(String value) {
        for (IbSheetStatus ibSheetStatus : values()) {
            if (ibSheetStatus.name().equals(value))
                return ibSheetStatus;
        }
        return null;
    }

}
