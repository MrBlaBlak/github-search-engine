package com.mrblablak.github_repo_search_engine.model.git;


public class BranchData {

    private final String name;
    private final String lastCommitSha;

    public BranchData(String name, String lastCommitSha) {
        this.name = name;
        this.lastCommitSha = lastCommitSha;
    }

    public String getName() {
        return name;
    }

    public String getLastCommitSha() {
        return lastCommitSha;
    }
}
