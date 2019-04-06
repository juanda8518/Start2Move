/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.davido.ejb;

import com.davido.entities.DbHospital;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author davidortega
 */
@Local
public interface DbHospitalFacadeLocal {

    void create(DbHospital dbHospital);

    void edit(DbHospital dbHospital);

    void remove(DbHospital dbHospital);

    DbHospital find(Object id);

    List<DbHospital> findAll();

    List<DbHospital> findRange(int[] range);

    int count();
    
    List<Object[]> findHospitals(List<String> listOfPostCodes);
    
    List<Object[]> getAllHospitals(List<String> listOfPostCodes);
    
}
