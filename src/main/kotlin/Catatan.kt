package com.kelompok5.async

class Catatan(val judul: String, val isi: String)

class PengelolaCatatan {
    private val daftarCatatan = mutableListOf<Catatan>()
    
    fun tambahCatatan(catatan: Catatan) {
        daftarCatatan.add(catatan)
    }

    fun tampilkanCatatan() {
        println("\nDaftar Catatan")
        for (catatan in daftarCatatan) {
            println("\nJudul\t: ${catatan.judul}")
            println("Isi\t\t: ${catatan.isi}")
        }
    }
}

fun main() {
    // Debugging punya Haidar, boleh dihapus

    val pengelolaCatatan = PengelolaCatatan()

    val note1 = Catatan("Sarapan", "Menu sarapan pagi ini adalah bubur ayam")
    val note2 = Catatan("Mudik", "Lusa akan mudik ke ngawi")

    pengelolaCatatan.tambahCatatan(note1)
    pengelolaCatatan.tambahCatatan(note2)

    pengelolaCatatan.tampilkanCatatan()

}
