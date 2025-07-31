package com.mrblablak.github_repo_search_engine.controller;

import com.mrblablak.github_repo_search_engine.model.git.ErrorResponse;
import com.mrblablak.github_repo_search_engine.service.GitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

@RestController
@RequestMapping("/github")
public class GitController {

    private final GitService gitService;

    public GitController(GitService gitService) {
        this.gitService = gitService;
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getRepos(@PathVariable String username) {
        try {
            return ResponseEntity.ok(gitService.getUserNotForkedRepos(username));
        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(404, "User " + username + " not found"));
        }
    }
}
