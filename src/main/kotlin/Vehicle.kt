import java.util.*
import java.util.concurrent.TimeUnit

data class Vehicle(val plate : String, val vehicleType: VehicleType, val discountCard : String? = null) : Parkable() {

    override fun equals(other: Any?): Boolean {
        if (other is Vehicle) {
            return this.plate == other.plate
        }
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return this.plate.hashCode()
    }
}