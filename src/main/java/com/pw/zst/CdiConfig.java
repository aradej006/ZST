package com.pw.zst;

import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class CdiConfig {

    @Produces
    @Dependent
    @PersistenceContext(unitName = "primary")
    public EntityManager entityManager;

}
