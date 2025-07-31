package com.mrblablak.github_repo_search_engine;

import com.mrblablak.github_repo_search_engine.model.git.BranchData;
import com.mrblablak.github_repo_search_engine.model.git.UserRepoData;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GithubRepoSearchEngineApplicationTests {

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void shouldReturnNotForkedRepositoriesForExistingUser() {
        //given
        String url = "http://localhost:" + port + "/github/mrblablak";
        //when
        ResponseEntity<UserRepoData[]> response = restTemplate.getForEntity(url, UserRepoData[].class);
        //then
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        UserRepoData[] repositories = response.getBody();
        assertThat(repositories).isNotEmpty();

        for (UserRepoData repo : repositories) {
            assertThat(repo.repositoryName()).isNotBlank();
            assertThat(repo.userName()).containsIgnoringCase("mrblablak");
            assertThat(repo.branches()).isNotEmpty();

            for (BranchData branch : repo.branches()) {
                assertThat(branch.name()).isNotBlank();
                assertThat(branch.lastCommitSha()).isNotBlank();
            }
        }
    }

}
