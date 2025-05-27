package co.edu.uniquindio.trabajofinalcode.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class GeneradorCodigos {

    public GeneradorCodigos() {}

    private static final String HEXADECIMAL = "0123456789ABCDEF";
    private static final String DECIMAL = "0123456789";
    private static final Random random = new Random();
    private static final Set<String> codigosUsados = new HashSet<>();

    public void validarLongitudPositiva(int longitud) throws IllegalArgumentException{
        if (longitud <= 0) {
            throw new IllegalArgumentException("La longitud debe ser mayor que 0");
        }
    }

    public long convertirBuilderToLong(StringBuilder codigo, int base) throws RuntimeException{
        try {
            return Long.parseLong(codigo.toString(), base);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Error al convertir el código generado a número", e);
        }
    }

    public long generarCodigoHexadecimal(int longitud) {
        validarLongitudPositiva(longitud);
        StringBuilder codigo = generarCodigoUnico(longitud, HEXADECIMAL);
        return convertirBuilderToLong(codigo, 16);
    }

    public long generarCodigoDecimal(int longitud) {
        validarLongitudPositiva(longitud);
        StringBuilder codigo = generarCodigoUnico(longitud, DECIMAL);
        return convertirBuilderToLong(codigo, 10);
    }

    public String generarCodigoHexadecimalStr(int longitud) {
        validarLongitudPositiva(longitud);
        return generarCodigoUnico(longitud, HEXADECIMAL).toString();
    }

    public String generarCodigoDecimalStr(int longitud) {
        validarLongitudPositiva(longitud);
        return generarCodigoUnico(longitud, DECIMAL).toString();
    }

    private StringBuilder generarCodigo(int longitud, String caracteres) {
        StringBuilder codigo = new StringBuilder();
        for (int i = 0; i < longitud; i++) {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }
        return codigo;
    }

    private StringBuilder generarCodigoUnico(int longitud, String caracteres) {
        StringBuilder codigo;
        int intentos = 0;
        do {
            if (++intentos > 1000) {
                throw new RuntimeException("No se pudo generar un código único después de muchos intentos");
            }
            codigo = generarCodigo(longitud, caracteres);
        } while (!codigosUsados.add(codigo.toString())); // Solo se añade si no existe
        return codigo;
    }
}
