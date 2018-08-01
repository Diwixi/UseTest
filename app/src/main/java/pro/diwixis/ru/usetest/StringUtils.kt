package pro.diwixis.ru.usetest

import java.util.regex.Pattern

fun isCarNumberValid(number: String?): Boolean {
    return number != null && number.isNotEmpty() && number.length <= 20 && number.matches("[A-ZА-Я0-9]+".toRegex())
}

fun isPasswordValid(password: CharSequence): Boolean {
    if (password.length < 8 || password.length > 16) return false

    val regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$"
    val pattern = Pattern.compile(regex)
    val matcher = pattern.matcher(password)

    return matcher.matches()
}