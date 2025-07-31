package com.mrblablak.github_repo_search_engine.model.git.dto;

public class GitBranchDTO {

    private String name;
    private GitCommitDTO commit;

    public String getName() {
        return name;
    }

    public GitCommitDTO getCommit() {
        return commit;
    }
}
