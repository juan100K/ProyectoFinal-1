package maper.dto;

import java.time.LocalTime;

public record ProductosDto(String nombre,
                           String categoria,
                           Double precio,
                           String codigo,
                           LocalTime fecha) {
}
