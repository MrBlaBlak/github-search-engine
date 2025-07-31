package com.mrblablak.github_repo_search_engine.service;

import com.mrblablak.github_repo_search_engine.client.GitClient;
import com.mrblablak.github_repo_search_engine.model.git.BranchData;
import com.mrblablak.github_repo_search_engine.model.git.GitUserRepoData;
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

        public List<GitUserRepoData> getUserNotForkedRepos(String username) {
            List<GitRepoDTO> repos = gitClient.getUserRepos(username);

            return repos.stream()
                    .filter(repo -> !repo.isFork())
                    .map(repo -> {
                        List<GitBranchDTO> branches = gitClient.getRepoBranches(username, repo.getName());
                        List<BranchData> branchData = branches.stream()
                                .map(b -> new BranchData(b.getName(), b.getCommit().getSha()))
                                .collect(Collectors.toList());

                        return new GitUserRepoData(
                                repo.getName(),
                                repo.getOwner().getLogin(),
                                branchData
                        );
                    })
                    .collect(Collectors.toList());
        }
    }
