package org.example.micromonopatin.DTO;

public class ReporteKilometrajeDTO {

    private Long id;
    private Long kilometrajeTotal;

    // Constructor
    public ReporteKilometrajeDTO(Long id, Long kilometrajeTotal) {
        this.id = id;
        this.kilometrajeTotal = kilometrajeTotal;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKilometrajeTotal() {
        return kilometrajeTotal;
    }

    public void setKilometrajeTotal(Long kilometrajeTotal) {
        this.kilometrajeTotal = kilometrajeTotal;
    }

    @Override
    public String toString() {
        return "ReporteKilometrajeDTO{" +
                "id=" + id +
                ", kilometrajeTotal=" + kilometrajeTotal +
                '}';
    }
}

