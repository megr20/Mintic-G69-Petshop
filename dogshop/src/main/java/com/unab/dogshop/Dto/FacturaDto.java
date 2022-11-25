package com.unab.dogshop.Dto;
import lombok.Data;

@Data
public class FacturaDto {
    private String id;
    private String descripcion;
    private String fecha;
    private String total;
    private String cliente; 
}