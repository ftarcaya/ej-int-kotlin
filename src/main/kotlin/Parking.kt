data class Parking(val vehicles: MutableSet<Vehicle>) {
    val max_space = 20

    fun addVehicle(vehicle: Vehicle) : Boolean{
        if (vehicles.size >= max_space) {
            println("Sorry, the check-in failed")
            println("(Max occupancy reached)")
            return false
        }

        if (vehicles.add(vehicle)) {
            println("Welcome to AlkeParking!")
            return true
        } else {
            println("Sorry, the check-in failed")
            println("(The plate already exists)")
            return false
        }
    }
}