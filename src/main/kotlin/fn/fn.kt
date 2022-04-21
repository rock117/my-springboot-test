package fn

fun <T> Int.repeat(t: T): List<T> {
    return (1..this).map { t }
}

fun <K, V> MutableMap<K, V>.copy(): MutableMap<K, V> {
    val m = mutableMapOf<K, V>()
    this.forEach { k, v ->
        m.put(k, v)
    }
    return m
}