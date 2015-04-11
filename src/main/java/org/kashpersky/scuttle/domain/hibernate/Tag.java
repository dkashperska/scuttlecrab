package org.kashpersky.scuttle.domain.hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "Tags")
public class Tag {
    
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "tag")
    private String tag;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "tagsChampions",
            joinColumns = {@JoinColumn(name = "tag")},
            inverseJoinColumns = {@JoinColumn(name = "champion")})
    private Set<Champion> champions;

    public Tag() {
        champions = new HashSet<>();
    }

    public Set<Champion> getChampions() {
        return champions;
    }

    public Tag setChampions(Set<Champion> champions) {
        this.champions = champions;
        return this;
    }

    public String getTag() {
        return tag;
    }

    public Tag setTag(String tag) {
        this.tag = tag;
        return this;
    }

    public Integer getId() {
        return id;
    }
}
