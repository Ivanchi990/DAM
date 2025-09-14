#!/bin/bash

echo "Hola bienvenido a mi menú"

opcion=0

while [ $opcion -ne 5 ]

echo -e "1-Copiar un archivo a otro directorio \n2-Mover un archivo a otro directorio \n3-Renombrar archivo \n4-Borrar archivo \n5-Salir"
read opcion

do
    case $opcion in
        1) 
            echo -e "Introduce el nombre del archivo: \n"
            read nombre
            echo -e "Introduce el nombre del directorio: \n"
            read dir
            if [[ -e $dir ]] && [[ -d $dir ]] && [[ -e $nombre ]]
            then
                    cp $nombre $dir
            elif [[ -e $nombre ]]
            then
                mkdir $dir
                cp $nombre $dir
                echo "Se ha creado un nuevo directorio."
                echo "El archivo $nombre se ha copiado en el directorio dir1."
	        else
		        echo "El archivo no existe."
            fi;;

        2)
            echo -e "Introduce el nombre del archivo: \n"
            read nombre
            echo -e "Introduce el nombre del directorio: \n"
            read dir
            if [[ -e $dir ]] && [[ -d $dir ]] && [[ -e $nombre ]]
            then
                    mv $nombre $dir
            elif [[ -e $nombre ]]
            then
                mkdir $dir
                mv $nombre $dir
                echo "Se ha creado un nuevo directorio."
                echo "El archivo $nombre se ha movido a el directorio dir2."
	        else
		        echo "El archivo no existe."
            fi;;
        4)
            echo -e "Introduce el nombre del archivo que quieres eliminar: \n"
            read nombre 
            if [[ -e $nombre ]] 
            then
                rm $nombre 
                echo "El archivo se ha borrado exitosamente."
            else
                echo "El archivo $nombre no existe."
            fi;;
        3)
            echo -e "Introduce el nombre del archivo: \n"
            read viejo
            if [[ -e $viejo ]]
            then
                echo -e "Introduce el nuevo nombre: \n"
                read nuevo
                mv $viejo $nuevo
                echo "El archivo $viejo ahora se llama $nuevo."
            else
                echo "El archivo no existe."
            fi;;
        5)
            echo "Adios ;)"
            exit;;
        *)
            echo "Opción no válida";;
        esac
done
