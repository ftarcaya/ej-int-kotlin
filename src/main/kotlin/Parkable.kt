import java.util.*
import java.util.concurrent.TimeUnit

open class Parkable {
    val checkInTime: Calendar = Calendar.getInstance()

    val parkedTime: Long
        get() = (Calendar.getInstance().timeInMillis - checkInTime.timeInMillis) / TimeUnit.MINUTES.toMillis(
            1
        )

    fun calculateFee(vehicleType: VehicleType, parkedTime: Int, discountCard: Boolean): Int {

        var extraTime: Int = 0

        if (parkedTime > 120) {
            extraTime = (parkedTime as Int) - 120
        }

        val discount: Float = if (discountCard) 0.85F else 1F

        return ((vehicleType.cost + (extraTime / 15) * 5) * discount).toInt()
    }
}