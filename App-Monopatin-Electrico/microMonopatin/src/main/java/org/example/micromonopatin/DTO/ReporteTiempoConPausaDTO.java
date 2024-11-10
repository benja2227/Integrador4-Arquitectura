package org.example.micromonopatin.DTO;

public class ReporteTiempoConPausaDTO {

    private Long id;
    private Long tiempoEnPausa;

    public ReporteTiempoConPausaDTO(Long id, Long tiempoEnPausa) {
        this.id = id;
        this.tiempoEnPausa = tiempoEnPausa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTiempoEnPausa() {
        return tiempoEnPausa;
    }

    public void setTiempoEnPausa(Long tiempoEnPausa) {
        this.tiempoEnPausa = tiempoEnPausa;
    }

    @Override
    public String toString() {
        return "ReporteTiempoConPausasDTO{" +
                "id=" + id +
                ", tiempoEnPausa=" + tiempoEnPausa +
                '}';
    }
}

