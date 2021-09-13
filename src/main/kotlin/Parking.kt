data class Parking(val vehicles: MutableSet<Vehicle>) {
    private val maxSpace = 20
    var earnings = Pair(0, 0)

    //Adds vehicles to the list checking maxSpace and if it already exists
    fun addVehicle(vehicle: Vehicle): Boolean {
        if (vehicles.size >= maxSpace) {
            println("Sorry, the check-in failed")
            println("(Max occupancy reached)")
            return false
        }

        return if (vehicles.add(vehicle)) {
            println("Welcome to AlkeParking!")
            true
        } else {
            println("Sorry, the check-in failed")
            println("(The plate already exists)")
            false
        }
    }

    //if the plate exists, calculates the fee and calls onSuccess function, else calls onError function
    fun checkOutVehicle(plate: String, onSuccess: (Int) -> Unit, onError: () -> Unit): Boolean {
        var vehicleRemoved: Vehicle? = null

        //I search for the vehicle in the MutableList, if it doesn't exists I return null
        vehicles.forEach {
            if (it.plate == plate) {
                vehicleRemoved = it

            }
        }

        if (vehicleRemoved != null) {
            //Fee calculation
            var fee: Int = vehicleRemoved!!.calculateFee(vehicleRemoved!!.vehicleType,
                vehicleRemoved!!.parkedTime.toInt(), vehicleRemoved!!.discountCard?.let { true } ?: false
            )

            //Save it on $earnings
            earnings = Pair(earnings.first + 1, earnings.second + fee)

            //Show the fee
            onSuccess(fee)

            //Remove vehicle
            vehicles.remove(vehicleRemoved)

            return true
        }

        onError()
        return false
    }

    fun onSuccess(fee: Int) {
        println("Your fee is $$fee. Come back soon.")
    }

    fun onError() {
        println("Sorry, the check-out failed")
    }

    fun showEarnings() {
        println("${earnings.first} vehicles have checked out and have earnings of $${earnings.second}")
    }

    fun listVehicles() {
        println("------------------")
        println("LISTA DE VEHICULOS")

        vehicles.forEach {
            println(it.plate)
        }

        println("------------------")
    }

}