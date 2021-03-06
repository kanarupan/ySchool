package org.yarlithub.yschool.repository.model.obj.yschool.iface;
import java.util.Date;
import org.yarlithub.yschool.repository.model.obj.yschool.ClassroomStudent;
import org.yarlithub.yschool.repository.model.obj.yschool.ClassroomSubject;


/** 
 * Object interface mapping for hibernate-handled table: student_classroom_subject.
 * @author autogenerated
 */

public interface IStudentClassroomSubject {



    /**
     * Return the value associated with the column: classroomStudentIdclassroomStudent.
	 * @return A ClassroomStudent object (this.classroomStudentIdclassroomStudent)
	 */
	ClassroomStudent getClassroomStudentIdclassroomStudent();
	

  
    /**  
     * Set the value related to the column: classroomStudentIdclassroomStudent.
	 * @param classroomStudentIdclassroomStudent the classroomStudentIdclassroomStudent value you wish to set
	 */
	void setClassroomStudentIdclassroomStudent(final ClassroomStudent classroomStudentIdclassroomStudent);

    /**
     * Return the value associated with the column: classroomSubjectIdclassroomSubject.
	 * @return A ClassroomSubject object (this.classroomSubjectIdclassroomSubject)
	 */
	ClassroomSubject getClassroomSubjectIdclassroomSubject();
	

  
    /**  
     * Set the value related to the column: classroomSubjectIdclassroomSubject.
	 * @param classroomSubjectIdclassroomSubject the classroomSubjectIdclassroomSubject value you wish to set
	 */
	void setClassroomSubjectIdclassroomSubject(final ClassroomSubject classroomSubjectIdclassroomSubject);

    /**
     * Return the value associated with the column: id.
	 * @return A Integer object (this.id)
	 */
	Integer getId();
	

  
    /**  
     * Set the value related to the column: id.
	 * @param id the id value you wish to set
	 */
	void setId(final Integer id);

    /**
     * Return the value associated with the column: modifiedTime.
	 * @return A Date object (this.modifiedTime)
	 */
	Date getModifiedTime();
	

  
    /**  
     * Set the value related to the column: modifiedTime.
	 * @param modifiedTime the modifiedTime value you wish to set
	 */
	void setModifiedTime(final Date modifiedTime);

	// end of interface
}