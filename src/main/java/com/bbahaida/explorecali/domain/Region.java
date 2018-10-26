package com.bbahaida.explorecali.domain;

public enum Region {
    Northern_California("Northern California"), Southern_California("Southern California"), Central_Coast("Central Coast"), Varies("Varies");
    private String label;
    private Region(String label){ this.label = label;}

    public static Region findByLabel(String label){
        for (Region r : Region.values()) {
            if (r.label.equalsIgnoreCase(label))
                return r;
        }
        return null;
    }
}
