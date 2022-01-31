#!/usr/bin/env kotlin

@file:DependsOn("it.krzeminski:github-actions-kotlin-dsl:0.5.0")

import it.krzeminski.githubactions.actions.actions.CheckoutV2
import it.krzeminski.githubactions.actions.gradle.WrapperValidationActionV1
import it.krzeminski.githubactions.domain.RunnerType.UbuntuLatest
import it.krzeminski.githubactions.domain.Trigger.PullRequest
import it.krzeminski.githubactions.domain.Trigger.Push
import it.krzeminski.githubactions.dsl.workflow
import it.krzeminski.githubactions.yaml.toYaml
import java.nio.file.Paths

val gradleWrapperValidationWorkflow = workflow(
    name = "Validate Gradle wrapper",
    on = listOf(Push, PullRequest),
    sourceFile = Paths.get(".github/workflows/gradle-wrapper-validation.main.kts"),
    targetFile = Paths.get(".github/workflows/gradle-wrapper-validation.yaml"),
) {
    job(
        name = "validation",
        runsOn = UbuntuLatest,
    ) {
        uses(
            name = "Checkout",
            action = CheckoutV2(),
        )
        uses(
            name = "Validate wrapper",
            action = WrapperValidationActionV1(),
        )
    }
}

println(gradleWrapperValidationWorkflow.toYaml())