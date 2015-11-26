package com.dsfarmacia.beans;

public class BeanProveedor {
  private int proveedorId;
  private String proveedornombre;
  
  public int getProveedorId() {
    return proveedorId;
  }
  
  public void setProveedorId(int proveedorId) {
    this.proveedorId = proveedorId;
  }
  
  public String getProveedornombre() {
    return proveedornombre;
  }
  
  public void setProveedornombre(String proveedornombre) {
    this.proveedornombre = proveedornombre;
  }
  
  @Override
  public String toString() {
    return "BeanProveedor [proveedorId=" + proveedorId + ", proveedornombre=" 
      + proveedornombre + "]";
  }

}
