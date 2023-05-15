package com.coffee.sales.service;

import java.time.LocalDateTime;

import com.coffee.sales.entities.ChangeControlable;
import com.coffee.sales.error.RegisterClass;

public class AbstractService extends RegisterClass {
	
	  /**
   * Informa los campos de control de cambio (fecha de creacion y última modificación)
   * @param entity
   */
  protected void setChangeControlData(ChangeControlable entity) {
      // Si es nueva entidad, asignar la fecha de creacion
      if (entity.getId() == null) {
          entity.setCreated(LocalDateTime.now());
      }
      entity.setUpdated(LocalDateTime.now());
  }



  protected ChangeControlable preserveControlData(ChangeControlable dbEntity, ChangeControlable newEntity) {
      newEntity.setCreated(dbEntity.getCreated());
      newEntity.setUpdated(dbEntity.getUpdated());
      newEntity.setDeleted(dbEntity.getDeleted());
      return  newEntity;
  }
}
