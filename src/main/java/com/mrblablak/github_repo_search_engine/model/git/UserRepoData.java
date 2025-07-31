package com.mrblablak.github_repo_search_engine.model.git;

import java.util.List;

public record UserRepoData(String repositoryName, String userName,
                           List<BranchData> branches) {
}
