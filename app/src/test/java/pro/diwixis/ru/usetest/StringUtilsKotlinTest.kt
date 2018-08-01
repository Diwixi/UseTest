package pro.diwixis.ru.usetest

import io.kotlintest.*
import io.kotlintest.matchers.boolean.shouldBeFalse
import io.kotlintest.matchers.numerics.shouldBeBetween
import io.kotlintest.matchers.numerics.shouldBeGreaterThanOrEqual
import io.kotlintest.matchers.numerics.shouldBeInRange
import io.kotlintest.matchers.numerics.shouldBeOdd
import io.kotlintest.matchers.shouldHaveSameHashCodeAs
import io.kotlintest.matchers.startWith
import io.kotlintest.matchers.string.shouldBeEmpty
import io.kotlintest.matchers.string.shouldBeLowerCase
import io.kotlintest.matchers.string.shouldMatch
import io.kotlintest.matchers.types.shouldBeInstanceOf
import io.kotlintest.matchers.uri.haveHost
import io.kotlintest.matchers.uri.havePath
import io.kotlintest.matchers.uri.haveScheme
import io.kotlintest.matchers.uri.shouldHaveHost
import io.kotlintest.specs.StringSpec
import java.net.URI

class StringUtilsKotlinTest : StringSpec({
    "empty string not valid"{
        isPasswordValid("") shouldBe false
    }
    "too long password"{
        isPasswordValid("0123456789abcdefghijklmnopqrstuvwxyz") shouldBe false
    }

    "test1, string"{
        "test" shouldBe startWith("t")
        "test".shouldBeLowerCase()
        "test".shouldMatch(".{4}")
        "".shouldBeEmpty()

    }

    "test2, boolean"{
        false.shouldBeFalse()
        false.shouldHaveSameHashCodeAs(false)
        false.shouldBeInstanceOf<Boolean>()
        false.should {  }
    }

    "test3, number"{
        val x = 5
        x.shouldBeBetween(1, 10)
        x.shouldBeOdd()
        x.shouldBeGreaterThanOrEqual(5)
        x.shouldBeInRange(1..10)
    }

    "uri"{
        val uri = URI("http://mega.ru/wtf/wtf.wow")
        uri.shouldHaveHost("mega.ru")
        uri.should {
            haveScheme("http://")
            haveHost("mega.ru")
            havePath("wtf/wtf.wow")
        }
    }
    //files days

    "test custom Matcher"{
        "hello foo" should containFoo()
        "hello bar" shouldNot containFoo()
    }



})


fun containFoo() = object : Matcher<String> {
    override fun test(value: String) = Result(value.contains("foo"), "String $value should include foo", "String $value should not include foo")
}