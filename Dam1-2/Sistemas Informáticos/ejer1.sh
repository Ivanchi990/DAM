#!/bin/bash

if [ $# -eq 0] then
    echo "No has pasado ningún elemento por parámetro."
else 
    if [ -d $1 ] then
        echo "El directorio ya existe."
    else
        mkdir $1
    fi
fi
