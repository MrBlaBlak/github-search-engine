package com.mrblablak.github_repo_search_engine.model.git;

import java.util.List;

public class GitUserRepoData {

    private final String repositoryName;
    private final String userName;
    private final List<BranchData> branches;

    public GitUserRepoData(String repositoryName, String userName, List<BranchData> branches) {
        this.repositoryName = repositoryName;
        this.userName = userName;
        this.branches = branches;
    }

    public String getRepositoryName() {
        return repositoryName;
    }

    public String getUserName() {
        return userName;
    }

    public List<BranchData> getBranches() {
        return branches;
    }
}
