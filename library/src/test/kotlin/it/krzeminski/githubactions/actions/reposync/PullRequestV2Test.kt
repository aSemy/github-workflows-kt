package it.krzeminski.githubactions.actions.reposync

import io.kotest.core.spec.style.DescribeSpec
import it.krzeminski.githubactions.shouldHaveYamlArguments

class PullRequestV2Test : DescribeSpec({

    it("renders with defaults") {
        PullRequestV2() shouldHaveYamlArguments linkedMapOf()
    }

    it("renders with all parameters") {
        PullRequestV2(
            sourceBranch = "main",
            githubToken = "GitHub token",
            prAllowEmpty = false,
            prDraft = false,
            prMilestone = "PR milestone",
            prLabel = listOf("label1", "label2"),
            prAssignee = listOf("assignee1", "assignee2"),
            prReviewer = listOf("someone", "someone_else"),
            prTemplate = "my_template",
            prBody = "PR Body",
            prTitle = "Pull Request title",
            destinationBranch = "dest",
        ) shouldHaveYamlArguments mapOf(
            "source_branch" to "main",
            "github_token" to "GitHub token",
            "pr_allow_empty" to "false",
            "pr_draft" to "false",
            "pr_milestone" to "PR milestone",
            "pr_label" to "label1,label2",
            "pr_assignee" to "assignee1,assignee2",
            "pr_reviewer" to "someone,someone_else",
            "pr_template" to "my_template",
            "pr_body" to "PR Body",
            "pr_title" to "Pull Request title",
            "destination_branch" to "dest",
        )
    }
})