package org.kashpersky.scuttle.domain.hibernate;

import com.google.common.collect.Sets;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@Entity(name = "Champions")
public class Champion {
    public static final Log log = LogFactory.getLog(Champion.class);

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "externalId")
    private Integer externalId;
    
    @Column(name = "name")
    private String name;

    @Column(name = "title")
    private String title;

    @Column(name = "patch")
    private String patch;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "champion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Stats stats;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "champions")
    private Set<Tag> tags;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "champion", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "type = 0")
    private Set<Tip> allyTips;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "champion", cascade = CascadeType.ALL, orphanRemoval = true)
    @Where(clause = "type = 1")
    private Set<Tip> enemyTips;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "champion", cascade = CascadeType.ALL, orphanRemoval = true)
    private Info info;

    public Champion() {
        tags = new HashSet<>();
        allyTips = new HashSet<>();
        enemyTips = new HashSet<>();
    }

    public Integer getId() {
        return id;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public Champion setExternalId(Integer externalId) {
        if (this.externalId == null) {
            this.externalId = externalId;
        } else {
            log.error(String.format("Attempting to repeatedly set externalId for champion" +
                    "(name: %s,externald: %i, id: %i)", name, externalId, id));
        }
        return this;
    }

    public String getName() {
        return name;
    }

    public Champion setName(String name) {
        this.name = name;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Champion setTitle(String title) {
        this.title = title;
        return this;
    }

    public String getPatch() {
        return patch;
    }

    public Champion setPatch(String patch) {
        if (this.patch == null) {
            this.patch = patch;
        } else {
            log.error(String.format("Attempting to repeatedly set patch for champion" +
                    "(name: %s,patch: %s, id: %i)", name, patch, id));
        }
        return this;
    }

    public Stats getStats() {
        return stats;
    }

    public Champion setStats(Stats stats) {
        this.stats = stats;
        return this;
    }

    public Set<Tag> getTags() {
        return tags;
    }

    public Champion setTags(Set<Tag> tags) {
        this.tags = tags;
        return this;
    }

    public Set<Tip> getAllyTips() {
        return allyTips;
    }

    public Champion setAllyTips(Set<Tip> allyTips) {
        checkTipType(allyTips, Tip.TipType.ALLY);
        this.allyTips = allyTips;
        return this;
    }

    public Set<Tip> getEnemyTips() {
        return enemyTips;
    }

    public Champion setEnemyTips(Set<Tip> enemyTips) {
        checkTipType(enemyTips, Tip.TipType.ENEMY);
        this.enemyTips = enemyTips;
        return this;
    }

    public Info getInfo() {
        return info;
    }

    public Champion setInfo(Info info) {
        this.info = info;
        return this;
    }

    private void checkTipType(Set<Tip> tips, Tip.TipType type) {
        Iterator<Tip> it = tips.iterator();
        while (it.hasNext()) {
            Tip tip = it.next();
            if (!type.equals(tip.getType())) {
                it.remove();
                log.warn(String.format("Unexpected TipType. Champion: %s (id: %i)", this.name, this.id));
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Champion champion = (Champion) o;

        if (externalId != null ? !externalId.equals(champion.externalId) : champion.externalId != null) return false;
        if (patch != null ? !patch.equals(champion.patch) : champion.patch != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = externalId != null ? externalId.hashCode() : 0;
        result = 31 * result + (patch != null ? patch.hashCode() : 0);
        return result;
    }

    @PrePersist
    @PreUpdate
    private void updateCollectionReferences() {
        // Make sure stats and info are pointing to this champion entity
        if (stats.getChampion() != this) {
            stats.setChampion(this);
        }
        if (info.getChampion() != this) {
            info.setChampion(this);
        }
        // Make sure each tag contains this champions reference
        for (Tag tag : tags) {
            if (!tag.getChampions().contains(this)) {
                tag.getChampions().add(this);
            }
        }
        // Make sure each tip is pointing to this champion
        for (Tip tip : Sets.union(allyTips, enemyTips)) {
            if (tip.getChampion() != this) {
                tip.setChampion(this);
            }
        }
    }
}
