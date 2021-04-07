fun main() {
    var f1 = Fraction()
    f1.numerator = 1F
    f1.demonimator = 3F

    var f2 = Fraction()
    f2.numerator = 2F
    f2.demonimator = 2F


    println(f1.reduction())
    println(f1.Difference(f2))
    println(f1.multiplication(f2))

}


class Fraction {
    var numerator: Float = 0F
    var demonimator: Float = 1F

    fun reduction() {

        var gcd = 1.0
        var i = 1.0
        if (numerator < demonimator) {

            while (i <= numerator && i <= demonimator) {
                if (numerator % i == 0.0 && demonimator % i == 0.0)
                    gcd = i
                ++i
            }
        } else {
            while (i <= numerator && i <= demonimator) {
                if (numerator % i == 0.0 && demonimator % i == 0.0)
                    gcd = i
                ++i
            }
        }

        var rednum = numerator/gcd;
        var reddem = demonimator/gcd;
        println("reduction $rednum/$reddem")
    }

    fun Difference(value: Any?) {
        var n1: Float;
        var n2: Float;
        var diffdem: Float;
        var result: Float;

        if (value is Fraction) {
            n1 = numerator*value.demonimator
            n2 = value.numerator*demonimator
            diffdem = demonimator*value.demonimator

            result = n1 +n2;
            println("difference is $result/$diffdem")
        }
    }

    fun multiplication(value: Any?) {
        var n: Float;
        var dem: Float;

        if(value is Fraction) {
            n= numerator*value.numerator
            dem=demonimator*value.demonimator

            println("multiplication result is $n/$dem")
        }
    }

}

