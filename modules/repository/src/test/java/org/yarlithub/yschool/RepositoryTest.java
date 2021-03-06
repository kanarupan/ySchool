package org.yarlithub.yschool;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.yarlithub.yschool.repository.factories.yschool.YschoolDataPoolFactory;
import org.yarlithub.yschool.repository.model.obj.yschool.*;
import org.yarlithub.yschool.repository.services.data.DataLayerYschool;
import org.yarlithub.yschool.repository.services.data.DataLayerYschoolImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Tese tests connects with database and transfer data.
 * Before Running tests make sure to import schema and initial data into the database.
 */

@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class RepositoryTest {

    @Test
    @Transactional
    public void testUserRole() {

        DataLayerYschool dataLayerYschool = DataLayerYschoolImpl.getInstance();

        //create object and save into RDBMS
        //
        //
        //Student studentss = YschoolDataPoolFactory.getStudent();
        UserRole userRole = YschoolDataPoolFactory.getUserRole();
        userRole.setName("transient_admin_WD#$@DTGHYFEX768IHHJWE");
        dataLayerYschool.save(userRole);
        dataLayerYschool.flushSession();

//        //TODO: hibernate query is not working now.
//        //Use hibernate query language to access RDBMS.
//        Query query = dataLayerYschool.createQuery("SELECT idUser_Role FROM user_role WHERE name = :testname");
//        query.setParameter("testname", "transient_admin_WD#$@DTGHYFEX768IHHJWE");
//        List list = query.list();
//
//        //Test the entered data.
//        assertEquals("Error in accessing UserRole table in database!", 1, list.size());

        //Use SQL query for insert operations.
        String sql = "INSERT INTO user (user_name, email, password, user_role_iduser_role) VALUES (:user_name, :email, :password, :user_role_iduser_role)";

        SQLQuery insertQuery = dataLayerYschool.createSQLQuery(sql);
        insertQuery.setParameter("user_name", "transient_testuser_WD#$@DTGHYFEX768IHHJWE");
        insertQuery.setParameter("email", "me@me.com");
        insertQuery.setParameter("password", "XXXX");
        insertQuery.setParameter("user_role_iduser_role", 1);
        int result1 = insertQuery.executeUpdate();

        assertEquals("Error in inserting value into User table!", 1, result1);

        //Delete the entries used in test to make the DB as it was after test.
        SQLQuery deleteQuery1 = dataLayerYschool.createSQLQuery("DELETE FROM user WHERE user_name = :testname");
        deleteQuery1.setParameter("testname", "transient_testuser_WD#$@DTGHYFEX768IHHJWE");
        deleteQuery1.executeUpdate();

        //Delete the entries used in test to make the DB as it was after test.
        SQLQuery deleteQuery2 = dataLayerYschool.createSQLQuery("DELETE FROM user_role WHERE name = :testname");
        deleteQuery2.setParameter("testname", "transient_admin_WD#$@DTGHYFEX768IHHJWE");
        int result2 = deleteQuery2.executeUpdate();

        assertEquals("Error in deleting value from UserRole table!", 1, result2);


//        User user = YschoolDataPoolFactory.getUser();
//        user.setEmail("testv1.1@gmail.com");
//        user.setUserName("newadmin");
//        user.setPassword("XXX");
//
//        //TODO: This is not working with generated POJOs or  with jUnit.
        //giving assumption violation exception.
//        UserRole userRole1 =  dataLayerYschool.getUserRole(1)   ;
//
//        user.setUserRoleIduserRole(userRole1);
//        dataLayerYschool.save(user);
//        dataLayerYschool.flushSession();

//        //netsted criteria test for joins : analytics subjectlists    //
//       Criteria st= dataLayerYschool.createCriteria(Subject.class);
//        List<Classroom> lt= st.createAlias("classroom_student","clsu").createAlias("student","st").add(Restrictions.eq("st.idstudent","1")).list();
        // List<Subject> lt= st.add(Restrictions.eq("name","SAIVISAM")).list();   //
//        System.out.println(lt.get(0).getId());

        //   ClassAnalyzerClassifier s = YschoolDataPoolFactory.getClassAnalyzerClassifier();

        Student student = null;
        Criteria studentCR = dataLayerYschool.createCriteria(Student.class);
        studentCR.add(Restrictions.eq("admissionNo", "18746"));                        //String.valueOf(admissionNo)
        List<Student> studentList = studentCR.list();
        /*The admission is unique thus the number of students retured should be one */
//        if (studentList.size() == 1) {
        student = studentList.get(0);
        System.out.println(student.getName());


//        Working after data1.0.4
        //         Exam exam =dataLayerYschool.getExam(1);
//        System.out.println(exam.getId());
//           ExamSync examSync = YschoolDataPoolFactory.getExamSync(null);
//        examSync.setClassIdexam(1);
//        examSync.setSyncStatus(2);
//        examSync.setExamIdexam(exam);
//        dataLayerYschool.save(examSync);
//        dataLayerYschool.flushSession();
//        System.out.println(examSync.getId());


        studentList = new ArrayList<>();
        studentCR = dataLayerYschool.createCriteria(Student.class);
        studentCR.add(Restrictions.eq("admissionNo", String.valueOf(18746)));                        //String.valueOf(admissionNo)
        studentList = studentCR.list();
        /*The admission is unique thus the number of students retured should be one */
//        if (studentList.size() == 1) {
        student = studentList.get(0);
        // }


        Criteria studentGeneralExamProfiles = dataLayerYschool.createCriteria(StudentGeneralexamProfile.class);

        // studentGeneralExamProfiles.createAlias("admissionNo", "adNo");

        studentGeneralExamProfiles.add(Restrictions.eq("alIslandRank", 18952));
        List<StudentGeneralexamProfile> adProfiles = studentGeneralExamProfiles.list();

        //  Criteria classroomSubjectCR = dataLayerYschool.createCriteria(ClassroomSubject.class);


        //student_classroom_subject data is not ready yet
        //classroomSubjectCR.createAlias("studentClassroomSubjects", "stclsu").createAlias("stclsu.classroomStudentIdclassroomStudent", "clst").add(Restrictions.eq("clst.studentIdstudent", student));
        //so using this as temporary ,but this may violate optional subject...


        //classroomSubjectCR.createAlias("classroomIdclass", "cl").createAlias("cl.classroomStudents", "clst").add(Restrictions.eq("clst.studentIdstudent", student));

        // classroomSubjectCR.add(Restrictions.eq("cl.grade", 10));
        //List<ClassroomSubject> lt = classroomSubjectCR.list();
        System.out.println(adProfiles);


        student = dataLayerYschool.getStudent(17);

        Criteria classroomSubjectCR = dataLayerYschool.createCriteria(ClassroomSubject.class);
        //student_classroom_subject data is not ready yet
        //classroomSubjectCR.createAlias("studentClassroomSubjects", "stclsu").createAlias("stclsu.classroomStudentIdclassroomStudent", "clst").add(Restrictions.eq("clst.studentIdstudent", student));
        //so using this as temporary ,but this may violate optional subject...
        classroomSubjectCR.createAlias("classroomIdclass", "cl").createAlias("cl.classroomStudents", "clst").add(Restrictions.eq("clst.studentIdstudent", student));

        classroomSubjectCR.add(Restrictions.eq("cl.grade", 11));
        List<ClassroomSubject> lt = classroomSubjectCR.list();
        System.out.println("\n\n\n\n");


        Criteria marks = dataLayerYschool.createCriteria(Marks.class);
        marks.add(Restrictions.eq("studentIdstudent", student));
        marks.createAlias("examIdexam", "examId").add(Restrictions.eq("examId.classroomSubjectIdclassroomSubject", lt.get(0)));

        marks.add(Restrictions.eq("examId.term", 3));
        List<Marks> marksList = marks.list();
        System.out.println("\n\n\n\n");
        System.out.println(marksList);

    }
}
