package org.kashpersky.scuttle.domain.mongo;

public class ChampionChanges {
    
    private String name;
    
    private String general;
    
    private String passive;
    
    private String qSkill;

    private String wSkill;

    private String eSkill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneral() {
        return general;
    }

    public void setGeneral(String general) {
        this.general = general;
    }

    public String getPassive() {
        return passive;
    }

    public void setPassive(String passive) {
        this.passive = passive;
    }

    public String getQSkill() {
        return qSkill;
    }

    public void setQSkill(String qSkill) {
        this.qSkill = qSkill;
    }

    public String getWSkill() {
        return wSkill;
    }

    public void setWSkill(String wSkill) {
        this.wSkill = wSkill;
    }

    public String getESkill() {
        return eSkill;
    }

    public void setESkill(String eSkill) {
        this.eSkill = eSkill;
    }

    public String getRSkill() {
        return rSkill;
    }

    public void setRSkill(String rSkill) {
        this.rSkill = rSkill;
    }

    private String rSkill;
}
