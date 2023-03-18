package by.it.academy.util;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import static by.it.academy.services.Constants.PROJECT_NAME;

public class JPAUtil {
    private EntityManager ENTITY_MANAGER = buildEntityManager();

    private EntityManager buildEntityManager() {
        return Persistence
                .createEntityManagerFactory(PROJECT_NAME)
                .createEntityManager();
    }

    public EntityManager getEntityManager() {
        return ENTITY_MANAGER;
    }
}
