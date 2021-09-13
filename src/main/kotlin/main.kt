fun main(args: Array<String>) {

    val parking = Parking(mutableSetOf())

    val defaultPlate = "AA111A"
    var i: Int = 0

    val car = Vehicle("AB111AA", VehicleType.CAR)
    parking.addVehicle(car)

    while (i < 5) {
        val car2 = Vehicle("AB111A" + ('A' + i), VehicleType.CAR, "DISCOUNT_CARD_001") //La primera vez devuelve FALSE por estar repetido
        val moto = Vehicle("AB111B" + ('A' + i), VehicleType.BIKE)
        val minibus = Vehicle("CC111C" + ('A' + i), VehicleType.MINIBUS)
        val bus = Vehicle("DD111D" + ('A' + i), VehicleType.BUS, "DISCOUNT_CARD_002")

        parking.addVehicle(car2)
        parking.addVehicle(bus)
        parking.addVehicle(moto)
        parking.addVehicle(minibus)

        i++
    }

    parking.listVehicles()

    parking.checkOutVehicle("AB111AA", parking::onSuccess, parking::onError) //sin descuento
    parking.checkOutVehicle("AB111AB", parking::onSuccess, parking::onError) //con descuento


}