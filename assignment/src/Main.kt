fun main() {
    println(isComposite(7))
    println(isComposite(12))
    println(isComposite(9))

}
fun isComposite(n: Int): Boolean {
    for (i in 2..n / 2) {
        if (n % i == 0) {
            return true
        }
    }
    return false
}