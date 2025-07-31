package com.mrblablak.github_repo_search_engine.service;

import com.mrblablak.github_repo_search_engine.client.GitClient;
import com.mrblablak.github_repo_search_engine.model.git.BranchData;
import com.mrblablak.github_repo_search_engine.model.git.UserRepoData;
import com.mrblablak.github_repo_search_engine.model.git.dto.GitBranchDTO;
import com.mrblablak.github_repo_search_engine.model.git.dto.GitRepoDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GitService {

    private final GitClient gitClient;

    public GitService(GitClient gitClient) {
        this.gitClient = gitClient;
    }

    public List<UserRepoData> getUserNotForkedRepos(String username) {
        List<GitRepoDTO> repos = gitClient.getUserRepos(username);

        return repos.stream()
                .filter(repo -> !repo.isFork())
                .map(repo -> {
                    List<GitBranchDTO> branches = gitClient.getRepoBranches(username, repo.name());
                    List<BranchData> branchData = branches.stream()
                            .map(b -> new BranchData(b.name(), b.commit().sha()))
                            .collect(Collectors.toList());

                    return new UserRepoData(
                            repo.name(),
                            repo.owner().login(),
                            branchData
                    );
                })
                .collect(Collectors.toList());
    }
}
