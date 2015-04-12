package org.kashpersky.scuttle.domain.mongo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
public class PatchNotes {

    private String patch;

    private List<ChampionChanges> champions;

    private List<ItemChanges> items;

    private List<String> bugFixes;

    private List<SkinChanges> skins;

    public String getPatch() {
        return patch;
    }

    public void setPatch(String patch) {
        this.patch = patch;
    }

    public List<ChampionChanges> getChampions() {
        return champions;
    }

    public void setChampions(List<ChampionChanges> champions) {
        this.champions = champions;
    }

    public List<ItemChanges> getItems() {
        return items;
    }

    public void setItems(List<ItemChanges> items) {
        this.items = items;
    }

    public List<String> getBugFixes() {
        return bugFixes;
    }

    public void setBugFixes(List<String> bugFixes) {
        this.bugFixes = bugFixes;
    }

    public List<SkinChanges> getSkins() {
        return skins;
    }

    public void setSkins(List<SkinChanges> skins) {
        this.skins = skins;
    }

}
