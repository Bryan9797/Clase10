package com.jdev.clase10

class Producto {

    var nombre : String ? = ""
    var descripcion : String ? = ""
    var precio : Float ? = 0.0f
    var stock : Int ? = 0

    constructor(nombre: String?, descripcion: String?, precio: Float?, stock: Int?) {
        this.nombre = nombre
        this.descripcion = descripcion
        this.precio = precio
        this.stock = stock
    }
}