package org.kashpersky.scuttle.domain.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.persistence.*;

@Entity(name = "Tips")
public class Tip {
    public static final Log log = LogFactory.getLog(Tip.class);

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "tip")
    private String tip;

    @Column(name = "type")
    @Enumerated(value = EnumType.ORDINAL)
    private TipType type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "champion")
    private Champion champion;

    public Integer getId() {
        return id;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        if (this.tip == null) {
            this.tip = tip;
        } else {
            log.error(String.format("Attempting to repeatedly set tip text for tip(text: %s, id: %i)", tip, id));
        }   
    }

    public TipType getType() {
        return type;
    }

    public void setType(TipType type) {
        this.type = type;
    }

    public Champion getChampion() {
        return champion;
    }

    public void setChampion(Champion champion) {
        this.champion = champion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tip tip1 = (Tip) o;

        if (tip != null ? !tip.equals(tip1.tip) : tip1.tip != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return tip != null ? tip.hashCode() : 0;
    }

    static enum TipType{
        ALLY,
        ENEMY
    }
}
