package com.example.dambite.opensqlite

import android.annotation.SuppressLint
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteException
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.dambite.entity.Plato

class MiBDOpenHelper(contex: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(contex, DATABASE_NAME, factory, DATABASE_VERSION) {

    val TAG = "SQLite"

    companion object {
        val DATABASE_VERSION = 1
        val DATABASE_NAME = "dambite.db"
        val TABLA_PLATOS = "platos"
        val PLATOS_C_ID_ = "id_plato"
        val PLATOS_C_NOMBRE = "nombre_plato"
        val PLATOS_C_CATEGORIA = "categoria_plato"
        val PLATOS_C_AREA = "area_plato"
        val PLATOS_C_IMAGEN = "iamgen_plato"

    }

    //para recrear las base de datos es necesarios borrar los ficheros sobre /data/data/nombre.aplicacion/databases
    override fun onCreate(db: SQLiteDatabase?) {
        try {
            var crearTablaPlatos = "CREATE TABLE $TABLA_PLATOS " +
                    "($PLATOS_C_ID_ TEXT PRIMARY KEY UNIQUE, " +
                    "$PLATOS_C_NOMBRE TEXT," +
                    "$PLATOS_C_CATEGORIA TEXT," +
                    "$PLATOS_C_AREA TEXT," +
                    "$PLATOS_C_IMAGEN TEXT)"

            var plato_Carbonara =
                "INSERT INTO $TABLA_PLATOS ($PLATOS_C_ID_,$PLATOS_C_NOMBRE,$PLATOS_C_CATEGORIA,$PLATOS_C_AREA,$PLATOS_C_IMAGEN) " +
                        "VALUES (52982,'Spaghetti alla Carbonara','Pasta','Italian','https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/llcbn01574260722.jpg');"
            var plato_Pizza =
                "INSERT INTO $TABLA_PLATOS ($PLATOS_C_ID_,$PLATOS_C_NOMBRE,$PLATOS_C_CATEGORIA,$PLATOS_C_AREA,$PLATOS_C_IMAGEN) " +
                        "VALUES (53014,'Pizza Express Margherita','Miscellaneous','Italian','https:\\/\\/www.themealdb.com\\/images\\/media\\/meals\\/x0lk931587671540.jpg');"

            db!!.execSQL(crearTablaPlatos)
            db!!.execSQL(plato_Carbonara)
            db!!.execSQL(plato_Pizza)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onCreate)", e.message.toString())
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        try {
            val dropTablaPlatos = "DROP TABLE IF EXISTS $TABLA_PLATOS"
            db!!.execSQL(dropTablaPlatos)
            onCreate(db)
        } catch (e: SQLiteException) {
            Log.e("$TAG (onUpgrade)", e.message.toString())
        }
    }

    override fun onOpen(db: SQLiteDatabase?) {
        super.onOpen(db)
        Log.e("$TAG (onOpen)", "Base de datos abierta")

    }


    @SuppressLint("Range")
    fun obtenerPlatos(): ArrayList<Plato>
    {
        val platos = ArrayList<Plato>()
        val selectQuery = "SELECT * FROM $TABLA_PLATOS"
        val db = this.readableDatabase
        val cursor = db.rawQuery(selectQuery, null)
        if (cursor.moveToFirst()) {
            do {
                val id_plato = cursor.getString(cursor.getColumnIndex(PLATOS_C_ID_))
                val nombre_plato = cursor.getString(cursor.getColumnIndex(PLATOS_C_NOMBRE))
                val categoria_plato = cursor.getString(cursor.getColumnIndex(PLATOS_C_CATEGORIA))
                val area_plato = cursor.getString(cursor.getColumnIndex(PLATOS_C_AREA))
                val imagen_plato = cursor.getString(cursor.getColumnIndex(PLATOS_C_IMAGEN))
                val plato = Plato(id_plato, nombre_plato, categoria_plato, area_plato, imagen_plato)
                platos.add(plato)
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return platos
    }

    fun anadirPlato(plato: Plato)
    {
        val db = this.writableDatabase

        val id = plato.id
        val nombre = plato.nombre
        val cat = plato.categoria
        val area = plato.area
        val img = plato.urlImagen

        var insercion = "INSERT INTO $TABLA_PLATOS VALUES('$id', '$nombre', '$cat', '$area', '$img');"

        db!!.execSQL(insercion)

        db.close()
    }

    fun eliminarPlato(id: String)
    {
        val db = this.writableDatabase

        val eliminar = "DELETE FROM $TABLA_PLATOS WHERE $PLATOS_C_ID_ = '$id'"

        db!!.execSQL(eliminar)

        db.close()
    }
}








