package com.kelompok5.async

import kotlinx.coroutines.*
import java.util.Scanner

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

    suspend fun tampilkanCatatanAsync() {
        withContext(Dispatchers.Default) {
            delay(1000)
            tampilkanCatatan()
        }
    }
}

suspend fun main() {
    // Debugging punya Haidar, boleh dihapus

//    val pengelolaCatatan = PengelolaCatatan()
//
//    val note1 = Catatan("Sarapan", "Menu sarapan pagi ini adalah bubur ayam")
//    val note2 = Catatan("Mudik", "Lusa akan mudik ke ngawi")
//
//    pengelolaCatatan.tambahCatatan(note1)
//    pengelolaCatatan.tambahCatatan(note2)
//
//    pengelolaCatatan.tampilkanCatatan()
//    println("====================")
//
//    println("Menampilkan catatan secara asynchronous...")
//    runBlocking {
//        pengelolaCatatan.tampilkanCatatanAsync()
//    }
//    println("Catatan telah ditampilkan.")
    val scanner = Scanner(System.`in`)
    val pengelola = PengelolaCatatan()

    while (true) {
        println("Menu:")
        println("1. Tambah Catatan")
        println("2. Tampilkan Daftar Catatan")
        println("3. Keluar")
        print("Pilih menu: ")
        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine()
                print("Masukkan judul catatan: ")
                val judul = scanner.nextLine()
                print("Masukkan isi catatan: ")
                val isi = scanner.nextLine()
                pengelola.tambahCatatan(Catatan(judul, isi))
            }
            2 -> {
                println("Menampilkan daftar catatan...")
                pengelola.tampilkanCatatanAsync()
            }
            3 -> {
                println("Keluar dari program.")
                return
            }
            else -> {
                println("Pilihan tidak valid.")
            }
        }
    }
}

