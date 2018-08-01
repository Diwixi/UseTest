package pro.diwixis.ru.usetest

import junit.framework.TestCase.assertEquals
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class StringUtilsTestSpek : Spek({
    describe("isPasswordValid") {
        val testCases = mapOf(
                "" to false,
                "abcdefgh" to false,
                "abcdef1" to false,
                "0123456789abcdefghijklmnopqrstuvwxyz" to false,
                "abcdefg1" to false,
                "aBcdefg 1" to false,
                "aBcdefg1&@%" to true
        )
        testCases.forEach { password, result ->
            given("password = '$password'") {
                it("result should be $result") {
                    assertEquals(isPasswordValid(password), result)
                }
            }
        }
    }

    xdescribe("isCarNumberValid", "because... f*ck u") {
        val testCases = mapOf(
                null to false,
                "" to false,
                "123456789012345678901" to false,
                "12 HBY" to false,
                "aaa123rt" to false,
                "AAA123RT" to true
        )
        testCases.forEach { carNumber, result ->
            given("carNumber = '$carNumber'") {
                it("result should be $result") {
                    assertEquals(isCarNumberValid(carNumber), result)
                }
            }
        }
    }
})