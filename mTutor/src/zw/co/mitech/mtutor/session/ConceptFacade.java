package zw.co.mitech.mtutor.session;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import zw.co.mitech.mtutor.entities.Concept;
import zw.co.mitech.mtutor.entities.TopicMarker;


@Repository
@Transactional
public class ConceptFacade  extends AbstractFacade<Concept>  {
	
	
	@PersistenceContext
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

	public ConceptFacade() {
		super(Concept.class);
		
	}

	public Concept findConceptByTopicAndSequence(long topic, long topicSequence) {
		
		String sql = "SELECT c FROM Concept c WHERE  c.topicId = :topic AND c.topicSequence = :topicSequence";
		EntityManager em = getEntityManager();
		Query query = em.createQuery(sql);
		query.setParameter("topicSequence", topicSequence);
		query.setParameter("topic", topic);
		
		
		query.setMaxResults(1);
		try{
			return (Concept) query.getSingleResult();
		}catch(Exception e){
			return null;
		}
	}

	public List<Concept> getConceptsByTopicIdOrderedBySequence(Long topicId) {
		String sql = "SELECT c FROM Concept c WHERE  c.topicId = :topic ORDER BY c.topicSequence ASC";
		EntityManager em = getEntityManager();
		Query query = em.createQuery(sql);
	
		query.setParameter("topic", topicId);
		
		
	return (List<Concept>) query.getResultList();
		
	}

	public long getTopicSequence(Long topicId) {
		String sql = "SELECT COUNT(c) FROM Concept c WHERE  c.topicId = :topic";
		EntityManager em = getEntityManager();
		Query query = em.createQuery(sql);
	
		query.setParameter("topic", topicId);
		
	return	(Long) query.getSingleResult();
	
		
	}

}
