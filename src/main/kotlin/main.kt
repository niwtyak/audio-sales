fun giveSale(price: Int, buyout: Int, regular: Boolean): Double {
    val scaledPriceInPennies = when (buyout) {
        in 0..1000 -> price * 100
        in 1001..10000 -> price * 100 - 10000
        else -> price * 95
    }
    return if (regular) scaledPriceInPennies * 0.99 / 100 else scaledPriceInPennies / 100.0
}

fun main() {
    val order1 = 1100
    val order2 = 10000
    val order3 = 10000
    val order4 = 10000
    println("Покупка ценой: $order1 руб. с учетом скидки: ${giveSale(order1,0,false)} руб.")
    println("Покупка ценой: $order2 руб. с учетом скидки: ${giveSale(order2,order1,false)} руб.")
    println("Покупка ценой: $order3 руб. с учетом скидки: ${giveSale(order3,order1+order2,false)} руб.")
    println("Покупка ценой: $order4 руб. с учетом скидки: ${giveSale(order4,order1+order2+order3,true)} руб.")
}