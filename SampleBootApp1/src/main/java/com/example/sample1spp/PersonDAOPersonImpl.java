package com.example.sample1app;

import java.util.List;

import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class PersonDAOPersonImpl implements PersonDAO<Person>{
	private static final long serialVesionUID = 1L;
	@PersistenceContext
	private EntityManager entityManager;
	public PersonDAOPersonImpl() {
		super();
	}
	@Override
	public List<Person> getAll() {
		Query query = entityManager.createQuery("from Person");
		@SuppressWarnings("unchecked")
		List<Person> list = query.getResultList();
		entityManager.close();
		return list;
	}
	@Override
	public Person findById(Long id) {
		return (Person)entityManager.createQuery("from Person where id ="
				+ id).getSingleResult();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> findByName(String name) {
		return (List<Person>)entityManager.createQuery("from Person where name = '"
				+ name + "'").getResultList();
	}
//	@Override
//	public List<Person> find(String fstr) {
//		List<Person> list = null;
//		String qstr = "from Person where id = :fstr";
//		Query query = entityManager.createQuery(qstr)
//				.setParameter("fstr", Long.parseLong(fstr));
//		list = query.getResultList();
//		return list;
//	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Person> find(String fstr) {
//		List<Person> list = null;
//		String qstr = "from Person where id = :fid or name like :fname or mail like :fmail";
//		Long fid = 0L;
//		try {
//			fid = Long.parseLong(fstr);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		Query query = entityManager.createQuery(qstr)
//				.setParameter("fid", fid)
//				.setParameter("fname", "%" + fstr + "%")
//				.setParameter("fmail", fstr + "%@%");
//		list = query.getResultList();
//		return list;
//	}
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Person> find(String fstr) {
//		List<Person> list = null;
//		String qstr = "from Person where id = ?1 or name like ?2 or mail like ?3";
//		Long fid = 0L;
//		try {
//			fid = Long.parseLong(fstr);
//		} catch (NumberFormatException e) {
//			e.printStackTrace();
//		}
//		Query query = entityManager.createQuery(qstr)
//				.setParameter(1, fid)
//				.setParameter(2, "%" + fstr + "%")
//				.setParameter(3, fstr + "%@%");
//		list = query.getResultList();
//		return list;
//	}
	@Override
	public List<Person> find(String fstr) {
		List<Person> list = null;
		String qstr = "findWithName";
		Query query = entityManager.createNamedQuery(qstr)
				.setParameter("fname", "%" + fstr + "%");
		list = query.getResultList();
		return list;
	}
	@Override
	public List<Person> findByAge(int min, int max) {
		List<Person> list = null;
		String qstr = "findByAge";
		Query query = entityManager.createNamedQuery(qstr)
				.setParameter("min", min)
				.setParameter("max", max);
		list = query.getResultList();
		return list;
	}
}
