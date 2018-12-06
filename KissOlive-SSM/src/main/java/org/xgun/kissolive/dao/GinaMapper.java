package org.xgun.kissolive.dao;

import org.apache.ibatis.annotations.Param;
import org.xgun.kissolive.pojo.*;

import java.util.List;

public interface GinaMapper {
    //添加管理员
    int insertManager(Manager manager);
    //按id和pwd查找管理员
    Manager selectManagerByMnoAndMpwd(Manager manager);

    //按id和pwd查找教师
    Teacher selectTeacherByTnoAndTpwd(Teacher teacher);

    //按id和pwd查找学生
    Student selectStudentBySnoAndSpwd(Student student);


    //添加学期信息
    int insertTermMessage(Term term);
    //查找学期信息编号是否已经存在
    int selectTermCountByTermno(String termno);
    //获取所有学期信息
    List<Term> selectAllTerm();
    //删除学期信息
    int deleteTerm(String termno);
    //修改学期信息
    int updateTerm(Term term);

    //添加院系信息
    int insertDepartment(Department department);
    //查找院系信息编号是否已经存在
    int selectDepartmentCountByDno(String dno);
    //获取所有的院系信息
    List<Department> selectAllDepartment();
    //删除院系信息
    int deleteDepqrtment(String dno);
    //修改院系信息
    int updateDepartment(Department department);

    //添加老师
    int inserTeacher(Teacher teacher);
    //查找教工号是否已经存在
    int selectTeacherCountByTno(String tno);
    //获取所有的教师信息
    List<Teacher> selectAllTeacher();
    //删除教师信息
    int deleteTeacher(String tno);
    //修改教师信息
    int updateTeacher(Teacher teacher);

    //添加学生
    int insertStudent(Student student);
    //查找学号是否已经存在
    int selectStudentCountBySno(String sno);
    //获取学生信息
    List<Student> selectAllStudent();
    //删除学生信息
    int deleteStudent(String sno);
    //修改学生信息
    int updateStudent(Student student);

    //添加开课通知
    int insertStartLseeonNotice(@Param("list")List<Message> messages);
    //获取某个教师的全部消息通知
    List<Message> getTeacherMessage(String tno);


    //发布开课申请
    int insertStartClassApplication(Course course);
    //获取所有的开课申请
    List<Course> getCourseList();

    //发布选课通知
    int insertElectiveNotice(@Param("list")List<Message> messages);
    //获取某个学生的全部消息
    List<Message> getStudentMessage(String sno);

    //更新课程状态
    int updateStatus(Course course);
    //获取通过审核的课程
    List<Course> getAuditingCourse();
    //获取不通过审核的课程
    List<Course> getNotAuditingCourse();

    //选课
    int insertSelectClass(Scort scort);
    //查找课程是否已选
    int selectScortCountBySnoAndCno(@Param("ssno")String ssno, @Param("scno") int scno );
    //查找已选的课程
    List<Scort> selectCourseIsSelectedBySno(String ssno);
    //选课 更新剩余人数-1
    int updateResnumReduce(@Param("cno")int cno, @Param("cresnum")int cresnum );
    //查找未选的课程
    List<Course> selectNotSelectedCourseBySno(@Param("ssno")String ssno );
    //删除已选课程
    int deleteSelectedCourse(int sno);
    //退选 更新剩余人数+1
    int updateResnumAdd(@Param("sno")int sno, @Param("cresnum")int cresnum );


    //查询课表
    List<Course> courseList();

    //获取允许开课的课程
    List<Course> getStartCourse();
    //获取不允许开课的课程
    List<Course> getNotStartCourse();

    //开课情况(根据status)
    List<Course> getCourseSituation(@Param("ctno") String ctno);
    //某个老师正常开课的课程
    List<Course> getStartCourseByTno(String tno);

    //获取选择某课程的全部学生名单
    List<Student> getStudentChooseCourseByCnoAndSno( @Param("scno") int cno);

    //录入成绩
    int updateGrade(@Param("list")List<Scort> scorts);

    //修改管理员密码
    int updatePasswordByMno(@Param("mno") String mno, @Param("mpwd") String mpwd);
    //修改教师密码
    int updatePasswordByTno(@Param("tno") String tno, @Param("tpwd") String tpwd);
    //修改学生密码
    int updatePasswordBySno(@Param("sno") String sno, @Param("spwd") String spwd);

}
