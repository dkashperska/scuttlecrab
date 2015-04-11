package org.kashpersky.scuttle.domain.hibernate;

import javax.persistence.*;

@Entity(name = "ChampionInfo")
public class Info {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "defense")
    private Integer defense;

    @Column(name = "magic")
    private Integer magic;

    @Column(name = "difficulty")
    private Integer difficulty;

    @Column(name = "attack")
    private Integer attack;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "champion")
    private Champion champion;

    public Integer getId() {
        return id;
    }

    public Integer getDefense() {
        return defense;
    }

    public Info setDefense(Integer defense) {
        this.defense = defense;
        return this;
    }

    public Integer getMagic() {
        return magic;
    }

    public Info setMagic(Integer magic) {
        this.magic = magic;
        return this;
    }

    public Integer getDifficulty() {
        return difficulty;
    }

    public Info setDifficulty(Integer difficulty) {
        this.difficulty = difficulty;
        return this;
    }

    public Integer getAttack() {
        return attack;
    }

    public Info setAttack(Integer attack) {
        this.attack = attack;
        return this;
    }

    public Champion getChampion() {
        return champion;
    }

    public Info setChampion(Champion champion) {
        this.champion = champion;
        return this;
    }
}
