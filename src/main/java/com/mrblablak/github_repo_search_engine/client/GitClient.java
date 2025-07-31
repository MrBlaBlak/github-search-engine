package com.mrblablak.github_repo_search_engine.client;

import com.mrblablak.github_repo_search_engine.model.git.dto.GitBranchDTO;
import com.mrblablak.github_repo_search_engine.model.git.dto.GitRepoDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Component
public class GitClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public List<GitRepoDTO> getUserRepos(String username) {
        String url = "https://api.github.com/users/" + username + "/repos";
        return Arrays.asList(restTemplate.getForObject(url, GitRepoDTO[].class));
    }

    public List<GitBranchDTO> getRepoBranches(String username, String repoName) {
        String url = "https://api.github.com/repos/" + username + "/" + repoName + "/branches";
        return Arrays.asList(restTemplate.getForObject(url, GitBranchDTO[].class));
    }
}
