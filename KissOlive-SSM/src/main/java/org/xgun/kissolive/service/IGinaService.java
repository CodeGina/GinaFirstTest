package org.xgun.kissolive.service;

import org.xgun.kissolive.common.ServerResponse;
import org.xgun.kissolive.pojo.*;

public interface IGinaService {
    //添加管理员
    ServerResponse<Boolean> addManager(Manager manager);
    //管理员登录
    ServerResponse<Manager> managerLogin(Manager manager);
    //教师登录
    ServerResponse<Teacher> teacherLogin(Teacher teacher);
    //学生登录
    ServerResponse<Student> studentLogin(Student student);

    //添加学期信息
    ServerResponse<Boolean> addTermMeassage(Term term);
    //获取所有学期信息
    ServerResponse getTermList();
    //删除学期信息
    ServerResponse<Boolean> deleteTerm(String termno);
    //修改学期信息
    ServerResponse editTerm(Term term);

    //添加院系信息
    ServerResponse<Boolean> addDepartment(Department department);
    //获取所有院系信息
    ServerResponse getDepartmentList();
    //删除院系信息
    ServerResponse<Boolean> deleteDepartment(String dno);
    //修改院系信息
    ServerResponse editDepartment(Department department);

    //添加老师
    ServerResponse<Boolean> addTeacher(Teacher teacher);
    //获取所有的教师信息
    ServerResponse getTeacherList();
    //删除教师信息
    ServerResponse<Boolean> deleteTeacher(String tno);
    //修改教师信息
    ServerResponse editTeacher(Teacher teacher);

    //添加学生信息
    ServerResponse<Boolean> addStudent(Student student);
    //获取所有的学生信息
    ServerResponse getStudentList();
    //删除学生信息
    ServerResponse<Boolean> deleteStudent(String sno);
    //修改学生信息
    ServerResponse editStudent(Student student);

    //添加申请开课通知
    ServerResponse sentStartLseeonNotice(Message message);
    //获取某个教师的全部消息通知
    ServerResponse getTeacherMessage(String tno);

    //开课申请
    ServerResponse classApplication(Course course);
    //获取所有的开课申请
    ServerResponse getCourseList();

    //添加选课通知
    ServerResponse sentElectiveNotice(Message message);
    //获取某个学生的全部消息通知
    ServerResponse getStudentessage(String sno);

    //更新课程状态：通过审核（1）
    ServerResponse changeCourseStatus(Course course);

    //获取通过审核的课程
    ServerResponse getAuditingCourseList();
    //获取不通过审核的课程
    ServerResponse getNotAuditingCourseList();

    //选课
    ServerResponse addSelectCourse(Scort scort);
    //已选课程
    ServerResponse selectCourseIsSelected(String ssno);
    //未选的课程
    ServerResponse notSelectedCourse(String ssno);
    //退选
    ServerResponse withdrawalCourse(int sno);

    //退选 剩余人数+1
    ServerResponse addResnum(int sno,int cresnum);
    //选课 剩余人数-1
    ServerResponse updateResnumReduce(int cno,int cresnum);

    //选课情况
    ServerResponse courseSelection();

    //获取允许开课
    ServerResponse getStartCourseList();
    ServerResponse getNotStartCourseList();

    //开课情况(根据status)
    ServerResponse getCourseSituation(String ctno);

    //获取老师正常开课的课程
    ServerResponse getStartCourseByTeacher(String tno);

    //获取选择某课程的全部学生名单
    ServerResponse getStudentChooseCourse(int cno);

    //录入成绩
    //ServerResponse entryGrade(String ssno, int scno, int grade);
    //ServerResponse entryGrade(Scort scort);

    //修改管理员密码
    ServerResponse changePasswordByAdmin(String mno, String mpwd);
    //修改教师密码
    ServerResponse changePasswordByTeacher(String tno, String tpwd);
    //修改学生密码
    ServerResponse changePasswordByStudent(String sno, String spwd);
}
