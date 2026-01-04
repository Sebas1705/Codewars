package kt_p5_rot13_test

import p5_kyu_rot13.rot13

fun main() {
    check(rot13("Hello, World!") == "Uryyb, Jbeyq!") { "Rot13 failed for 'Hello, World!'" }
    check(rot13("Uryyb") == "Hello") { "Rot13 failed for 'Uryyb'" }
    println("Rot13 Kotlin tests OK")
}
