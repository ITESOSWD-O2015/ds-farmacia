package com.dsfarmacia.beans;

public class BeanUnidadMedida {
  private int unidadmedidaId;
  private String unidadmedidanombre;
  
  public int getUnidadmedidaId() {
    return unidadmedidaId;
  }
  
  public void setUnidadmedidaId(int unidadmedidaId) {
    this.unidadmedidaId = unidadmedidaId;
  }
  
  public String getUnidadmedidanombre() {
    return unidadmedidanombre;
  }
  
  public void setUnidadmedidanombre(String unidadmedidanombre) {
    this.unidadmedidanombre = unidadmedidanombre;
  }

  @Override
  public String toString() {
    return "BeanUnidadMedida [unidadmedidaId=" + unidadmedidaId + ","
      + " unidadmedidanombre=" + unidadmedidanombre + "]";
  }

}
