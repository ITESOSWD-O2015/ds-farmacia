package com.dsfarmacia.daos;

import com.dsfarmacia.db.Conexion;
 


public class SingletonLogin extends Login{
  private static Login uniqueInstance;
  
  private int test;
  
  private SingletonLogin() {
    setconection(new Conexion());
  }
  
  /**.
  * @return new instance
  */
  public static  Login getInstance() {
    if (uniqueInstance == null) {
      if (uniqueInstance == null) {
        uniqueInstance = new SingletonLogin();
      }
    }
    return uniqueInstance;
  }
}
