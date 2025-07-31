package com.mrblablak.github_repo_search_engine.model.git.dto;


public class GitRepoDTO {

    private String name;
    private GitOwnerDTO owner;
    private boolean fork;

    public String getName() {
        return name;
    }

    public GitOwnerDTO getOwner() {
        return owner;
    }

    public boolean isFork() {
        return fork;
    }
}
