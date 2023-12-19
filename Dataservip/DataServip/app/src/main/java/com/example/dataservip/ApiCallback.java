package com.example.dataservip;

import com.example.dataservip.modelos.Vehiculo;

public abstract class ApiCallback<T> {
    public abstract void onSuccess(Vehiculo vehiculo);

    public abstract void onFailure(String mensajeError);
}
