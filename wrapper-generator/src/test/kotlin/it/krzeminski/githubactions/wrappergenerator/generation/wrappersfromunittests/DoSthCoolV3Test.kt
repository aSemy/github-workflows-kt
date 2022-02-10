package it.krzeminski.githubactions.wrappergenerator.generation.wrappersfromunittests

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import it.krzeminski.githubactions.actions.johnsmith.DoSthCoolV3

class DoSthCoolV3Test : DescribeSpec({
    it("renders with defaults") {
        // given
        val action = DoSthCoolV3(
            fooBar = "abc123",
            bazGoo = "def456",
        )

        // when
        val yaml = action.toYamlArguments()

        // then
        yaml shouldBe linkedMapOf(
            "foo-bar" to "abc123",
            "baz-goo" to "def456",
        )
    }
})
