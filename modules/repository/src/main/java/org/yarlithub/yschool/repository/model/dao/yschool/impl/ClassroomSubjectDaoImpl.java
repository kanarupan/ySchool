package org.yarlithub.yschool.repository.model.dao.yschool.impl;

import com.felees.hbnpojogen.persistence.impl.GenericHibernateDaoImpl;
import org.yarlithub.yschool.repository.model.obj.yschool.ClassroomSubject;
import org.springframework.stereotype.Repository;
import org.yarlithub.yschool.repository.model.dao.yschool.ClassroomSubjectDao;
 
 
/**
 * DAO for table: ClassroomSubject.
 * @author autogenerated
 */
@Repository
public class ClassroomSubjectDaoImpl extends GenericHibernateDaoImpl<ClassroomSubject, Integer> implements ClassroomSubjectDao {
	
	/** Constructor method. */
		public ClassroomSubjectDaoImpl() {
			super(ClassroomSubject.class);
		}
	}

