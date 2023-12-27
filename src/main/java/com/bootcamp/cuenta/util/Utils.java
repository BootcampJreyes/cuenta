package com.bootcamp.cuenta.util;

import java.time.LocalTime;
import java.time.ZoneId;

public class Utils {
    public static boolean validarHorario() {

        boolean flag = false;
        ZoneId zonaHoraria = ZoneId.of("America/Lima");
        LocalTime horaActual = LocalTime.now(zonaHoraria);
        LocalTime horaInicio = LocalTime.of(8, 00);
        LocalTime horaFin = LocalTime.of(23, 50);

        if (horaActual.isAfter(horaInicio) && horaActual.isBefore(horaFin)) {
            flag = true;
        }

        return flag;
    }
}
