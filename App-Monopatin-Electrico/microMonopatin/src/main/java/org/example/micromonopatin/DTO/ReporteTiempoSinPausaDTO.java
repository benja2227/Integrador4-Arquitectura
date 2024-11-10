package org.example.micromonopatin.DTO;

public class ReporteTiempoSinPausaDTO {

    private Long id;
    private Long tiempoSinPausas;

    public ReporteTiempoSinPausaDTO(Long id, Long tiempoSinPausas) {
        this.id = id;
        this.tiempoSinPausas = tiempoSinPausas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTiempoSinPausas() {
        return tiempoSinPausas;
    }

    public void setTiempoSinPausas(Long tiempoSinPausas) {
        this.tiempoSinPausas = tiempoSinPausas;
    }

    @Override
    public String toString() {
        return "ReporteTiempoSinPausasDTO{" +
                "id=" + id +
                ", tiempoSinPausas=" + tiempoSinPausas +
                '}';
    }
}

