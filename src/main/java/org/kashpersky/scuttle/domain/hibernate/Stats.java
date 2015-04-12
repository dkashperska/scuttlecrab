package org.kashpersky.scuttle.domain.hibernate;

import javax.persistence.*;

@Entity(name = "ChampionStats")
public class Stats {

    //TODO: finish this entity
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "champion")
    private Champion champion;

    @Column(name = "attackrange")
    private Double attackrange;

    @Column(name = "mpperlevel")
    private Double mpperlevel;

    @Column(name = "mp")
    private Double mp;

    @Column(name = "attackdamage")
    private Double attackdamage;

    @Column(name = "hp")
    private Double hp;

    @Column(name = "hpperlevel")
    private Double hpperlevel;

    @Column(name = "attackdamageperlevel")
    private Double attackdamageperlevel;

    @Column(name = "armor")
    private Double armor;

    @Column(name = "mpregenperlevel")
    private Double mpregenperlevel;

    @Column(name = "hpregen")
    private Double hpregen;

    @Column(name = "critperlevel")
    private Double critperlevel;

    @Column(name = "spellblockperlevel")
    private Double spellblockperlevel;

    @Column(name = "mpregen")
    private Double mpregen;

    @Column(name = "attackspeedperlevel")
    private Double attackspeedperlevel;

    @Column(name = "spellblock")
    private Double spellblock;

    @Column(name = "movespeed")
    private Double movespeed;

    @Column(name = "attackspeedoffset")
    private Double attackspeedoffset;

    @Column(name = "crit")
    private Double crit;

    @Column(name = "hpregenperlevel")
    private Double hpregenperlevel;

    @Column(name = "armorperlevel")
    private Double armorperlevel;

    public Integer getId() {
        return id;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }
}
