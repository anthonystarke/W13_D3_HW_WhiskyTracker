package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class WhiskyRepositoryImpl implements WhiskyRepositoryCustom {

    EntityManager entityManager;

    public List<Distillery> findDestilleryWithWhiskyNamed(String name){
        List<Distillery> result = null;
        Session session = entityManager.unwrap(Session.class);
        try {
            Criteria cr = session.createCriteria(Distillery.class);
            cr.createAlias("whiskies", "whiskyAlias");
            cr.add(Restrictions.eq("whiskyAlias.name", name));
            result = cr.list();
        } catch (HibernateException ex) {
            ex.printStackTrace();
        }
        return result;
    }

}
