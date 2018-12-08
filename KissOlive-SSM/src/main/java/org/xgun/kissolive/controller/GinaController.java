package org.xgun.kissolive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.xgun.kissolive.common.ServerResponse;
import org.xgun.kissolive.pojo.*;
import org.xgun.kissolive.service.IGinaService;
import org.xgun.kissolive.utils.MD5Util;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class GinaController {
    @Autowired
    private IGinaService iGinaService;

    /**
     * 添加管理员
     * @param session
     * @param mno
     * @param mname
     * @param mpwd
     * @return
     */
    @RequestMapping(value = "add_manager.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addManager(HttpSession session,
                                     @RequestParam("manager_number") String mno,
                                     @RequestParam("manager_name") String mname,
                                     @RequestParam("manager_password") String mpwd) {
        // TODO: 一般可以通过session来判断用户是否登录等
        String MD5password = MD5Util.MD5EncodeUtf8(mpwd);
        Manager manager = new Manager(mno,mname,MD5password);
        return iGinaService.addManager(manager);
    }

    /**
     * 管理员登录
     * @param session
     * @param mno
     * @param mpwd
     * @return
     */
    @RequestMapping(value = "login_manager.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse loginManager(HttpSession session,
                                     @RequestParam("manager_number") String mno,
                                     @RequestParam("manager_password") String mpwd) {
        // TODO: 一般可以通过session来判断用户是否登录等
        String MD5password = MD5Util.MD5EncodeUtf8(mpwd);
        Manager manager = new Manager(mno,null,MD5password);
        ServerResponse response =  iGinaService.managerLogin(manager);
        if (response.isSuccess()) {
            session.removeAttribute("CurrentManager");
            session.setAttribute("CurrentManager", response.getData());
        }
        return response;
    }

    /**
     * 教师登录
     * @param session
     * @param tno
     * @param tpwd
     * @return
     */
    @RequestMapping(value = "login_teacher.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse loginTeacher(HttpSession session,
                                       @RequestParam("teacher_number") String tno,
                                       @RequestParam("teacher_password") String tpwd){
        String MD5password = MD5Util.MD5EncodeUtf8(tpwd);
        Teacher teacher = new Teacher(tno, null, null, null, null,null,null,MD5password );
        ServerResponse response =  iGinaService.teacherLogin(teacher);
        if (response.isSuccess()) {
            session.removeAttribute("CurrentTeacher");
            session.setAttribute("CurrentTeacher", response.getData());
        }
        return response;
    }

    /**
     * 学生登录
     * @param session
     * @param sno
     * @param spwd
     * @return
     */
    @RequestMapping(value = "login_student.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse loginStudent(HttpSession session,
                                       @RequestParam("student_number") String sno,
                                       @RequestParam("student_password") String spwd){
        String MD5password = MD5Util.MD5EncodeUtf8(spwd);
        Student student = new Student(sno, null, null, null, MD5password, null,null);
        ServerResponse response =  iGinaService.studentLogin(student);
        if (response.isSuccess()) {
            session.removeAttribute("CurrentStudent");
            session.setAttribute("CurrentStudent", response.getData());
        }
        return response;
    }

    /**
     * 添加学期信息
     * @param session
     * @param termno
     * @param termdesc
     * @return
     */
    @RequestMapping(value = "add_term.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addTerm(HttpSession session,
                                  @RequestParam("term_number") String termno,
                                  @RequestParam("term_desc") String termdesc){
        Term term = new Term(termno, termdesc);
        return iGinaService.addTermMeassage(term);
    }

    /**
     * 获取所有学期信息
     * @return
     */
    @RequestMapping(value = "term_list.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getTermList(){
        return iGinaService.getTermList();
    }

    /**
     * 删除学期信息
     * @param session
     * @param termno
     * @return
     */
    @RequestMapping(value = "delete_term.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteTerm(HttpSession session,
                                     @RequestParam("term_number") String termno){
        return iGinaService.deleteTerm(termno);
    }

    /**
     * 修改学期信息
     * @param session
     * @param termno
     * @param termdesc
     * @return
     */
    @RequestMapping(value = "edit_term.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse editTerm(HttpSession session,
                                   @RequestParam("term_number") String termno,
                                   @RequestParam("term_desc") String termdesc){
        Term term = new Term(termno, termdesc);
        return iGinaService.editTerm(term);
    }

    /**
     * 添加院系信息
     * @param session
     * @param dno
     * @param dname
     * @param dmanager
     * @param dtel
     * @return
     */
    @RequestMapping(value = "add_department.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addDepartment(HttpSession session,
                                        @RequestParam("department_number") String dno,
                                        @RequestParam("department_name") String dname,
                                        @RequestParam("department_manager") String dmanager,
                                        @RequestParam("department_tel") String dtel){
        Department department = new Department(dno, dname, dmanager, dtel);
        return iGinaService.addDepartment(department);
    }

    /**
     * 获取所有的院系信息
     * @return
     */
    @RequestMapping(value = "department_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getDepartmentList(){
        return iGinaService.getDepartmentList();
    }

    /**
     * 删除院系信息
     * @param session
     * @param dno
     * @return
     */
    @RequestMapping(value = "delete_department.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteDepartment(HttpSession session,
                                           @RequestParam("department_number") String dno){
        return iGinaService.deleteDepartment(dno);
    }

    /**
     * 修改院系信息
     * @param session
     * @param dno
     * @param dname
     * @param dmanager
     * @param dtel
     * @return
     */
    @RequestMapping(value = "edit_department.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse editDepartment(HttpSession session,
                                         @RequestParam("department_number") String dno,
                                         @RequestParam("department_name") String dname,
                                         @RequestParam("department_manager") String dmanager,
                                         @RequestParam("department_tel") String dtel
                                         ){
        Department department = new Department(dno, dname, dmanager, dtel);
        return iGinaService.editDepartment(department);
    }

    /**
     * 添加教师信息
     * @param session
     * @param tno
     * @param tname
     * @param tsex
     * @param tbirth
     * @param teducation
     * @param tposition
     * @param tintroduction
     * @return
     */
    @RequestMapping(value = "add_teacher.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addTeacher(HttpSession session,
                                     @RequestParam("teacher_number") String tno,
                                     @RequestParam("teacher_name") String tname,
                                     @RequestParam("teacher_sex") String tsex,
                                     @RequestParam("teacher_birthday") String tbirth,
                                     @RequestParam("teacher_education") String teducation,
                                     @RequestParam("teacher_position") String tposition,
                                     @RequestParam("teacher_introduction") String tintroduction
                                     ) {
        String MD5password = MD5Util.MD5EncodeUtf8("123456");
        Teacher teacher = new Teacher(tno, tname, tsex, tbirth, teducation, tposition, tintroduction, MD5password);
        return iGinaService.addTeacher(teacher);
    }

    /**
     * 获取所有的教师信息
     * @return
     */
    @RequestMapping(value = "teacher_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getTeacherList(){
        return iGinaService.getTeacherList();
    }

    /**
     * 删除教师信息
     * @param session
     * @param tno
     * @return
     */
    @RequestMapping(value = "delete_teacher.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteTeacher(HttpSession session,
                                        @RequestParam("teacher_number") String tno){
        return iGinaService.deleteTeacher(tno);
    }

    /**
     * 修改教师信息
     * @param session
     * @param tno
     * @param tname
     * @param tsex
     * @param tbirth
     * @param teducation
     * @param tposition
     * @param tintroduction
     * @return
     */
    @RequestMapping(value = "edit_teacher.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse editTeacher(HttpSession session,
                                      @RequestParam("teacher_number") String tno,
                                      @RequestParam("teacher_name") String tname,
                                      @RequestParam("teacher_sex") String tsex,
                                      @RequestParam("teacher_birthday") String tbirth,
                                      @RequestParam("teacher_education") String teducation,
                                      @RequestParam("teacher_position") String tposition,
                                      @RequestParam("teacher_introduction") String tintroduction){
        String MD5password = MD5Util.MD5EncodeUtf8("123456");
        Teacher teacher = new Teacher(tno, tname, tsex, tbirth, teducation, tposition, tintroduction, MD5password);
        return iGinaService.editTeacher(teacher);
    }

    /**
     * 添加学生信息
     * @param session
     * @param sno
     * @param sname
     * @param ssex
     * @param sbirth
     * @param sdno
     * @return
     */
    @RequestMapping(value = "add_student.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addStudent(HttpSession session,
                                     @RequestParam("student_number") String sno,
                                     @RequestParam("student_name") String sname,
                                     @RequestParam("student_sex") String ssex,
                                     @RequestParam("student_birthday") String sbirth,
                                     @RequestParam("student_departmentNumber") String sdno
                                     ){
        String MD5password = MD5Util.MD5EncodeUtf8("123456");
        Student student = new Student(sno, sname, ssex, sbirth, MD5password, sdno, null);
        return iGinaService.addStudent(student);
    }

    /**
     * 获取学生信息
     * @return
     */
    @RequestMapping(value = "student_list.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getStudentList(){
        return iGinaService.getStudentList();
    }

    /**
     * 删除学生信息
     * @param session
     * @param sno
     * @return
     */
    @RequestMapping(value = "delete_student.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse deleteStudent(HttpSession session,
                                        @RequestParam("student_number") String sno){
        return iGinaService.deleteStudent(sno);
    }

    /**
     * 修改学生信息
     * @param session
     * @param sno
     * @param sname
     * @param ssex
     * @param sbirth
     * @param sdno
     * @return
     */
    @RequestMapping(value = "student_edit.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse editStudent(HttpSession session,
                                      @RequestParam("student_number") String sno,
                                      @RequestParam("student_name") String sname,
                                      @RequestParam("student_sex") String ssex,
                                      @RequestParam("student_birthday") String sbirth,
                                      @RequestParam("student_departmentNumber") String sdno){
        String MD5password = MD5Util.MD5EncodeUtf8("123456");
        Student student = new Student(sno, sname, ssex, sbirth, MD5password, sdno, null);
        return iGinaService.editStudent(student);
    }

    /**
     * 发布开课通知
     * @param session
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "sentStartLessonNotice.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sentStartLessonNotice(HttpSession session,
                                               @RequestParam("title") String title,
                                               @RequestParam("content") String content){
        Message message = new Message(0,title,content,null);
        return iGinaService.sentStartLseeonNotice(message);
    }

    /**
     * 获取某个教师的全部消息
     * @param session
     * @param tno
     * @return
     */
    @RequestMapping(value = "getTeacherMessage.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse TeacherMessageList(HttpSession session,
                                             @RequestParam("teacher_num") String tno){
        return iGinaService.getTeacherMessage(tno);
    }

    /**
     * 开课申请
     * @param session
     * @param cname
     * @param ctype
     * @param cterm
     * @param cdesc
     * @param ctno
     * @return
     */
    @RequestMapping(value = "ClassApplication.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addClassApplication(HttpSession session,
                                              @RequestParam("course_name") String cname,
                                              @RequestParam("type") String ctype,
                                              @RequestParam("term") String cterm,
                                              @RequestParam("desc") String cdesc,
                                              @RequestParam("teacher_number")  String ctno){
        //Course course = new Course(0, ktype, kterm, kdesc, ktno,kcoursename,null);
        Course course = new Course(0,ctype,cterm,cdesc,ctno,cname,2,0,0,null);
        return iGinaService.classApplication(course);
    }

    /**
     * 获取所有的开课申请
     * @return
     */
    @RequestMapping(value = "getClassApplication.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getClassApplication(){
        return iGinaService.getCourseList();
    }

    /**
     * 发布选课通知
     * @param session
     * @param title
     * @param content
     * @return
     */
    @RequestMapping(value = "sentElectiveNotice.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse sentElectiveNotice(HttpSession session,
                                                @RequestParam("title") String title,
                                                @RequestParam("content") String content){
        Message message = new Message(0,title,content,null);
        return iGinaService.sentElectiveNotice(message);
    }

    /**
     * 发布选课通知
     * @param session
     * @param sno
     * @return
     */
    @RequestMapping(value = "getStudentMessage.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse StudentMessageList(HttpSession session,
                                             @RequestParam("student_num") String sno){
        return iGinaService.getStudentessage(sno);
    }

    /**
     * 修改状态
     * @param session
     * @param cno
     * @param cstatus
     * @return
     */
    @RequestMapping(value = "change_status.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changeCourseStatus(HttpSession session,
                                             @RequestParam("course_number") int cno,
                                             @RequestParam("course_status") int cstatus){
        Course course = new Course(cno,null,null,null,null,null,2,0,cstatus,null);
        return iGinaService.changeCourseStatus(course);
    }

    /**
     * 获取通过审核的课程
     * @return
     */
    @RequestMapping(value = "getAuditingCourseList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getAuditingCourseList(){
        return iGinaService.getAuditingCourseList();
    }

    /**
     * 获取不通过审核的课程
     * @return
     */
    @RequestMapping(value = "getNotAuditingCourseList.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getNotAuditingCourseList(){
        return iGinaService.getNotAuditingCourseList();
    }

    /**
     * 选课
     * @param session
     * @param ssno
     * @param scno
     * @param stermno
     * @return
     */
    @RequestMapping(value = "selectClass.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse selectClass(HttpSession session,
                                      @RequestParam("student_number") String ssno,
                                      @RequestParam("course_number") int scno,
                                      @RequestParam("term_number") String stermno){
        Scort scort = new Scort(ssno,scno,-1,stermno,null, 2, null, 60, null);
        return iGinaService.addSelectCourse(scort);
    }

    /**
     * 查找已选课程
     * @param session
     * @param ssno
     * @return
     */
    @RequestMapping(value = "courseIsSelected.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse courseIsSelected(HttpSession session,
                                           @RequestParam("student_number") String ssno){
        return iGinaService.selectCourseIsSelected(ssno);
    }

    /**
     * 查找未选课程
     * @param session
     * @param ssno
     * @return
     */
    @RequestMapping(value = "courseNotSelected.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse courseNotSelected(HttpSession session,
                                            @RequestParam("student_number") String ssno){
        return iGinaService.notSelectedCourse(ssno);
    }

    /**
     * 退选
     * @param session
     * @param sno
     * @return
     */
    @RequestMapping(value = "withdrawalCourse.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse withdrawalCourse(HttpSession session,
                                           @RequestParam("scort_number") int sno){
        return iGinaService.withdrawalCourse(sno);
    }

    /**
     * 退选 剩余人数+1
     * @param session
     * @param sno
     * @param cresnum
     * @return
     */
    @RequestMapping(value = "addResnum.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addResnum(HttpSession session,
                                    @RequestParam("sct_number") int sno,
                                    @RequestParam("cresnum") int cresnum){
        return iGinaService.addResnum(sno,cresnum);
    }

    /**
     * 选课人数 剩余人数-1
     * @param session
     * @param cno
     * @param cresnum
     * @return
     */
    @RequestMapping(value = "reduceResnum.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse reduceResnum(HttpSession session,
                                       @RequestParam("course_number") int cno,
                                       @RequestParam("cresnum") int cresnum){
        System.out.println(cno+"========"+cresnum);
        return iGinaService.updateResnumReduce(cno,cresnum);
    }

    @RequestMapping(value = "getCourseList.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getCourseList(){
        return iGinaService.courseSelection();
    }

    /**
     * 获取允许开课的课程
     * @return
     */
    @RequestMapping(value = "getStartCourseList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getStartCourseList(){
        return iGinaService.getStartCourseList();
    }

    /**
     * 获取不允许开课的课程
     * @return
     */
    @RequestMapping(value = "getNotStartCourseList.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getNotStartCourseList(){
        return iGinaService.getNotStartCourseList();
    }

    /**
     * 开课情况
     * @param session
     * @param ctno
     * @return
     */
    @RequestMapping(value = "getCourseSituation.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getCourseSituation(HttpSession session,
                                             @RequestParam("ctno") String ctno
                                             ){
        return iGinaService.getCourseSituation(ctno);
    }

    /**
     * 教师课程表
     * @param session
     * @param tno
     * @return
     */
    @RequestMapping(value = "getStartCourseByTeacher.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getStartCourseByTeacher(HttpSession session,
                                                  @RequestParam("teacher_number") String tno){
        return iGinaService.getStartCourseByTeacher(tno);
    }

    /**
     * 学生名单
     * @param session
     * @param cno
     * @return
     */
    @RequestMapping(value = "getStudentChooseCourse.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getStudentChooseCourse(HttpSession session,
                                                 @RequestParam("course_number") int cno){
        return iGinaService.getStudentChooseCourse(cno);
    }

    /**
     * 录入成绩
     * @param stuGrades
     * @return
     */
    @RequestMapping(value = "entryGrade.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse entryGrade(@RequestBody StuGrade[] stuGrades){
        List<StuGrade> stuGradeList = new ArrayList<StuGrade>();
        for (StuGrade stuGrade : stuGrades) {
            stuGradeList.add(stuGrade);
        }
        return iGinaService.entryGrade(stuGradeList);
    }

    /**
     * 获取个人成绩
     * @param sno
     * @return
     */
    @RequestMapping(value = "getMyGrade.do",method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse getMyGrade(@RequestParam("sno") String sno){
        return iGinaService.getMyGrade(sno);
    }

    /**
     * 修改管理员密码
     * @param session
     * @param mno
     * @param mpwd
     * @return
     */
    @RequestMapping(value = "changeAdminPassword.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changeAdminPassword(HttpSession session,
                                              @RequestParam("admin_number") String mno,
                                              @RequestParam("admin_passord") String mpwd){
        String MD5password = MD5Util.MD5EncodeUtf8(mpwd);
        return iGinaService.changePasswordByAdmin(mno,MD5password);
    }

    /**
     * 修改教师密码
     * @param session
     * @param tno
     * @param tpwd
     * @return
     */
    @RequestMapping(value = "changeTeacherPassword.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changeTeacherPassword(HttpSession session,
                                                @RequestParam("teacher_number") String tno,
                                                @RequestParam("teacher_password") String tpwd){
        String MD5password = MD5Util.MD5EncodeUtf8(tpwd);
        return iGinaService.changePasswordByTeacher(tno, MD5password);
    }

    /**
     * 修改学生密码
     * @param session
     * @param sno
     * @param spwd
     * @return
     */
    @RequestMapping(value = "changeStudentPassword.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse changeStudentPassword(HttpSession session,
                                                @RequestParam("student_number") String sno,
                                                @RequestParam("stuednt_password") String spwd){
        String MD5password = MD5Util.MD5EncodeUtf8(spwd);
        return iGinaService.changePasswordByStudent(sno,MD5password);
    }

}
